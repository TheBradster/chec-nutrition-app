package com.example.checnutritionapp.model;

import java.io.Serializable;

public class Ticket implements Serializable {

    // Fields
    private Meal mMeal;
    private Order mOrder;
    private int mNumServings;

    // Constructors
    protected Ticket(Meal meal, Order order) {
        mMeal = meal;
        mOrder = order;
        mNumServings = 0;
    }

    // Properties
    public boolean changeServing(int amount) {
        mNumServings += amount;
        if (mNumServings < 0) {
            mNumServings = 0;
            return false;
        }
        else { return true; }
    }

    public int numberOfServings() {
        return mNumServings;
    }

    /**
     * This method is how all the tickets should be created. It allows for the list
     * of meals passed to the order in its creation to be converted into tickets.
     * @param order the order that the meals belong to.
     * @param meals an array containing meals that need tickets.
     * @return An array that contains all the tickets for the order.
     */
    public static Ticket[] makeOrderTickets(Order order, Meal[] meals) {
        Ticket[] tickets = new Ticket[meals.length];
        for (int i = 0; i < meals.length; i++) {
            tickets[i] = new Ticket(meals[i], order);
        }
        return tickets;
    }
}
