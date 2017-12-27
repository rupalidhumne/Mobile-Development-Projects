package com.example.rdhumne.rainapird;

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

public class MainActivity extends AppCompatActivity {
    private EditText input1;
    public String city = "";
    public static String CITY = "com.mycompany.myfirstapp.MESSAGE";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                /*
                Intent intent = new Intent(MainActivity.this, APIActivity.class);
                city = input1.getText().toString();
                intent.putExtra(CITY, city);
                startActivity(intent);
                */
                //SHARED PREFERENCE PART AND INTENT


            }
        });


    }

}

