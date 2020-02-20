package com.alimurtaza.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView startButton;
    TextView answerTextView;
    TextView scoreTextView;
    TextView timerTextView;
    TextView numericsTextView;
    androidx.gridlayout.widget.GridLayout gridLayout;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    Button a;
    Button b;
    Button c;
    Button d;
    int score;
    int numberOfQuestions;
    Button playAgain;

    public void playAgain(View view) {
        playAgain.setVisibility(View.INVISIBLE);
        score = 0;
        numberOfQuestions = 0;
        scoreTextView.setText(score + "/" + numberOfQuestions);

        timer();
        generateQuestions();

    }

    public void timer(){
        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                timerTextView.setText("0s");
                answerTextView.setVisibility(View.VISIBLE);
                answerTextView.setText("Time Up!");

                new CountDownTimer(2000, 2000){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        answerTextView.setText("Your score : " +scoreTextView.getText());
                        playAgain.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        }.start();
    }

    public void generateQuestions() {
        Random randomNumber = new Random();

        int left = randomNumber.nextInt(21);
        int right = randomNumber.nextInt(21);

        numericsTextView.setText(left + " + " + right);

        locationOfCorrectAnswer = randomNumber.nextInt(4);

        answers.clear();

        int incorrectAnswer;

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(left + right);
            } else {
                incorrectAnswer = randomNumber.nextInt(41);

                while (incorrectAnswer == (left + right)) {
                    incorrectAnswer = randomNumber.nextInt(41);
                }

                answers.add(incorrectAnswer);
            }
        }

        a.setText(Integer.toString(answers.get(0)));
        b.setText(Integer.toString(answers.get(1)));
        c.setText(Integer.toString(answers.get(2)));
        d.setText(Integer.toString(answers.get(3)));
    }

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        numericsTextView.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);

        timer();
    }

    public void chooseAnswer(View view) {
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
            score++;
            answerTextView.setText("Correct!");
            answerTextView.setVisibility(View.VISIBLE);
        } else {
            answerTextView.setText("Wrong!");
            answerTextView.setVisibility(View.VISIBLE);
        }
        numberOfQuestions++;
        scoreTextView.setText(score + "/" + numberOfQuestions);

        new CountDownTimer(1000, 1000) {
            public void onTick(long milliSecondsUntilDone) {
            }

            public void onFinish() {
                generateQuestions();
                answerTextView.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startView);
        numericsTextView = findViewById(R.id.numericsTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        answerTextView = findViewById(R.id.answerTextView);
        gridLayout = findViewById(R.id.gridLayout);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        playAgain = findViewById(R.id.playAgainButton);

        generateQuestions();


    }
}
