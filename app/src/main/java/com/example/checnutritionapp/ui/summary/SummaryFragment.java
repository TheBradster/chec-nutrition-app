package com.example.checnutritionapp.ui.summary;

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
import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.model.Order;

import java.util.Date;

public class SummaryFragment extends Fragment  {

    private SummaryViewModel mViewModel;

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
        // TODO: Use the ViewModel
        Meal[] meals = new Meal[]{new Meal("Meal1"), new Meal("meal2")};
        Order x = new Order(new Date(), meals);
    }
}
