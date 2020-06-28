package com.eyasumulugeta.pyf.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;
import com.eyasumulugeta.pyf.activities.utils.Preferences;

public class SplashActivity extends BaseActivity {

    private static final String FIRST_TIME_START = "first_time_start";
    private static final long SPLASH_DELAY = 3000;
    private Handler handler;
    private Runnable task;
    private Preferences p;
    boolean firstStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        isFirstRun();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(task);
    }

    public void isFirstRun() {
        // Creating an object to access the Preference class instance members.
        p = new Preferences(this);

        // Initializing the shared preference object.
        getPref();

        /*
        * Returning the SharedPreference object using the getPreferences().
        * Checking whether the preferences contains a preference named FIRST_TIME_START using the getBoolean().
        * If the preference doesn't exist, it'll return the second argument as a default,
        * which is the value true even though the default value of getBoolean() is false.
        * */
        firstStart = p.getPreferences().getBoolean(FIRST_TIME_START, true);

        // If firstStart holds true, it means it is running for the first time.
        if (firstStart) {

            /*
            * The open() returns an initialized SharedPreference.Editor object.
            * The putBoolean(key, value) Set a boolean value in the preferences editor, to be written back
              once {@link #commit} or {@link #apply} are called.
            * The apply() commits its changes to the in-memory.
            * */
            p.open().putBoolean(FIRST_TIME_START, false).apply();

            task = new Runnable() {
                @Override
                public void run() {
                    toIntroActivity();
                    finish();
                }
            };
            handler = new Handler();
            handler.postDelayed(task, SPLASH_DELAY);
        } else {
            toIntroActivity();
            SplashActivity.this.finish();
        }
    }

    private void toIntroActivity() {
        startActivity(new Intent(SplashActivity.this, IntroActivity.class));
    }

}
