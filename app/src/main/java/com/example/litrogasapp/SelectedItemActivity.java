package com.example.litrogasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectedItemActivity extends AppCompatActivity {

    TextView rselectedItemName;
    TextView rselectedItemPrice;
    TextView rselectedItemAvailability;
    ItemModel itemModel;
    Intent intent;

    ImageView homeIcon, gasIcon, userIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item);
        rselectedItemName = findViewById(R.id.rselectedItemName);
        rselectedItemPrice = findViewById(R.id.rselectedItemPrice);
        rselectedItemAvailability = findViewById(R.id.rselectedAvailability);

        intent = getIntent();

        if(intent != null){
            itemModel = (ItemModel) intent.getSerializableExtra("data");
            String itemName = itemModel.getTitle();
            String itemP = itemModel.getPrice();
            String itemA = itemModel.getAvailability();
            rselectedItemName.setText(itemName);
            rselectedItemPrice.setText(itemP);
            rselectedItemAvailability.setText(itemA);
        }

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