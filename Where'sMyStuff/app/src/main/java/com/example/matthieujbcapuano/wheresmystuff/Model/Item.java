package com.example.matthieujbcapuano.wheresmystuff.Model;

import android.location.Location;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class Item implements Parcelable {
    private String date;
    private ItemCategory cat;
    private double latitude;
    private double longitude;
    private String description;
    private String name;
    private Condition status;
    //private Image img;

    private static LatLng defaultLoc = new LatLng(0.00000, 0.000000);
    /**
     *
     * @param name the name of the item
     * @param description the description of the item
     * @param location the location of the item
     * @param date the date of the item
     * @param status the status of the item
     * @param cat the category of the item
     */
    public Item(String name, String description, LatLng location, String date, Condition status, ItemCategory cat) {
        this.name = name;
        this.description = description;
        this.latitude = location.latitude;
        this.longitude = location.longitude;
        this.date = date;
        this.status = status;
        this.cat = cat;
        //this.img = img;
    }

    public Item(String name, String description, double latitude, double longitude, String date, Condition status, ItemCategory cat) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.status = status;
        this.cat = cat;
    }

    /**
     *
     * @param name          The name of the item
     * @param description   The description of the item
     * @param location      The location of the item
     */
    public Item(String name, String description, LatLng location) {
        this(name, description, location, "", Condition.NONE_UNKNOWN, ItemCategory.OTHER_NONE);
    }

    /**
     * empty constructor
     */
    public Item() {
        this("", "", defaultLoc, "", Condition.NONE_UNKNOWN, ItemCategory.OTHER_NONE);
    }

    /** Getters **/
    /**
     *
     * @return name of item
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return description of item
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return location of item
     */
    public LatLng getLocation() {
        return new LatLng(latitude, longitude);
    }

    /**
     *
     * @return location of item as a string
     */
    public String getLocString() {
        return (latitude + "," + longitude);
    }

    /**
     *
     * @return latitude of item
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     *
     * @return longitude of item
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     *
     * @return date of item
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @return status of item
     */
    public Condition getStatus() {
        return status;
    }

    /**
     *
     * @return category of the item
     */
    public ItemCategory getCategory() {
        return cat;
    }

    public String getStatusString() {return status.toString();}

    /** Setters **/
    /**
     *
     * @param date the date to set to
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @param location the location to set to
     */
    public void setLocation(LatLng location) {
        setLatitude(location.latitude);
        setLongitude(location.longitude);
    }

    /**
     *
     * @param latitude the latitude to set to
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    /**
     *
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @param description the description to set to
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param name the name to set to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param status the status to set to
     */
    public void setStatus(Condition status) {
        this.status = status;
    }

    /**
     *
     * @param cat the category of the item
     */
    public void setCategory(ItemCategory cat) {
        this.cat = cat;
    }

    public static Creator<Item> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return name + " " + description;
    }

    /**********************************************************************************************
     * ALEXANDER: Borrowed from M3, These methods are required by the parcelable interface
     *
     */
    private Item(Parcel in) {
        name = in.readString();
        description = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        date = in.readString();
        status = Condition.valueOf(in.readString());
        cat = ItemCategory.valueOf(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /* *************************
       If you add new instance vars to Student, you will need to add them to the write
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeString(date);
        dest.writeValue(status);
        dest.writeValue(cat);
    }

    public static final Parcelable.Creator<Item> CREATOR
            = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
