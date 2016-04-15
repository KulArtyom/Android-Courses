package com.kulart05gmail.lesson_1.HomeWorks.Homework_6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kulart05gmail.lesson_1.R;

public class Homework_6_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_6_3_1);

        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
//        CirclePageIndicator circleIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
//        circleIndicator.setViewPager(viewPager);
    }

}
