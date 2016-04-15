package com.kulart05gmail.lesson_1.Lessons.Lesson_8.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kulart05gmail.lesson_1.Lessons.Lesson_8.Models.LoginRequest;
import com.kulart05gmail.lesson_1.Lessons.Lesson_8.network.listeners.LoginCallback;
import com.kulart05gmail.lesson_1.Lessons.Lesson_8.ServiceBroker;
import com.kulart05gmail.lesson_1.R;

public class Lesson_8 extends AppCompatActivity {

    private static final String TAG = Lesson_8.class.getSimpleName();

    private Button mButton;
    private TextView mTextview;
    private EditText mLoginEditText;
    private EditText mPasswordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_8);

        mButton = (Button) findViewById(R.id.btn_rest);
        mTextview = (TextView) findViewById(R.id.tv_rest);
        mLoginEditText = (EditText) findViewById(R.id.ed_t);
        mPasswordEditText = (EditText) findViewById(R.id.ed_t1);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick mButton");

                LoginRequest loginRequest = new LoginRequest(
                        String.valueOf(mLoginEditText.getText()),
                        String.valueOf(mPasswordEditText.getText()));

                // тут можно запустить ProgressBar
                ServiceBroker.getInstance().login(loginRequest, new LoginCallback() {
                    @Override
                    public void response(boolean isError) {
                        // а тут остановить ProgressBar
                        if (isError) {
                            mTextview.setText("Ошибка");
                        } else {
                            mTextview.setText("Все супер");
                        }
                    }
                });
            }
        });
    }
}