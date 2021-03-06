package com.example.checnutritionapp.ui.queue;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.activities.MainActivity;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Week;

public class QueueFragment extends Fragment {

    private QueueViewModel queueViewModel;

    private Week week;

    public static QueueFragment newInstance() {
        return new QueueFragment();
    }

    @Nullable
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Load week data
        MainActivity mainActivity = (MainActivity) getActivity();
        week = mainActivity.getWeek();
        Log.d("Queue", week.toString());

        // Update total
        TextView grandTotal = getActivity().findViewById(R.id.total);
        grandTotal.setText(String.format("Total: $%.2f", week.getWeekOrderTotal()));

        CardView monday = getActivity().findViewById(R.id.monday_card);
        // Make card disappear if there is no order
        if (!week.orderPlaced(0)) {
            monday.setVisibility(View.GONE);
        }
        else {
            if (week.dayPastCutoff(0)) {
                monday.setCardBackgroundColor(Color.GRAY);
            }
            TextView meal1 = getActivity().findViewById(R.id.meal1_mon);
            meal1.setText(week.getOrder(0).getTickets()[0].getMeal().getName());
            TextView meal2 = getActivity().findViewById(R.id.meal2_mon);
            meal2.setText(week.getOrder(0).getTickets()[1].getMeal().getName());
            TextView q1 = getActivity().findViewById(R.id.q1_mon);
            q1.setText("Quantity: " + week.getOrder(0).getTickets()[0].numberOfServings());
            TextView q2 = getActivity().findViewById(R.id.q2_mon);
            q2.setText("Quantity: " + week.getOrder(0).getTickets()[1].numberOfServings());
            TextView locationName = getActivity().findViewById(R.id.location_mon);
            locationName.setText(week.getOrder(0).getLocation().getName());
            TextView address = getActivity().findViewById(R.id.address_mon);
            address.setText(week.getOrder(0).getLocation().getAddress());
            TextView total = getActivity().findViewById(R.id.total_mon);
            total.setText(String.format("$%.2f", week.getOrder(0).orderTotal()));
        }

        CardView tuesday = getActivity().findViewById(R.id.tuesday_card);
        // Make card disappear if there is no order
        if (!week.orderPlaced(1)) {
            tuesday.setVisibility(View.GONE);
        }
        else {
            if (week.dayPastCutoff(1)) {
                monday.setCardBackgroundColor(Color.GRAY);
            }
            TextView meal1 = getActivity().findViewById(R.id.meal1_tue);
            meal1.setText(week.getOrder(1).getTickets()[0].getMeal().getName());
            TextView meal2 = getActivity().findViewById(R.id.meal2_tue);
            meal2.setText(week.getOrder(1).getTickets()[1].getMeal().getName());
            TextView q1 = getActivity().findViewById(R.id.q1_tue);
            q1.setText("Quantity: " + week.getOrder(1).getTickets()[0].numberOfServings());
            TextView q2 = getActivity().findViewById(R.id.q2_tue);
            q2.setText("Quantity: " + week.getOrder(1).getTickets()[1].numberOfServings());
            TextView locationName = getActivity().findViewById(R.id.location_tue);
            locationName.setText(week.getOrder(1).getLocation().getName());
            TextView address = getActivity().findViewById(R.id.address_tue);
            address.setText(week.getOrder(1).getLocation().getAddress());
            TextView total = getActivity().findViewById(R.id.total_tue);
            total.setText(String.format("$%.2f", week.getOrder(1).orderTotal()));
        }

        CardView wednesday = getActivity().findViewById(R.id.wednesday_card);
        // Make card disappear if there is no order
        if (!week.orderPlaced(2)) {
            wednesday.setVisibility(View.GONE);
        }
        else {
            if (week.dayPastCutoff(2)) {
                monday.setCardBackgroundColor(Color.GRAY);
            }
            TextView meal1 = getActivity().findViewById(R.id.meal1_wed);
            meal1.setText(week.getOrder(2).getTickets()[0].getMeal().getName());
            TextView meal2 = getActivity().findViewById(R.id.meal2_wed);
            meal2.setText(week.getOrder(2).getTickets()[1].getMeal().getName());
            TextView q1 = getActivity().findViewById(R.id.q1_wed);
            q1.setText("Quantity: " + week.getOrder(2).getTickets()[0].numberOfServings());
            TextView q2 = getActivity().findViewById(R.id.q2_wed);
            q2.setText("Quantity: " + week.getOrder(2).getTickets()[1].numberOfServings());
            TextView locationName = getActivity().findViewById(R.id.location_wed);
            locationName.setText(week.getOrder(2).getLocation().getName());
            TextView address = getActivity().findViewById(R.id.address_wed);
            address.setText(week.getOrder(2).getLocation().getAddress());
            TextView total = getActivity().findViewById(R.id.total_wed);
            total.setText(String.format("$%.2f", week.getOrder(2).orderTotal()));
        }

        CardView thursday = getActivity().findViewById(R.id.thursday_card);
        // Make card disappear if there is no order
        if (!week.orderPlaced(3)) {
            thursday.setVisibility(View.GONE);
        }
        else {
            if (week.dayPastCutoff(3)) {
                monday.setCardBackgroundColor(Color.GRAY);
            }
            TextView meal1 = getActivity().findViewById(R.id.meal1_thur);
            meal1.setText(week.getOrder(3).getTickets()[0].getMeal().getName());
            TextView meal2 = getActivity().findViewById(R.id.meal2_thur);
            meal2.setText(week.getOrder(3).getTickets()[1].getMeal().getName());
            TextView q1 = getActivity().findViewById(R.id.q1_thur);
            q1.setText("Quantity: " + week.getOrder(3).getTickets()[0].numberOfServings());
            TextView q2 = getActivity().findViewById(R.id.q2_thur);
            q2.setText("Quantity: " + week.getOrder(3).getTickets()[1].numberOfServings());
            TextView locationName = getActivity().findViewById(R.id.location_thur);
            locationName.setText(week.getOrder(3).getLocation().getName());
            TextView address = getActivity().findViewById(R.id.address_thur);
            address.setText(week.getOrder(3).getLocation().getAddress());
            TextView total = getActivity().findViewById(R.id.total_thur);
            total.setText(String.format("$%.2f", week.getOrder(3).orderTotal()));
        }


    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        queueViewModel =
                ViewModelProviders.of(this).get(QueueViewModel.class);
                View root = inflater.inflate(R.layout.activity_queue, container, false);
      //  final TextView textView = root.findViewById(R.id.nav_queue);

        //queueViewModel.getText().observe(this, new Observer<String>() {
          //  @Override
           //public void onChanged(@Nullable String s) {
               // textView.setText(s);
            //}

        //public void onCreate(Bundle saveInstanceState){

                //mon = Monday.getText().toString();
               // String Mon=mon;


       // }
        //});

        return root;
    }
}