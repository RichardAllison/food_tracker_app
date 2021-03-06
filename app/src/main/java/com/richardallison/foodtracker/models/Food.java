package com.richardallison.foodtracker.models;

import java.io.Serializable;

public class Food implements Serializable {

    private long id;
    private String name;
    private String type;
    private String description;
    private String brand;
    private int servingSize;
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
    private int fibre;
    private int sugar;

    public Food() {}
    public Food(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }
    public Food(long id,
            String name,
            String type,
            String description,
            String brand,
            int servingSize,
            int calories,
            int glycemicIndex,
            int carbohydrates,
            int fat,
            int saturatedFat,
            int transFat,
            int cholesterol,
            int protein,
            int sodium,
            int potassium,
            int fibre,
            int sugar) {

        this.name = name;
        this.brand = brand;
        this.type = type;
        this.description = description;
        this.brand = brand;
        this.servingSize = servingSize;
        this.calories = calories;
        this.glycemicIndex = glycemicIndex;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.saturatedFat = saturatedFat;
        this.transFat = transFat;
        this.cholesterol = cholesterol;
        this.protein = protein;
        this.sodium = sodium;
        this.potassium = potassium;
        this.fibre = fibre;
        this.sugar = sugar;
    }

    public long getID() {
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
    public int getServingSize() {
        return this.servingSize;
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
        return this.saturatedFat;
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
    public int getFibre() {
        return this.fibre;
    }
    public int getSugar() {
        return this.sugar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setGlycemicIndex(int glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public void setCarbohydrates(int calories) {
        this.carbohydrates = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSaturatedFat(int saturatedFat) {
        this.saturatedFat = saturatedFat;
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

    public void setFibre(int fibre) {
        this.fibre = fibre;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setID(long id) {
        this.id = id;
    }

}
