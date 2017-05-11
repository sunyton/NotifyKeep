package com.example.suny.notifykeep.utils.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.suny.notifykeep.Constants.Constants;

/**
 * Created by suny on 2017/5/10.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table "
                + Constants.TABLE_NAME + "("
                + Constants._ID + " integer primary key,"
                + Constants.APP_NAME + " varchar,"
                + Constants.BODY + " varchar,"
                + Constants.DATETIME + " integer,"
                + Constants.IS_KEEP + " varchar)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
