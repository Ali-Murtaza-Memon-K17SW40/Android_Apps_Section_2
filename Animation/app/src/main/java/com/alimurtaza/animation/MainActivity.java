package com.alimurtaza.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {

        //ImageView bart = findViewById(R.id.bart);
        //bart.animate().alpha(0f).setDuration(2000);

        //ImageView homar = findViewById(R.id.homar);
        //homar.animate().alpha(1f).setDuration(2000);

        ImageView bart = findViewById(R.id.bart);
        bart.animate().translationX(-1000f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
