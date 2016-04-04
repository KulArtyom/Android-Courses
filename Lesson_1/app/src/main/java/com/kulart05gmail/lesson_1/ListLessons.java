package com.kulart05gmail.lesson_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kulart05gmail.lesson_1.Lessons.Lesson_2.Lesson_2;
import com.kulart05gmail.lesson_1.Lessons.Lesson_1.Lesson_1;
import com.kulart05gmail.lesson_1.Lessons.Lesson_3.Lesson_3;
import com.kulart05gmail.lesson_1.Lessons.Lesson_4.Lesson_4;
import com.kulart05gmail.lesson_1.Lessons.Lesson_4.Lesson_4_1;
import com.kulart05gmail.lesson_1.Lessons.Lesson_4.Lesson_4_3;
import com.kulart05gmail.lesson_1.Lessons.Lesson_5.Lesson_5;

public class ListLessons extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_lessons);


        String[] lessons = {"Lesson 1", "Lesson 2", "Lesson 3", "Lesson 4", "Lesson 4.1", "Lesson 5",
                "Lesson 6", "Lesson 7", "Lesson 8", "Lesson 9", "Lesson 10"};


        // находим список
        ListView lvLS = (ListView) findViewById(R.id.lvLessons);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lessons);

        // присваиваем адаптер списку
        lvLS.setAdapter(adapter);

        lvLS.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent lesson_1 = new Intent(this, Lesson_1.class);
                startActivity(lesson_1);
                break;
            case 1:
                Intent lesson_2 = new Intent(this, Lesson_2.class);
                startActivity(lesson_2);
                break;
            case 2:
                Intent lesson_3 = new Intent(this, Lesson_3.class);
                startActivity(lesson_3);
                break;
            case 3:
                Intent lesson_4 = new Intent(this, Lesson_4.class);
                startActivity(lesson_4);
                break;
            case 4:
                Intent lesson_4_1 = new Intent(this, Lesson_4_3.class);
                startActivity(lesson_4_1);
                break;
            case 5:
                Intent lesson_5 = new Intent(this, Lesson_5.class);
                startActivity(lesson_5);
                break;
        }
    }
}
