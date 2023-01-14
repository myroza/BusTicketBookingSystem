package com.example.busticketbookingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(@Nullable Context context) {
        super(context, "Userinfo1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetail2(name2 TEXT primary key, source2 TEXT, destination2 TEXT,start2 TEXT,Arrive2 TEXT,Fare2 TEXT,Date2 TEXT,duration2 TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetail2");

    }

    public Boolean insertuserdata2(String name, String source, String destination, String start, String Arrive, String Fare, String Date, String duration)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name2", name);
            contentValues.put("source2", source);
            contentValues.put("destination2", destination);
            contentValues.put("start2", start);
            contentValues.put("Arrive2", Arrive);
            contentValues.put("Date2", Date);
            contentValues.put("Fare2", Fare);
            contentValues.put("duration2", duration);
            long result = DB.insert("Userdetail2", null, contentValues);
            if (result == 1)
            {
                return false;
            } else
            {
                return true;
            }
        }

        public Cursor getdata2() {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from Userdetail2", null);
            return cursor;
        }

        public Boolean deleteuserdata2(String name) {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from Userdetail2 where name2 = ?", new String[]{name});
            if (cursor.getCount() > 0)
            {
                long result = DB.delete("Userdetail2", "name2=?", new String[]{name});
                if (result == -1)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return false;
            }

        }
}

