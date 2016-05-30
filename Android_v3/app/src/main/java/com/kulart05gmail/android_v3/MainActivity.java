package com.kulart05gmail.android_v3;

import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kulart05gmail.android_v3.Works.MapsActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnLessons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLessons = (Button) findViewById(R.id.btn_lessons);


        btnLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lessons = new Intent(MainActivity.this, Lessons.class);
                startActivity(lessons);
            }
        });


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }
}
