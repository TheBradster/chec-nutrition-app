package com.example.checnutritionapp.model;

/**
 * Class represents a schedule for a week.
 */
public class Schedule {

    private Meal[][] schedule;

    public Schedule(Meal[][] schedule) {
        this.schedule = schedule;
    }

    public Meal[] getDay(int day) {
        return schedule[day];
    }
}
