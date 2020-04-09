package com.example.checnutritionapp.ui.summary;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Order;

public class SummaryFragment extends Fragment {

    private SummaryViewModel mViewModel;

    private Order mOrder;

    public static SummaryFragment newInstance() {
        return new SummaryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.summary_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SummaryViewModel.class);
        mOrder = (Order) getActivity().getIntent().getSerializableExtra("Order");
        Log.d(getClass().toString(), mOrder.toString()); // We have object

        //update pickup address
//  Location location = mOrder.getLocation();
        // TextView pickuplocation = getView().findViewById(R.id.address);
        // pickuplocation.setText(location.getAddress());
        // update servings1
        TextView servings1 = getView().findViewById(R.id.servings1);
        servings1.setText(String.valueOf(mOrder.getTickets()[0].numberOfServings()));
        // update servings2
        TextView servings2 = getView().findViewById(R.id.servings2);
        servings2.setText(String.valueOf(mOrder.getTickets()[1].numberOfServings()));
        // update pickup time
        TextView pickupTime = getView().findViewById(R.id.pickupTime);
        pickupTime.setText("Between 12:00pm and 5:00pm on " + mOrder.pickupDayOfWeek());
        // update total
        TextView total = getView().findViewById(R.id.total);
        total.setText("  $" + String.format("%.2f", mOrder.orderTotal()));

    }
};


