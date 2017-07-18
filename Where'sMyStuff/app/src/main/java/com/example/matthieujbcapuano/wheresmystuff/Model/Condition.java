package com.example.matthieujbcapuano.wheresmystuff.Model;

/**
 * Created by simolanayak on 7/17/17.
 */

public enum Condition {
    LOST ("Lost"),
    REUNITED ("Returned to Owner"),

    DONATION("Donation"),

    LIKE_NEW ("Like new"),
    GOOD ("Good"),
    FAIR ("Fair"),
    POOR ("Poor"),
    AWFUL ("Toast"),

    NONE_UNKNOWN ("None/Unknown");

    private String displayString;

    Condition (String displayString) {
        this.displayString = displayString;
    }

    public String toString() {
        return displayString;
    }

    public Condition[] foundArr() {
        return new Condition[]{LIKE_NEW, GOOD, FAIR, POOR, AWFUL};
    }

    public static String[] conditionString() {
        String[] kittystring = new String[Condition.values().length];
        int kitdex = 0;
        for (Condition kit: Condition.values()) {
            kittystring[kitdex] = kit.toString();
            kitdex++;
        }
        return kittystring;
    }

    public static Condition[] condarr() {
        return Condition.values();
    }

}
