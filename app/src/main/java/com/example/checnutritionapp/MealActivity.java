package com.example.checnutritionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.checnutritionapp.ui.meal.MealFragment;

public class MealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MealFragment.newInstance())
                    .commitNow();
        }
    }
}
