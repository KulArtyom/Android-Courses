package com.kulart05gmail.android_v2.Lessons.Lesson_12.Lesson_12_2;

import android.os.Handler;
import android.os.Message;

/**
 * Created by KulArtyom on 02.05.2016.
 */
public class MThread extends Thread {

    private Handler mHandler;

    public MThread(Handler handler) {
        mHandler = handler;
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message message = new Message();
        message.what = Lesson_12.MESSAGE_TOAST;
        message.arg1 = 500;
        message.arg2 = 700;
        message.obj = "Hello";


        mHandler.sendMessage(message);
    }

}
