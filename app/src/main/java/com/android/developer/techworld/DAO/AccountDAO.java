package com.android.developer.techworld.DAO;

import static android.content.Context.MODE_PRIVATE;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.developer.techworld.MainActivity;
import com.android.developer.techworld.database.DbHelper;

public class AccountDAO {
    private DbHelper dbHelper;
    SharedPreferences sharedPreferences;
    public AccountDAO(Context context){
        dbHelper = new DbHelper(context);
        sharedPreferences = context.getSharedPreferences(MainActivity.PREFS_FILE,MODE_PRIVATE);

    }

    // #ACCOUNTs     ID - PASSWORD - ROLE - NAME - PHONE - ADDRESS

    //query
    public boolean queryDatabase_Login(String id,String password){
        //Readable
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ACCOUNTs WHERE ID = ? AND PASSWORD = ?",new String[]{id,password} );
        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            //...lưu sharedpreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("ID", cursor.getString(0));
            editor.putString("PASSWORD",cursor.getString(1));
            editor.putBoolean("ROLE", (cursor.getInt(2) > 0) );
            editor.putString("NAME",cursor.getString(3));
            editor.putString("PHONE",cursor.getString(4));
            editor.putString("ADDRESS",cursor.getString(5));
            editor.apply();

            return true;
        }else{
            return false;
        }
    }

    //update
    public boolean updateDatabase(String id,String name,String phone,String address){
        //Writable
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("PHONE",phone);
        contentValues.put("ADDRESS",address);

        long updateRows = sqLiteDatabase.update("ACCOUNTs",contentValues,"ID = ?",new String[]{id});

        if(updateRows == -1){
            return false;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME",name);
        editor.putString("PHONE",phone);
        editor.putString("ADDRESS",address);
        editor.apply();

        return true;
    }
}
