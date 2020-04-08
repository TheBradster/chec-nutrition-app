package com.example.checnutritionapp;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.checnutritionapp.model.Meal;

public class MealNutrition extends Fragment {

    private MealNutritionViewModel mViewModel;

    public static MealNutrition newInstance() {
        return new MealNutrition();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Meal m = (Meal) getActivity().getIntent().getSerializableExtra("meal");
        View v = inflater.inflate(R.layout.meal_nutrition_fragment, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MealNutritionViewModel.class);
        // TODO: Use the ViewModel
    }

}
