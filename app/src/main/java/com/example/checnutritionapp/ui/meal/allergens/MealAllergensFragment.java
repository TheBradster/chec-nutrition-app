package com.example.checnutritionapp.ui.meal.allergens;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Meal;

public class MealAllergensFragment extends Fragment {

    private MealAllergensViewModel mViewModel;

    public static MealAllergensFragment newInstance() {
        return new MealAllergensFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.meal_allergens_fragment, container, false);

        // Store serializable meal object so that its data may be referenced
        Meal m = (Meal) getActivity().getIntent().getSerializableExtra("meal");

        // TODO: Pull allergen data from meals JSON and prepare it for presentation

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MealAllergensViewModel.class);
        // TODO: Use the ViewModel
    }

}
