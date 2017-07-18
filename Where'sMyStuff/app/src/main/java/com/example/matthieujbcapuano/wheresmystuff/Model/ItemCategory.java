package com.example.matthieujbcapuano.wheresmystuff.Model;

/**
<<<<<<< HEAD
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
=======
 * Created by simolanayak on 7/17/17.
 */

//An enum for the item categories:
public enum ItemCategory {
    SMALL_GENERIC ("Small Item, Any Kind"),
    MED_GENERIC ("Medium Item, Any Kind"),
    LARGE_GENERIC ("Large Item, Any Kind"),
    OVERSIZE ("Oversize Item, Any Kind"),

    LIVE_ANIMAL ("Live Animal"),
    MISSING_PERSON ("Missing Person"),
    PAPER_GOODS ("Books/Paper-Based Item"),
    MEDICAL_FIRST_AID ("Medical/First Aid"),
    ELECTRONIC_SMALL ("Personal Electronics"),
    ELECTRONIC_LARGE ("Appliances"),
    VALUABLES ("Valuables/Jewelry"),
    CLOTHING ("Clothing/Textiles"),
    FURNITURE ("Furniture"),
    RECREATION_GAMES ("Recreational Items/Games"),

    OTHER_NONE ("Other/None");

    private String displayString;

    ItemCategory (String displayString) {
        this.displayString = displayString;
    }

    public String toString() {
        return displayString;
    }

    public static String[] catString() {
        String[] kittystring = new String[ItemCategory.values().length];
        int kitdex = 0;
        for (ItemCategory kit: ItemCategory.values()) {
            kittystring[kitdex] = kit.toString();
            kitdex++;
        }
        return kittystring;
    }

    public static ItemCategory[] catarr() {
        return ItemCategory.values();
>>>>>>> master
    }
}
