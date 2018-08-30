package com.app.shahrdarirouls.DataBase;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDateBase extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "MyDbJafar.db";
    private static final int DATABASE_VERSION = 1;

    public MyDateBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
