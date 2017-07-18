package com.example.matthieujbcapuano.wheresmystuff.Model;

/**
 * Created by Alezx on 6/27/2017.
 */

public class FoundItem extends Item{

    /**
     *
     * @param name the name of found item
     * @param description the description of the found item
     * @param location the location of the found item
     * @param date the date of the found item
     */
    public FoundItem(String name, String description, String location, String date, Condition status, ItemCategory cat) {
        super(name, description, location, date, status, cat);
    }
}
