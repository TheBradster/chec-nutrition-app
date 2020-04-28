package com.example.checnutritionapp.ui.meal.procedure;

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

public class MealProcedureFragment extends Fragment {

    private MealProcedureViewModel mViewModel;

    public static MealProcedureFragment newInstance() {
        return new MealProcedureFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.meal_procedure_fragment, container, false);

        // Store serializable meal object so that its data may be referenced
        Meal m = (Meal) getActivity().getIntent().getSerializableExtra("meal");

        // Pull the preparation instructions from meal object and set into respective TextView
        TextView preparationTextView = v.findViewById(R.id.preparationText);
        preparationTextView.setText(m.getProcedure());

        // Pull the preparation time from the meal object and set into respective TextView
        TextView prepTimeTextView = v.findViewById(R.id.prepTimeText);
        String prepString = "Time: " + m.getPrepTime();
        prepTimeTextView.setText(prepString);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MealProcedureViewModel.class);
        // TODO: Use the ViewModel
    }

}
