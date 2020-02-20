package com.alimurtaza.timersdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First Type of Timer.
//        new CountDownTimer(10000, 1000){
//            public void onTick(long milliSecondsUntilDone){
//                //Count down counting down after every 1 second.
//                Toast.makeText(MainActivity.this, String.valueOf(milliSecondsUntilDone / 1000), Toast.LENGTH_LONG).show();
//            }
//
//            public void onFinish(){
//                //CountDown is Finished after 10 seconds.
//                Toast.makeText(MainActivity.this, "ContDown is Finished!", Toast.LENGTH_LONG).show();
//            }
//        }.start();

        //Second Type of Timer.
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Run After Every Second!", Toast.LENGTH_LONG).show();
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);
    }
}
