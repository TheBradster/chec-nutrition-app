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
    private String mName;
    private double mPrice;

    // Constructors
    public Meal(String name, double price) {
        mName = name;
        mPrice = price;
    }

    // Properties
    public String getName() {
        return mName;
    }

    public double price() { return mPrice; }
}
