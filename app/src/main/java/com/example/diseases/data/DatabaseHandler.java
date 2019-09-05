package com.example.diseases.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.diseases.R;
import com.example.diseases.model.Disease;
import com.example.diseases.util.Util;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }


    //creating the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DISEASE_TABLE = String.valueOf(R.string.createTable) + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY,"
                + Util.KEY_NAME + " TEXT,"
                + Util.KEY_DESCRIPTION + " TEXT"
                + ")";
        db.execSQL(CREATE_DISEASE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE = String.valueOf(R.string.db_drop);
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
    }
}
