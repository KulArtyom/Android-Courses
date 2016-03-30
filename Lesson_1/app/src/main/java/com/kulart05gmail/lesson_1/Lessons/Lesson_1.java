package com.kulart05gmail.lesson_1.Lessons;


import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kulart05gmail.lesson_1.R;


public class Lesson_1 extends Activity implements View.OnClickListener {

    private TextView tvTitle;
    private TextView tvC;
    private TextView tvJava;
    private Button btnBlack;
    private Button btnGreen;
    private Button btnYellow;
    private Button btnChange;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_1);


        btnBlack = (Button) findViewById(R.id.bntBlack);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnYellow = (Button) findViewById(R.id.btnYellow);
        btnChange = (Button) findViewById(R.id.btnChange);



        tvTitle = (TextView) findViewById(R.id.tvAndroidCourses);
        tvJava = (TextView) findViewById(R.id.tvJava);
        tvC = (TextView) findViewById(R.id.tvC);
        tvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvJava.setText("Java");
                tvC.setText("C++");
            }
        });


        btnBlack.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnChange.setOnClickListener(this);
        tvJava.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bntBlack:
                tvTitle.setTextColor(Color.BLACK);
                break;
            case R.id.btnGreen:
                tvTitle.setTextColor(Color.GREEN);
                break;
            case R.id.btnYellow:
                tvTitle.setTextColor(Color.YELLOW);
                break;
            case R.id.btnChange:
                tvJava.setText("C++");
                tvC.setText("Java");
                break;
            case R.id.tvJava:
                tvJava.setText("C++");
                tvC.setText("Java");
                break;

        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}