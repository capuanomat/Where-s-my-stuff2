package com.example.matthieujbcapuano.wheresmystuff.Model;

<<<<<<< HEAD
import java.util.Date;

=======
import android.location.Location;
>>>>>>> master
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class Item implements Parcelable {
<<<<<<< HEAD
    private Date date;
    private ItemCategory cat; //made us an enum - Simola Nayak
    private Location location;
    private String description;
    private String name;
    private String status;
    private Image image; // added the picture variable- Simola Nayak
=======
    private String date;
    private ItemCategory cat;
    private double latitude;
    private double longitude;
    private String description;
    private String name;
    private Condition status;
    //private Image img;
>>>>>>> master

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
<<<<<<< HEAD
<<<<<<< HEAD
    public Item(String name, String description, Location location, Date date, String status, ItemCategory cat, Image image) {
=======
    public Item(String name, String description, String location, String date, Condition status, ItemCategory cat) {
>>>>>>> master
=======
    public Item(String name, String description, LatLng location, String date, Condition status, ItemCategory cat) {
>>>>>>> master
        this.name = name;
        this.description = description;
        this.latitude = location.latitude;
        this.longitude = location.longitude;
        this.date = date;
        this.status = status;
        this.cat = cat;
<<<<<<< HEAD
        this.image = image;
=======
        //this.img = img;
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
        this("", "", null, null, "", ItemCategory.NONE, null);
=======
        this("", "", "", "", Condition.NONE_UNKNOWN, ItemCategory.OTHER_NONE);
>>>>>>> master
=======
        this("", "", defaultLoc, "", Condition.NONE_UNKNOWN, ItemCategory.OTHER_NONE);
>>>>>>> master
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
<<<<<<< HEAD
    public Location getLocation() {
        return location;
=======
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
>>>>>>> master
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
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @param location the location to set to
     */
<<<<<<< HEAD
    public void setLocation(Location location) {
        this.location = location;
=======
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
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
        //location =  ;
        //date = ;
        status = in.readString();
=======
        location = in.readString();
=======
        latitude = in.readDouble();
        longitude = in.readDouble();
>>>>>>> master
        date = in.readString();
        status = Condition.valueOf(in.readString());
        cat = ItemCategory.valueOf(in.readString());
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
        //location
        //date
        dest.writeString(status);
=======
        dest.writeString(location);
=======
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
>>>>>>> master
        dest.writeString(date);
        dest.writeValue(status);
        dest.writeValue(cat);
>>>>>>> master
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
