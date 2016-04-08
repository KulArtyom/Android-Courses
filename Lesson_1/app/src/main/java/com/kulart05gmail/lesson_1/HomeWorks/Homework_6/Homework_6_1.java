package com.kulart05gmail.lesson_1.HomeWorks.Homework_6;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.kulart05gmail.lesson_1.R;

public class Homework_6_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_6_1);

        final ImageView imageButton = (ImageView) findViewById(R.id.ib_lavery);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homework_6_1.this, Homework_6.class);
                startActivity(intent);
                overridePendingTransition(R.anim.rigth_in, R.anim.left_out);
            }
        });
    }

}
