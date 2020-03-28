package com.example.checnutritionapp.utility;

import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.model.Order;

import java.io.Serializable;

/**
 * Class represents a schedule for a week.
 */
public class Week implements Serializable {

    private Meal[][] schedule;
    private Order[] orders;

    /**
     * Primary constructor. Should automatically retrieve schedule for the week.
     * Currently it references a JSON file to get test data.
     */
    public Week() {

    }

    /**
     * Alternate constructor where schedule array is given up front.
     * @param schedule
     */
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

    /**
     * Checks if order has been placed for given day.
     * @param day
     * @return
     */
    public boolean orderPlaced(int day) {
        return orders[day] != null;
    }

    /**
     * If order has been placed for a given day, this method retrieves it.
     * @param day
     * @return
     */
    public Order getOrder(int day) {
        if (orderPlaced(day) && day < orders.length) {
            return orders[day];
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Order does not exist for given day");
        }
    }
}
