package com.example.jobup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBhelper extends SQLiteOpenHelper {
    Cursor cursor = null;
    public DBhelper( Context context) {
        super(context, "AppDB.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table user (Id INTEGER PRIMARY KEY ,FullName varchar(255),Email varchar(255),Password varchar(255))");
        db.execSQL("create table offer (Id INTEGER PRIMARY KEY ,title varchar(500),email varchar(255),phone varchar(50),description varchar(1000) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public Boolean InsertOffer(String title,String email,String phone,String description ){

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",title);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("description",description);
        long res=DB.insert("offer",null,contentValues);
        if(res==-1) {
            return false;}

        else {return true;}

    }

    public Boolean InsertAdmin(String email,String Password){

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("fullname","");
        contentValues.put("email",email);
        contentValues.put("Password",Password);
        long res=DB.insert("user",null,contentValues);
        if(res==-1) {
            return false;}

        else {return true;}

    }




    public Boolean InsertUser(String fullname,String email,String Password){

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("fullname",fullname);
        contentValues.put("email",email);
        contentValues.put("Password",Password);
        long res=DB.insert("user",null,contentValues);
        if(res==-1) {
            return false;}

        else {return true;}

    }

    public Boolean CheckUserExistence(String email) {

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select Email from user where Email=?",new String[] {email});
        if(cursor.getCount()>0){
            return true;
        }
        else return false;

    }

    public Boolean CheckPassword(String email, String password) {

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select Email,Password from user where Email=? and Password=?",new String[] {email,password});
        if(cursor.getCount()>0){
            return true;
        }
        else return false;

    }
    public Cursor getdata(){
        String query = "select Id,title,email,phone from offer";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }








}
