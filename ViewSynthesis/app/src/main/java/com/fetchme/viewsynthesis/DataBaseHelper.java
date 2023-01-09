package com.fetchme.viewsynthesis;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Manager.db";
    private static final String TABLE_NAME = "users";
    private static final String FIRST_COL = "id";
    private static final String SECOND_COL = "password";

    private static final String TABLE_NAME_1 = "Students";
    private static final String FIRST_COL_1 = "name";
    private static final String SECOND_COL_1 = "birth";
    private static final String THIRD_COL_1 = "university";
    private static final String FORTH_COL_1 = "sex";
    private static final String FIFTH_COL_1 = "hobbies";
    private static final String SIXTH_COL_1 = "image";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    /*
            This is called the first time database is accessed. There should be a code here to create a new database.
             */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + FIRST_COL + " TEXT PRIMARY KEY, " + SECOND_COL + " TEXT );";

        String query_1 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_1 + " (" + FIRST_COL_1 + " TEXT, " + SECOND_COL_1 + " TEXT, " + THIRD_COL_1 + " TEXT, " + FORTH_COL_1 + " TEXT, " + FIFTH_COL_1 + " TEXT, " + SIXTH_COL_1 + " INTEGER, " + FIRST_COL + " TEXT, PRIMARY KEY (" + FIRST_COL_1 + "," + SECOND_COL_1 + "," + FORTH_COL_1 + "," + FIRST_COL + "));";
        db.execSQL(query);
        db.execSQL(query_1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addAccount(Account user) {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME + " VALUES( '" + user.getAccount_id().trim() + "', '" + user.getAccount_password().trim() + "' );";
        try {
            database.execSQL(query);
            database.close();
            return true;
        } catch (Exception e) {
            database.close();
            return false;
        }
    }

    public boolean addStudent(Student user, String UserID) {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME_1 + " VALUES( '" + user.getName().trim() + "', '" + user.getBirth().trim() + "', '" + user.getUniversity().trim() + "', '" + user.getSex().trim() + "', '" + user.getHobbies().trim() + "', '" + user.getIMG() + "', '" + UserID + "' );";
        try {
            database.execSQL(query);
            database.close();
            return true;
        } catch (Exception e) {
            database.close();
            return false;
        }
    }


    public Account renderFirstAccount(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        // Fetch the data from query by using cursor
        Cursor c = database.rawQuery(query, null);
        String id = "";
        String password = "";
        // Move to the first index of the fetched data
        if(c.moveToFirst()){
            id = c.getString(0);
            password = c.getString(1);
        }
        c.close();
        database.close();
        return new Account(id, password);
    }
    public Account getAccount(String id) {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = '" + id + "' ORDER BY name;";

        // Fetch the data from query by using cursor
        Cursor c = database.rawQuery(query, null);
        // Move to the first index of the fetched data
        c.moveToFirst();
        String password = c.getString(1);
        c.close();
        database.close();
        return new Account(id, password);
    }

    public ArrayList<Student> getStudents(String UserID) {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_1 + " WHERE id = '" + UserID + "' ORDER BY name;";
        // Set List Holder
        ArrayList<Student> list = new ArrayList<>();
        // Set Attributes
        String name;
        String birth;
        String university;
        String sex;
        String hobbies;
        int image;
        // Fetch the data from query by using cursor
        Cursor c = database.rawQuery(query, null);
        // Move to the first index of the fetched data
        if (c.moveToFirst()) {
            do {
                name = c.getString(0);
                birth = c.getString(1);
                university = c.getString(2);
                sex = c.getString(3);
                hobbies = c.getString(4);
                image = c.getInt(5);
                list.add(new Student(name, birth, university, sex, hobbies, image));
            } while (c.moveToNext());
        }
        c.close();
        database.close();
        return list;
    }
}
