package com.example.checnutritionapp.ui.your_week;

import android.app.Activity;
import android.content.Context;
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
import com.example.checnutritionapp.SummaryActivity;
import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.model.Order;
import com.example.checnutritionapp.utility.Week;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class YourWeekFragment extends Fragment {

    private Week week;
    private YourWeekViewModel yourWeekViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        yourWeekViewModel =
                ViewModelProviders.of(this).get(YourWeekViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_your_week, container, false);
        final TextView textView = root.findViewById(R.id.text_your_week);
        yourWeekViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        MainActivity activity = (MainActivity) getActivity();
        week = activity.getWeek();

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
                    Meal[] meals = {new Meal(1, "Meal 1", 5), new Meal(2, "Meal 2", 1.3)};
                    // Create order object to be further customized on in the next activity
                    intent.putExtra("Order", new Order(new Date(), meals));
                    startActivity(intent);
                }
        });

        // Button
        final Button summaryButton = (Button) root.findViewById(R.id.summaryButton);
        summaryButton.setText("Summary");
        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HomeFragment", "Button has been pressed");
                // Create intent to be passed to activity for placing order
                Intent intent2 = new Intent(getActivity(), SummaryActivity.class);
                // Create new meals for the test
                //Meal[] meals = {new Meal("Meal 1", 5), new Meal("Meal 2", 1.3)};
                // Create order object to be further customized on in the next activity
              //  intent2.putExtra("Order", new Order(new Date(), meals));
                startActivity(intent2);
            }
        });

        final Button[] dayButtons = {d1, d2, d3, d4};


        // Enable the link between the respective day buttons and their order pages
        for (int i = 0; i < 4; i++) {
            transferToPlaceOrder(dayButtons[i], i);
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

    private void transferToPlaceOrder(Button i, final int day) {
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlaceOrderActivity.class);
                // Get meals from schedule
                Meal[] meals = week.getMealsForDay(day);
                // Get date for current day of week
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY + day);
                intent.putExtra("Order", new Order(cal.getTime(), meals));
                startActivityForResult(intent, day);
            }
        });
    }

    // For reference: https://stackoverflow.com/questions/5060971/how-to-return-result-in-a-natural-way-when-the-called-the-called-activity-exit
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {

            // Update week object
            Order newOrder = (Order) data.getSerializableExtra("Order");
            week.updateOrder(requestCode, newOrder);
            Log.d("OnActivityResult",week.getOrder(requestCode)+"");

            // Save week object to file
            try {
                // Saved to /data/data/com.example.checnutritionapp
                FileOutputStream out = getActivity().openFileOutput("saved_orders.json", Context.MODE_PRIVATE);
                JSONArray weekData = week.getOrdersJSON();
                out.write(weekData.toString().getBytes());
                out.close();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }

    }
}