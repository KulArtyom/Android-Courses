package com.kulart05gmail.android_v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListHomeworks extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_homeworks);


        String[] homeworks = getResources().getStringArray(R.array.homeworks);

        ListView lvHW = (ListView) findViewById(R.id.lvHomeworks);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, homeworks);

        lvHW.setAdapter(adapter);

        lvHW.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:

                break;
            default:
                break;

        }
    }
}
