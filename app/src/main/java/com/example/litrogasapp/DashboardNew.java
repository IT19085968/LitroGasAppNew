package com.example.litrogasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class DashboardNew extends AppCompatActivity implements itemAdapter.itemClickListener {

    RecyclerView rvItems;
    itemAdapter itemAd;
    List<ItemModel> itemModelList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_new);
        Intent intent = getIntent();



        rvItems = findViewById(R.id.rvItems);
        setData();
        prepareRecyclerView();
    }

    public void setData() {
        itemModelList.add(new ItemModel("12kg","Rs.500","1","Available"));
        itemModelList.add(new ItemModel("3kg","Rs.200","1","Not Available"));
        itemModelList.add(new ItemModel("6kg","Rs.700","1","Available"));
        itemModelList.add(new ItemModel("1kg","Rs.50","1","Available"));
        itemModelList.add(new ItemModel("3kg refill","Rs.200","1","Not Available"));
        itemModelList.add(new ItemModel("5kg","Rs.500","1","Available"));
    }

    public void prepareRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvItems.setLayoutManager(linearLayoutManager);
        prepareAdapter();
    }

    public void prepareAdapter() {
        itemAd = new itemAdapter(itemModelList,this, this::selectedItem);
        rvItems.setAdapter(itemAd);
    }

    @Override
    public void selectedItem(ItemModel itemModel) {
        startActivity(new Intent(this,SelectedItemActivity.class).putExtra("data",itemModel));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.searchView){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem menuItem = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String searchString = newText;
                itemAd.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}