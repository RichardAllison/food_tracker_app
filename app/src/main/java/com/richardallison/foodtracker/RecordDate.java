package com.richardallison.foodtracker;

public class RecordDate {

    private long id;
    private String date;

    public RecordDate(String date) {
        this.date = date;
    }
    public RecordDate(long id, String date) {
        this.id = id;
        this.date = date;
    }

    public long getID() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public void setID(long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
