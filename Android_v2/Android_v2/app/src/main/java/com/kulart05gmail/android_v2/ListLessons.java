package com.kulart05gmail.android_v2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kulart05gmail.android_v2.Lessons.Lesson_11_DataBase.Lesson_11;
import com.kulart05gmail.android_v2.Lessons.Lesson_12.Lesson_12_2.Lesson_12;
import com.kulart05gmail.android_v2.Lessons.Lesson_13.activity.Lesson_13;
import com.kulart05gmail.android_v2.Lessons.Lesson_15.Lesson_15;
import com.kulart05gmail.android_v2.Lessons.Lesson_16.Lesson_16;
import com.kulart05gmail.android_v2.Lessons.Lesson_17.Lesson_17;
import com.kulart05gmail.android_v2.Lessons.Lesson_18.MapsActivity;


public class ListLessons extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_lessons);


        String[] lessons = getResources().getStringArray(R.array.lesson);

        ListView lvLS = (ListView) findViewById(R.id.lvLessons);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lessons);

        assert lvLS != null;
        lvLS.setAdapter(adapter);

        lvLS.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent lesson_11 = new Intent(ListLessons.this, Lesson_11.class);
                startActivity(lesson_11);
                break;
            case 1:
                Intent lesseon_12 = new Intent(ListLessons.this, Lesson_12.class);
                startActivity(lesseon_12);
                break;
            case 2:
                Intent lesson_13 = new Intent(ListLessons.this, Lesson_13.class);
                startActivity(lesson_13);
                break;
            case 3:
                Intent lesson_15 = new Intent(ListLessons.this, Lesson_15.class);
                startActivity(lesson_15);
                break;
            case 4:
                Intent lesson_16 = new Intent(ListLessons.this, Lesson_16.class);
                startActivity(lesson_16);
                break;
            case 5:
                Intent lesson_17 = new Intent(ListLessons.this, Lesson_17.class);
                startActivity(lesson_17);
                break;
            case 6:
                Intent lesson_18 = new Intent(ListLessons.this, MapsActivity.class);
                startActivity(lesson_18);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Данный урок не задействован", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
