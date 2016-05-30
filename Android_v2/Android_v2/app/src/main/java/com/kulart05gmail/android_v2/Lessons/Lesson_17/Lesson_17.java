package com.kulart05gmail.android_v2.Lessons.Lesson_17;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.PointF;
import android.media.FaceDetector;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kulart05gmail.android_v2.R;

import java.io.File;


public class Lesson_17 extends AppCompatActivity {

    private static final int REQUEST_PERMISSION = 123;
    private static final int REQUEST_CAMERA = 321;
    private static final int REQUEST_GALLARY = 444;
    private ImageView imageView;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_17);
        mButton = (Button) findViewById(R.id.btn_L17);
        imageView = (ImageView) findViewById(R.id.iv_L17);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseVoid();
            }
        });


        NewMessageNotification.notify(this, "Open Tennis Score", 5);
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void chooseVoid() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            startChooser();
        } else {
            requestPermissions(new String[]{
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (REQUEST_PERMISSION == requestCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    private void startChooser() {
        startCamera();
        //startGalery();

    }

    private void startCamera() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (i.resolveActivity(this.getPackageManager()) != null) {
            File file = getFile();
            if (file != null) {
                i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(i, REQUEST_CAMERA);
            }
        }

    }

    private File getFile() {
        File filephoto;
        File file = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        if (!file.exists()) {
            file.mkdir();
        }

        filephoto = new File(file, "MyPhoto");
        return filephoto;
    }


    private void startGalery() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //есть программа через котору можно выбрать фото 
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_GALLARY);
        } else {
            //проблемка
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CAMERA) {
            File file = getFile();

            if (file.exists()) {
                PhotoASyncTasl task = new PhotoASyncTasl();
                task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
            } else {
                Log.e("AAAAA", "Gallery error");

            }


        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == REQUEST_GALLARY) {
            try {
                //возращает ссылку на контент
                Uri selectedImage = data.getData();

                String[] filePashColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver()
                        .query(selectedImage, filePashColumn, null, null, null);
                if (cursor == null) {
                    Log.e("AAAAA", "Gallery error = null");
                    return;

                }
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePashColumn[0]);
                String immagePath = cursor.getString(columnIndex);
                cursor.close();
                if (TextUtils.isEmpty(immagePath)) {
                    Log.e("AAAAA", "Gallery error");
                    return;
                }
                File file = new File(immagePath);


            } catch (Exception e) {
                Log.e("AAAAAA", "Gallery error = " + e.toString());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void scannDir() {
        MediaScannerConnection.scanFile(this, new String[]{"путь к деректории"}, null, new MediaScannerConnection.OnScanCompletedListener() {
            @Override
            public void onScanCompleted(String path, Uri uri) {
                //успешно отсканили
            }
        });
    }

    private class PhotoASyncTasl extends AsyncTask<File, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(File... params) {
            return resizePhoto(params[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    private static Bitmap resizePhoto(File file) {
        BitmapFactory.Options bOption = new BitmapFactory.Options();
        bOption.inJustDecodeBounds = true;
        bOption.inPreferredConfig = Bitmap.Config.RGB_565;
        bOption.inPurgeable = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), bOption);
        int w = bOption.outWidth;
        int h = bOption.outHeight;

        if (w > 1000 || h > 1000) {
            bOption.inSampleSize = Math.max(w / 200, h / 200);


        } else {
            Log.e("AAAAa", "resizePhoro erroe");
        }
        bOption.inJustDecodeBounds = false;
        Bitmap b = BitmapFactory.decodeFile(file.getAbsolutePath(), bOption);

        Log.e("AAAA", "new bitmap W =" + b.getWidth());
        Log.e("AAAA", "new bitmap H =" + b.getHeight());

        FaceDetector faceDetector = new FaceDetector(b.getWidth(), b.getHeight(), 1);
        FaceDetector.Face[] faces = new FaceDetector.Face[1];
        int facecount = faceDetector.findFaces(b, faces);
        if (facecount > 0) {
            FaceDetector.Face face = faces[0];
            PointF pointF = new PointF();
            face.getMidPoint(pointF);
            Log.e("AAAA", "getSmile = " + face.confidence());
            Log.e("AAAA", "x = " + pointF.x);
            Log.e("AAAA", "x = " + pointF.y);
            Log.e("AAAA", "getH = " + face.eyesDistance());

        } else {
            Log.e("erroe", "can't recognize face");
        }


//        FaceDetector faceDetector = new FaceDetector.Builder(this)
//                .setTrackingEnabled(false)
//                .setProminentFaceOnly(true)
//                .build();
//        Frame frame = new Frame.Builder().setBitmap(b).build();
//        SparseArray<Face> faces = faceDetector.detect(frame);
//
//        if (faceDetector.isOperational() && faces != null && faces.size() > 0) {
//            Face face = faces.valueAt(0);
//            Log.e("AAAA", "x = " + face.getPosition().x);
//            Log.e("AAAA", "x = " + face.getPosition().y);
//            Log.e("AAAA", "getH = " + face.getHeight());
//            Log.e("AAAA", "getW = " + face.getWidth());
//            Log.e("AAAA", "getSmile = " + face.getIsSmilingProbability());
//
//


        return b;
    }
}


