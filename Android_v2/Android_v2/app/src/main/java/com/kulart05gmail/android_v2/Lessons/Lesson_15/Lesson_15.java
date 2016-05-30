package com.kulart05gmail.android_v2.Lessons.Lesson_15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kulart05gmail.android_v2.R;

public class Lesson_15 extends AppCompatActivity {

    private Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_15);
        mButtonNext = (Button)findViewById(R.id.btn_next);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActivity();
            }
        });

    }

    //удобный вариант выхода из приложения при использовании фрагментов
    public void showActivity() {

        Intent intent = new Intent(this, Lesson_15_1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
