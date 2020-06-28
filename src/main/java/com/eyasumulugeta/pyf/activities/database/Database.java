package com.eyasumulugeta.pyf.activities.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.eyasumulugeta.pyf.activities.models.User;
import com.eyasumulugeta.pyf.activities.utils.Utils;

import static com.eyasumulugeta.pyf.activities.database.DBHelper.COLUMN_EMAIL_ADDRESS;
import static com.eyasumulugeta.pyf.activities.database.DBHelper.COLUMN_PASSWORD;
import static com.eyasumulugeta.pyf.activities.database.DBHelper.USER_TABLE;

public class Database {

    public static final String DATABASE_NAME = "db_pyf";
    public static final int DATABASE_VERSION = 1;

    private static DatabaseHelper instance;

    // Initialize the DatabaseHelper instance if not initialized
    public static void initialize(Context context) {
        // Check if the instance is null
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
    }

    public static DatabaseHelper getInstance() {
        checkInit();
        return instance;
    }

    // Checks to see if the instance has been initialize
    private static void checkInit() {
        if (instance == null) {
            throw new RuntimeException("DatabaseHelper instance has not been initialized!");
        }
    }

    public static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            d("< ----- onCreate(SQLiteDatabase) ----- >");
            // Create user table
            String sql = User.CREATE;
            d("Executing query: " + sql);
            db.execSQL(sql);
        }

        public boolean getUser(String email, String pass){

            String selectQuery = "select * from "+ USER_TABLE+" where "+ COLUMN_EMAIL_ADDRESS +
                    " = "+"'"+email+"'"+
                    " and "+ COLUMN_PASSWORD+" = "+"'"+pass+"'";

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            cursor.moveToFirst();
            if(cursor.getCount()>0){
                return true;
            }
            cursor.close();
            db.close();

            return false;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        private void d(String message) {
            Utils.d(this, message);
        }
    }
}
