package com.kulart05gmail.lesson_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by KulArtyom on 29.03.2016.
 */
public class Main extends Activity implements View.OnClickListener {

    private Button btnLessons;
    private Button btnHomeWorks;
    private Button btnOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnLessons = (Button) findViewById(R.id.btnLessons);
        btnHomeWorks = (Button) findViewById(R.id.btnHomeworks);
        btnOther = (Button) findViewById(R.id.btn_other);

        btnHomeWorks.setOnClickListener(this);
        btnLessons.setOnClickListener(this);
        btnOther.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLessons:
                Intent lesson = new Intent(this, ListLessons.class);
                startActivity(lesson);
                break;
            case R.id.btnHomeworks:
                Intent homework = new Intent(this, ListHomeworks.class);
                startActivity(homework);
                break;
            case R.id.btn_other:
                Intent other = new Intent(this, ListOther.class);
                startActivity(other);
                break;
        }
    }
}
