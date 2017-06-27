package com.example.matthieujbcapuano.wheresmystuff.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alezx on 6/27/2017.
 */

public class LostItemManager {
    //ALEXANDER: designed after M3 model class which uses singelton instance
    private static final LostItemManager _instance = new LostItemManager();
    public static LostItemManager getInstance() { return _instance; }

    //ALEXANDER: holds list of all lost items
    private List<LostItem> lostItemlist;

    //ALEXANDER: currently selected lost item, default is first item
    private LostItem currenLostItem;

    //ALEXANDER: null item returned when no item is found
    private final LostItem theNullItem = new LostItem("No name","No description","No Location", "No date");

    public LostItemManager() {
        lostItemlist = new ArrayList<>();
    }

    public boolean addLostItem(LostItem lostItem) {
        //ALEXANDER: doesn't add if duplicate item, haven't overriden equals method in LostItem class
        //so it won't work yet
        for (LostItem item: lostItemlist) {
            if (item.equals(lostItem)) {
                return false;
            }
        }
        lostItemlist.add(lostItem);
        return true;
    }

    public LostItem getCurrentLostItem() {
        return currenLostItem;
    }

    public void setCurrentLostItem(LostItem lostItem) {
        currenLostItem = lostItem;
    }

    //ALEXANDER: example of searching for item in list by attribute from M3, can be implemented via
    //other methods for all attributes
    public LostItem getLostItemByName(String name) {
        for (LostItem item: lostItemlist) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return theNullItem;
    }
}
