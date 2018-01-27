package com.codeclan.example.foodtracker;

public class Food implements Consumable {

    private String name;
    private String type;
    private String description;
    private String brand;
//    private ArrayList<Food> ingredients; //?

    //nutritional information (extension thought)
    private int calories;
    int glycemicIndex;
    private int carbohydrates;
    private int fat;
    private int saturatedFat;
    private int transFat;
    private int cholesterol;
    private int protein;
    private int sodium;
    private int potassium;
    private int fiber;
    private int sugar;

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
