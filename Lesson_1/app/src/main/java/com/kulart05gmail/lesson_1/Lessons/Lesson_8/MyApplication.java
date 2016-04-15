package com.kulart05gmail.lesson_1.Lessons.Lesson_8;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;



/**
 * Created by KulArtyom on 11.04.2016.
 */
public class MyApplication extends Application {

    private static MyApplication myApplication;

    public MyApplication getInstance() {
        return myApplication;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        LeakCanary.install(this);

        myApplication = this;
        Log.d("MyApplication", "OnCreate");
    }


}
