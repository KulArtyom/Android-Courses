package com.kulart05gmail.lesson_1.Lessons.Lesson_4;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kulart05gmail.lesson_1.R;


/**
 * Created by KulArtyom on 01.04.2016.
 */
public class MyArrayAdapter extends ArrayAdapter {

    private String[] names;
    private final Activity context;

    public MyArrayAdapter(Context context, String[] names) {
        super(context, R.layout.item_text, names);
        this.context = (Activity) context;
        this.names = names;

    }


    static class ViewHolder {
        private ImageView imageView;
        private TextView textView;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // ViewHolder буферизирует оценку различных полей шаблона элемента
        ViewHolder holder;
        // Очищает сущетсвующий шаблон, если параметр задан
        // Работает только если базовый шаблон для всех классов один и тот же
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_text, null, true);
            holder = new ViewHolder();
            holder.textView = (TextView) rowView.findViewById(R.id.tvText);
            holder.imageView = (ImageView) rowView.findViewById(R.id.image);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        holder.textView.setText(names[position]);
        Log.d("ListAdapter", "getView() position = " + position);

//        /* конвертируем xml  в объектную модель */
//        View view = mLayoutInflater.inflate(R.layout.item_text, parent, false);
//
//        //находим  объект TextView
//        TextView textView = (TextView) view.findViewById(R.id.tvText);
//
//        //получаем из колекции строчку которую хотим показать на экране
//        //position - эти данные подаются в getView() от ListView котоорму мы задаем данный адаптер
//        String text = mList.get(position);
//
//        //записываем строку из колекции TextView
//        textView.setText(text);

        return rowView;

    }
}
