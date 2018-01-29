package com.richardallison.foodtracker;

import java.io.Serializable;

public class Drink implements Consumable, Serializable {
    private String name;
    private String brand;
//    private String type;
//    private String description;
    private int calories;
//    private int carbohydrates;
//    private int fat;
//    private int protein;
//    private int salt;
//    private int sugar;
//    private int alcohol;

    public Drink(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }
}
