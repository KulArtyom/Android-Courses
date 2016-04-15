package com.kulart05gmail.lesson_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kulart05gmail.lesson_1.StartAndroid.Lesson_52_SimpleCursorAdapter.SimpleCursorAdapter;

public class ListStartAndroid extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvStartAndroid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_start_android);


        String[] startandroidlessons = {"Lesson 52 \"SimpleCursorAdapter\"", "Lesson 2", "Lesson 3", "Lesson 4", "Lesson 5", "Lesson 6", "Lesson 7", "Lesson 8", "Lesson 9", "Lesson 10", "Lesson 11", "Lesson 12", "Lesson 13", "Lesson 14"};

        // находим список
        lvStartAndroid = (ListView) findViewById(R.id.lv_startandroid);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, startandroidlessons);

        // присваиваем адаптер списку
        lvStartAndroid.setAdapter(adapter);

        lvStartAndroid.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent l_52 = new Intent(this, SimpleCursorAdapter.class);
                startActivity(l_52);
                break;

        }
    }
}
