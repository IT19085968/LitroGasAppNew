package com.example.litrogasapp.Database;

import android.provider.BaseColumns;

public class AddressDetails {

    private AddressDetails() {
    }


    public static class Address implements BaseColumns {
        public static final String TABLE_NAME = "UserAddressDetails";
        public static final String COLUMN_1 = "deliveryTo";
        public static final String COLUMN_2 = "district";
        public static final String COLUMN_3 = "address1";
        public static final String COLUMN_4 = "address2";
        public static final String COLUMN_5 = "city";
    }
}
