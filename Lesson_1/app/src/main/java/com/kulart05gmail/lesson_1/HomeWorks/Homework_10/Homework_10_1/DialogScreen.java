package com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import com.kulart05gmail.lesson_1.R;

/**
 * Created by KulArtyom on 25.04.2016.
 */
public class DialogScreen {

    public static final int IDD_ABOUT = 1; // Идентификаторы диалоговых окон
    public static final int IDD_SETTINGS = 2;
    public static final int IDD_RATE = 3;

    public static AlertDialog getDialog (int ID, Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        switch(ID) {
            case IDD_ABOUT: // Диалоговое окно About
                builder.setTitle("Dialog About");
                builder.setMessage("About us");
                builder.setCancelable(true);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Отпускает диалоговое окно
                    }
                });
                return builder.create();
            case IDD_RATE: // Диалоговое окно Rate the app
                builder.setTitle("Rate the app");
                builder.setMessage("Please rate the our app");
                builder.setCancelable(true);
                builder.setPositiveButton(R.string.dialog_rate_ok, new DialogInterface.OnClickListener() { // Переход на оценку приложения
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Переход
                        dialog.dismiss();
                    }
                });
                builder.setNeutralButton(R.string.dialog_rate_cancel, new DialogInterface.OnClickListener() { // Оценить приложение потом
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Отпускает диалоговое окно
                    }
                });
                builder.setNegativeButton(R.string.dialog_rate_buy, new DialogInterface.OnClickListener() { // Переход на покупку AdFree версии
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Переход
                        dialog.dismiss();
                    }
                });
                return builder.create();
            case IDD_SETTINGS: // Диалог настроек
                View view = activity.getLayoutInflater().inflate(R.layout.settings, null); // Получаем layout по его ID
                builder.setView(view);
                builder.setTitle(R.string.dialog_settings_title);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                    public void onClick(DialogInterface dialog, int whichButton) {
                         // Переход в сохранение настроек MainActivity
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // Кнопка Отмена
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(true);
                return builder.create();
            default:
                return null;
        }
    }
}

