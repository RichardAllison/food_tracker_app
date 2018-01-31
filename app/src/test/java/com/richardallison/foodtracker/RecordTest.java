package com.richardallison.foodtracker;

import org.junit.Before;
import org.junit.Test;

//import java.util.Date;
//import java.sql.Time;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class RecordTest {

    Food bread;
    Drink irnBru;
    Record foodRecord;
    Record drinkRecord;
//    Record<Drink> drinkRecord;
//    Record<Drink> drinkRecord;

    @Before
    public void before() {
        bread = new Food("bread", "Allinsons");
        irnBru = new Drink("Irn-Bru", "Barr");
//        foodRecord = new Record<Food>(bread, LocalDate.now(), MealTime.LUNCH, "slice"); //LocalTime.now()
//        drinkRecord = new Record<Drink>(irnBru, LocalDate.now(), MealTime.LUNCH, "50ml"); //LocalTime.now()
    }

//    @Test
//    public void foodRecordHasFood() {
//        assertEquals(bread, foodRecord.getItem());
//        assertEquals("bread", foodRecord.getItem().getName());
//    }

//    @Test
//    public void foodRecordHasDate() {
//        assertEquals(LocalDate.now(), foodRecord.getDate());
//    }

//    @Test
//    public void foodRecordHasMealTime() {
//        assertEquals(MealTime.LUNCH, foodRecord.getMealTime());
//    }

//    @Test
//    public void foodRecordHasPortion() {
//        assertEquals("slice", foodRecord.getPortionSize());
//    }

//    @Test
//    public void drinkRecordHasFood() {
//        assertEquals(irnBru, drinkRecord.getItem());
//        assertEquals("Irn-Bru", drinkRecord.getItem().getName());
//    }

//    @Test
//    public void drinkRecordHasDate() {
//        assertEquals(LocalDate.now(), drinkRecord.getDate());
//    }

//    @Test
//    public void drinkRecordHasMealTime() {
//        assertEquals(MealTime.LUNCH, drinkRecord.getMealTime());
//    }

//    @Test
//    public void drinkRecordHasPortion() {
//        assertEquals("50ml", drinkRecord.getPortionSize());
//    }

}
