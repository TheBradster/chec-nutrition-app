package com.example.checnutritionapp.ui.meal;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.checnutritionapp.activities.MealActivity;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.ui.meal.allergens.MealAllergensFragment;
import com.example.checnutritionapp.ui.meal.nutrition.MealNutrition;
import com.example.checnutritionapp.ui.meal.procedure.MealProcedureFragment;

public class MealFragment extends Fragment {

    private MealViewModel mViewModel;

    public static MealFragment newInstance() {
        return new MealFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.meal_fragment, container, false);

        // Retrieve the meal object to be parsed through in the lifespan of MealFragment
        final Bundle b = this.getArguments();
        Meal m = (Meal) b.getSerializable("meal");

        // Pull and display the TextView for the meal title
        TextView title = v.findViewById(R.id.mealTitle_text);
        title.setText(m.getName());

        // Pull and display the TextView for the meal price
        TextView price = v.findViewById(R.id.mealPrice_text);
        String priceText = "Starting Price: $" + Double.toString(m.getPrice());
        price.setText(priceText);

        // TODO: Likely a way to create a method for these all to reduce repetitive code

        // Create listener for button to display MealNutrition fragment
        Button openNutFacts = v.findViewById(R.id.nut_button);
        openNutFacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MealNutrition nutritionFragment = new MealNutrition();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.meal_layout, nutritionFragment);
                trans.addToBackStack(null);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }
        });

        // Create listener for button to display MealProcedure fragment
        Button openProcedure = (Button) v.findViewById(R.id.proc_button);
        openProcedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MealProcedureFragment procFragment = new MealProcedureFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.meal_layout, procFragment);
                trans.addToBackStack(null);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }
        });

        // Create listener for button to display MealAllergens fragment
        Button openAllergens = (Button) v.findViewById(R.id.allergen_button);
        openAllergens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MealAllergensFragment allergenFragment = new MealAllergensFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.meal_layout, allergenFragment);
                trans.addToBackStack(null);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }
        });

        MealActivity mainActivity = (MealActivity) getActivity();

        // Pluck meal image reference from meal object to be set dynamically
        ImageView pic = v.findViewById(R.id.meal_image);
        String filename = m.getImageNameRef();
        String packageName = mainActivity.getApplicationContext().getPackageName();
        int imgID = getResources().getIdentifier(packageName + ":drawable/" + filename, null, null);
        pic.setImageResource(imgID);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MealViewModel.class);
        // TODO: Use the ViewModel
    }

}
