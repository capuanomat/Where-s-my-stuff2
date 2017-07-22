package com.example.matthieujbcapuano.wheresmystuff.Model;

<<<<<<< HEAD
import android.location.Location;
import android.media.Image;

import java.util.Date;
=======
import com.google.android.gms.maps.model.LatLng;
>>>>>>> master

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
<<<<<<< HEAD
<<<<<<< HEAD
    public FoundItem(String name, String description, Location location, Date date, ItemCategory cat, Image img) {
        super(name, description, location, date, "FOUND", cat, img);
=======
    public FoundItem(String name, String description, String location, String date, Condition status, ItemCategory cat) {
        super(name, description, location, date, status, cat);
>>>>>>> master
=======
    public FoundItem(String name, String description, double latitude, double longitude, String date, Condition status, ItemCategory cat) {
        super(name, description, latitude, longitude, date, status, cat);
    }

    public FoundItem(String name, String description, LatLng loc, String date, Condition status, ItemCategory cat) {
        super(name, description, loc.latitude, loc.longitude, date, status, cat);
>>>>>>> master
    }
}
