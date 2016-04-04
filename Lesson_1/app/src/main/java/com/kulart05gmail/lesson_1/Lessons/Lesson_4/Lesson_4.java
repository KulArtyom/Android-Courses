package com.kulart05gmail.lesson_1.Lessons.Lesson_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kulart05gmail.lesson_1.R;

public class Lesson_4 extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_4);

        Button btn1 = (Button) findViewById(R.id.btnAc2);
        btn1.setOnClickListener(this);

        if (savedInstanceState != null) {
            //это значит что мы пересоздем activity
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //тут делаем сохранение всех важных даныых
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAc2:
                Intent i = new Intent(this, Lesson_4_1.class);
                startActivity(i);

//                Lesson_4_1.show(this);
                break;
        }
    }
}
