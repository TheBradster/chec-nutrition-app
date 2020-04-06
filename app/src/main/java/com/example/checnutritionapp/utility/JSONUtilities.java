package com.example.checnutritionapp.utility;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtilities {

    /**
     * Creates JSON object out of .json asset
     * Source: https://stackoverflow.com/questions/13814503/reading-a-json-file-in-android
     * @param context
     * @return JSONObject
     * @throws JSONException
     */
    public static JSONObject loadJSONFromAsset(Context context, String filename) throws JSONException {
        String jsonString;
        try {
            InputStream inputStream = context.getAssets().open(filename);
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
