package com.alimurtaza.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.alimurtaza.sharedpreferences", Context.MODE_PRIVATE);

        /*ArrayList<String> friends = new ArrayList<>();

        friends.add("Zain");
        friends.add("Zohaib");
        friends.add("Musharaf");
        friends.add("Maaz");
        friends.add("Mehtab");
        friends.add("Ravi");


        try {
            sharedPreferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        ArrayList<String> newFriends = new ArrayList<>();

        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("friends", newFriends.toString());


        //sharedPreferences.edit().putString("username", "Ali").apply();

        //String username = sharedPreferences.getString("username", null);

        //Log.i("username" , username);
    }
}
