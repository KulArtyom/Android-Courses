package com.kulart05gmail.android_v2.Lessons.Lesson_13.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by KulArtyom on 06.05.2016.
 */
public class BaseActivity extends AppCompatActivity {


    public void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}
