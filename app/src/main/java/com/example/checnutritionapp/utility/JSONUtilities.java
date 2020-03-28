package com.example.checnutritionapp.utility;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtilities {

    public static JSONObject loadJSONFromAsset(Context context) throws JSONException {
        String jsonString;
        try {
            InputStream inputStream = context.getAssets().open("meals.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return new JSONObject(jsonString);

    }
}
