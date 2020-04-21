package com.example.checnutritionapp.ui.queue;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.MainActivity;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.*;
import com.example.checnutritionapp.utility.Week;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        CardView monday = getActivity().findViewById(R.id.monday_card);
        // Make card disappear if there is no order
        if (!week.orderPlaced(0)) {
            monday.setVisibility(View.GONE);
        }
        else {
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