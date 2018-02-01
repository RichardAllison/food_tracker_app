package com.richardallison.foodtracker;

import com.richardallison.foodtracker.models.Food;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodTest {

    Food bread;

    @Before
    public void before() {
        bread = new Food("bread", "Allinsons");
    }

    @Test
    public void hasName() {
        assertEquals("bread", bread.getName());
    }

    @Test
    public void hasBrand() {
        assertEquals("Allinsons", bread.getBrand());
    }
}
