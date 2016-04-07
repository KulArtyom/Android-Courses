package com.kulart05gmail.lesson_1.Lessons.Lesson_6.Lesson_6_1;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.kulart05gmail.lesson_1.R;

import butterknife.Bind;

import static com.kulart05gmail.lesson_1.R.color.red;
import static com.kulart05gmail.lesson_1.R.drawable.rounded_btn_without_color;

public class Lesson_6_1 extends AppCompatActivity {

    private RelativeLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_6_1);

        Button button = (Button) findViewById(R.id.btn_draw);
        ll = (RelativeLayout)findViewById(R.id.rl_lesson_6_1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    ll.setBackground(getResources().getDrawable(R.color.red));
                }
                ll.getBackground();
                Toast.makeText(Lesson_6_1.this, "Boom", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
