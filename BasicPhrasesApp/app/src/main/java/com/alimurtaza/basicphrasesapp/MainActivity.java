package com.alimurtaza.basicphrasesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public void buttonClicked(View view) {
        int resource = view.getResources().getIdentifier(view.getResources().getResourceEntryName(view.getId()),
                "raw", "com.alimurtaza.basicphrasesapp");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, resource);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
