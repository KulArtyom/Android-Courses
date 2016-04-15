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
import com.kulart05gmail.lesson_1.Lessons.Lesson_4.Lesson_4_3;
import com.kulart05gmail.lesson_1.Lessons.Lesson_5.Lesson_5;
import com.kulart05gmail.lesson_1.Lessons.Lesson_6.Lesson_6;
import com.kulart05gmail.lesson_1.Lessons.Lesson_6.Lesson_6_1.Lesson_6_1;
import com.kulart05gmail.lesson_1.Lessons.Lesson_7.Lesson_7;
import com.kulart05gmail.lesson_1.Lessons.Lesson_8.ui.activities.Lesson_8;

public class ListLessons extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_lessons);


        String[] lessons = getResources().getStringArray(R.array.lesson);

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
            case 6:
                Intent lesson_6 = new Intent(this, Lesson_6.class);
                startActivity(lesson_6);
                break;
            case 7:
                Intent lesson_6_1 = new Intent(this, Lesson_6_1.class);
                startActivity(lesson_6_1);
                break;
            case 8:
                Intent lesson_7 = new Intent(this, Lesson_7.class);
                startActivity(lesson_7);
                break;
            case 9:
                Intent lesson_8 = new Intent(this, Lesson_8.class);
                startActivity(lesson_8);
                break;
        }
    }
}
