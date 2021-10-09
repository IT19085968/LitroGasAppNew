package com.example.litrogasapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "User.db";

    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_DETAILS);
        db.execSQL(ADDRESS_DETAILS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private static final String USER_DETAILS =
            "CREATE TABLE "+ UserProfile.User.TABLE_NAME + " (" +
                    UserProfile.User._ID + " INTEGER PRIMARY KEY," +
                    UserProfile.User.COLUMN_1 + " TEXT," +
                    UserProfile.User.COLUMN_2 + " TEXT," +
                    UserProfile.User.COLUMN_3 + " TEXT," +
                    UserProfile.User.COLUMN_4 + " TEXT," +
                    UserProfile.User.COLUMN_5 + " TEXT," +
                    UserProfile.User.COLUMN_6+ " TEXT)";

    private static final String ADDRESS_DETAILS =
            "CREATE TABLE "+ AddressDetails.Address.TABLE_NAME + " (" +
                    AddressDetails.Address._ID + " INTEGER PRIMARY KEY," +
                    AddressDetails.Address.COLUMN_1 + " TEXT," +
                    AddressDetails.Address.COLUMN_2 + " TEXT," +
                    AddressDetails.Address.COLUMN_3 + " TEXT," +
                    AddressDetails.Address.COLUMN_4 + " TEXT," +
                    AddressDetails.Address.COLUMN_5+ " TEXT)";


    public long addUserDetails(String firstName, String lastName, String email, String mobile, String password, String confirmPassword){

        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(UserProfile.User.COLUMN_1, firstName);
        values.put(UserProfile.User.COLUMN_2, lastName);
        values.put(UserProfile.User.COLUMN_3, email);
        values.put(UserProfile.User.COLUMN_4, mobile);
        values.put(UserProfile.User.COLUMN_5, password);
        values.put(UserProfile.User.COLUMN_6, confirmPassword);

        long newUserId = db.insert(UserProfile.User.TABLE_NAME, null, values);

        return newUserId;
    }


    public long addAddressDetails(String deliveryTo, String district, String address1, String address2, String city){

        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(AddressDetails.Address.COLUMN_1, deliveryTo);
        values.put(AddressDetails.Address.COLUMN_2, district);
        values.put(AddressDetails.Address.COLUMN_3, address1);
        values.put(AddressDetails.Address.COLUMN_4, address2);
        values.put(AddressDetails.Address.COLUMN_5, city);

        long newAddressId = db.insert(AddressDetails.Address.TABLE_NAME, null, values);

        return newAddressId;
    }

}
