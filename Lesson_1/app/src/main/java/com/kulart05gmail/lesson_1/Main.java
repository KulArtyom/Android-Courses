package com.kulart05gmail.lesson_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kulart05gmail.lesson_1.Lessons.Lesson_1;

/**
 * Created by KulArtyom on 29.03.2016.
 */
public class Main extends Activity implements View.OnClickListener {

    private Button btnLessons;
    private Button btnHomeWorks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnLessons = (Button)findViewById(R.id.btnLessons);
        btnHomeWorks = (Button)findViewById(R.id.btnHomeworks);

        btnHomeWorks.setOnClickListener(this);
        btnLessons.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLessons:
                Intent lesson = new Intent(this, ListLessons.class);
                startActivity(lesson);
                break;
            case R.id.btnHomeworks:
                Intent homework = new Intent(this, ListHomeworks.class);
                startActivity(homework);
                break;
        }
    }
}
