package com.example.checnutritionapp.model;

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

    @Override
    public String toString() {
        return mName;
    }
}
