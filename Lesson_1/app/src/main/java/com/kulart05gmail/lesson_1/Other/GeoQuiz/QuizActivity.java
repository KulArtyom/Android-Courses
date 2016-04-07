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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kulart05gmail.lesson_1.R;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonnTrue;
    private Button mButtonnFalse;
    private ImageButton mBtnNext;
    private ImageButton mBtnBack;
    private TextView mTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    private int mCurrentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mButtonnFalse = (Button) findViewById(R.id.btn_false);
        mButtonnTrue = (Button) findViewById(R.id.btn_true);
        mBtnNext = (ImageButton) findViewById(R.id.btn_next);
        mBtnBack = (ImageButton) findViewById(R.id.btn_back);
        mTextView = (TextView) findViewById(R.id.tv_text);


        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mTextView.setText(question);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                upDateQuestion();

            }
        });

        mButtonnTrue.setOnClickListener(this);
        mButtonnFalse.setOnClickListener(this);
        mBtnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                    upDateQuestion();
                } catch (ArrayIndexOutOfBoundsException e) {
                    Toast.makeText(QuizActivity.this, "Null", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                        upDateQuestion();

                } catch (ArrayIndexOutOfBoundsException e) {
                    Toast.makeText(QuizActivity.this, "Null", Toast.LENGTH_SHORT).show();
                }

            }
        });

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
                checkAnswer(true);
                break;
            case R.id.btn_false:
                checkAnswer(false);
                break;

        }
    }

    //метод обновления вопроса
    private void upDateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mTextView.setText(question);
    }

    //метод выбора правильного ответа
    private void checkAnswer(boolean userPressedTrue) {
        try {
            boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTrue();
            int messageResId = 0;
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
            } else {
                messageResId = R.string.wrongg_toast;
            }
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                    .show();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }


}
