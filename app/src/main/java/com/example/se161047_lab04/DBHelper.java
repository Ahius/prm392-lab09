package com.example.se161047_lab04;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Lab09SE161047", null, 1); //Tạo DB
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table Food(id integer primary key autoincrement," +
                "foodName text, foodDes text, image text)";
        db.execSQL(sql);
        sql = "Insert Into Food Values (null, 'Banh Mi', 'Banh Mi Sai Gon', 'https://bvnguyentriphuong.com.vn/uploads/092023/images/banh-mi.jpg')";
        db.execSQL(sql);
        sql = "Insert Into Food Values (null, 'Pho Bo', 'Pho Bo Ngon', 'https://cdn.tgdd.vn/Files/2022/01/25/1412805/cach-nau-pho-bo-nam-dinh-chuan-vi-thom-ngon-nhu-hang-quan-202201250313281452.jpg')";
        db.execSQL(sql);
        sql = "Insert Into Food Values (null, 'Com Tam', 'Com Tam Binh Duong', 'https://tiki.vn/blog/wp-content/uploads/2023/07/com-tam.jpeg')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if exists Food");
        onCreate(db);
    }
}
