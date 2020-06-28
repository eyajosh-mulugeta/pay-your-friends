package com.eyasumulugeta.pyf.activities.java_classes;

import android.app.Application;


import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.controllers.Controllers;
import com.eyasumulugeta.pyf.activities.database.Database;
import com.eyasumulugeta.pyf.activities.utils.Utils;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Jo on 5/9/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/roboto_medium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        Utils.e(this, "< ---------------------------------------- Application.onCreate() ---------------------------------------- >");
        Database.initialize(this);      // initialize database
        Controllers.initialize();       // initialize controllers
    }
}