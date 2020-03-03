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

import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Order;

public class PlaceOrderFragment extends Fragment {

    private PlaceOrderViewModel mViewModel;

    public static PlaceOrderFragment newInstance() {
        return new PlaceOrderFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Get order object from intent
        Order order = (Order) getActivity().getIntent().getSerializableExtra("Order");
        Log.d(getClass().toString(), order.toString()); // We have object



        return inflater.inflate(R.layout.place_order_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PlaceOrderViewModel.class);
        // TODO: Use the ViewModel
    }

}
