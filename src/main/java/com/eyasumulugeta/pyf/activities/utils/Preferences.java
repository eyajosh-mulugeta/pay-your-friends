package com.eyasumulugeta.pyf.activities.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jo on 5/5/2017.
 */

public class Preferences {
public static final String PREFERENCE_SETTINGS = "SETTINGS";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public Preferences(Context context){
        preferences= context.getSharedPreferences(PREFERENCE_SETTINGS, Context.MODE_PRIVATE);
    }

public Preferences (Context context, String name){
    preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
}

public SharedPreferences getPreferences(){
    return preferences;
}
public SharedPreferences.Editor open(){
    editor = preferences.edit();
return editor;
}

public Preferences putBoolean(String key, boolean value){
editor.putBoolean(key, value);
    return this;
}

public Preferences putInt(String key, int value){
    editor.putInt(key, value);
    return this;
}

public Preferences putString(String key, String value){
    editor.putString(key, value);
    return this;
}

public Boolean getBoolean(String key){
    return preferences.getBoolean(key, false);
}

public int getInt(String key){
    return preferences.getInt(key, 0);
}

public String getString(String key){
    return preferences.getString(key, "");
}


public void close(){
    editor.apply();
}
}
