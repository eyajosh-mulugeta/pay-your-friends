package com.eyasumulugeta.pyf.activities.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.eyasumulugeta.pyf.activities.utils.Preferences;
import com.eyasumulugeta.pyf.activities.utils.Utils;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * Created by Jo on 5/5/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        d("<<<<<<<<<<<<<<<<<<<<<<< onCreate() >>>>>>>>>>>>>>>>>>>>>>>");
    }



    @Override
    protected void onStart() {
        super.onStart();

        d("<<<<<<<<<<<<<<<<<<<<<<< onStart() >>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    protected void onResume() {
        super.onResume();
        d("<<<<<<<<<<<<<<<<<<<<<<< onResume() >>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        d("<<<<<<<<<<<<<<<<<<<<<<< onPause() >>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        d("<<<<<<<<<<<<<<<<<<<<<<< onStop() >>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        d("<<<<<<<<<<<<<<<<<<<<<<< onRestart() >>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        d("<<<<<<<<<<<<<<<<<<<<<<< onDestroy() >>>>>>>>>>>>>>>>>>>>>>>");
    }


    protected Preferences getPref() {
        return new Preferences(this);
    }

    protected Preferences getPrefs(String name) {
        return new Preferences(this, name);
    }

    public void d(String message) {
        Utils.d(this, message);
    }

    public void e(String message) {
        Utils.e(this, message);
    }

    public void toast(String message) {
        toast(message, Toast.LENGTH_SHORT);
    }

    protected void toast(String message, int length) {
        Toast.makeText(this, message, length).show();
    }

}
