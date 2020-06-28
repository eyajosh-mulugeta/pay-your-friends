package com.eyasumulugeta.pyf.activities.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.eyasumulugeta.pyf.activities.activities.SignUpActivity;
import com.eyasumulugeta.pyf.activities.fragments.SignUpFragment1;
import com.eyasumulugeta.pyf.activities.fragments.SignUpFragment2;

/**
 * Created by Jo on 4/10/2017.
 */

public class SignUpPagerAdapter extends FragmentPagerAdapter {

    public SignUpPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SignUpFragment1();
            default:
                return new SignUpFragment2();

        }
    }

    @Override
    public int getCount() {
        return SignUpActivity.FRAGMENT_COUNT;
    }
}
