package com.example.checnutritionapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.ui.meal.MealFragment;

public class MealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Retrieve the serializable meal object to be passed in a bundle
        Meal m = (Meal) getIntent().getSerializableExtra("meal");

        // Establish bundle that will contain the serializable meal object
        Bundle b = new Bundle();
        b.putSerializable("meal", m);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_activity);

        // Create a MealFragment and store within it the meal-containing bundle
        MealFragment frag = new MealFragment();
        frag.setArguments(b);

        // If appropriate, begin the transaction that will direct user to the meal object
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, frag)
                    .commitNow();
        }

        // Edit toolbar
        getSupportActionBar().setTitle(m.getName());

        // Provide the back button
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
