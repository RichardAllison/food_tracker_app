package com.richardallison.foodtracker.models;

public enum MealTime {

    BREAKFAST(0),
    MORNING_SNACK(1),
    LUNCH(2),
    AFTERNOON_SNACK(3),
    DINNER(4),
    EVENING_SNACK(5);

    private final int value;

    MealTime(int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
