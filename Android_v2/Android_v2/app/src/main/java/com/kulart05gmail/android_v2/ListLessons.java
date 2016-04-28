package com.kulart05gmail.android_v2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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

                break;

        }
    }
}
