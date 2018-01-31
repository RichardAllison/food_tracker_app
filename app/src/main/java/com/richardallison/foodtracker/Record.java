package com.richardallison.foodtracker;

//import java.util.Date;
//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalTime;

import java.io.Serializable;


public class Record implements Serializable {

    long id;
//    private int dateID;
    private String date;
    private long itemID;
//    private int mealtime;
    private String mealtime;
    private String portionSize;
    private String foodName;

    public Record() {

    }

    public Record(String date, long itemID, String meal, String portionSize) { //int dateId,
        this.date = date;
        this.itemID = itemID;
        this.mealtime = meal;
        this.portionSize = portionSize;
    }

    public Record(long id, String date, long itemID, String meal, String portionSize) { //int dateId,
        this.id = id;
//        this.dateID = dateID;
        this.date = date;
        this.itemID = itemID;
        this.mealtime = meal;
        this.portionSize = portionSize;
    }

    public long getID() {
        return this.id;
    }

//    public int getDateID(){
//        return this.dateID;
//    }

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

//    public void setDateID(int dateID){
//        this.dateID = dateID;
//    }
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



//public class Record<T extends Consumable> implements Serializable {

//    private T item;
//    private LocalDate date;
//    private MealTime meal;
//    portion size unit
//
//    public Record(T item, LocalDate date, MealTime meal, String portion_size) {
//        this.item = item;
//        this.date = date;
//        this.meal = meal;
//        this.portion_size = portion_size;
//    }
//
//    public T getItem() {
//        return this.item;
//    }
//
//    public LocalDate getDate() {
//        return this.date;
//    }
//
//    public MealTime getMealTime() {
//        return this.meal;
//    }


}
