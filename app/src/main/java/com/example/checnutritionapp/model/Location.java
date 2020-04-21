package com.example.checnutritionapp.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Location implements Serializable {

    // Fields
    private String mName;
    private String mAddress;

    // Constructors
    public Location(String name, String address) {
        mName = name;
        mAddress = address;
    }

    public String getName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public static Location[] convertLocationList(JSONObject data) throws JSONException {
        JSONArray array = data.getJSONArray("Locations");
        Location[] locations = new Location[array.length()];
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            locations[i] = new Location(obj.getString("Name"), obj.getString("Address"));
        }
        return locations;
    }

    @Override
    public String toString() {
        return mName + ", " + mAddress;
    }
}
