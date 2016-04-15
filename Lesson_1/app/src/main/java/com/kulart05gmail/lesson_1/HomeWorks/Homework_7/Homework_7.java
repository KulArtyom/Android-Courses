package com.kulart05gmail.lesson_1.HomeWorks.Homework_7;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.kulart05gmail.lesson_1.R;

public class Homework_7 extends Activity {

    private static final String TAG = Homework_7.class.getSimpleName();
    private final static String KEY_TEXT = "text";


    private Button mButton;
    private TextView mTextView;
    private MService mMyService;
    private Animation mAnimation1;
    private Animation mAnimation2;

    public static void newIntentForResult(Activity activity, String text, int requestCode) {

        Intent intent = new Intent(activity, Homework_7.class);
        intent.putExtra(KEY_TEXT, text);
        activity.startActivityForResult(intent, requestCode);
    }

    private void showIntentsetResult() {
        // получаем сообщение
        Intent intent = getIntent();
        // выводим сообщение
        Toast.makeText(this, intent.getStringExtra(KEY_TEXT), Toast.LENGTH_SHORT).show();
    }

    private void answer() {
        // отвечаем что все ок
        setResult(Activity.RESULT_OK);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_8);
        showIntentsetResult();
        Log.d(TAG, "onCreate");
        mButton = (Button) findViewById(R.id.btn_start);
        mTextView = (TextView) findViewById(R.id.tv_tvtimer);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animations();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, MService.class), mServiceConnection, 0);
        mTextView.setTextSize(10);
        mTextView.setText("СЕРВИС НЕ ЗАПУЩЕН");
        Log.d(TAG, "onStart");
        mButton.setText("Start");
        IntentFilter filter = new IntentFilter();
        filter.addAction(MService.ACTION_HOMEWORK_7);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
        final String TEXT_STOP = "Stop";
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mButton.getText().equals(TEXT_STOP)) {
                    stopService(new Intent(Homework_7.this, MService.class));
                    mButton.setText("Start");
                } else {
                    startService(new Intent(Homework_7.this, MService.class));
                    mButton.setText("Stop");
                }

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        unbindService(mServiceConnection);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected");
            mButton.setText("Stop");
            MService.LocalBinder localBinder = (MService.LocalBinder) service;
            mMyService = localBinder.getService();
            String message = String.valueOf(mMyService.getValue());
            sizeText(message);
            mTextView.setText(message);
            answer();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected");
            mMyService = null;
        }
    };

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "BroadcastReceiver");
            String message = intent.getStringExtra(MService.KEY_MESSAGE);
            if (intent.getAction().equals(MService.ACTION_HOMEWORK_7)) {
                if (message.equals(MService.STOPPED)) {
                    mTextView.setTextSize(10);
                    mTextView.append("\n");
                    mTextView.append(MService.STOPPED);
                    mButton.setText("Start");
                } else {
                    sizeText(message);
                    mTextView.setText(message);
                }

            }
        }
    };

    protected void sizeText(String message) {
        if (message.equals(MService.STOPPED)) {
            return;
        }
        if (Integer.parseInt(message) < 100) {
            mTextView.setTextSize(350);
        } else if (Integer.parseInt(message) < 1000) {
            mTextView.setTextSize(240);
        } else if (Integer.parseInt(message) < 10000) {
            mTextView.setTextSize(180);
        } else if (Integer.parseInt(message) < 100000) {
            mTextView.setTextSize(140);
        } else if (Integer.parseInt(message) < 1000000) {
            mTextView.setTextSize(120);
        } else if (Integer.parseInt(message) < 10000000) {
            mTextView.setTextSize(100);
        } else if (Integer.parseInt(message) < 100000000) {
            mTextView.setTextSize(90);
        } else if (Integer.parseInt(message) < 1000000000) {
            mTextView.setTextSize(80);
        } else if (Integer.parseInt(message) < Integer.MAX_VALUE) {
            mTextView.setTextSize(70);
        }
    }

    private void animations() {

        mAnimation1 = AnimationUtils.loadAnimation(Homework_7.this, R.anim.left_out);
        mButton.startAnimation(mAnimation1);
        mAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mTextView.setClickable(false);
                mButton.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                animationSkale();
                            }
                        });
                    }
                });
                thread.start();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void animationSkale() {
        mAnimation2 = AnimationUtils.loadAnimation(Homework_7.this, R.anim.rigth_in);
        mButton.startAnimation(mAnimation2);
        mAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                mButton.setVisibility(View.GONE);
                mTextView.setClickable(true);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
