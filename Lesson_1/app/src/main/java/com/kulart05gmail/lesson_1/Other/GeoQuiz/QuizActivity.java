package com.kulart05gmail.lesson_1.Other.GeoQuiz;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kulart05gmail.lesson_1.R;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonnTrue;
    private Button mButtonnFalse;
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mButtonnFalse = (Button) findViewById(R.id.btn_false);
        mButtonnTrue = (Button) findViewById(R.id.btn_true);
        mTextView = (TextView)findViewById(R.id.tv_text);

        mButtonnTrue.setOnClickListener(this);
        mButtonnFalse.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_true:
                Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_false:
                Toast.makeText(this, R.string.wrongg_toast, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
