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

    // Constructors
    public Meal(int id, String name, double price) {
        mId = id;
        mName = name;
        mPrice = price;
    }

    public Meal(String meal1) {
    }

    // Properties
    public String getName() {
        return mName;
    }

    public int getId() { return mId; }

    public double price() { return mPrice; }
}
