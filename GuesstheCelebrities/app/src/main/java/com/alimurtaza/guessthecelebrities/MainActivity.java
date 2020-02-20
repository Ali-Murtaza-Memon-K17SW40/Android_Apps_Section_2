package com.alimurtaza.guessthecelebrities;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    List<String> celebritiesNamesList = new ArrayList<>();
    int locationOfAnswer;
    int chooseCelebrity;
    String[] answers = new String[4];
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    public void chooseCelebrities(View view) {
        if (view.getTag().toString().equals(Integer.toString(locationOfAnswer))) {
            view.setBackgroundColor(Color.GREEN);
        } else {
            view.setBackgroundColor(Color.RED);

            if(locationOfAnswer == 0){
                button1.setBackgroundColor(Color.GREEN);
            } else if(locationOfAnswer == 1){
                button2.setBackgroundColor(Color.GREEN);
            } else if(locationOfAnswer == 2){
                button3.setBackgroundColor(Color.GREEN);
            } else {
                button4.setBackgroundColor(Color.GREEN);
            }
        }

        new CountDownTimer(2000, 2000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                generateNewQuestions();

                button1.setBackgroundColor(0xFFD5D6D6);
                button2.setBackgroundColor(0xFFD5D6D6);
                button3.setBackgroundColor(0xFFD5D6D6);
                button4.setBackgroundColor(0xFFD5D6D6);
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celebritiesNamesList.add("chadwick_boseman");
        celebritiesNamesList.add("chris_evans");
        celebritiesNamesList.add("chris_hemsworth");
        celebritiesNamesList.add("chris_pratt");
        celebritiesNamesList.add("dave_bautista");
        celebritiesNamesList.add("elizabeth_olsen");
        celebritiesNamesList.add("hugh_jackman");
        celebritiesNamesList.add("jeremy_renner");
        celebritiesNamesList.add("josh_brolin");
        celebritiesNamesList.add("karen_gillan");
        celebritiesNamesList.add("mark_ruffalo");
        celebritiesNamesList.add("paul_rudd");
        celebritiesNamesList.add("robert_downey_jr");
        celebritiesNamesList.add("samuel_l_jackson");
        celebritiesNamesList.add("scarlett_johansson");
        celebritiesNamesList.add("tom_hiddleston");
        celebritiesNamesList.add("tom_holland");
        celebritiesNamesList.add("wade_wilson");
        celebritiesNamesList.add("zoe_saldana");

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        generateNewQuestions();
    }

    public void generateNewQuestions() {

        Random random = new Random();
        chooseCelebrity = random.nextInt(19);
        Log.i("Check", Integer.toString(chooseCelebrity));
        int resource = getResources().getIdentifier(celebritiesNamesList.get(chooseCelebrity), "drawable", "com.alimurtaza.guessthecelebrities");

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(resource);

        locationOfAnswer = random.nextInt(4);

        for (int i = 0; i < 4; i++) {

            if (i == locationOfAnswer) {
                answers[i] = celebritiesNamesList.get(chooseCelebrity);
            } else {
                int incorrectAnswer = random.nextInt(19);

                while (incorrectAnswer == chooseCelebrity) {
                    incorrectAnswer = random.nextInt(19);
                }

                answers[i] = celebritiesNamesList.get(incorrectAnswer);
            }
        }

        button1.setText(answers[0]);
        button2.setText(answers[1]);
        button3.setText(answers[2]);
        button4.setText(answers[3]);
    }
}
