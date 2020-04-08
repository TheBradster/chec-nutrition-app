package com.example.checnutritionapp.utility;

import android.util.Log;

import com.example.checnutritionapp.model.Meal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MealBank {

    private HashMap<Integer, Meal> mealDictionary = new HashMap<Integer, Meal>();

    public MealBank(JSONObject jsonData) throws JSONException {
        JSONArray mealsArray = jsonData.getJSONArray("Meals");
        // Log.d("MealBank",mealsArray.toString());
        for (int i = 0; i < mealsArray.length(); i++) {
            JSONObject meal = mealsArray.getJSONObject(i);
            Integer id = (Integer) meal.get("id");
            String[] nutrition = {
                    meal.getString("Calories/serving (kcal)"),
                    meal.getString("Total Fat "),
                    meal.getString("Sat "),
                    meal.getString("Trans"),
                    meal.getString("Monounsat"),
                    meal.getString("Polyunsat"),
                    meal.getString("Omega 3"),
                    meal.getString("Omega 6"),
                    meal.getString("Chol"),
                    meal.getString("Total Carb"),
                    meal.getString("Dietary fiber (g)"),
                    meal.getString("Sugar"),
                    meal.getString("Protein")
            };

            mealDictionary.put(id, new Meal(id, meal.getString("Name"), Double.parseDouble(meal.getString("Price per serving ").substring(1)), meal.getString("Description"), meal.getString("Procedure"),
                    meal.getString("Time for prep"), nutrition));
        }
        Log.d("MealBank", mealDictionary.toString());
    }

    public Meal getMealById(int day) {
        return mealDictionary.get(day);
    }

}
