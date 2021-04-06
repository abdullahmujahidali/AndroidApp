package com.wtechweb.mad_assignment_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import 	android.os.Handler;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    final static int SPLASH_TIME=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
          @Override
          public void run() {
              Intent intent = new Intent(getApplicationContext(),
                      com.wtechweb.mad_assignment_2.Login.class);
              startActivity(intent);
          }

          }, SPLASH_TIME);

    }
}