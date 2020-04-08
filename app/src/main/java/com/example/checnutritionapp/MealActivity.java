package com.example.checnutritionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.ui.meal.MealFragment;

public class MealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Meal m = (Meal) getIntent().getSerializableExtra("meal");
        // Debug
        System.out.println(m.getName() + " -- in Meal Activity");

        Bundle b = new Bundle();
        b.putSerializable("meal", m);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_activity);

        MealFragment frag = new MealFragment();
        frag.setArguments(b);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, frag)
                    .commitNow();
        }

        // Edit toolbar
        getSupportActionBar().setTitle(m.getName());
        // Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Source for back button: https://www.youtube.com/watch?v=s3pheMAmaPI
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
