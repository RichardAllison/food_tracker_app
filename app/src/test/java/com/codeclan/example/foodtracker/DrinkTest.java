package com.codeclan.example.foodtracker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    Drink irnBru;

    @Before
    public void before() {
        irnBru = new Drink("Irn-Bru", "Barr");
    }

    @Test
    public void hasName() {
        assertEquals("Irn-Bru", irnBru.getName());
    }

    @Test
    public void hasBrand() {
        assertEquals("Barr", irnBru.getBrand());
    }
}
