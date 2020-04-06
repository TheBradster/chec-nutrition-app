package com.example.checnutritionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.checnutritionapp.model.Order;
import com.example.checnutritionapp.ui.placeorder.PlaceOrderFragment;

public class PlaceOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_order_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PlaceOrderFragment.newInstance())
                    .commitNow();
        }

        // Get order
        Order order = (Order) getIntent().getSerializableExtra("Order");
        // Edit toolbar
        getSupportActionBar().setTitle(order.pickupDayOfWeek());
        // Add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        // Source for back button: https://www.youtube.com/watch?v=s3pheMAmaPI
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if (id == android.R.id.home) {
                this.setResult(Activity.RESULT_CANCELED);
                this.finish();
            }

            return super.onOptionsItemSelected(item);
        }

}
