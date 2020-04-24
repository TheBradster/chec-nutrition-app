package com.example.checnutritionapp.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Model that represents an "order". Needs a date that corresponds to when the order is ready
 * and an array of Meal objects to be created.
 */
public class Order implements Serializable {

    // Fields
    private Ticket[] mTickets; // Tickets interface between meals and orders
    private boolean mPayedFor;
    private Date mPlacedTime;
    private Date mReadyDate;
    private Location mLocation;

    // Constructors
    public Order(Date readyDate, Meal[] meals) {
        this.mTickets = Ticket.makeOrderTickets(this, meals); // Generate tickets
        this.mPayedFor = false;
        this.mPlacedTime = new Date();
        this.mReadyDate = readyDate;
        this.mLocation = null;
    }

    // Properties
    public Ticket[] getTickets() {
        return mTickets;
    }

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

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public String pickupDayOfWeek() {
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        return format.format(mReadyDate);
    }

    public double orderTotal() {
        double total = 0;
        for (Ticket ticket : mTickets) {
            total += ticket.total();
        }
        return total;
    }

    public boolean pastCutoff() {
        Date today = new Date();
        // Get order day
        Calendar cal  = Calendar.getInstance();
        return today.compareTo(mPlacedTime) > 0;
    }

    @Override
    public String toString() {
        return "Ready Date: " + pickupDayOfWeek() + "\n"
                + "Pickup Location: " + mLocation + "\n"
                + "Meals: " + java.util.Arrays.deepToString(mTickets) + "\n"
                + "Total: " + orderTotal();
    }

}