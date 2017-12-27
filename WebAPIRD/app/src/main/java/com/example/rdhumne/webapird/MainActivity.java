package com.example.rdhumne.webapird;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private EditText input1;
    public String city = "";
    public static String CITY = "com.mycompany.myfirstapp.MESSAGE";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button);
        input1 = (EditText) findViewById(R.id.et_input1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                //SharedPreferences.Editor editor = sharedpreferences.edit();
                //editor.putString("City", city);
               // editor.commit();

                Intent intent = new Intent(MainActivity.this, APIActivity.class);
                city = input1.getText().toString();
                intent.putExtra(CITY, city);
                startActivity(intent);
           //SHARED PREFERENCE PART AND INTENT


            }
        });


    }

}

 /*

                                if(resp.indexOf("Rain")>0)
                                {
                                    weatherDesc = "It's rainy outside!";
                                    if (resp.indexOf("light") > 0) {
                                        rain = 0;
                                        weatherAdj = "light";
                                    }
                                    if (resp.indexOf("moderate") > 0) {
                                        rain = 2;
                                        weatherAdj = "moderate";
                                    }
                                    if (resp.indexOf("heavy") > 0) {
                                        rain = 3;
                                        weatherAdj = "heavy";
                                    }
                                    tv_result.setText("Weather is:" +weatherDesc + " The level is " +weatherAdj );
                                    if(rain==2 || rain==3)
                                    {

                                        tv_result2.setText("Might want to opt for rain boots");
                                    }
                                    else
                                    {
                                        tv_result2.setText("Don't need rainboots today!");
                                    }
                                }
                                else
                                {
                                    tv_result2.setText("Don't need rainboots today!");
                                }
                                */
/*
String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + ",us&appid=5ceffedb10c9bc3603ee4590a5c8cf45";
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                String resp = response;
                                tv_result2.setText("Current Temp:" + resp.substring(152, 158));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tv_result.setText("That didn't work!");
                    }
                });
                queue.add(stringRequest);
 */
