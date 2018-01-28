package com.richardallison.foodtracker;

//import java.util.Date;
//import java.sql.Time;

import java.time.LocalDate;
//import java.time.LocalTime;
public class Record<T extends Consumable> {

    private T item;
    private LocalDate date;
    private MealTime meal;
    private String portion_size;
//    portion size unit

    public Record(T item, LocalDate date, MealTime meal, String portion_size) {
        this.item = item;
        this.date = date;
        this.meal = meal;
        this.portion_size = portion_size;
    }


    public T getItem() {
        return this.item;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public MealTime getMealTime() {
        return this.meal;
    }

    public String getPortionSize() {
        return this.portion_size;
    }
}