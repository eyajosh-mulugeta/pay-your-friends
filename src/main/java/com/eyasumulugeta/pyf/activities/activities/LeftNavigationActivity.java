package com.eyasumulugeta.pyf.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eyasumulugeta.pyf.R;
import com.eyasumulugeta.pyf.activities.base.BaseActivity;
import com.eyasumulugeta.pyf.activities.controllers.Session;
import com.eyasumulugeta.pyf.activities.fragments.LoansAndDebtsFragment;

public class LeftNavigationActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView profilePic;
    Session session;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_navigation);
        this.setTitle("Home");

        session = new Session(this);
        if (!session.loggedIn()) {
            logOut();
        }

        View v = getLayoutInflater().inflate(R.layout.nav_header_left_navigation, null);
        TextView username = (TextView) v.findViewById(R.id.username);
        Intent intent = getIntent();
        String uname = intent.getStringExtra("username");
        Toast.makeText(this, "Welcome " + uname, Toast.LENGTH_SHORT).show();
        username.setText(uname);


        LoansAndDebtsFragment loansAndDebtsFragment = new LoansAndDebtsFragment();
        fragmentManager.beginTransaction().replace(R.id.layout_for_fragment, loansAndDebtsFragment, loansAndDebtsFragment.getTag()).commit();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        int stackCount = fragmentManager.getBackStackEntryCount();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (fragmentManager.getFragments() != null) {
            LoansAndDebtsFragment loansAndDebtsFragment = new LoansAndDebtsFragment();
            fragmentManager.beginTransaction().replace(R.id.layout_for_fragment, loansAndDebtsFragment, loansAndDebtsFragment.getTag()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.left_navigation, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logOut() {
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(this, SignInActivity.class));
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.requestLoan) {
            requestLoan();
        } else if (id == R.id.loanRequests) {
            loanRequests();
        } else if (id == R.id.balance) {
            balance();
        } else if (id == R.id.profile) {
            profile();
        } else if (id == R.id.socialize) {
            socialize();
        } else if (id == R.id.settings) {
            settings();
        } else if (id == R.id.about) {
            about();
        } else if (id == R.id.logOut) {
            logOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void about() {

        startActivity(new Intent(this, AboutActivity.class));
        /*
        AboutFragment aboutFragment = new AboutFragment();
        fragmentManager.beginTransaction().replace(R.id.layout_for_fragment, aboutFragment, aboutFragment.getTag()).commit();
*/
    }

    private void settings() {
        startActivity(new Intent(this, SettingsActivity.class));
        //SettingsFragment settingsFragment = new SettingsFragment();
        //fragmentManager.beginTransaction().replace(R.id.layout_for_fragment, settingsFragment, settingsFragment.getTag()).commit();
    }

    private void socialize() {
    }

    private void profile() {
        startActivity(new Intent(this, ProfileActivity.class));
/*
        ProfileFragment profileFragment = new ProfileFragment();
        fragmentManager.beginTransaction().replace(R.id.layout_for_fragment, profileFragment, profileFragment.getTag()).commit();
*/
    }

    private void balance() {
/*
        BalanceFragment balanceFragment = new BalanceFragment();
        fragmentManager.beginTransaction().replace(R.id.layout_for_fragment, balanceFragment, balanceFragment.getTag()).commit();
*/
    }

    private void requestLoan() {
        startActivity(new Intent(this, RequestLoanActivity.class));
/*
        RequestLoanFragment requestLoanFragment = new RequestLoanFragment();
        fragmentManager.beginTransaction().replace(R.id.layout_for_fragment, requestLoanFragment, requestLoanFragment.getTag()).commit();
*/
    }

    private void loanRequests() {
        startActivity(new Intent(this, LoanRequestsActivity.class));
/*
        LoanRequestsFragment loanRequestsFragment = new LoanRequestsFragment();
        fragmentManager.beginTransaction().replace(R.id.layout_for_fragment, loanRequestsFragment, loanRequestsFragment.getTag()).commit();
*/
    }
}
