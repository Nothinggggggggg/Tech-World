package com.android.developer.techworld.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "Tech World", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // #ACCOUNTs     ID - PASSWORD - ROLE - NAME - PHONE - ADDRESS
        // #ID == USERNAME
        // #ROLE
        //      1 - ADMIN
        //      0 - USER
        String tableAccount = "CREATE TABLE ACCOUNTs" +
                "(" +
                "ID TEXT PRIMARY KEY," +
                "PASSWORD TEXT," +
                "ROLE INTEGER DEFAULT 0," +
                "NAME TEXT," +
                "PHONE TEXT," +
                "ADDRESS TEXT" +
                ")";
        db.execSQL(tableAccount);

        // #CATEGORies    ID - NAME
        //                  1 - COMPUTER
        //                  2 - PHONE
        //                  3 - OTHER
        String tableCategory = "CREATE TABLE CATEGORies" +
                "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT" +
                ")";
        db.execSQL(tableCategory);

        // #PRODUCTs     ID - BANNER - NAME - CONFIG - DESCRIPTION - PRICE - CATEGORY_ID (CATEGORies)
        String tableProduct = "CREATE TABLE PRODUCTs" +
                "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BANNER INTEGER," +
                "NAME TEXT," +
                "CONFIG TEXT," +
                "DESCRIPTION TEXT," +
                "PRICE INTEGER," +

                "CATEGORY_ID INTEGER," +

                "FOREIGN KEY (CATEGORY_ID) REFERENCES ID(CATEGORies)" +
                ")";
        db.execSQL(tableProduct);

        // #ORDERs       ID - QUANTITY - DATE_ORDER - DATE_RECEIPT - STATUS - TOTAL - ACCOUNT_ID (ACCOUNTs) - PRODUCT_ID (PRODUCTs)
        //      -1 - CHƯA ĐẶT HÀNG
        //      1 - CHỜ XỬ LÝ
        //      10 - ĐANG GIAO HÀNG
        //      100 - GIAO HÀNG THÀNH CÔNG
        //      0 - GIAO HÀNG THẤT BẠI
        String tableOrder = "CREATE TABLE ORDERs" +
                "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "QUANTITY INTEGER," +
                "DATE_ORDER TEXT," +
                "DATE_RECEIPT," +
                "STATUS INTEGER DEFAULT (-1)," +
                "TOTAL INTEGER," +

                "ACCOUNT_ID TEXT," +
                "PRODUCT_ID INTEGER," +

                "FOREIGN KEY (ACCOUNT_ID) REFERENCES ID(ACCOUNTs)," +
                "FOREIGN KEY (PRODUCT_ID) REFERENCES ID(PRODUCTs)" +
                ")";
        db.execSQL(tableOrder);

        // #Data
        db.execSQL("INSERT INTO ACCOUNTs (ID, PASSWORD, ROLE, NAME) VALUES ('user','',0,'User'),('admin','group3',1,'Admin')");
        db.execSQL("INSERT INTO CATEGORies VALUES (1,'Computer'),(2,'Smart phone'),(3,'Other')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ORDERs");
        db.execSQL("DROP TABLE IF EXISTS PRODUCTs");
        db.execSQL("DROP TABLE IF EXISTS DELIVERies");
        db.execSQL("DROP TABLE IF EXISTS CATEGORies");
        db.execSQL("DROP TABLE IF EXISTS ACCOUNTs");
        onCreate(db);
    }
}
