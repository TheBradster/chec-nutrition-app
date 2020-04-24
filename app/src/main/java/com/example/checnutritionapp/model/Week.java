package com.example.checnutritionapp.model;

import android.util.Log;

import com.example.checnutritionapp.model.Meal;
import com.example.checnutritionapp.model.Order;
import com.example.checnutritionapp.utility.MealBank;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Class represents a schedule for a week.
 */
public class Week implements Serializable {

    private Meal[][] schedule;
    private Order[] orders;
    private Date firstDayOfWeek = createFirstDayOfWeek();

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

    public double getRemainingOrderTotal() {
        double total = 0;
        for (Order order : orders) {
            if (order != null && !order.pastCutoff())
                total += order.orderTotal();
        }
        return total;
    }

    private Date createFirstDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    public boolean dayPastCutoff(int day) {
        Date today = new Date();
        // Get order day
        Calendar cal  = Calendar.getInstance();
        cal.setTime(firstDayOfWeek);
        cal.add(Calendar.DAY_OF_WEEK, day - 1);
        Date orderDay = cal.getTime();
        return today.compareTo(orderDay) > 0;
    }

    public Date getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(schedule);
    }
}
