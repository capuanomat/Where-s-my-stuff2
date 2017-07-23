package Model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Alezx on 6/27/2017.
 */

public class LostItem extends Item {

    /**
     *
     * @param name the name of lost item
     * @param description the description of the lost item
     * @param latitude the location of lost item
     * @param longitude the location of lost item
     * @param date the date of the item
     */
    public LostItem(String name, String description, double latitude, double longitude, String date, ItemCategory cat) {
        super(name, description, latitude, longitude, date, Condition.LOST, cat);
    }

    public LostItem(String name, String description, LatLng loc, String date, ItemCategory cat) {
        super(name, description, loc.latitude, loc.longitude, date, Condition.LOST, cat);
    }
}
