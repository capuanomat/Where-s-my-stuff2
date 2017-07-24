package Model;

import java.io.Serializable;

public class Item implements Serializable{
    private String date;
    private ItemCategory cat;
    //private String location;
    /*SMH, Alex and Matt... Why didn't you anticipate Location as something
    that could be placed on a map*/
    private double latitude;
    private double longitude;
    private String description;
    private String name;
    private Condition status;
    //private Image img;

    public Item(String name, String description, double latitude, double longitude, String date, Condition status, ItemCategory cat) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.status = status;
        this.cat = cat;
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

    @Override
    public String toString() {
        return name + " " + description;
    }
}
