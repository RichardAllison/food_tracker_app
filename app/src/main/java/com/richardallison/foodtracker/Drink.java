package com.richardallison.foodtracker;

import java.io.Serializable;

public class Drink implements Serializable {
    private long id;
    private String name;
    private String brand;
    private String type;
    private String description;
    private int volume;
    private int calories;
    private int glycemicIndex;
    private int carbohydrates;
    private int fat;
    private int saturatedFat;
    private int transFat;
    private int cholesterol;
    private int protein;
    private int sodium;
    private int potassium;
    private int sugar;
    private int alcohol;
    private int caffeine;
    private boolean carbonated;

    public Drink(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getType() {
        return this.type;
    }
    public String getDescription() {
        return this.description;
    }
    public int getVolume() {
        return this.volume;
    }
    public int getCalories() {
        return this.calories;
    }
    public int getGlycemicIndex() {
        return this.glycemicIndex;
    }
    public int getCarbohydrates() {
        return this.carbohydrates;
    }
    public int getFat() {
        return this.fat;
    }
    public int getSaturatedFat() {
        return this.saturatedFat ;
    }
    public int getTransFat() {
        return this.transFat;
    }
    public int getCholesterol() {
        return this.cholesterol;
    }
    public int getProtein() {
        return this.protein;
    }
    public int getSodium() {
        return this.sodium;
    }
    public int getPotassium() {
        return this.potassium;
    }
    public int getSugar() {
        return this.sugar;
    }
    public int getAlcohol() {
        return this.alcohol;
    }
    public int getCaffeine() {
        return this.caffeine;
    }
    public boolean getCarbonated() {
        return this.carbonated;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public void setGlycemicIndex(int glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }
    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
    public void setFat(int fat) {
        this.fat = fat;
    }
    public void setSaturatedFat(int saturatedFat) {
        this.saturatedFat  = saturatedFat;
    }
    public void setTransFat(int transFat) {
        this.transFat = transFat;
    }
    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }
    public void setPotassium(int potassium) {
        this.potassium = potassium;
    }
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }
    public void setCaffeine(int caffeine) {
        this.caffeine = caffeine;
    }
    public void setCarbonated(boolean carbonated) {
        this.carbonated = carbonated;
    }
}
