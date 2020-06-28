package com.eyasumulugeta.pyf.activities.controllers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jo on 5/25/2017.
 */

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx) {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("pyf_user", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedIn(boolean loggedIn) {
        editor.putBoolean("loggedInMode", loggedIn);
        editor.apply();
    }

    public void saveUsernameAndPassword(String username, String password) {
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    public String getUsername(){
        return prefs.getString("username", null);
    }

    public String getPassword(){
        return prefs.getString("password", null);
    }


    public boolean loggedIn() {
        return prefs.getBoolean("loggedInMode", false);
    }
}
