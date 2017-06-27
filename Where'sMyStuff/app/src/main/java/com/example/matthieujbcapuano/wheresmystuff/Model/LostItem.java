package com.example.matthieujbcapuano.wheresmystuff.Model;

/**
 * Created by Alezx on 6/27/2017.
 */

public class LostItem extends Item {

    public LostItem(String name, String description, String location, String date) {
        super(name, description, location, date, "LOST");
    }
}
