package com.kulart05gmail.android_v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kulart05gmail.android_v2.Homeworks.Homework_12.Homework_12;
import com.kulart05gmail.android_v2.Homeworks.Homework_14.Homework_14;
import com.kulart05gmail.android_v2.Lessons.Lesson_12.Lesson_12_1.Lesson_12_1;


public class ListHomeworks extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_homeworks);


        String[] homeworks = getResources().getStringArray(R.array.homeworks);

        ListView lvHW = (ListView) findViewById(R.id.lvHomeworks);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, homeworks);

        assert lvHW != null;
        lvHW.setAdapter(adapter);

        lvHW.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent homework_12 = new Intent(this, Homework_12.class);
                startActivity(homework_12);
                break;
            case 1:
                Intent homework_12_1 = new Intent(this, Lesson_12_1.class);
                startActivity(homework_12_1);
                break;
            case 2:
                Intent homework_13 = new Intent(this, Homework_14.class);
                startActivity(homework_13);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Данный урок не задействован", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
