package com.kulart05gmail.lesson_1.HomeWorks.Homework_5.Homework_5_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kulart05gmail.lesson_1.R;

public class CardViewActivity extends Activity {

    TextView personName;
    TextView personAge;
    ImageView personPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cardview_activity);
        personName = (TextView)findViewById(R.id.person_name);
        personAge = (TextView)findViewById(R.id.person_age);
        personPhoto = (ImageView)findViewById(R.id.person_photo);

        personName.setText("Emma Wilson");
        personAge.setText("23 years old");
        personPhoto.setImageResource(R.drawable.emma);
    }
}
