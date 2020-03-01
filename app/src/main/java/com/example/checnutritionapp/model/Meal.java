package com.example.checnutritionapp.model;

/**
 * Model representing a "meal". Currently has a name, which it needs to be created.
 * Later is should have all the other nutritional information associated with meals
 * as well as procedure and ingredients lists.
 */
public class Meal {

    // Fields
    // TODO add rest of fields
    private String mName;

    // Constructors
    public Meal(String name) {
        mName = name;
    }

    // Properties
    public String getName() {
        return mName;
    }
}
