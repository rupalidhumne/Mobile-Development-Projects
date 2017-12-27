package com.example.rdhumne.webapird;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
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

public class APIActivity extends AppCompatActivity
{
    private TextView tv_result, tv_result2;
    private RequestQueue queue;
    int rain;
    String weatherDesc;
    String rainDesc;
    String weatherAdj;
    double prevTemp, currTemp;
    boolean clicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        Intent intent = getIntent();
        final String city = intent.getStringExtra(MainActivity.CITY);
        tv_result = (TextView) findViewById(R.id.tv_result);

        tv_result2 = (TextView) findViewById(R.id.tv_result2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(APIActivity.this, MainActivity.class);
                startActivity(intent);



            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {

            public void run() {
                update(city);
                //tv_result2.setText(city);

            }
        }, 0, 500000000);


    }
    public void update(String c)
    {
        final String place = c;
        //SharedPreferences prefs =getSharedPreferences("City",0);
        //
        queue = Volley.newRequestQueue(this);
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + place + ",us&appid=5ceffedb10c9bc3603ee4590a5c8cf45";
        //tv_result2.setText(url); BREAKS HERE :-(
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        String resp = response;


                        if (resp.indexOf("Rain") > 0) {

                            if (resp.indexOf("light") > 0) {
                                rain = 0;

                                //weatherAdj = "light";
                            }
                            if (resp.indexOf("moderate") > 0) {
                                rain = 2;
                                // weatherAdj = "moderate";
                            }
                            if (resp.indexOf("heavy") > 0) {
                                rain = 3;
                                //weatherAdj = "heavy";
                            }
                            //tv_result.setText("Weather is:" + weatherDesc + " The level is " + weatherAdj);
                        }
                    }
                },
                new Response.ErrorListener()
                {
                @Override
                    public void onErrorResponse(VolleyError error) {
                        tv_result.setText("That didn't work!");
                    }

                }

        );

        queue.add(stringRequest);
        weatherDesc = "It's rainy outside!";
        if(rain==0)
        {
            rainDesc = "Possibly Light Rain but no worries!";
        }
        if (rain==2)
        {

            rainDesc = "Might want to opt for rain boots";


        }
        if (rain == 3) {
            rainDesc = "Definitely Need Rainboots!";

        }
        if(rain==0 || rain==2 || rain==3) {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("It's Raining!")
                            .setContentText(weatherDesc + " " + rainDesc);
            int mNotificationId = 001;
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotifyMgr.notify(mNotificationId, mBuilder.build());
        }


    }

}
