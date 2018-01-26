package com.codeclan.example.foodtracker;

import org.junit.Before;
import org.junit.Test;

//import java.util.Date;
//import java.sql.Time;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class RecordTest {

    Food bread;
    Drink irnBru;
    Record<Food> foodRecord;
    Record<Drink> drinkRecord;

    @Before
    public void before() {
        bread = new Food("bread", "Allinsons");
        irnBru = new Drink("Irn-Bru", "Barr");
        foodRecord = new Record<>(bread, LocalDate.now(), MealTime.AFTERNOON_MEAL, "slice"); //LocalTime.now()
        drinkRecord = new Record<>(irnBru, LocalDate.now(), MealTime.AFTERNOON_MEAL, "50ml"); //LocalTime.now()
    }

    @Test
    public void foodRecordHasFood() {
        assertEquals(bread, foodRecord.getItem());
        assertEquals("bread", foodRecord.getItem().getName());
    }

    @Test
    public void foodRecordHasDate() {
        assertEquals(LocalDate.now(), foodRecord.getDate());
    }

    @Test
    public void foodRecordHasMealTime() {
        assertEquals(MealTime.AFTERNOON_MEAL, foodRecord.getMealTime());
    }

    @Test
    public void foodRecordHasPortion() {
        assertEquals("slice", foodRecord.getPortion());
    }

    @Test
    public void drinkRecordHasFood() {
        assertEquals(irnBru, drinkRecord.getItem());
        assertEquals("Irn-Bru", drinkRecord.getItem().getName());
    }

    @Test
    public void drinkRecordHasDate() {
        assertEquals(LocalDate.now(), drinkRecord.getDate());
    }

    @Test
    public void drinkRecordHasMealTime() {
        assertEquals(MealTime.AFTERNOON_MEAL, drinkRecord.getMealTime());
    }

    @Test
    public void drinkRecordHasPortion() {
        assertEquals("50ml", drinkRecord.getPortion());
    }

}
