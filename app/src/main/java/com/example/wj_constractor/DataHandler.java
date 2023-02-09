package com.example.wj_constractor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;

import java.util.ArrayList;

public class DataHandler {
    private Context con;
    private DBConnector dbCon;
    private SQLiteDatabase db;
    private String username;
    private String password;

    public DataHandler(Context con) {
        this.con = con;

    }

    public DataHandler openDB() {
        this.dbCon = new DBConnector(con);
        this.db = dbCon.getWritableDatabase();
        return this;
    }

    public void RegisterAdmin(Admin admin)throws Exception{
        ContentValues contentValues = new ContentValues();

        contentValues.put("admin_Id", admin.getAdminId());
        contentValues.put("first_name", admin.getFirstname());
        contentValues.put("last_name", admin.getLastname());
        contentValues.put("address", admin.getAddress());
        contentValues.put("phone", admin.getPhone());
        contentValues.put("username", admin.getUsername());
        contentValues.put("password", admin.getPassword());
        contentValues.put("email", admin.getEmail());

        db.insert("admin",null,contentValues);

    }

    public void RegisterSuper(Supervisor supervisor) throws Exception {
        ContentValues contentValues = new ContentValues();

        contentValues.put("super_Id", supervisor.getSuperId());
        contentValues.put("first_name", supervisor.getFirstname());
        contentValues.put("last_name", supervisor.getLastname());
        contentValues.put("address", supervisor.getAddress());
        contentValues.put("phone", supervisor.getPhone());
        contentValues.put("username", supervisor.getUsername());
        contentValues.put("password", supervisor.getPassword());
        contentValues.put("email", supervisor.getEmail());

        db.insert("supervisor", null, contentValues);

    }
    public void RegisterMasonaryWorkers(Masonary_workers masonary_workers)throws Exception{
        ContentValues contentValues = new ContentValues();

        contentValues.put("worker_Id", masonary_workers.getId());
        contentValues.put("first_name", masonary_workers.getfName());
        contentValues.put("last_name", masonary_workers.getlName());
        contentValues.put("nic", masonary_workers.getNic());
        contentValues.put("age", masonary_workers.getAge());
        contentValues.put("phoneno", masonary_workers.getPhone());
        contentValues.put("address", masonary_workers.getAddress());
        contentValues.put("email", masonary_workers.getEmail());

        db.insert("Worker",null,contentValues);

    }
    public void AddNewSite(AddNewSite addNewSite){
        ContentValues contentValues = new ContentValues();

        contentValues.put("site_id", addNewSite.getId());
        contentValues.put("site_name", addNewSite.getSiteName());
        contentValues.put("site_superName ", addNewSite.getSuperId());
        contentValues.put("location", addNewSite.getLocation());
        contentValues.put("start_date", addNewSite.getStartDate());

        db.insert("addnewsite",null,contentValues);


    }
    public void updateSupervisor(Supervisor supervisor){

        ContentValues contentValues = new ContentValues();

        contentValues.put("super_Id", supervisor.getSuperId());
        contentValues.put("first_name", supervisor.getFirstname());
        contentValues.put("last_name", supervisor.getLastname());
        contentValues.put("address", supervisor.getAddress());
        contentValues.put("phone", supervisor.getPhone());
        contentValues.put("username", supervisor.getUsername());
        contentValues.put("password", supervisor.getPassword());
        contentValues.put("email", supervisor.getEmail());

        db.update("supervisor",contentValues,"super_id=?", new String[]{supervisor.getSuperId()});
    }

    public void updateWorker(Masonary_workers masonary_workers){
        ContentValues contentValues = new ContentValues();

        contentValues.put("worker_ID", masonary_workers.getId());
        contentValues.put("first_name", masonary_workers.getfName());
        contentValues.put("last_name", masonary_workers.getlName());
        contentValues.put("nic", masonary_workers.getNic());
        contentValues.put("age", masonary_workers.getAge());
        contentValues.put("phoneno", masonary_workers.getPhone());
        contentValues.put("address", masonary_workers.getAddress());
        contentValues.put("email", masonary_workers.getEmail());

        db.update("worker",contentValues,"worker_ID=?",new String[]{masonary_workers.getId()});
    }


    public Integer DeleteSupervisor(String superId) {
        this.db = dbCon.getWritableDatabase();
        return db.delete("supervisor", "super_id=?",new String[]{superId});
    }

    public Integer DeleteWorker(String id) {
        this.db = dbCon.getWritableDatabase();
        return db.delete("worker", "worker_ID=?",new String[]{id});
    }


    public ArrayList<Supervisor> getAllSupervisor() {return null;}
    public boolean checkForSupervisor(Supervisor supervisor){

        Cursor cursor = db.rawQuery("select * from supervisor where username='"+ supervisor.getUsername()+"'",null);

        if(cursor.moveToFirst()){
            return true;
        }
        return false;
    }

    public ArrayList<Admin> getAllAdmin() {return null;}
    public boolean checkForAdminRegister(Admin admin){

        Cursor cursor = db.rawQuery("select * from admin where username='"+ admin.getUsername()+"'",null);

        if(cursor.moveToFirst()){
            return true;
        }
        return false;
    }
    public boolean checkAdminLogin(String username, String password){
        Cursor cursor = db.rawQuery("SELECT * FROM admin WHERE username=? and password=?",new String[]{username,password});
        if(cursor.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean checkSupervisorLogin(String username, String password){
        Cursor cursor = db.rawQuery("SELECT * FROM supervisor WHERE username=? and password=?",new String[]{username,password});
        if(cursor.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Masonary_workers> getAllWorkers() {return null;}

    public boolean checkForWorker(Masonary_workers masonary_workers){
        Cursor cursor = db.rawQuery("select * from worker where worker_Id='"+ masonary_workers.getId()+"'",null);

        if(cursor.moveToFirst()){
            return true;
        }
        return false;
    }

    public void Attendance(Attendance attendance){
        ContentValues contentValues = new ContentValues();

        contentValues.put("emp_id",attendance.getMarkId());
        contentValues.put("emp_name", attendance.getMarkName());
        contentValues.put("date", attendance.getMarkDate());


        db.insert("attendance", null, contentValues);
    }
}

