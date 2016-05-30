package com.kulart05gmail.android_v2.Lessons.Lesson_11_DataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.kulart05gmail.android_v2.R;

public class Lesson_11 extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = "myLogs";
    private EditText edName;
    private EditText edEmail;
    private EditText edId;

    private Button btnSave;
    private Button btnLoad;
    private Button btnClear;
    private Button btnUpdate;
    private Button btnDelete;
    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_11);
        showLog();

        edName = (EditText) findViewById(R.id.ed_name);
        edEmail = (EditText) findViewById(R.id.ed_email);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnClear = (Button) findViewById(R.id.btn_clear);
        btnLoad = (Button) findViewById(R.id.btn_load);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        edId = (EditText) findViewById(R.id.ed_id);


        dbHelper = new DBHelper(this);

        btnSave.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // создаем объект для данных
        ContentValues cv = new ContentValues();

        // получаем данные из полей ввода
        String name = edName.getText().toString();
        String email = edEmail.getText().toString();
        String id = edId.getText().toString();

        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        switch (v.getId()) {
            case R.id.btn_save:
                Log.e(LOG_TAG, "--- Insert in mytable: ---");
                // подготовим данные для вставки в виде пар: наименование столбца - значение

                cv.put("name", name);
                cv.put("email", email);
                // вставляем запись и получаем ее ID
                long rowID = db.insert("mytable", null, cv);
                Log.e(LOG_TAG, "row inserted, ID = " + rowID);
                Toast.makeText(getApplicationContext(), "Save", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_load:
                Log.e(LOG_TAG, "--- Rows in mytable: ---");
                // делаем запрос всех данных из таблицы mytable, получаем Cursor
                Cursor c = db.query("mytable", null, null, null, null, null, null);

                // ставим позицию курсора на первую строку выборки
                // если в выборке нет строк, вернется false
                if (c.moveToFirst()) {

                    // определяем номера столбцов по имени в выборке
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");
                    int emailColIndex = c.getColumnIndex("email");

                    do {
                        // получаем значения по номерам столбцов и пишем все в лог
                        Log.e(LOG_TAG,
                                "ID = " + c.getInt(idColIndex) +
                                        ", name = " + c.getString(nameColIndex) +
                                        ", email = " + c.getString(emailColIndex));
                        Toast.makeText(getApplicationContext(), "Load", Toast.LENGTH_SHORT).show();
                        // переход на следующую строку
                        // а если следующей нет (текущая - последняя), то false - выходим из цикла
                    } while (c.moveToNext());
                } else
                    Log.e(LOG_TAG, "0 rows");
                c.close();
                break;
            case R.id.btn_clear:
                Log.e(LOG_TAG, "--- Clear mytable: ---");
                // удаляем все записи
                int clearCount = db.delete("mytable", null, null);
                Log.e(LOG_TAG, "deleted rows count = " + clearCount);
                Toast.makeText(getApplicationContext(), "Clear", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_update:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.e(LOG_TAG, "--- Update mytabe: ---");
                // подготовим значения для обновления
                cv.put("name", name);
                cv.put("email", email);
                // обновляем по id
                int updCount = db.update("mytable", cv, "id = ?",
                        new String[]{id});
                Log.e(LOG_TAG, "updated rows count = " + updCount);
                Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_delete:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.e(LOG_TAG, "--- Delete from mytabe: ---");
                // удаляем по id
                int delCount = db.delete("mytable", "id = " + id, null);
                Log.e(LOG_TAG, "deleted rows count = " + delCount);
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();

                break;
        }


        // закрываем подключение к БД
        dbHelper.close();
    }

    public void showLog() {
        Log.e(LOG_TAG, "Logged");
    }
}
