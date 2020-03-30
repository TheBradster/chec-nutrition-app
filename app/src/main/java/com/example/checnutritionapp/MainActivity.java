package com.example.checnutritionapp;

import android.os.Bundle;

import com.example.checnutritionapp.ui.home.HomeFragment;
import com.example.checnutritionapp.utility.JSONUtilities;
import com.example.checnutritionapp.utility.MealBank;
import com.example.checnutritionapp.utility.Week;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private Week week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Import data

        try {
            // Get meal data
            JSONObject mealsJSON = JSONUtilities.loadJSONFromAsset(getApplicationContext(), "meals.json");
            // Process meal JSON data
            MealBank meals = new MealBank(mealsJSON);
            // Get meal schedule
            // For now we're importing test data
            JSONObject scheduleJSON = JSONUtilities.loadJSONFromAsset(getApplicationContext(), "test_schedule.json");
            week = new Week(scheduleJSON, meals);
        } catch (JSONException e) {
            e.printStackTrace();
            this.finish();
        }

        Log.d("Main Activity", week.toString());

        /*// Send data to home fragment
        Bundle bundle = new Bundle();
        bundle.putSerializable("Week", week);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(bundle);*/
    }

    public Week getWeek() {
        return week;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
