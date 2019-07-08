package com.lemubit.lemuel.swiselapppro.ui;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.lemubit.lemuel.swiselapppro.R;
import com.lemubit.lemuel.swiselapppro.api.SwiselEndPointCallManager;
import com.lemubit.lemuel.swiselapppro.model.transactions.TransactionsModel;
import com.lemubit.lemuel.swiselapppro.model.registeredcourses.RegisteredCoursesModel;
import com.lemubit.lemuel.swiselapppro.model.currentsession.CurrentSessionModel;
import com.lemubit.lemuel.swiselapppro.model.login.LoginModel;
import com.lemubit.lemuel.swiselapppro.ui.fragment.RegisteredCoursesFragment;
import com.lemubit.lemuel.swiselapppro.ui.fragment.StudentHomeProfileFragment;
import com.lemubit.lemuel.swiselapppro.ui.fragment.TransactionsFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.Toast;

import org.parceler.Parcels;

/**
 * @author lemuel
 */
public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LoginModel loginModel;
    CurrentSessionModel currentSessionModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Credit functionality not ready...", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        loginModel = Parcels.unwrap(getIntent().getParcelableExtra("loginModel"));

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        //initial home fragment
        StudentHomeProfileFragment studentHomeProfile = StudentHomeProfileFragment.newInstance(loginModel);
        ft.replace(R.id.swisel_home_placeholder, studentHomeProfile);
        ft.commit();

        SwiselEndPointCallManager.getCurrentSession(new SwiselEndPointCallManager.OnGetCurrentSessionListener() {
            @Override
            public void onSuccess(CurrentSessionModel currentSessionModel) {
                Toast.makeText(HomeActivity.this, "Session= " + currentSessionModel.data.id, Toast.LENGTH_SHORT).show();
                HomeActivity.this.currentSessionModel = currentSessionModel;
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(HomeActivity.this, "Can't fetch current session", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeActivity/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            StudentHomeProfileFragment studentHomeProfile = StudentHomeProfileFragment.newInstance(loginModel);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.swisel_home_placeholder, studentHomeProfile);
            ft.commit();
        } else if (id == R.id.nav_registered_courses) {
            Toast.makeText(this, "Please wait...", Toast.LENGTH_LONG).show();
            SwiselEndPointCallManager.getRegisteredCourses(currentSessionModel.getData().getId(), loginModel.getData().getId(), new SwiselEndPointCallManager.OnGetRegisteredCoursesListener() {
                @Override
                public void onSuccess(RegisteredCoursesModel registeredCoursesModel) {
                    RegisteredCoursesFragment registeredCourses = RegisteredCoursesFragment.newInstance(registeredCoursesModel);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.swisel_home_placeholder, registeredCourses);
                    ft.commit();
                    Toast.makeText(HomeActivity.this, "Registered Courses: " + registeredCoursesModel.getData().length, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(String errorMessage) {
                    Toast.makeText(HomeActivity.this, "Unable to get info", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (id == R.id.nav_transactions) {
            Toast.makeText(this, "Please wait...", Toast.LENGTH_SHORT).show();
            SwiselEndPointCallManager.getTransactionHistory(loginModel.getData().getId(), new SwiselEndPointCallManager.OnGetTransactionHistoryListener() {
                @Override
                public void onSuccess(TransactionsModel transactionsModel) {
                    TransactionsFragment transactionsFragment = TransactionsFragment.newInstance(transactionsModel);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.swisel_home_placeholder, transactionsFragment);
                    ft.commit();
                }

                @Override
                public void onFailure(String errorMessage) {
                    Toast.makeText(HomeActivity.this, "Unable to get info", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
