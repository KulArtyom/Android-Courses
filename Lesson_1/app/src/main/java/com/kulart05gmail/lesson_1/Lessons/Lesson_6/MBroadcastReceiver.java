package com.kulart05gmail.lesson_1.Lessons.Lesson_6;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;


/**
 * Created by KulArtyom on 06.04.2016.
 */
public class MBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            Log.d("TAG","onReceive ConnectivityManager");

        } else if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED))
            Log.d("TAG", "onReceive BluetoothAdapter");

    }
}
