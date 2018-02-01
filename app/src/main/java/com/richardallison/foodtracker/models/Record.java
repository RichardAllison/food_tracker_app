package com.richardallison.foodtracker.models;

import java.io.Serializable;


public class Record implements Serializable {

    private long id;
    private String foodName;
    private String date;
    private long itemID;
//    private int mealtime;
    private String mealtime;
    private String portionSize;

    public Record() {

    }

    public Record(String date, long itemID, String meal, String portionSize) {
        this.date = date;
        this.itemID = itemID;
        this.mealtime = meal;
        this.portionSize = portionSize;
    }

    public Record(String name, String date, long itemID, String meal, String portionSize) {
        this.foodName = name;
        this.date = date;
        this.itemID = itemID;
        this.mealtime = meal;
        this.portionSize = portionSize;
    }

    public Record(long id, String date, long itemID, String meal, String portionSize) {
        this.id = id;
        this.date = date;
        this.itemID = itemID;
        this.mealtime = meal;
        this.portionSize = portionSize;
    }

    public long getID() {
        return this.id;
    }

    public String getDate(){
        return this.date;
    }

    public long getItemID(){
        return this.itemID;
    }

    public String getMealtime(){
        return this.mealtime;
    }

    public String getPortionSize(){
        return this.portionSize;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public void setID(long id) {
        this.id = id;
    }

    public void setDateID(String date){
        this.date = date;
    }

    public void setItemID(int itemID){
        this.itemID = itemID;
    }

    public void setMealtime(String mealtime){
        this.mealtime = mealtime;
    }

    public void setPortionSize(String portionSize){
        this.portionSize = portionSize;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
