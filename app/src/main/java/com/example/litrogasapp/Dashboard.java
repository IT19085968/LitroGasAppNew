package com.example.litrogasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    ImageView homeIcon, gasIcon, userIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();

        homeIcon = findViewById(R.id.homeIcon);
        gasIcon = findViewById(R.id.gasIcon);
        userIcon = findViewById(R.id.profileIcon);
    }

    public void sendMessageToProfile(View view) {
        Intent intent = new Intent(this, MyProfile.class);
        startActivity(intent);
    }

    public void sendMessageToOrders(View view) {
        Intent intent = new Intent(this, PreviousOrders.class);
        startActivity(intent);
    }
}