package com.example.matthieujbcapuano.wheresmystuff.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.matthieujbcapuano.wheresmystuff.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsDB extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "items.db";

    public static final String LOST_TABLE_NAME = "lost_table";
    public static final String FOUND_TABLE_NAME = "found_table";
    public static final String COL_1 = "IDL";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "LOCATION";
    public static final String COL_5 = "DATE";

    public ItemsDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + LOST_TABLE_NAME + " (IDL INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, LOCATION TEXT, DATE TEXT)");
        db.execSQL("CREATE TABLE " + FOUND_TABLE_NAME + " (IDL INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, LOCATION TEXT, DATE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LOST_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + FOUND_TABLE_NAME);
        onCreate(db);
    }

    public boolean addLostItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, item.getName());
        contentValues.put(COL_3, item.getDescription());
        contentValues.put(COL_4, item.getLatitude()+" ,"+item.getLongitude());
        contentValues.put(COL_5, item.getDate());

        long result = db.insert(LOST_TABLE_NAME, null, contentValues);
        return (result != -1);
    }

    public List<Item> getLostItems() {
        List<Item> items = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + LOST_TABLE_NAME, null);
        if (res.moveToFirst()) {
            do {
                Item it = new Item();

                it.setName(res.getString(res.getColumnIndex("NAME")));
                it.setName(res.getString(res.getColumnIndex("DESCRIPTION")));
                it.setName(res.getString(res.getColumnIndex("LOCATION")));
                it.setName(res.getString(res.getColumnIndex("DATE")));
                items.add(it);
            } while (res.moveToNext());
        }
        return items;
    }

    public Integer deleteLostItem(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(LOST_TABLE_NAME, "IDL = ?", new String[]{id});
    }

    /**
     *  METHOD CONTRACT (by Matthieu Capuano):
     *  Signature: public boolean addFoundItem(Item item)
     *  Preconditions: True
     *  Postconditions: After adding an item, original data should still be there and unchanged,
     *                  there should be an extra row in the found items table, the added item should
     *                  be the latest row
     * Invariants: Number of items in database is always >=0
     * Framing Conditions: Size of database is increased by 1, database has an extra row, original
     *                     elements are unchanged
     *
     * This method essentially just adds an item to the found Item table in the Items database. The
     * Item may have
     *
     * @param item  The item to be added
     * @return      Whether the item was added correctly or not
     */
    public boolean addFoundItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, item.getName());
        contentValues.put(COL_3, item.getDescription());
        contentValues.put(COL_4, item.getLatitude()+" ,"+item.getLongitude());
        contentValues.put(COL_5, item.getDate());

        long result = db.insert(FOUND_TABLE_NAME, null, contentValues);
        return (result != -1);
    }

    /**
     * The method returns an array list of all the found items in the database
     * @return  A list of all the items in the database
     */
    public List<Item> getFoundItems() {
        List<Item> items = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + FOUND_TABLE_NAME, null);
        if (res.moveToFirst()) {
            do {
                Item it = new Item();

                it.setName(res.getString(res.getColumnIndex("NAME")));
                it.setDescription(res.getString(res.getColumnIndex("DESCRIPTION")));
                String latlongstring = res.getString(res.getColumnIndex("LOCATION"));

                double latitude = Double.parseDouble(latlongstring);
                latlongstring.replace(latitude+", ", "");
                double longitude = Double.parseDouble(latlongstring);
                it.setLatitude(latitude);
                it.setLongitude(longitude);

                it.setDate(res.getString(res.getColumnIndex("DATE")));
                //it.setStatus(res.getString(res.getColumnIndex("STATUS")));
                items.add(it);
            } while (res.moveToNext());
        }
        return items;
    }

    /**
     * Deletes an item from the found item table in the Items database.
     * @param id    The id of the item to be removed
     * @return      An integer that describes whether or not the item was removed
     */
    public Integer deleteFoundItem(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(FOUND_TABLE_NAME, "IDL = ?", new String[]{id});
    }

    /**
     * Deletes all the items in the database.
     */
    public void deleteAllFound() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(FOUND_TABLE_NAME, null, null);
    }
}
