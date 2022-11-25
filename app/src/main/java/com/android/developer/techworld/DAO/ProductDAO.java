package com.android.developer.techworld.DAO;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.developer.techworld.database.DbHelper;
import com.android.developer.techworld.model.Product;

import java.util.ArrayList;

public class ProductDAO {
    private DbHelper dbHelper;
    public ProductDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    // #PRODUCTs     ID - BANNER - NAME - CONFIG - DESCRIPTION - PRICE - CATEGORY_ID (CATEGORies)

    //get
    public ArrayList<Product> getDatabase_Computer(){
        ArrayList<Product> list = new ArrayList<>();

        //Readable
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM PRODUCTs WHERE CATEGORY_ID = 1",null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){

                list.add(new Product
                        (
                                cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getInt(5),
                                cursor.getInt(6)
                        ));

            }
        }

        cursor.close();

        return list;
    }

    public ArrayList<Product> getDatabase_Phone(){
        ArrayList<Product> list = new ArrayList<>();

        //Readable
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM PRODUCTs WHERE CATEGORY_ID = 2",null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){

                list.add(new Product
                        (
                                cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getInt(5),
                                cursor.getInt(6)
                        ));

            }
        }

        cursor.close();

        return list;
    }

    public ArrayList<Product> getDatabase_Other(){
        ArrayList<Product> list = new ArrayList<>();

        //Readable
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM PRODUCTs WHERE CATEGORY_ID = 3",null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){

                list.add(new Product
                        (
                                cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getInt(5),
                                cursor.getInt(6)
                        ));

            }
        }

        cursor.close();

        return list;
    }

    //insert
    public boolean insertDatabase(Product product){
        //Writable
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("BANNER",product.getIMG_banner());
        contentValues.put("NAME",product.getName());
        contentValues.put("CONFIG",product.getConfig());
        contentValues.put("DESCRIPTION",product.getDescription());
        contentValues.put("PRICE",product.getPrice());
        contentValues.put("CATEGORY_ID",product.getCategory_id());

        long newRowID = database.insert("PRODUCTs",null,contentValues);

        if(newRowID == -1){
            return false;
        }
        return true;
    }


}
