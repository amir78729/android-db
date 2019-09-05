package com.example.diseases.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.diseases.R;
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
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
