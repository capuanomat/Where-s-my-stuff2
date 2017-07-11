package com.example.matthieujbcapuano.wheresmystuff.Model;

import java.util.Date;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.location.Location;

public class Item implements Parcelable {
    private Date date;
    private ItemCategory cat; //made us an enum - Simola Nayak
    private Location location;
    private String description;
    private String name;
    private String status;
    private Image image; // added the picture variable- Simola Nayak

    /**
     *
     * @param name the name of the item
     * @param description the description of the item
     * @param location the location of the item
     * @param date the date of the item
     * @param status the status of the item
     * @param cat the category of the item
     */
    public Item(String name, String description, Location location, Date date, String status, ItemCategory cat, Image image) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.status = status;
        this.cat = cat;
        this.image = image;
    }

    /**
     * empty constructor
     */
    public Item() {
        this("", "", null, null, "", ItemCategory.NONE, null);
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
     * @return picture of item
     */
    public Image getImage() {
        return image;
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
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @return date of item
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @return status of item
     */
    public String getStatus() {
        return status;
    }

    /** Setters **/
    /**
     *
     * @param date the date to set to
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @param location the location to set to
     */
    public void setLocation(Location location) {
        this.location = location;
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
    public void setStatus(String status) {
        this.status = status;
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
        //location = in.readParcelable;
        //date = in.readString();
        status = in.readString();
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
        dest.writeParcelable(location, 0);
        dest.writeParcelable(date, 0);
        dest.writeString(status);
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
