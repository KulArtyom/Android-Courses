package com.kulart05gmail.android_v2.Lessons.Lesson_12.Lesson_12_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kulart05gmail.android_v2.R;

public class Lesson_12_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_12_1);

        MyView myView = (MyView)findViewById(R.id.view);

    }

}
