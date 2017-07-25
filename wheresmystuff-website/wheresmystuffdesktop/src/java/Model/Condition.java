package Model;

/**
 * Created by Simola Nayak on 7/17/17.
 */
/**
 * Due to some poor design decisions and a couple of design differences, this
 * package requires refactoring
 */
public enum Condition {
    LOST("Lost"),
    REUNITED("Returned to Owner"),
    DONATION("Donation"),
    LIKE_NEW("Like new"),
    GOOD("Good"),
    FAIR("Fair"),
    POOR("Poor"),
    AWFUL("In Shambles"),
    NONE_UNKNOWN("None/Unknown");

    private final String displayString;

    Condition(String displayString) {
        this.displayString = displayString;
    }

    @Override
    public String toString() {
        return displayString;
    }

    public Condition[] foundArr() {
        return new Condition[]{LIKE_NEW, GOOD, FAIR, POOR, AWFUL};
    }

    public Condition[] lostArr() {
        return new Condition[]{LOST, REUNITED};
    }

    public static String[] conditionString() {
        String[] kittystring = new String[Condition.values().length];
        int kitdex = 0;
        for (Condition kit : Condition.values()) {
            kittystring[kitdex] = kit.toString();
            kitdex++;
        }
        return kittystring;
    }

    public static Condition[] condarr() {
        return Condition.values();
    }
}
