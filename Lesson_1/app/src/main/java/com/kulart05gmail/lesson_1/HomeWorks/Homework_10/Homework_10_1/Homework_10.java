package com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.kulart05gmail.lesson_1.R;

public class Homework_10 extends Activity implements View.OnClickListener {

    private Button mButttonAbout;
    private Button mButttonSettings;
    private Button mButttonRate;
    private Button mButtonDatePikerDialog;
    private Button mButtonTimePikerDialog;
    private TextView tvDate;


    private int DIALOG_DATE = 3;
    private int myYear = 2011;
    private int myMonth = 2;
    private int myDay = 3;

    int DIALOG_TIME = 1;
    int myHour = 14;
    int myMinute = 35;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_10);

        mButttonAbout = (Button) findViewById(R.id.btn_dialog_about);
        mButttonSettings = (Button) findViewById(R.id.btn_dialog_settings);
        mButttonRate = (Button) findViewById(R.id.btn_dialog_rate);
        mButtonDatePikerDialog = (Button) findViewById(R.id.btn_date_piker_dialog);
        mButtonTimePikerDialog = (Button) findViewById(R.id.btn_time_piker_dialog);
        tvDate = (TextView) findViewById(R.id.tvDialogs);

        mButtonTimePikerDialog.setOnClickListener(this);
        mButtonDatePikerDialog.setOnClickListener(this);
        mButttonAbout.setOnClickListener(this);
        mButttonSettings.setOnClickListener(this);
        mButttonRate.setOnClickListener(this);


    }

    private void initSettings(AlertDialog dialog) {
        // Определяем SeekBar и привязываем к нему дельты настроек
        SeekBar sb_sense = (SeekBar) dialog.findViewById(R.id.seekSense);
        SeekBar sb_vol = (SeekBar) dialog.findViewById(R.id.seekVol);
        // Задаем этим SeekBar текущие значения настроек
        sb_sense.setProgress(100);
        sb_vol.setProgress(100);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack1, myYear, myMonth, myDay);
            return tpd;
        } else if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, myHour, myMinute, true);
            return tpd;
        }
        return super.onCreateDialog(id);
    }


    DatePickerDialog.OnDateSetListener myCallBack1 = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            tvDate.setText("Today is " + myDay + "/" + myMonth + "/" + myYear);
        }
    };


    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            tvDate.setText("Time is " + myHour + " hours " + myMinute + " minutes");
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dialog_about:
                AlertDialog dialog_about = DialogScreen.getDialog(DialogScreen.IDD_ABOUT, this);
                assert dialog_about != null;
                dialog_about.show();
                break;
            case R.id.btn_dialog_settings:
                AlertDialog dialog = DialogScreen.getDialog(DialogScreen.IDD_SETTINGS, this);
                assert dialog != null;
                dialog.show();
                initSettings(dialog);
                break;
            case R.id.btn_dialog_rate:
                AlertDialog dialog_rate = DialogScreen.getDialog(DialogScreen.IDD_RATE, this);
                assert dialog_rate != null;
                dialog_rate.show();
                break;
            case R.id.btn_date_piker_dialog:
                showDialog(DIALOG_DATE);
                break;
            case R.id.btn_time_piker_dialog:
                showDialog(DIALOG_TIME);
                break;
        }
    }
}


