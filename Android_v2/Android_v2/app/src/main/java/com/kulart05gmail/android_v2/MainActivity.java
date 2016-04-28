package com.kulart05gmail.android_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnLessons;
    private Button btnHomeworks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLessons = (Button) findViewById(R.id.btn_lessons);
        btnHomeworks = (Button) findViewById(R.id.btn_homeworks);

        btnLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lessons = new Intent(MainActivity.this, ListLessons.class);
                startActivity(lessons);
            }
        });

        btnHomeworks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeworks = new Intent(MainActivity.this, ListHomeworks.class);
                startActivity(homeworks);
            }
        });

    }
}
