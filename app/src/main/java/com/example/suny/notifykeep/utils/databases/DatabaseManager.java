package com.example.suny.notifykeep.utils.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;

import com.example.suny.notifykeep.Constants.Constants;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by suny on 2017/5/10.
 */

public class DatabaseManager {

    DatabaseHelper helper;

    public DatabaseManager(Context context) {
        helper = new DatabaseHelper(context);
    }

    public void insert(String appName, String body, long date) {

        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.APP_NAME, appName);
        values.put(Constants.BODY, body);
        values.put(Constants.DATETIME, String.valueOf(date));
        values.put(Constants.IS_KEEP, 0);

        db.insert(Constants.TABLE_NAME, null, values);
        db.close();
    }

//根据code区分设置提醒（1），未设置提醒（0），已完成（3）三个类别
    public void update(String code) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        String where = "keep=?";
        String[] whereValue = {code};
        db.update(Constants.TABLE_NAME, values, where, whereValue);
        db.close();

    }

    public List<Datas> query(String code) {

        SQLiteDatabase db = helper.getWritableDatabase();
        List<Datas> datasList = new ArrayList<>();

        Cursor cursor = db.query(true, Constants.TABLE_NAME, new String[]{Constants.APP_NAME,Constants.BODY,Constants.IS_KEEP}, "keep=?", new String[]{code}, null, null, Constants.DATETIME + " desc","");
        while (cursor.moveToNext()) {
            String appName = cursor.getString(cursor.getColumnIndex(Constants.APP_NAME));
            String appBody = cursor.getString(cursor.getColumnIndex(Constants.BODY));
            Datas datas = new Datas();
            datas.setAppName(appName);
            datas.setBody(appBody);
            datasList.add(datas);

        }

        db.close();
        return datasList;



    }

//    public void delete() {
//        SQLiteDatabase db = helper.getWritableDatabase();
//
//        String where = "";
//        db.delete(Constants.TABLE_NAME,where)
//    }
}
