package com.example.checnutritionapp.utility;

import android.util.Log;

import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.model.Order;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Arrays;

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
    public Week(JSONObject jsonData, MealBank meals) throws JSONException {
        orders = new Order[4];
        schedule = new Meal[4][2];

        // Process JSON data
        JSONArray jsonArray = jsonData.getJSONArray("days");
        Log.d("Week", jsonArray.toString());

        //String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday"};
        for (int i = 0; i < 4; i++) {
            JSONArray day = jsonArray.getJSONArray(i);
            schedule[i][0] = meals.getMealById(day.getInt(0));
            schedule[i][1] = meals.getMealById(day.getInt(1));
        }
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
    public Meal[] getMealsForDay(int day) {
        try {
            return schedule[day];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Day of week integer is out of bounds.");
        }
    }

    /**
     * Updates an order for a given day to a new order
     * @param day
     * @param order
     */
    public void updateOrder(int day, Order order) {
        orders[day] = order;
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

    public JSONArray getOrdersJSON() throws JSONException {
        JSONArray array = new JSONArray();
        for (Order order : orders) {
            if (order != null) {
                JSONObject orderJSON = new JSONObject();
                orderJSON.put(order.pickupDayOfWeek(), order);
                array.put(orderJSON);
            }
        }

        return array;
    }

    public double getWeekOrderTotal() {
        double total = 0;
        for (Order order : orders) {
            if (order != null)
                total += order.orderTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(schedule);
    }
}
