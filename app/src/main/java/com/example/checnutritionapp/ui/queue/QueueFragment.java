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