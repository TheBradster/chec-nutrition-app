package com.example.checnutritionapp.model;

import java.util.Date;

/**
 * Model that represents an "order". Needs a date that corresponds to when the order is ready
 * and an array of Meal objects to be created.
 */
public class Order {

    // Fields
    private Ticket[] mTickets; // Tickets interface between meals and orders
    private boolean mPayedFor;
    private Date mPlacedTime;
    private Date mReadyDate;
    private String mLocation;

    // Constructors
    public Order(Date readyDate, Meal[] meals) {
        this.mTickets = Ticket.makeOrderTickets(this, meals); // Generate tickets
        this.mPayedFor = false;
        this.mPlacedTime = new Date();
        this.mReadyDate = readyDate;
        this.mLocation = null;
    }

    // Properties
//     public Ticket[] getTickets() {
//          return mTickets;
//     }

    public void pay() {
        this.mPayedFor = true;
    }

    // TODO replace with Date getCutOffTime() or boolean pastCutOffTime()
    public Date getPlacedTime() {
        return mPlacedTime;
    }

    public Date getReadyDate() {
        return mReadyDate;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }

    public String getLocation() {
        return this.mLocation;
    }


}
