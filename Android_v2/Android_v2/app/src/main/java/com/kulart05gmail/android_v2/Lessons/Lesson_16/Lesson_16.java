package com.kulart05gmail.android_v2.Lessons.Lesson_16;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kulart05gmail.android_v2.R;

public class Lesson_16 extends AppCompatActivity {

    private static final String TAG = Lesson_16.class.getSimpleName();
    private static final int LOADER_ID = 121212;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_16);

        getSupportLoaderManager().initLoader(LOADER_ID, new Bundle(), contactsLoader);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private LoaderManager.LoaderCallbacks<Cursor> contactsLoader = new LoaderManager.LoaderCallbacks<Cursor>() {
        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            Log.d(TAG, "onCreateLoader");

            String[] uiBindForm = {
                    ContactsContract.Contacts._ID,
                    ContactsContract.Contacts.DISPLAY_NAME,
                    ContactsContract.Contacts.PHOTO_URI,
            };
            CursorLoader cursorLoader = new CursorLoader(Lesson_16.this, ContactsContract.Contacts.CONTENT_URI, uiBindForm, null, null, null);

            return cursorLoader;
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            Log.d(TAG, "onLoadFinished");

            //data -  список людей из контактов
            if (data.moveToFirst()) {
                while (data.moveToNext()) {
                    Log.d(TAG, "name = " + data.getString(data.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                }
            }
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {
            Log.d(TAG, "onLoaderReset");

        }
    };
}
