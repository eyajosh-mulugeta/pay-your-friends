package com.eyasumulugeta.pyf.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;
import com.eyasumulugeta.pyf.activities.utils.Preferences;

public class IntroActivity extends BaseActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSignIn, btnSignUp;
    private static final String FIRST_TIME_START = "walkthrough_first_time_start";
    private Preferences p;
    boolean firstStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFirstRun();
    }

    public void btnSignInClick(View v) {
        launchSignInScreen();
    }

    public void btnSignUpClick(View v) {

        launchSignUpScreen();

    }

    private void launchSignUpScreen() {
        startActivity(new Intent(this, SignUpActivity.class));
        finish();
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };


    @NonNull
    public Spanned fromHtml(@NonNull String source) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(source);
        }
    }


    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);

            dots[i].setText(fromHtml("&#8226;"));


            dots[i].setTextSize(35);
            dots[i].setTextColor(ContextCompat.getColor(this, R.color.dot_inactive));
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[currentPage].setTextColor(ContextCompat.getColor(this, R.color.dot_active));
    }


    private void launchSignInScreen() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();

    }

    public class ViewPagerAdapter extends PagerAdapter {
        public LayoutInflater layoutInflater;

        public ViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
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

            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.activity_intro);

            viewPager = (ViewPager) findViewById(R.id.view_pager);
            dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
            btnSignIn = (Button) findViewById(R.id.btnSignIn);
            btnSignUp = (Button) findViewById(R.id.btnSignUp);
            layouts = new int[]{
                    R.layout.walkthrough_slide1,
                    R.layout.walkthrough_slide2,
                    R.layout.walkthrough_slide3};

            // adding bottom dots
            addBottomDots(0);

            viewPagerAdapter = new ViewPagerAdapter();
            viewPager.setAdapter(viewPagerAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        } else {
            launchSignInScreen();
        }
    }
}
