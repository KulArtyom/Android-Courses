package com.kulart05gmail.lesson_1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kulart05gmail.lesson_1.R;

import java.util.ArrayList;

public class ListOther extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_other);

        ListView lvOther = (ListView) findViewById(R.id.lv_other);

        ArrayList<String> other = new ArrayList<>();
        other.add("Item 1");
        other.add("Item 2");
        other.add("Item 3");
        other.add("Item 4");
        other.add("Item 5");
        other.add("Item 6");
        other.add("Item 7");
        other.add("Item 8");
        other.add("Item 9");
        other.add("Item 10");
        other.add("Item 11");

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, other);

        // присваиваем адаптер списку
        lvOther.setAdapter(adapter);

        lvOther.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                break;
        }
    }
}
