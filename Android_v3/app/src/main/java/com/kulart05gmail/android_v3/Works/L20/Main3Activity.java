package com.kulart05gmail.android_v3.Works.L20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

import com.kulart05gmail.android_v3.R;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText mEditText = (EditText) findViewById(R.id.ed_1);
        assert mEditText != null;

        String s = String.valueOf(mEditText.getText())
        if (s == null) {
            mEditText.setError("Invalid password");
        }

    }
}
