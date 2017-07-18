package com.example.matthieujbcapuano.wheresmystuff.Model;

/**
 * Created by Alezx on 6/27/2017.
 */

public class LostItem extends Item {

    /**
     *
     * @param name the name of lost item
     * @param description the description of the lost item
     * @param location the location of lost item
     * @param date the date of the item
     */
    public LostItem(String name, String description, String location, String date, ItemCategory cat) {
        super(name, description, location, date, Condition.LOST, cat);
    }

}
