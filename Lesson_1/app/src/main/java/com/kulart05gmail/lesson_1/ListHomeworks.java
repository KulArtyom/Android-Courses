package com.kulart05gmail.lesson_1;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kulart05gmail.lesson_1.HomeWorks.Homework_2.Homework_2;
import com.kulart05gmail.lesson_1.HomeWorks.Homework_3.Homework_3;
import com.kulart05gmail.lesson_1.HomeWorks.Homework_5.Homework_5_1.helper.MainActivity;
import com.kulart05gmail.lesson_1.HomeWorks.Homework_5.Homework_5_2.RecyclerViewActivity;
import com.kulart05gmail.lesson_1.Lessons.Lesson_1.Lesson_1;
import com.kulart05gmail.lesson_1.Lessons.Lesson_4.Lesson_4_3;


/**
 * Created by KulArtyom on 29.03.2016.
 */
public class ListHomeworks extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_homeworks);


        String[] homeworks = {"Homework 1", "Homework 2", "Homework 3", "Homework 4", "Homework 5_1", "Homework 5_2", "Homework 7"
                , "Homework3", "Homework3", "Homework3", "Homework3", "Homework3", "Homework3"};


        // находим список
        ListView lvHW = (ListView) findViewById(R.id.lvHomeworks);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, homeworks);

        // присваиваем адаптер списку
        lvHW.setAdapter(adapter);

        lvHW.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent homework1 = new Intent(this, Lesson_1.class);
                startActivity(homework1);
                break;
            case 1:
                Intent homework2 = new Intent(this, Homework_2.class);
                startActivity(homework2);
                break;
            case 2:
                Intent homework3 = new Intent(this, Homework_3.class);
                startActivity(homework3);
                break;
            case 3:
                Intent homework_4 = new Intent(this, Lesson_4_3.class);
                startActivity(homework_4);
                break;
            case 4:
                Intent homework_5_1 = new Intent(this, MainActivity.class);
                startActivity(homework_5_1);
                break;
            case 5:
                Intent homework_5_2 = new Intent(this, RecyclerViewActivity.class);
                startActivity(homework_5_2);
                break;
        }
    }
}
