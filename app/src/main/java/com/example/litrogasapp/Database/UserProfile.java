package com.example.litrogasapp.Database;

import android.provider.BaseColumns;

public class UserProfile {

    private UserProfile() {
    }


    public static class User implements BaseColumns {
        public static final String TABLE_NAME = "UserDetails";
        public static final String COLUMN_1 = "firstName";
        public static final String COLUMN_2 = "lastName";
        public static final String COLUMN_3 = "email";
        public static final String COLUMN_4 = "mobile";
        public static final String COLUMN_5 = "password";
        public static final String COLUMN_6 = "confirmPassword";
    }
}
