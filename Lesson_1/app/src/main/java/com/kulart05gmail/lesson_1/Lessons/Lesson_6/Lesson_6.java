package com.kulart05gmail.lesson_1.Lessons.Lesson_6;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.kulart05gmail.lesson_1.R;

public class Lesson_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_6);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);

        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                Toast.makeText(Lesson_6.this, "BroadcastReceiver ConnectivityManager", Toast.LENGTH_SHORT).show();

            } else if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED))
                Toast.makeText(Lesson_6.this, "BroadcastReceiver BluetoothAdapter", Toast.LENGTH_SHORT).show();

        }
    };

}
