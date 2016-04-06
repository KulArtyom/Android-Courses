package com.kulart05gmail.lesson_1.Lessons.Lesson_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kulart05gmail.lesson_1.Lessons.Lesson_1.Lesson_1;
import com.kulart05gmail.lesson_1.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Lesson_5 extends Activity {

    @Bind(R.id.rv_Lesson5)RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_5);

      //  mRecyclerView = (RecyclerView) findViewById(R.id.rv_Lesson5);

        ButterKnife.bind(this);

        List<String> lvList = new ArrayList<>();
        lvList.add("Item 1");
        lvList.add("Item 2");
        lvList.add("Item 3");
        lvList.add("Item 4");
        lvList.add("Item 5");
        lvList.add("Item 6");
        lvList.add("Item 7");
        lvList.add("Item 8");
        lvList.add("Item 9");
        lvList.add("Item 10");
        lvList.add("Item 11");
        lvList.add("Item 12");
        lvList.add("Item 13");
        lvList.add("Item 14");
        lvList.add("Item 15");

        //метод ускоряет rv если высота всех элементов одинаковая
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        RListAdapter adapter = new RListAdapter(lvList, new RListAdapter.onItemClickkListener() {
            @Override
            public void OnClick(String text, int position) {
                switch (position){
                    case 0:
                        Intent i = new Intent(Lesson_5.this, Lesson_1.class);
                        startActivity(i);
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(adapter);


    }


//    @OnClick(R.id.button)
//    private void OnClick(){
//
//    }

}
