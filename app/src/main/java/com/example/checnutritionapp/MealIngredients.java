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

public class MealIngredients extends Fragment {

    private MealIngredientsViewModel mViewModel;

    public static MealIngredients newInstance() {
        return new MealIngredients();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Meal m = (Meal) getActivity().getIntent().getSerializableExtra("meal");
        View v = inflater.inflate(R.layout.meal_ingredients_fragment, container, false);

        String[] ingredients = m.getIngredients();

        TextView text = v.findViewById(R.id.ingredients_list);

        String s = "";
        for (int i = 0; i < ingredients.length; i++) {
            s = s + ingredients[i];
            if (i != ingredients.length - 1)
                s = s + ", ";
        }

        text.setText(s);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MealIngredientsViewModel.class);
        // TODO: Use the ViewModel
    }

}
