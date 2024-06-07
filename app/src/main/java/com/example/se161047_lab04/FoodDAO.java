package com.example.se161047_lab04;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FoodDAO {
    public static ArrayList<Food> getAll(Context context) {
        ArrayList<Food> arr = new ArrayList<>();
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = helper.getReadableDatabase();
            cursor = db.rawQuery("SELECT * FROM Food", null);
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String foodName = cursor.getString(1);
                    String foodDes = cursor.getString(2);
                    String image = cursor.getString(3);
                    Food food = new Food(id, foodName, foodDes, image);
                    arr.add(food);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return arr;
    }

//    public static boolean insert(Context context, String foodName, String foodDes, String image) {
//        DBHelper helper = new DBHelper(context);
//        SQLiteDatabase db = helper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("foodName", foodName);
//        values.put("foodDes", foodDes);
//        values.put("image", image);
//        long row = db.insert("Food", null, values);
//        return (row > 0);
//    }

    public static boolean insert(Context context, String foodName, String foodDes, String image) {
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = null;
        long rowId = -1;
        try {
            db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("foodName", foodName);
            values.put("foodDes", foodDes);
            values.put("image", image);
            rowId = db.insert("Food", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return rowId > 0;
    }
}


