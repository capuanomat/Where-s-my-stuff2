package com.example.matthieujbcapuano.wheresmystuff.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.matthieujbcapuano.wheresmystuff.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class LostItemsDB extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "lost.db";

    public static final String TABLE_NAME = "lost_table";
    public static final String COL_1 = "IDL";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "LOCATION";
    public static final String COL_5 = "DATE";

    public LostItemsDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (IDL INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, LOCATION TEXT, DATE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addLostItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, item.getName());
        contentValues.put(COL_3, item.getName());
        contentValues.put(COL_4, item.getDescription());
        contentValues.put(COL_5, item.getDate());

        long result = db.insert(TABLE_NAME, null, contentValues);
        return (result != -1);
    }

    public List<Item> getLostItems() {
        List<Item> items = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
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
}
