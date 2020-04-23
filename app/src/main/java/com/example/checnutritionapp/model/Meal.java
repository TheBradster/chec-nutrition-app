package com.example.checnutritionapp.model;

import java.io.Serializable;

/**
 * Model representing a "meal". Currently has a name, which it needs to be created.
 * Later is should have all the other nutritional information associated with meals
 * as well as procedure and ingredients lists.
 */
public class Meal implements Serializable {

    // Fields
    // TODO add rest of fields
    private int mId;
    private String mName;
    private double mPrice;
    private String description;
    private String procedure;
    private String prepTime;
    private String[] nutrition;
    private String[] ingredients;
    private boolean vegan;

    // Constructors
    public Meal(int id, String name, double price, String desc, String proc, String prep, String[] nut, String[] ing, boolean v) {
        mId = id;
        mName = name;
        mPrice = price;
        description = desc;
        procedure = proc;
        prepTime = prep;
        nutrition = nut;
        ingredients = ing;
        vegan = v;
    }

    public Meal(String meal1) {
    }

    // Properties
    public String getName() {
        return mName;
    }

    public int getId() { return mId; }

    public double price() { return mPrice; }

    public String getDescription() { return description; }

    public String getProcedure() { return procedure; }

    public String getPrepTime() { return prepTime; }

    public String[] getNutrition() { return nutrition; }

    @Override
    public String toString() {
        return "id: " + mId + " Name: " + mName + " Price: " + mPrice;
    }
}
