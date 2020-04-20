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
        JSONArray mealsArray = jsonData.getJSONArray("Meals");

        JSONArray usersArray = jsonData.getJSONArray("Users");
        
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject user = usersArray.getJSONObject(i);
            Integer id = (Integer) user.get("id");

            allUsers.put(id, new User());
        }
        
    }

    public User getUserById(int id) {
        return allUsers.get(id);
    }

}