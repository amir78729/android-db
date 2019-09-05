package com.example.diseases.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.diseases.R;
import com.example.diseases.model.Disease;
import com.example.diseases.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }


    //creating the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DISEASE_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY,"
                + Util.KEY_NAME + " TEXT,"
                + Util.KEY_DESCRIPTION + " TEXT"
                + ")";
        db.execSQL(CREATE_DISEASE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE = String.valueOf(R.string.dropTableIfExists);
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addDiseases(Disease disease){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, disease.getName());
        values.put(Util.KEY_DESCRIPTION, disease.getDescriptiom());
        db.insert(Util.TABLE_NAME, null, values);
        db.close();
        Log.d("DB", "addDiseases: disease added!");
    }

    public Disease getDisease(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME,
                new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_DESCRIPTION},
                Util.KEY_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (cursor != null )
            cursor.moveToFirst();
        Disease disease = new Disease();
        disease.setId(Integer.parseInt(cursor.getString(0)));
        disease.setName(cursor.getString(1));
        disease.setDescriptiom(cursor.getString(2));
        cursor.close();//?
        return disease;
    }

    public List<Disease> getAllDiseases(){
        List<Disease> allDiseases = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String SELECT_ALL = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(SELECT_ALL, null);
        if (cursor.moveToFirst()){
            do {
                Disease disease = new Disease();
                disease.setId(Integer.parseInt(cursor.getString(0)));
                disease.setName(cursor.getString(1));
                disease.setDescriptiom(cursor.getString(2));
                allDiseases.add(disease);
                }while (cursor.moveToNext());
        }
        return allDiseases;
    }

    public int updateDisease(Disease disease){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, disease.getName());
        values.put(Util.KEY_DESCRIPTION, disease.getDescriptiom());
        return db.update(Util.TABLE_NAME, values, Util.KEY_ID + "=?", new String[]{String.valueOf(disease.getId())});

    }

    public void deleteDisease(Disease disease){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?" , new String[]{String.valueOf(disease.getId())});
        db.close();
    }

    public void deleteDisease(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?" , new String[]{String.valueOf(id)});
        db.close();
    }

    public int getCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        String COUNT_QUERY = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(COUNT_QUERY, null);
        return cursor.getCount();
    }
}
