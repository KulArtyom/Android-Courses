package com.kulart05gmail.lesson_1.HomeWorks.Homework_6;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.kulart05gmail.lesson_1.R;

public class Homework_6_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_6_3);

        ImageView imageView = (ImageView) findViewById(R.id.iv_sova);

        imageView.setBackgroundResource(R.drawable.viewanim);
        AnimationDrawable animation = (AnimationDrawable) imageView.getBackground();
            animation.start();


    }

}
