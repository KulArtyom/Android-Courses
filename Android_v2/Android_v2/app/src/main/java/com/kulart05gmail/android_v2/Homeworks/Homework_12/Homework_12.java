package com.kulart05gmail.android_v2.Homeworks.Homework_12;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.kulart05gmail.android_v2.R;

import java.util.ArrayList;

public class Homework_12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_12);

        PieChart pieChart = (PieChart) findViewById(R.id.chart);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(20f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(12f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));

        PieDataSet dataset = new PieDataSet(entries, "");

        final ArrayList<String> labels = new ArrayList<String>();
        labels.add("Apple");
        labels.add("LG");
        labels.add("Huawei");
        labels.add("Samsung");
        labels.add("Sony");
        labels.add("Lenovo");

        PieData data = new PieData(labels, dataset);
        //Размер шрифта внутреннего текста
        data.setValueTextSize(10f);

        //Добаление большего количества ццветов
        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.JOYFUL_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.COLORFUL_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.LIBERTY_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.PASTEL_COLORS) {
            colors.add(c);
        }

        colors.add(ColorTemplate.getHoloBlue());
        //добавление цветов в диаграмму
        dataset.setColors(colors);
        //Текст дескрипшена
        pieChart.setDescription("Description");
        //Размер дескрипшена
        pieChart.setDescriptionTextSize(20f);

        pieChart.setData(data);
        //внешний радиус
        pieChart.setHoleRadius(15);
        //внутренний радиус
        pieChart.setTransparentCircleRadius(20);
        // pieChart.setCenterTextSize(20f);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                //displayed msg when value select
                if (entry == null)
                    return;
                Toast.makeText(getApplicationContext(), labels.get(entry.getXIndex()) + " = " + entry.getVal() + "%",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });


        pieChart.animateY(5000);

    }
}
