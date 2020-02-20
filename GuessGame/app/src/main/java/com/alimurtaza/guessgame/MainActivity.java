package com.alimurtaza.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void makeToast(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_LONG).show();
    }

    public void guess(View view) {
        EditText text = findViewById(R.id.textField);
        int guessNumber = Integer.parseInt(text.getText().toString());

        if (guessNumber > randomNumber) {
            makeToast("Number is Greater than Random Number!");
        } else if (guessNumber < randomNumber) {
            makeToast("Number is less than Random Number!");
        } else {
            makeToast("That's right!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
    }
}
