package com.example.checnutritionapp.utility;

import android.util.Log;
import com.example.checnutritionapp.model.Meal;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserSet {

    private HashMap<Integer, User> allUsers = new HashMap<Integer, User>();

    public UserSet(JSONObject jsonData) throws JSONException {
        JSONArray usersArray = jsonData.getJSONArray("Users");
        
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject user = usersArray.getJSONObject(i);
            Integer id = (Integer) user.get("id");
            String[] allergens = user.getJSONArray("user_allergens");

            allUsers.put(id, new User(
                user.getString("user_name"),
                user.getString("user_fname"),
                user.getString("user_lname"),
                user.getString("user_age"),
                user.getString("user_height"),
                user.getString("user_weight"),
                user.getString("user_location"),
                user.getString("user_occupation"),
                user.get("user_familyc"),
                user.get("user_glucose"),
                user.get("user_a1c"),
                user.get("user_cholesterol"),
                allergens
            ));
        }
        
    }

    public User getUserById(int id) {
        return allUsers.get(id);
    }

}