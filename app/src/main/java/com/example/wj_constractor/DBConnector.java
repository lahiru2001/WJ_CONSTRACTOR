package com.example.wj_constractor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnector extends SQLiteOpenHelper {
    public DBConnector(Context con){
        super(con,"wj_database",null,1);//database name is wj_database

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE admin(admin_id text,first_name text,last_name text,address text,phone text,username text,password text,email text)");
        db.execSQL("CREATE TABLE supervisor(super_id text,first_name text,last_name text,address text,phone text, username text,password text,email text)");
        db.execSQL("CREATE TABLE worker(worker_ID text,first_name text,last_name text,nic text, age text,phoneno text,address text,email text)");
        db.execSQL("CREATE TABLE addnewsite(site_id text,site_name text,site_superName text,location text,start_date text)");
        db.execSQL("CREATE TABLE attendance(emp_id text,emp_name text,date text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists worker");
        db.execSQL("drop Table if exists supervisor");
    }

    public Cursor getsupervisordata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from supervisor",null);
        return cursor;
    }

    public Cursor getworkerdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from worker", null);
        return cursor;
    }
}
