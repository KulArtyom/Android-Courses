package com.kulart05gmail.lesson_1.HomeWorks.Homework_7;


import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;


public class MService extends Service {
    private static final String TAG = MService.class.getSimpleName();
    public static final String ACTION_HOMEWORK_7 = "com.kulart05gmail.lesson_1.homeworks.homework_7.homework_7";
    public static final String KEY_MESSAGE = "key_message";
    public static final String STOPPED = "Stopped";
    private Intent mIntent;
    private int mValue;

    public int getValue() {
        return mValue;
    }

    private final IBinder mIBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public MService getService() {
            return MService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        mIntent = new Intent(MService.ACTION_HOMEWORK_7);

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mTask.execute();
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);


    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return mIBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return true;
    }
    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
        mTask.cancel(true);
        mIntent.putExtra(KEY_MESSAGE, STOPPED);
        LocalBroadcastManager.getInstance(MService.this).sendBroadcast(mIntent);
    }

    private AsyncTask<Void, Void, Void> mTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            for(int i = 0; i < Integer.MAX_VALUE; i++) {
                if(isCancelled()) {
                    break;
                }
                mValue = i;
                mIntent.putExtra(KEY_MESSAGE, String.valueOf(mValue));
                LocalBroadcastManager.getInstance(MService.this).sendBroadcast(mIntent);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                Log.d(TAG, "AsyncTask doInBackground");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "AsyncTask onPostExecute");
            stopSelf();
        }
    };
}
