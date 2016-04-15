package com.kulart05gmail.lesson_1.Lessons.Lesson_7;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by KulArtyom on 08.04.2016.
 */
public class MyIntentService extends IntentService {

    private static String TAG = MyIntentService.class.getSimpleName();
    public static String KEY = "\\>>>>>>=====key=====>\\";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

    }

    @Override
    //будет вызываться каждый раз когда будет вызван метод startIntentService
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "onHandleIntent start" + intent.getStringExtra(KEY));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "onHandleIntent stop" + intent.getStringExtra(KEY));

    }
}
