package com.kulart05gmail.android_v3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kulart05gmail.android_v3.Works.L20.Main3Activity;
import com.kulart05gmail.android_v3.Works.MapsActivity;

public class Lessons extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_homeworks);


        String[] works = {"Lesson18", "Lesson"};

        ListView lvHW = (ListView) findViewById(R.id.lvHomeworks);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, works);

        assert lvHW != null;
        lvHW.setAdapter(adapter);

        lvHW.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent homework_12 = new Intent(this, MapsActivity.class);
                startActivity(homework_12);
                break;
            case 1:
                Intent lesss = new Intent(this, Main3Activity.class);
                startActivity(lesss);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Данный урок не задействован", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
