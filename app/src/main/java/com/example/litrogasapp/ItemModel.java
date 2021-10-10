package com.example.litrogasapp;

import java.io.Serializable;

public class ItemModel implements Serializable {
    private String title;
    private String price;
    private String quantity;
    private String availability;

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public ItemModel(String title, String price, String quantity, String availability) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.availability = availability;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
