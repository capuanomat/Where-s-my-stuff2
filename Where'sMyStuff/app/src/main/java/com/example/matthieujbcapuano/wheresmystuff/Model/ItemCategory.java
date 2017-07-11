package com.example.matthieujbcapuano.wheresmystuff.Model;

/**
 * Created by simolanayak on 7/11/17.
 */

public enum ItemCategory {

    GENERIC_SMALL_ITEM ("Small item"),
    GENERIC_MEDIUM_ITEM ("Medium item"),
    GENERIC_LARGE_ITEM ("Large item"),
    GENERIC_OVERSIZE ("Oversize item"),

    NONE ("Undefined"), //as a default

    ANIMAL ("Pets/Animals"),
    PERSON ("Missing Person"),
    VALUABLES ("Jewelry/Valuables"),
    MEDIA ("Book/Album/CD/Media"),
    ELECTRONICS ("Electronic Device"),
    ID_CREDIT_CARDS ("ID/Credit Card"),
    CLOTHING ("Clothing"),
    APPLIANCE ("Appliance"),
    INSTRUMENT ("Musical Instrument");

    private String itemType;

    ItemCategory(String itemType) {
        this.itemType = itemType;
    }

    public String toString() {
        return itemType;
    }
}
