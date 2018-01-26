package com.codeclan.example.foodtracker;

public class Food implements Consumable {

    private String name;
    private String type;
    private String description;
    private String brand;
//    private ArrayList<Food> ingredients; //?

    //nutritional information (extension thought)
    private int calories;
//    private int carbohydrates;
//    private int fat;
//    private int protein;
//    private int salt;
//    private int sugar;

    public Food(String name) {
        this.name = name;
    }

    public Food(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }


    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setName(String name) {
        this.name = name;
    }



}
