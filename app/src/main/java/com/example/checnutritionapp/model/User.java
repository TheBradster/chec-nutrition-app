package com.example.checnutritionapp.model;

import java.io.Serializable;

public class User implements Serializable {

    // User attribute fields
    private int u_id;
    private String u_name;
    private String u_fname;
    private String u_lname;
    private String u_age;
    private String u_height;
    private String u_weight;
    private String u_location;
    private String u_occupation;
    private int u_familyc;
    private int u_glucose;
    private int u_a1c;
    private int u_cholesterol;
    private String[] u_allergens;

    // Constructors
    public User(
        int id,
        String user_name,
        String user_fname,
        String user_lname,
        String user_age,
        String user_height,
        String user_weight,
        String user_location,
        String user_occupation,
        Integer user_familyc,
        Integer user_glucose,
        Integer user_a1c,
        Integer user_cholesterol,
        String[] user_allergens
    ) {
        u_id = id;
        u_name = user_name;
        u_fname = user_fname;
        u_lname = user_lname;
        u_age = user_age;
        u_height = user_height;
        u_weight = user_weight;
        u_location = user_location;
        u_occupation = user_occupation;
        u_familyc = user_familyc;
        u_glucose = user_glucose;
        u_a1c = user_a1c;
        u_cholesterol = user_cholesterol;
        u_allergens = user_allergens;
    }

    public User(String user) {
    }

    // Properties
    public String getUsername() {
        return u_name;
    }

    public String getFullName() {
        String name = u_fname + " " + u_lname;
        return name;
    }

    public String getAge() {
        return u_age;
    }

    public String getHeight() {
        return u_height;
    }

    public String getWeight() {
        return u_weight;
    }

    public String getLocation() {
        return u_location;
    }

    public String getOccupation() {
        return u_occupation;
    }

    public int getFamilyCount() {
        return u_familyc;
    }

    public int getGlucose() {
        return u_glucose;
    }

    public int getCholesterol() {
        return u_cholesterol;
    }

    public String[] getAllergens() {
        return u_allergens;
    }

    @Override
    public String toString() {
        return "Test";
    }
}