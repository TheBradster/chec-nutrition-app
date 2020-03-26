package com.example.checnutritionapp.model;

/**
 * Class represents a schedule for a week.
 */
public class Schedule {

    private Meal[][] schedule;

    public Schedule(Meal[][] schedule) {
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
}
