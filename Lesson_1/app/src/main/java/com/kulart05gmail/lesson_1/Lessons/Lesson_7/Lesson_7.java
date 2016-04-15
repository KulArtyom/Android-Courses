package com.kulart05gmail.lesson_1.Lessons.Lesson_7;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.kulart05gmail.lesson_1.R;

public class Lesson_7 extends AppCompatActivity {

    private static String TAG = MyService.class.getSimpleName();
    private MyService mMyService;
    private MyIntentService mMyIntentService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_7);

        // startService(new Intent(this, MyService.class));

    }

    @Override
    protected void onResume() {
        super.onResume();
        bindService(new Intent(this, MyService.class), mServiceConnection, BIND_AUTO_CREATE);

        Intent i1 = new Intent(this,MyIntentService.class);
        i1.putExtra(MyIntentService.KEY, "One");
        startService(i1);

        Intent i2 = new Intent(this,MyIntentService.class);
        i2.putExtra(MyIntentService.KEY,"Two");
        startService(i2);

        Intent i3 = new Intent(this,MyIntentService.class);
        i3.putExtra(MyIntentService.KEY,"Three");
        startService(i3);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(mServiceConnection);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected");


            MyService.LocalBinder localBinder = (MyService.LocalBinder) service;
            mMyService = localBinder.getService();


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceConnected");
            mMyService = null;
        }
    };
}
