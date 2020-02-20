package com.example.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        ImageView bart = findViewById(R.id.bart);
        bart.animate().alpha(0f).setDuration(1000);
    }

//    public void clickFunction(View view) {
//
//
//        Log.i("Info", "Button Clicked");
////        EditText username = (EditText) findViewById(R.id.username);
////        EditText password = (EditText) findViewById(R.id.password);
////
////        Toast.makeText(MainActivity.this, "Hi there, " + username.getText().toString(), Toast.LENGTH_LONG).show();
////        //Toast.makeText(MainActivity.this, username.getText().toString(), Toast.LENGTH_LONG).show();
////
////        Log.i("Info", "Username: " + username.getText() + " Password: " + password.getText());
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
