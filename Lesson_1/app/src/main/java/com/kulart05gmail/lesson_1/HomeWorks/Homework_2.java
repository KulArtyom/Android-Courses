package com.kulart05gmail.lesson_1.HomeWorks;

import android.app.Activity;
import android.media.MediaActionSound;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kulart05gmail.lesson_1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Homework_2 extends Activity {

    private Button btnShow;
    private TextView tvTextParse;
    private ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_2);

        btnShow = (Button) findViewById(R.id.btnShow);
        tvTextParse = (TextView) findViewById(R.id.tvParseText);
        bar = (ProgressBar) findViewById(R.id.pbProgressBar);




        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JSONTask().execute("http://kiparo.ru/t/service_station.json");
            }
        });



    }


    private void startThread(){
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } ;
        }
    };




    public class JSONTask extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {
            Thread thread = new Thread(runnable);
            thread.start();
            //выполняется в отдельном потоке
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(params[0]);
                try {
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();

                    InputStream stream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();

                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line + "");
                    }
                    String finalJson = buffer.toString();


                    JSONObject parentObject = new JSONObject(finalJson);
                    JSONArray parentArray = parentObject.getJSONArray("customers");

                    StringBuffer finalBufferData = new StringBuffer();
                    for (int i = 0; i < parentArray.length(); i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);

                        int id = finalObject.getInt("id");
                        String name = finalObject.getString("name");
                        String surname = finalObject.getString("surname");
                        String middlename = finalObject.getString("middle_name");
                        String lastOrder = finalObject.getString("lastOrder");
                        String dateofBirth = finalObject.getString("dateOfBirth");
                        String car = finalObject.getString("car");
                        boolean discount = Boolean.parseBoolean(finalObject.getString("discount"));
                        finalBufferData.append("id - " + id + "\n" +
                                               "name - " + name + "\n" +
                                                "surname - " + surname + "\n" +
                                                "middle name - " + middlename + "\n" +
                                                "lastOrder - " + lastOrder + "\n" +
                                               "dateofBirth - " + dateofBirth + "\n" +
                                                "car - " + car + "\n" +
                                                "discount - " + discount + "\n");
                    }
                    return finalBufferData.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            bar.setProgress(BIND_IMPORTANT);
        }

        @Override
        protected void onPreExecute() {
            bar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String result) {
            bar.setVisibility(View.GONE);
            super.onPostExecute(result);
            tvTextParse.setText(result);
        }
    }

}




