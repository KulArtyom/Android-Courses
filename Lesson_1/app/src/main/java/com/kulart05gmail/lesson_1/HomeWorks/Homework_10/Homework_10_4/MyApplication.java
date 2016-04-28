package com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;

/**
 * Created by al-ev on 11.04.2016.
 */
public class MyApplication extends Application{

private static MyApplication myApplication;

    public MyApplication getInstance()
    {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Moi", "MyApplication class onCreate");
        myApplication = this;
        Stetho.initializeWithDefaults(this);
    }
}
