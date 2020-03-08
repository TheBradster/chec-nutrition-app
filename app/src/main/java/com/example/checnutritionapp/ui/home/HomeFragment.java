package com.example.checnutritionapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.MainActivity;
import com.example.checnutritionapp.MealActivity;
import com.example.checnutritionapp.PlaceOrderActivity;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.model.Order;


import java.util.Date;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // Meal buttons
        final ImageButton m1 = (ImageButton) root.findViewById(R.id.imageButton2);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                startActivity(intent);
            }
        });

        final ImageButton m2 = (ImageButton) root.findViewById(R.id.imageButton3);
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                startActivity(intent);
            }
        });

        final ImageButton m3 = (ImageButton) root.findViewById(R.id.imageButton4);
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                startActivity(intent);
            }
        });

        final ImageButton m4 = (ImageButton) root.findViewById(R.id.imageButton5);
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                startActivity(intent);
            }
        });

        final ImageButton m5 = (ImageButton) root.findViewById(R.id.imageButton6);
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                startActivity(intent);
            }
        });

        final ImageButton m6 = (ImageButton) root.findViewById(R.id.imageButton7);
        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                startActivity(intent);
            }
        });

        final ImageButton m7 = (ImageButton) root.findViewById(R.id.imageButton8);
        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                startActivity(intent);
            }
        });

        final ImageButton m8 = (ImageButton) root.findViewById(R.id.imageButton9);
        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                startActivity(intent);
            }
        });

        // Button
        final Button orderButton = (Button) root.findViewById(R.id.orderButton);
        orderButton.setText("ORDER");
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HomeFragment", "Button has been pressed");
                // Create intent to be passed to activity for placing order
                Intent intent = new Intent(getActivity(), PlaceOrderActivity.class);
                // Create new meals for the test
                Meal[] meals = {new Meal("Meal 1"), new Meal("Meal 2")};
                // Create order object to be further customized on in the next activity
                intent.putExtra("Order", new Order(new Date(), meals));
                startActivity(intent);

            }
        });

        return root;
    }
}