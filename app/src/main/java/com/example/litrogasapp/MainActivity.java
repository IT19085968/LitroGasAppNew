package com.example.litrogasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.litrogasapp.Database.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        DBHelper dbHelper = new DBHelper(this);
        long val = dbHelper.addInfo("admin@gmail.com","admin123");

    }

    public void signIn(View view){
        DBHelper dbHelper = new DBHelper(this);

        Intent intent = new Intent(this,AddAddress.class);
        Intent intent2 = new Intent(this,MainActivity.class);

        List emails = dbHelper.readAllInfo("email");
        List passwords = dbHelper.readAllInfo("password");

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (emails.indexOf(email)>=0){
            if (passwords.get(emails.indexOf(email)).equals(password)){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Login unsuccessful", Toast.LENGTH_SHORT).show();
                startActivity(intent2);
            }
        }
    }
}