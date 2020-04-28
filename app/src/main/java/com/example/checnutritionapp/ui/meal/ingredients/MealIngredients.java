package com.example.checnutritionapp.ui.meal.ingredients;

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

public class MealIngredients extends Fragment {

    private MealIngredientsViewModel mViewModel;

    public static MealIngredients newInstance() {
        return new MealIngredients();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.meal_ingredients_fragment, container, false);

        // Store serializable meal object so that its data may be referenced
        Meal m = (Meal) getActivity().getIntent().getSerializableExtra("meal");

        // Create ingredients list based upon data stored in meal object
        String[] ingredients = m.getIngredients();

        TextView ingredientsTextView = v.findViewById(R.id.ingredients_list);

        // Build a string with all the ingredients concatenated together in a listing
        String s = "";
        for (int i = 0; i < ingredients.length; i++) {
            s = s + ingredients[i];
            if (i != ingredients.length - 1)
                s = s + ", ";
        }

        // Set the TextView to display the list of ingredients
        ingredientsTextView.setText(s);

        // View meal object data and determine if it is vegan friendly
        TextView isVeganTextView = v.findViewById(R.id.vegan_response);
        if (m.getVegan()) {
            isVeganTextView.setText("Yes!");
        } else {
            isVeganTextView.setText("No!");
        }

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MealIngredientsViewModel.class);
        // TODO: Use the ViewModel
    }

}
