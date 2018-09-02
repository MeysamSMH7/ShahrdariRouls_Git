package com.app.shahrdarirouls.DataBase;

/**
 * Created by SMH on 05-Aug-18.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.shahrdarirouls.DataBase.Structure.tb_FavoriteStructure;
import com.app.shahrdarirouls.DataBase.Structure.tb_ShardariRoulsStructure;


public class DatabaseManagement extends SQLiteOpenHelper {
    public static final String databaseName = "MyDbShahrdari.db";
    public static final int databaseVersion = 1;


    public DatabaseManagement(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tb_ShardariRoulsStructure.createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
