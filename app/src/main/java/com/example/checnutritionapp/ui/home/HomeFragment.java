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

        // Instantiate the meal buttons as established in home_fragment.xml
        final ImageButton m1 = (ImageButton) root.findViewById(R.id.imageButton2);
        final ImageButton m2 = (ImageButton) root.findViewById(R.id.imageButton3);
        final ImageButton m3 = (ImageButton) root.findViewById(R.id.imageButton4);
        final ImageButton m4 = (ImageButton) root.findViewById(R.id.imageButton5);
        final ImageButton m5 = (ImageButton) root.findViewById(R.id.imageButton6);
        final ImageButton m6 = (ImageButton) root.findViewById(R.id.imageButton7);
        final ImageButton m7 = (ImageButton) root.findViewById(R.id.imageButton8);
        final ImageButton m8 = (ImageButton) root.findViewById(R.id.imageButton9);

        ImageButton[] imageButtons = {m1, m2, m3, m4, m5, m6, m7, m8};

        // Enable the link between the respective meal buttons and their meal pages
        for (int i = 0; i < 8; i++) {
            transferToMeal(imageButtons[i]);
        }

        // Instantiate the day buttons as established in home_fragment.xml
        final Button d1 = (Button) root.findViewById(R.id.button2);
        final Button d2 = (Button) root.findViewById(R.id.button3);
        final Button d3 = (Button) root.findViewById(R.id.button4);
        final Button d4 = (Button) root.findViewById(R.id.button5);

        Button[] dayButtons = {d1, d2, d3, d4};

        // Enable the link between the respective day buttons and their order pages
        for (int i = 0; i < 4; i++) {
            transferToPlaceOrder(dayButtons[i]);
        }

        return root;
    }

    private void transferToMeal(ImageButton i) {
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                startActivity(intent);
            }
        });
    }

    private void transferToPlaceOrder(Button i) {
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlaceOrderActivity.class);
                // Create new meals for the test
                Meal[] meals = {new Meal("Sample #1"), new Meal("Sample #2")};
                intent.putExtra("Order", new Order(new Date(), meals));
                startActivity(intent);
            }
        });
    }
}