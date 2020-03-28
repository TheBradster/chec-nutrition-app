package com.example.checnutritionapp.model;

import java.io.Serializable;

/**
 * Class represents a schedule for a week.
 */
public class Week implements Serializable {

    private Meal[][] schedule;
    private Order[] orders;

    public Week(Meal[][] schedule) {
        this.orders = new Order[4];
        this.schedule = schedule;
    }

    /**
     * Get meals for for a given day. Monday: 0, Tuesday: 1, etc.
     * @param day
     * @return meal object for day of week
     */
    public Meal[] getDayForDay(int day) {
        try {
            return schedule[day];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Day of week integer is out of bounds.");
        }
    }

    public boolean orderPlaced(int day) {
        return orders[day] != null;
    }

    public Order getOrder(int day) {
        if (orderPlaced(day) && day < orders.length) {
            return orders[day];
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Order does not exist for given day");
        }
    }
}
