package com.example.matthieujbcapuano.wheresmystuff.Model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matthieu J.B Capuano on 7/17/2017.
 */
public class ItemTest {
    @Test
    public void getDescription() throws Exception {
        String description1 = "This is the first description";

        Item item = new Item();
        item.setDate(description1);

        assertEquals(description1, item.getDate());
    }

    @Test
    public void setDescription() throws Exception {
        String description1 = "This is the first description";

        Item item = new Item();
        item.setDescription(description1);

        assertEquals(description1, item.getDescription());
    }

}