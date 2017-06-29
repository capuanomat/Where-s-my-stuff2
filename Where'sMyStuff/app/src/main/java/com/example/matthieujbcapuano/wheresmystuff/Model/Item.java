package com.example.matthieujbcapuano.wheresmystuff.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String date;
    //TODO: add category enum
    private String location;
    private String description;
    private String name;
    private String status;
    //TODO: add picture variable

    public Item(String name, String description, String location, String date, String status) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.status = status;
    }

    public Item() {
        this("", "", "", "", "");
    }

    /** Getters **/
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    /** Setters **/
    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        location = in.readString();
        date = in.readString();
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
        dest.writeString(location);
        dest.writeString(date);
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
