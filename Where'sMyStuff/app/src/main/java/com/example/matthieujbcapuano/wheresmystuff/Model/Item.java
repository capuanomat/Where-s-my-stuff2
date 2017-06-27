package com.example.matthieujbcapuano.wheresmystuff.Model;

/**
 * Created by Alezx on 6/27/2017.
 */

public class Item {
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
}
