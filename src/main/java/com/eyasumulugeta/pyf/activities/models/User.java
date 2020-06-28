package com.eyasumulugeta.pyf.activities.models;

import java.util.Date;

public class User {

    public static final String TABLE = "pyf_user";

    public static final String COL_ID = "_id";
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_LAST_NAME = "last_name";
    public static final String COL_PHONE_NUMBER = "phone_number";
    public static final String COL_EMAIL_ADDRESS = "email_address";
    public static final String COL_COUNTRY = "country";
    public static final String COL_CITY= "city";
    public static final String COL_USERNAME= "username";
    public static final String COL_PASSWORD= "password";
    public static final String COL_BANK= "bank";
    public static final String COL_ACCOUNT_NUMBER= "account_number";
    public static final String COL_LOGGED_IN_AT = "logged_in_at";

    public static final String CREATE = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s TEXT PRIMARY KEY," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s INTEGER NOT NULL" +
                    ")",
            TABLE,
            COL_ID,
            COL_FIRST_NAME,
            COL_LAST_NAME,
            COL_PHONE_NUMBER,
            COL_EMAIL_ADDRESS,
            COL_COUNTRY,
            COL_CITY,
            COL_USERNAME,
            COL_PASSWORD,
            COL_BANK,
            COL_ACCOUNT_NUMBER,
            COL_LOGGED_IN_AT
    );

    public String id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String emailAddress;
    public String country;
    public String city;
    public String username;
    public String password;
    public String bank;
    public String accountNumber;
    public Date loggedInAt;

    public User() {
        id = "";
        firstName="";
        lastName="";
        phoneNumber="";
        emailAddress="";
        country="";
        city="";
        username="";
        password="";
        bank="";
        accountNumber="";
        loggedInAt = new Date();
    }
}
