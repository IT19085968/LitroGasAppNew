package com.example.litrogasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.litrogasapp.Database.AddressDetails;
import com.example.litrogasapp.Database.UserDBHelper;

public class Signup extends AppCompatActivity {

    EditText firstName, lastName, email, mobile, password, confirmPassword;
    Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Intent intent = getIntent();

        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.newpassword);
        confirmPassword = findViewById(R.id.confirmpassword);
        register = findViewById(R.id.register);


//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                UserDBHelper userDBHelper = new UserDBHelper(getApplicationContext());
//
//                long newID = userDBHelper.addUserDetails(firstName.getText().toString(),
//                        lastName.getText().toString(),
//                        email.getText().toString(),
//                        mobile.getText().toString(),
//                        password.getText().toString(),
//                        confirmPassword.getText().toString());
//
//                Toast.makeText(Signup.this, "Details added successfully. Order ID : " +newID, Toast.LENGTH_SHORT).show();
//
//                Intent i = new Intent(getApplicationContext(), AddressDetails.class);
//                startActivity(i);
//            }
//        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, AddAddress.class);
        startActivity(intent);

    }

    public void sendMessage4(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}