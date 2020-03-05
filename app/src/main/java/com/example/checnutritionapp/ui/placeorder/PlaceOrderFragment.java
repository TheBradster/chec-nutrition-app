package com.example.checnutritionapp.ui.placeorder;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Order;
import com.example.checnutritionapp.model.Ticket;

public class PlaceOrderFragment extends Fragment implements View.OnClickListener {

    private PlaceOrderViewModel mViewModel;

    private Order mOrder;

    public static PlaceOrderFragment newInstance() {
        return new PlaceOrderFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.place_order_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PlaceOrderViewModel.class);
        // TODO: Use the ViewModel

        // Get order object from intent
        mOrder = (Order) getActivity().getIntent().getSerializableExtra("Order");
        Log.d(getClass().toString(), mOrder.toString()); // We have object

        // Get buttons and set on click listener
        Button plus1 = (Button) getView().findViewById(R.id.plus1);
        plus1.setOnClickListener(this);
        Button plus2 = (Button) getView().findViewById(R.id.plus2);
        plus2.setOnClickListener(this);
        Button minus1 = (Button) getView().findViewById(R.id.minus1);
        minus1.setOnClickListener(this);
        Button minus2 = (Button) getView().findViewById(R.id.minus2);
        minus2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Ticket[] tickets = mOrder.getTickets();
        Log.d("PlaceOrderFramgment", "Yay, Buttons!!!");
        switch (id) {
            case R.id.plus1: tickets[0].changeServing(1); break;
            case R.id.plus2: tickets[1].changeServing(1); break;
            case R.id.minus1: tickets[0].changeServing(-1); break;
            case R.id.minus2: tickets[1].changeServing(-1); break;
            default: Log.wtf("PlaceOrderFragment", "WTF");
        }

        Log.d(getClass().toString(), mOrder.toString());
    }

}
