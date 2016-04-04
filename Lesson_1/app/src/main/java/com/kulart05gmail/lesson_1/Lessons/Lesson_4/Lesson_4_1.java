package com.kulart05gmail.lesson_1.Lessons.Lesson_4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kulart05gmail.lesson_1.R;

public class Lesson_4_1 extends AppCompatActivity implements View.OnClickListener {

    private static String KEY = "text";
    public static void show(Activity activity){
        Intent i = new Intent(activity,Lesson_4_1.class);
        activity.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_4_1);
        Button btn = (Button) findViewById(R.id.btnAct2);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAct2:
                Intent i2 = new Intent(this, Lesson_4.class);
                startActivity(i2);
                break;
        }
    }
}
