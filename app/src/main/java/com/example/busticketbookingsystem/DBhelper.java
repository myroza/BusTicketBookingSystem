package com.example.busticketbookingsystem;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DBNAME="login.db";
    public DBhelper(@Nullable Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table register(username TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists register");
    }

    public boolean insertData(String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        //contentValues.put("Repassword",Repassword);

        long result= db.insert("register",null,contentValues);

        if(result==-1){
            return  false;
        }
        else{
            return true;
        }
    }
    public boolean chackusername(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor =db.rawQuery("select *from register where username=?",new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean chacknamePassword(String username,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor =db.rawQuery("select *from register where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
