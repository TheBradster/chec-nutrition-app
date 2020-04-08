package com.example.checnutritionapp;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        String[] nutrients = m.getNutrition();
        TextView[] vals = {v.findViewById(R.id.nut1x),
                           v.findViewById(R.id.nut2x),
                           v.findViewById(R.id.nut3x),
                           v.findViewById(R.id.nut4x),
                           v.findViewById(R.id.nut5x),
                           v.findViewById(R.id.nut6x),
                           v.findViewById(R.id.nut7x),
                           v.findViewById(R.id.nut8x),
                           v.findViewById(R.id.nut9x),
                           v.findViewById(R.id.nut10x),
                           v.findViewById(R.id.nut11x),
                           v.findViewById(R.id.nut12x),
                           v.findViewById(R.id.nut13x)};
        for (int i = 0; i < 13; i++) {
            vals[i].setText(nutrients[i]);
        }

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MealNutritionViewModel.class);
        // TODO: Use the ViewModel
    }

}
