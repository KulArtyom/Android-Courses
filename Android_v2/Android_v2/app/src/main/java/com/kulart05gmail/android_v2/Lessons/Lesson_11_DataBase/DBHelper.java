package com.kulart05gmail.android_v2.Lessons.Lesson_11_DataBase;


import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;


/**
 * Created by KulArtyom on 29.04.2016.
 */
public class DBHelper extends SQLiteOpenHelper implements BaseColumns {

    private static final String LOG_TAG = "myLogs";
    // имя базы данных
    private static final String DATABASE_NAME = "mydatabase";
    //версия базы данных
    private static final int DATA_BASE_VERSION = 1;
    //имя таблицы
    private static final String DATABASE_TABLE = "users";
    //имена колонок
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SURNAME = "surname";


    private static final String DATE_BASE_CREATE_SCRIPT = "create table mytable ("
            + "id integer primary key autoincrement,"
            + "name text,"
            + "email text" + ");";


    //Третий параметр null в суперклассе используется для работы с курсорами. Сейчас их не используем, поэтому оставим в покое.
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATA_BASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL(DATE_BASE_CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}



