package com.eyasumulugeta.pyf.activities.controllers;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.eyasumulugeta.pyf.activities.models.User;

import java.util.Date;
import java.util.UUID;

public class UserController extends BaseController<User> {

    public UserController(String tableName) {
        super(tableName);
    }

    @Override
    protected void load() {
        fetchAll();

        // load the users
        if (cursor.moveToFirst()) {
            User user = new User();

            user.id = cursor.getString(0);
            user.firstName = cursor.getString(1);
            user.lastName = cursor.getString(2);
            user.phoneNumber = cursor.getString(3);
            user.emailAddress = cursor.getString(4);
            user.country = cursor.getString(5);
            user.city = cursor.getString(6);
            user.username = cursor.getString(7);
            user.password = cursor.getString(8);
            user.bank = cursor.getString(9);
            user.accountNumber = cursor.getString(10);
            user.loggedInAt = new Date(cursor.getLong(11));

            add(user);
        }

        // close the cursor
        closeCursor();
    }

    public User getUser() {
        return isEmpty() ? null : get(0);
    }


    public boolean createUser(String firstName, String lastName, String phoneNumber, String emailAddress, String country,
                              String city, String username, String password, String bank, String accountNumber) {
        d("Creating new user...");

        // Create instance of the User class
        User user = new User();
        user.id = UUID.randomUUID().toString();
        user.firstName=firstName;
        user.lastName=lastName;
        user.phoneNumber=phoneNumber;
        user.emailAddress=emailAddress;
        user.country=country;
        user.city=city;
        user.username=username;
        user.password=password;
        user.bank=bank;
        user.accountNumber=accountNumber;


        // Retrieve instance of the SQLiteDatabase class
        SQLiteDatabase db = openDatabase();

        // Create ContentValues for holding the data
        ContentValues values = new ContentValues();
        // Add data to the ContentValues
        values.put(User.COL_ID, user.id);
        values.put(User.COL_FIRST_NAME, user.firstName);
        values.put(User.COL_LAST_NAME, user.lastName);
        values.put(User.COL_PHONE_NUMBER, user.phoneNumber);
        values.put(User.COL_EMAIL_ADDRESS, user.emailAddress);
        values.put(User.COL_COUNTRY, user.country);
        values.put(User.COL_CITY, user.city);
        values.put(User.COL_USERNAME, user.username);
        values.put(User.COL_PASSWORD, user.password);
        values.put(User.COL_BANK, user.bank);
        values.put(User.COL_ACCOUNT_NUMBER, user.accountNumber);
        values.put(User.COL_LOGGED_IN_AT, user.loggedInAt.getTime());

        // Add user to temp memory
        add(user);

        // Insert data into database
        long rowId = db.insert(User.TABLE, null, values);
        boolean inserted = rowId != -1;
        if (inserted) {
            d("-> User created");
        } else {
            d("-> User not created: " + rowId);
        }

        // Return result
        return inserted;
    }

    public void signOut() {
        // Delete any logged in users inside the database
        // get the db
        SQLiteDatabase db = openDatabase();
        int rowsDeleted = db.delete(User.TABLE, "1", null);
        d("Users deleted/killed: " + rowsDeleted);
        clear();
    }
}
