package com.example.matthieujbcapuano.wheresmystuff.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.matthieujbcapuano.wheresmystuff.Model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user.db";

    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "USERNAME";
    public static final String COL_4 = "PASSWORD";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, USERNAME TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addAccount(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, user.getName());
        contentValues.put(COL_3, user.getUserName());
        contentValues.put(COL_4, user.getPassword());

        long result = db.insert(TABLE_NAME, null, contentValues);
        return (result != -1);
    }

    public List<User> getAccounts() {
        List<User> users = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            do {
                User us = new User();
                //us.setName(res.getString(res.getColumnIndex("NAME")));
                us.setUserName(res.getString(res.getColumnIndex("USERNAME")));
                us.setPassword(res.getString(res.getColumnIndex("PASSWORD")));
                users.add(us);
            } while (res.moveToNext());
        }
        return users;
    }
}
