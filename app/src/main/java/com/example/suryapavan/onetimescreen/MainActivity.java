package com.example.suryapavan.onetimescreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //use shared preferences to put a check for first time user
        SharedPreferences sharedPreferences = getSharedPreferences("usercheck",0);
        boolean isSecondTime = sharedPreferences.getBoolean("secondtime",false);

        //if user is coming for first time...proceed
        //else open second activity

        if(isSecondTime == true)
        {
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("secondtime", true);
            editor.commit();


            setContentView(R.layout.activity_main);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 5000);
        }
    }
}
