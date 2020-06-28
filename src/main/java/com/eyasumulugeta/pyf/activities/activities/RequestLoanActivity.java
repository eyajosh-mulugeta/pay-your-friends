package com.eyasumulugeta.pyf.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.adapter.RequestLoanPagerAdapter;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;
import com.eyasumulugeta.pyf.activities.database.DBHelper;
import com.eyasumulugeta.pyf.activities.fragments.RequestLoanFragment;
import com.eyasumulugeta.pyf.activities.java_classes.MyConnector;

import java.util.ArrayList;

public class RequestLoanActivity extends BaseActivity implements ViewPager.OnPageChangeListener, MyConnector {
    public ViewPager viewPager;
    public static final int FRAGMENT_COUNT = 2;
    private ImageView backArrow, nextArrow;
    private static ArrayList<String> arrayList;
    Bundle bundle;
    DBHelper db;

    public RequestLoanActivity () {
        arrayList = new ArrayList<String>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_loan);

        RequestLoanFragment requestLoanFragment = new RequestLoanFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.requestLoanViewPager, requestLoanFragment);
        fragmentTransaction.commit();

        viewPager = (ViewPager) findViewById(R.id.requestLoanViewPager);
        RequestLoanPagerAdapter requestLoanPagerAdapter = new RequestLoanPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(requestLoanPagerAdapter );
        viewPager.addOnPageChangeListener(this);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }


    public void backArrow(View view) {
        if (viewPager.getCurrentItem() == 1) {
            viewPager.setCurrentItem(0);
        } else if (viewPager.getCurrentItem() == 0) {
            startActivity(new Intent(this, LeftNavigationActivity.class));
            this.finish();
        }
    }

    @Override
    public void getValuesFromFragment1(String firstName, String lastName, String phoneNumber, String emailAddress, String country, String city) {
        arrayList.add(firstName);
        arrayList.add(lastName);
        arrayList.add(phoneNumber);
        arrayList.add(emailAddress);
        arrayList.add(country);
        arrayList.add(city);
    }

    @Override
    public void getValuesFromFragment2(String username, String password, String bank, String accountNumber) {
        arrayList.add(username);
        arrayList.add(password);
        arrayList.add(bank);
        arrayList.add(accountNumber);

        register();
    }

    private void register() {
        boolean status= db.addUser(arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3),
                arrayList.get(4), arrayList.get(5), arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9));
        if(status) {
            toast("Registration failed ! ", Toast.LENGTH_SHORT);
            toast("Username already taken, please use a different username ! ", Toast.LENGTH_LONG);
        }
        else{
            toast("User registered!");
            startActivity(new Intent(this, SignInActivity.class));
            finish();
        }
    }

    @Override
    public void statusFragment1(String status) {
        if (status.equals("stay")) {
            viewPager.setCurrentItem(0);

        } else if (status.equals("change")) {
            viewPager.setCurrentItem(1);
        }
    }

    @Override
    public void checkIfEmpty() {
        viewPager.setCurrentItem(0);
    }
}