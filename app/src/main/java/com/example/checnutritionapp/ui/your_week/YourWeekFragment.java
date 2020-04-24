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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.checnutritionapp.MainActivity;
import com.example.checnutritionapp.MealActivity;
import com.example.checnutritionapp.PlaceOrderActivity;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.SummaryActivity;
import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.model.Order;
import com.example.checnutritionapp.model.Week;


import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class YourWeekFragment extends Fragment {

    private Week week;
    private YourWeekViewModel yourWeekViewModel;

    // Buttons
    ImageButton[] mealButtons;
    Button[] orderButtons;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        yourWeekViewModel =
                ViewModelProviders.of(this).get(YourWeekViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_your_week, container, false);
        //final TextView textView = root.findViewById(R.id.text_your_week);
/*        yourWeekViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        MainActivity activity = (MainActivity) getActivity();
        week = activity.getWeek();

        // Create meal arrays for each of the days of the week
        Meal[] mDay0 = week.getMealsForDay(0);
        Meal[] mDay1 = week.getMealsForDay(1);
        Meal[] mDay2 = week.getMealsForDay(2);
        Meal[] mDay3 = week.getMealsForDay(3);

        Meal[][] mDays = {mDay0, mDay1, mDay2, mDay3};

        // Instantiate the meal buttons as established in home_fragment.xml
        final ImageButton m1 = (ImageButton) root.findViewById(R.id.monday_meal1);
        final ImageButton m2 = (ImageButton) root.findViewById(R.id.monday_meal2);
        final ImageButton m3 = (ImageButton) root.findViewById(R.id.tuesday_meal1);
        final ImageButton m4 = (ImageButton) root.findViewById(R.id.tuesday_meal2);
        final ImageButton m5 = (ImageButton) root.findViewById(R.id.wed_meal1);
        final ImageButton m6 = (ImageButton) root.findViewById(R.id.wed_meal2);
        final ImageButton m7 = (ImageButton) root.findViewById(R.id.thur_meal1);
        final ImageButton m8 = (ImageButton) root.findViewById(R.id.thur_meal2);

        ImageButton[] a = {m1, m2, m3, m4, m5, m6, m7, m8};
        mealButtons = a;

        // Enable the link between the respective meal buttons and their meal pages
        for (int i = 0, j = 0, k = 0; i < 8; i++) {
            if (j == 1) {
                transferToMeal(mealButtons[i], mDays[k][1]);
            } else if (j == 2) {
                transferToMeal(mealButtons[i], mDays[++k][0]);
                j = 0;
            } else {
                transferToMeal(mealButtons[i], mDays[k][0]);
            }
            j++;
        }

        // Instantiate the day buttons as established in home_fragment.xml
        final Button d1 = (Button) root.findViewById(R.id.monday_order);
        final Button d2 = (Button) root.findViewById(R.id.tuesday_order);
        final Button d3 = (Button) root.findViewById(R.id.wednesday_order);
        final Button d4 = (Button) root.findViewById(R.id.thursday_order);

/*        // Button
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
        */

        Button[] array = {d1, d2, d3, d4};
        orderButtons = array;


        // Enable the link between the respective day buttons and their order pages
        refreshButtons();

        return root;
        }

    private void transferToMeal(ImageButton i, final Meal m) {
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                intent.putExtra("meal", m);
                startActivity(intent);
            }
        });
    }

    private void refreshButtons() {
        for (int i = 0; i < 4; i++) {
            linkOrderButton(orderButtons[i], i);
        }
    }

    private void linkOrderButton(Button i, final int day) {

        final boolean alreadyPlaced = week.orderPlaced(day);
        final boolean pastCutoff = week.dayPastCutoff(day);

        // Set button text
        if (alreadyPlaced && pastCutoff) {
            i.setText("View Order");
        }
        else if (alreadyPlaced) {
            i.setText("Edit Order");
        }
        else if (pastCutoff) {
            i.setText("");
        }
        else {
            i.setText("Place Order");
        }

        // Get meals from schedule
        final Meal[] meals = week.getMealsForDay(day);

        // Get date for current day of week
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY + day);
        final Date orderTime = cal.getTime();

        final Order orderToPass = (alreadyPlaced) ? week.getOrder(day) : new Order(orderTime, meals);


        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pastCutoff || alreadyPlaced) {
                    Intent intent = new Intent(getActivity(), (alreadyPlaced) ? SummaryActivity.class : PlaceOrderActivity.class);
                    intent.putExtra("Order", orderToPass);
                    startActivityForResult(intent, day);
                }
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

            // Update text
            refreshButtons();
        }

    }
}