package com.alimurtaza.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void convert(View view){

        EditText text = findViewById(R.id.textField);
        Double dollars = Double.parseDouble(text.getText().toString());
        double rupees = dollars * 146.85;
        Toast.makeText(MainActivity.this, String.format("%.2f", rupees)+" Rupee", Toast.LENGTH_LONG).show();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
