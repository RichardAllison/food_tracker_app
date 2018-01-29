package com.richardallison.foodtracker;

public class User {

    private String name;
    private char gender;
    private int age;
    private int height;
    private int weight;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public char getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }
}
