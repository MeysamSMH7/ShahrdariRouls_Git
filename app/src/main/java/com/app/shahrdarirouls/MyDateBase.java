package com.app.shahrdarirouls;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.shahrdarirouls.DataBase.Structure.tb_FavoriteStructure;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDateBase extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "MyDbJafar.db";
    private static final int DATABASE_VERSION = 1;
    private static final int NEWDATABASE_VERSION = 2;

    public MyDateBase(Context context) {
        super(context, DATABASE_NAME, null, NEWDATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //super.onUpgrade(db, oldVersion, newVersion);
        Log.d("oldversion" , oldVersion + "");
        Log.d("oldversion" , newVersion + "");


        if (oldVersion == 1){
            db.execSQL(tb_FavoriteStructure.createTableQuery);
        }
    }
}
