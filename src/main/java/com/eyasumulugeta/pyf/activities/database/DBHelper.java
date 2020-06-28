package com.eyasumulugeta.pyf.activities.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.android.volley.VolleyLog.d;

/**
 * Created by Jo on 5/25/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TAG = DBHelper.class.getSimpleName();
    public static final String DB_NAME = "db";
    public static final int DB_VERSION = 1;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_EMAIL_ADDRESS = "email_address";
    public static final String COLUMN_COUNTRY = "country";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_BANK = "bank";
    public static final String COLUMN_ACCOUNT_NUMBER = "account_number";

    public boolean userExist;
    public boolean isUserExist;

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FIRST_NAME + " TEXT,"
            + COLUMN_LAST_NAME + " TEXT,"
            + COLUMN_PHONE_NUMBER + " TEXT,"
            + COLUMN_EMAIL_ADDRESS + " TEXT,"
            + COLUMN_COUNTRY + " TEXT,"
            + COLUMN_CITY + " TEXT,"
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_PASSWORD + " TEXT,"
            + COLUMN_BANK + " TEXT,"
            + COLUMN_ACCOUNT_NUMBER + " TEXT);";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    public boolean addUser(String firstName, String lastName, String phoneNumber, String emailAddress, String country,
                           String city, String username, String password, String bank, String accountNumber) {

        boolean status = checkIfUsernameTaken(username);
        if (status) {
            return true;
        } else {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_FIRST_NAME, firstName);
            values.put(COLUMN_LAST_NAME, lastName);
            values.put(COLUMN_PHONE_NUMBER, phoneNumber);
            values.put(COLUMN_EMAIL_ADDRESS, emailAddress);
            values.put(COLUMN_COUNTRY, country);
            values.put(COLUMN_CITY, city);
            values.put(COLUMN_USERNAME, username);
            values.put(COLUMN_PASSWORD, password);
            values.put(COLUMN_BANK, bank);
            values.put(COLUMN_ACCOUNT_NUMBER, accountNumber);

            long id = db.insert(USER_TABLE, null, values);
            Log.d(TAG, "user inserted" + id);
            return false;
        }

    }


    private boolean checkIfUsernameTaken(String username) {
        String selectQuery = "select * from " + USER_TABLE + " where " + COLUMN_USERNAME +
                " = " + "'" + username + "'";

        SQLiteDatabase dba = this.getReadableDatabase();
        Cursor cursor = dba.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        dba.close();
        return false;
    }

    public boolean getUser(String email, String pass) {

        String selectQuery = "select * from " + USER_TABLE + " where " + COLUMN_USERNAME +
                " = " + "'" + email + "'" +
                " and " + COLUMN_PASSWORD + " = " + "'" + pass + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            d("I got it");
            userExist = true;
            return true;
        }
        cursor.close();
        db.close();
        userExist = false;
        d("I didn't got it");

        return false;
    }

    public boolean isUserExist() {
        return userExist;
    }
}
