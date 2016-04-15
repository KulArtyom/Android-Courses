package com.kulart05gmail.lesson_1.HomeWorks.Homework_6;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    int count = 5;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count<10){
            this.count = count;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView tv = new TextView(context);
        tv.setText("Позиция " + position);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(tv, 0);
        return tv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager) container).removeView((TextView) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }


}
