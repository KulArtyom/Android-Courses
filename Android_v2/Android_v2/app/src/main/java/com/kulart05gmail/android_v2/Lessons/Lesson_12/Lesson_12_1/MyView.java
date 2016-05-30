package com.kulart05gmail.android_v2.Lessons.Lesson_12.Lesson_12_1;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by KulArtyom on 02.05.2016.
 */
public class MyView extends View {

    private Paint mPaint;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);

    }

    public MyView(Context context) {
        super(context);
        initView(context, null);

    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    public void initView(Context context, AttributeSet attrs) {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        float width = 400f;
        float height = 240f;
        float radius = 200f;

        Path path = new Path();
        path.addCircle(width, height, radius, Path.Direction.CW);
        Paint paint = new Paint();
        paint.setColor(Color.RED); // установим белый цвет
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL); // заливаем
        paint.setAntiAlias(true);

        Paint paint1 = new Paint();
        paint1.setColor(Color.YELLOW);
        paint1.setStrokeWidth(5);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);

        Paint paint2 = new Paint();
        paint1.setColor(Color.GREEN);
        paint1.setStrokeWidth(5);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);

        Paint paint3 = new Paint();
        paint1.setColor(Color.BLUE);
        paint1.setStrokeWidth(5);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);


        float center_x, center_y;
        center_x = 400f;
        center_y = 550f;

        final RectF oval = new RectF();
        oval.set(center_x - radius, center_y - radius, center_x + radius,
                center_y + radius);

//        canvas.drawArc(oval, 90, 90, true, paint1);
//        canvas.drawArc(oval, 180, 90, true, paint2);
//        canvas.drawArc(oval, 90, 180, true, paint);
        //canvas.drawArc(oval, 90, 360, true, paint);
        canvas.drawArc(oval, 90, 90, true, paint);
        canvas.drawArc(oval, 180, 90, true, paint1);
        canvas.drawArc(oval, 270, 90, true, paint);
        canvas.drawArc(oval, 360, 90, true, paint3);



        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setData(int[] s) {
        invalidate();
    }
}
