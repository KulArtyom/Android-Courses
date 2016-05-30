package com.kulart05gmail.android_v2.Lessons.Lesson_12.Lesson_12_2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.kulart05gmail.android_v2.R;

public class Lesson_12 extends AppCompatActivity {

    public static final int MESSAGE_TOAST = 0;
    public static final int MESSAGE_ALLERT = 1;


    private MHandler mHandler;
    private Runnable runnable;
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_12);

        //c помощью него можно делать пересылку данных
        mHandler = new MHandler();
//
//        //ппривязка конкретно к UI потоку
//        // mHandler = new Handler(Looper.getMainLooper());
//
//
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                //все будет выполнено в главном потоке
//                Log.e(TAG, "");
//            }
//        });
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //поток стартанул
//                mHandler = new MHandler();
//
//
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.getMessage();
//                }
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        //все будет выполнено в главном потоке
//                        Log.e(TAG, "");
//                    }
//                });
//            }
//        });
//        thread.start();
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //поток стартанул и мы находимся в отдельном потоке
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        //будет выполнено от имени первого потока
//                    }
//                });
//            }
//        });
//        thread1.start();
//
//
//        mHandler.postDelayed(runnable, 2999);
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                //то что выполенится через 2999 млс
//            }
//        };

        MThread mThread = new MThread(mHandler);
        mThread.start();

    }

    private class MHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case MESSAGE_TOAST:
                    Toast.makeText(getApplicationContext(), "Shalalala", Toast.LENGTH_SHORT).show();
                    Log.e("sdf", "msg.arg1 = " + msg.arg1);
                    Log.e("sdf", "msg.arg2 = " + msg.arg2);


                    break;
                case MESSAGE_ALLERT:
                    //alertdialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(Lesson_12.this);
                    builder.setTitle("Allert")
                            .setMessage("Allert mythefucker!!!!!")
                            .setCancelable(false)
                            .setNegativeButton("ACAB",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                    break;
                default:
                    //неизвестное сообщение
                    break;
            }

        }
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        mHandler.postDelayed(runnable, 2000);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mHandler.removeCallbacks(runnable);
//    }
}
