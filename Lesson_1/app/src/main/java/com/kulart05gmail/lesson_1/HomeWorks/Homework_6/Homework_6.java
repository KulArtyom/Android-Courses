package com.kulart05gmail.lesson_1.HomeWorks.Homework_6;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.kulart05gmail.lesson_1.R;

public class Homework_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_6);

        ImageView icon = (ImageView) findViewById(R.id.im_emma);

        Animation animRotateIn_icon = AnimationUtils.loadAnimation(this,
                R.anim.rotate);

         icon.startAnimation(animRotateIn_icon);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homework_6.this, Homework_6_1.class);
                startActivity(i);
                overridePendingTransition(R.anim.rigth_in, R.anim.left_out);
            }
        });

    }


}
