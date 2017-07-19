package com.example.matthieujbcapuano.wheresmystuff.Model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Alezx on 6/27/2017.
 */

public class FoundItem extends Item{

    /**
     *
     * @param name the name of found item
     * @param description the description of the found item
     * @param latitude the location of the found item
     * @param longitude the location of the found item
     * @param date the date of the found item
     */
    public FoundItem(String name, String description, double latitude, double longitude, String date, Condition status, ItemCategory cat) {
        super(name, description, latitude, longitude, date, status, cat);
    }

    public FoundItem(String name, String description, LatLng loc, String date, Condition status, ItemCategory cat) {
        super(name, description, loc.latitude, loc.longitude, date, status, cat);
    }
}
