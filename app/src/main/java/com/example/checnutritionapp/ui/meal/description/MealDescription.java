package com.example.checnutritionapp.ui.meal.description;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Meal;

public class MealDescription extends Fragment {

    private MealDescriptionViewModel mViewModel;

    public static MealDescription newInstance() {
        return new MealDescription();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Meal m = (Meal) getActivity().getIntent().getSerializableExtra("meal");
        View v = inflater.inflate(R.layout.meal_description_fragment, container, false);

        TextView desc = (TextView) v.findViewById(R.id.mealDescText);
        desc.setText(m.getDescription());

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MealDescriptionViewModel.class);
        // TODO: Use the ViewModel
    }

}
