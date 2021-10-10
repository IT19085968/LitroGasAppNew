package com.example.litrogasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        Intent intent = getIntent();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DashboardNew.class);
        startActivity(intent);

    }
}