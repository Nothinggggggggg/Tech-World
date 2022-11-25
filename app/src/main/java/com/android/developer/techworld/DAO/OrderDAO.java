package com.android.developer.techworld.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.developer.techworld.database.DbHelper;
import com.android.developer.techworld.model.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OrderDAO {
    private DbHelper dbHelper;
    public OrderDAO(Context context) {
        this.dbHelper = new DbHelper(context);
    }

    // #ORDERs       ID - QUANTITY - DATE_ORDER - DATE_RECEIPT - STATUS - TOTAL - ACCOUNT_ID (ACCOUNTs) - PRODUCT_ID (PRODUCTs)
    // #ACCOUNTs     ID - PASSWORD - ROLE - NAME - PHONE - ADDRESS
    // #PRODUCTs     ID - BANNER - NAME - CONFIG - DESCRIPTION - PRICE - CATEGORY_ID (CATEGORies)


    //get
    public ArrayList<Order> getDatabase(){
        ArrayList<Order> list = new ArrayList<>();

        //Readable
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(
                "SELECT O.ID, O.QUANTITY, O.DATE_ORDER, O.DATE_RECEIPT, O.STATUS, O.TOTAL," +
                        " ACC.ID,ACC.PASSWORD,ACC.ROLE,ACC.NAME,ACC.PHONE,ACC.ADDRESS," +
                        "P.ID,P.BANNER,P.NAME,P.CONFIG,P.DESCRIPTION,P.PRICE,P.CATEGORY_ID " +
                        " FROM ORDERs O ,ACCOUNTs ACC, PRODUCTs P " +
                        " WHERE O.ACCOUNT_ID = ACC.ID AND O.PRODUCT_ID = P.ID" +
                        " ORDER BY O.ID DESC",
                null);

        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){

                list.add(new Order
                        (
                                cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getInt(4),
                                cursor.getInt(5),

                                cursor.getString(6),
                                cursor.getString(7),
                                cursor.getString(8),
                                cursor.getString(9),
                                cursor.getString(10),
                                cursor.getString(11),

                                cursor.getInt(12),
                                cursor.getInt(13),
                                cursor.getString(14),
                                cursor.getString(15),
                                cursor.getString(16),
                                cursor.getInt(17),
                                cursor.getInt(18)
                        ));

            }
        }

        cursor.close();

        return list;
    }

    //get - Customer
    public ArrayList<Order> getDatabase_Customer(String id){
        ArrayList<Order> list = new ArrayList<>();

        //Readable
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(
                "SELECT O.ID, O.QUANTITY, O.DATE_ORDER, O.DATE_RECEIPT, O.STATUS, O.TOTAL," +
                        " ACC.ID,ACC.PASSWORD,ACC.ROLE,ACC.NAME,ACC.PHONE,ACC.ADDRESS," +
                        "P.ID,P.BANNER,P.NAME,P.CONFIG,P.DESCRIPTION,P.PRICE,P.CATEGORY_ID " +
                        " FROM ORDERs O ,ACCOUNTs ACC, PRODUCTs P " +
                        " WHERE O.ACCOUNT_ID = ACC.ID AND O.PRODUCT_ID = P.ID" +
                        " AND ACC.ID = ?" +
                        " ORDER BY O.ID DESC",
                new String[]{id});

        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){

                list.add(new Order
                        (
                                cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getInt(4),
                                cursor.getInt(5),

                                cursor.getString(6),
                                cursor.getString(7),
                                cursor.getString(8),
                                cursor.getString(9),
                                cursor.getString(10),
                                cursor.getString(11),

                                cursor.getInt(12),
                                cursor.getInt(13),
                                cursor.getString(14),
                                cursor.getString(15),
                                cursor.getString(16),
                                cursor.getInt(17),
                                cursor.getInt(18)
                        ));

            }
        }

        cursor.close();

        return list;
    }

    // #ORDERs       ID - QUANTITY - DATE_ORDER - DATE_RECEIPT - STATUS - TOTAL - ACCOUNT_ID (ACCOUNTs) - PRODUCT_ID (PRODUCTs)


    //insert
    public boolean insertDatabase(int quantity,int total,String account_id,int product_id){
        //Writable
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("QUANTITY",quantity);
        contentValues.put("TOTAL",total);
        contentValues.put("ACCOUNT_ID",account_id);
        contentValues.put("PRODUCT_ID",product_id);

        long newRowID = database.insert("ORDERs",null,contentValues);

        if(newRowID == -1){
            return false;
        }
        return true;
    }

    //update -> Customer order
    //      date_order == present
    //      status == 1 (dang giao hang)
    public boolean updateDatabase(int id){
        //Writable
        SQLiteDatabase database = dbHelper.getWritableDatabase();


        Calendar calendar  = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String date_order = simpleDateFormat.format(calendar.getTime());

        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE_ORDER", date_order);
        contentValues.put("STATUS",1);

        long updateRows = database.update("ORDERs",contentValues,"ID = ?",new String[]{String.valueOf(id)});

        if(updateRows == -1){
            return false;
        }
        return true;
    }

}
