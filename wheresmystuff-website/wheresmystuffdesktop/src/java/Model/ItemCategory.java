package Model;

/**
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
    }
}
