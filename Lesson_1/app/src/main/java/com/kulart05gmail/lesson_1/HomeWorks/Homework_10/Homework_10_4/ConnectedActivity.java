package com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4.rest.ServiceBroker;
import com.kulart05gmail.lesson_1.R;

import java.text.SimpleDateFormat;

public class ConnectedActivity extends AppCompatActivity {

    private TextView user, email, created;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected);
        user = (TextView)findViewById(R.id.text_users);
        email = (TextView)findViewById(R.id.text_email);
        created = (TextView)findViewById(R.id.text_created);

        if (ServiceBroker.getInstance().getUser()!= null)
        {
            user.setText(ServiceBroker.getInstance().getUser().getName());
            email.setText(ServiceBroker.getInstance().getUser().getEmail());

            SimpleDateFormat formats = new SimpleDateFormat("dd.MMM.yyyy HH:mm");
            String textDate = formats.format(ServiceBroker.getInstance().getUser().getCreated());

            created.setText(textDate);
        }
    }
}
