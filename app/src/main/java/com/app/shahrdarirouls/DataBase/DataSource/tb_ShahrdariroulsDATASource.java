package com.app.shahrdarirouls.DataBase.DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.app.shahrdarirouls.DataBase.MyDateBase;
import com.app.shahrdarirouls.DataBase.Structure.tb_ShardariRoulsStructure;
import com.app.shahrdarirouls.DataBase.Table.tb_ShahrdariRouls;

import java.util.ArrayList;
import java.util.List;

//import com.app.shahrdarirouls.DataBase.MyDateBase;

/**
 * Created by SMH on 05-Aug-18.
 */

public class tb_ShahrdariroulsDATASource {
    private SQLiteDatabase database;
    private MyDateBase dbManagement;


    private String[] allColumns = {

            tb_ShardariRoulsStructure.colPK_ShahrdariRouls,
            tb_ShardariRoulsStructure.colroulName,
            tb_ShardariRoulsStructure.colmAde,
            tb_ShardariRoulsStructure.coltAbsare,
            tb_ShardariRoulsStructure.colsHarhSefr,
            tb_ShardariRoulsStructure.colsHarhOne,
            tb_ShardariRoulsStructure.colsHarhTwo,
            tb_ShardariRoulsStructure.colsHoraMashmol,
            tb_ShardariRoulsStructure.coltxt


    };

    public tb_ShahrdariroulsDATASource(Context context) {
        dbManagement = new MyDateBase(context);
    }

    public void Open() throws SQLException {
        database = dbManagement.getWritableDatabase();
    }

    public void Close() {
        dbManagement.close();
        database.close();
    }

    public long Add(tb_ShahrdariRouls data) {
        ContentValues values = new ContentValues();

        values.put(tb_ShardariRoulsStructure.colroulName, data.RoulsNAme);
        values.put(tb_ShardariRoulsStructure.colmAde, data.MadeNum);
        values.put(tb_ShardariRoulsStructure.coltAbsare, data.Tabsare);
        values.put(tb_ShardariRoulsStructure.colsHarhSefr, data.SharhZERO);
        values.put(tb_ShardariRoulsStructure.colsHarhOne, data.SharhOne);
        values.put(tb_ShardariRoulsStructure.colsHarhTwo, data.SharhTwo);
        values.put(tb_ShardariRoulsStructure.colsHoraMashmol, data.ShoraiMashmol);
        values.put(tb_ShardariRoulsStructure.coltxt, data.txtRouls);


        return database.insert(tb_ShardariRoulsStructure.tableName, null, values);
    }


    public long QueryNumEntries() {
        return DatabaseUtils.queryNumEntries(database, tb_ShardariRoulsStructure.tableName);
    }

    public tb_ShahrdariRouls GetRecord() {
        Cursor cursor = database.query(tb_ShardariRoulsStructure.tableName, allColumns,
                null, null, null, null, null);
        cursor.moveToFirst();

        if (cursor.getCount() == 0) {
            return null;
        }

        tb_ShahrdariRouls data = ConvertToRecord(cursor);
        cursor.close();
        return data;
    }

    public tb_ShahrdariRouls GetRecord(int id) {
        Cursor cursor = database.query(tb_ShardariRoulsStructure.tableName, allColumns,
                tb_ShardariRoulsStructure.colPK_ShahrdariRouls + "=" + id,
                null, null, null, null);

        cursor.moveToFirst();

        if (cursor.getCount() == 0) {
            return null;
        }

        tb_ShahrdariRouls data = ConvertToRecord(cursor);
        cursor.close();
        return data;
    }

    public void DeleteAll(){
        database.delete(tb_ShardariRoulsStructure.tableName , null , null);
    }


    public List<tb_ShahrdariRouls> GetRecordByCompanyName(
            String SESTchBoxShar_01
            , String SESTchBoxShar_02
            , String SESTchBoxShar_03
            , String SESTchBoxShar_04
            , String SESTchBoxShar_05
            , String SESTchBoxShar_06
            , String SESTchBoxShar_07
            , String SESTchBoxShar_08
            , String SESTchBoxShar_09
            , String SESTchBoxShar_10
            , String SESTchBoxShar_11
            , String SESTchBoxShar_12
            , String SESTchBoxShar_13
            , String SESTchBoxShar_14
            , String SESTchBoxShar_15
            , String SESTchBoxShar_16
            , String SESTchBoxShar_17
            , String SESTchBoxShar_18
            , String SESTchBoxShar_19
            , String SESTchBoxShar_20
            , String SESTchBoxShar_21
            , String SESTchBoxShar_22
            , String SESTchBoxShar_23
            , String SESTchBoxShar_24
            , String SESTchBoxShar_25
            , String SESTchBoxShar_26
            , String SESTchBoxShar_27
            , String SESTchBoxShar_28
            , String SESTchBoxShar_29
            , String SESTchBoxShar_30
            , String SESTchBoxShar_31
            , String SESTchBoxShar_32
            , String SESTchBoxShar_33
            , String SESTchBoxShar_34
            , String SESTchBoxShar_36
            , String SESTchBoxShar_37
            , String SESTchBoxShar_38
            , String SESTchBoxShar_40
            , String SESTchBoxShar_41
            , String SESTchBoxShar_42
            , String SESTchBoxShar_43
            , String SESTchBoxShar_44
            , String SESTchBoxShar_45
            , String SESTchBoxShar_46
            , String SESTchBoxShar_47
            , String SESTchBoxShar_48
            , String SESTchBoxShar_49
            , String SESTchBoxShar_51
            , String SESTchBoxShar_52
            , String SESTchBoxShar_53
            , String SESTchBoxShar_54
            , String SESTchBoxShar_55
            , String SESTchBoxShar_56
            , String SESTchBoxShar_57
            , String SESTchBoxShar_58
            , String SESTchBoxShar_59
            , String SESTchBoxShar_61
            , String SESTchBoxShar_62
            , String SESTchBoxShar_63
            , String SESTchBoxShar_64
            , String SESTchBoxShar_65
            , String SESTchBoxShar_66
            , String SESTchBoxShar_67
            , String SESTchBoxShar_68
            , String SESTchBoxShar_69
            , String SESTchBoxShar_39
            , String SESTchBoxShar_70
            , String SESTchBoxShar_71
            , String SESTchBoxShar_72
            , String SESTchBoxShar_73
            , String SESTchBoxShar_74

            , String SESTchBoxShora_01
            , String SESTchBoxShora_02
            , String SESTchBoxShora_03
            , String SESTchBoxShora_04
            , String SESTchBoxShora_05
            , String SESTchBoxShora_06
            , String SESTchBoxShora_07
            , String SESTchBoxShora_08
            , String SESTchBoxShora_09
            , String SESTchBoxShora_10
            , String SESTchBoxShora_11
            , String SESTchBoxShora_12
            , String SESTchBoxShora_13
            , String SESTchBoxShora_14
            , String SESTchBoxShora_15
            , String SESTchBoxShora_16
            , String SESTchBoxShora_17
            , String SESTchBoxShora_18
            , String SESTchBoxShora_19
            , String SESTchBoxShora_20
            , String SESTchBoxShora_21

    ) {

        List<tb_ShahrdariRouls> lstData = new ArrayList<tb_ShahrdariRouls>();

        Cursor cursor = database.query(false, tb_ShardariRoulsStructure.tableName, allColumns,


                tb_ShardariRoulsStructure.colsHarhOne + " IN " + "('"
                        + SESTchBoxShar_01 +
                        "' , '" + SESTchBoxShar_02 +
                        "' , '" + SESTchBoxShar_03 +
                        "' , '" + SESTchBoxShar_04 +
                        "' , '" + SESTchBoxShar_05 +
                        "' , '" + SESTchBoxShar_06 +
                        "' , '" + SESTchBoxShar_07 +
                        "' , '" + SESTchBoxShar_08 +
                        "' , '" + SESTchBoxShar_09 +
                        "' , '" + SESTchBoxShar_10 +
                        "' , '" + SESTchBoxShar_11 +
                        "' , '" + SESTchBoxShar_12 +
                        "' , '" + SESTchBoxShar_13 +
                        "' , '" + SESTchBoxShar_14 +
                        "' , '" + SESTchBoxShar_15 +
                        "' , '" + SESTchBoxShar_16 +
                        "' , '" + SESTchBoxShar_17 +
                        "' , '" + SESTchBoxShar_18 +
                        "' , '" + SESTchBoxShar_19 +
                        "' , '" + SESTchBoxShar_20 +
                        "' , '" + SESTchBoxShar_21 +
                        "' , '" + SESTchBoxShar_22 +
                        "' , '" + SESTchBoxShar_23 +
                        "' , '" + SESTchBoxShar_24 +
                        "' , '" + SESTchBoxShar_25 +
                        "' , '" + SESTchBoxShar_26 +
                        "' , '" + SESTchBoxShar_27 +
                        "' , '" + SESTchBoxShar_28 +
                        "' , '" + SESTchBoxShar_29 +
                        "' , '" + SESTchBoxShar_30 +
                        "' , '" + SESTchBoxShar_31 +
                        "' , '" + SESTchBoxShar_32 +
                        "' , '" + SESTchBoxShar_33 +
                        "' , '" + SESTchBoxShar_34 +
                        "' , '" + SESTchBoxShar_36 +
                        "' , '" + SESTchBoxShar_37 +
                        "' , '" + SESTchBoxShar_38 +
                        "' , '" + SESTchBoxShar_40 +
                        "' , '" + SESTchBoxShar_41 +
                        "' , '" + SESTchBoxShar_42 +
                        "' , '" + SESTchBoxShar_43 +
                        "' , '" + SESTchBoxShar_44 +
                        "' , '" + SESTchBoxShar_45 +
                        "' , '" + SESTchBoxShar_46 +
                        "' , '" + SESTchBoxShar_47 +
                        "' , '" + SESTchBoxShar_48 +
                        "' , '" + SESTchBoxShar_49 +
                        "' , '" + SESTchBoxShar_51 +
                        "' , '" + SESTchBoxShar_52 +
                        "' , '" + SESTchBoxShar_53 +
                        "' , '" + SESTchBoxShar_54 +
                        "' , '" + SESTchBoxShar_55 +
                        "' , '" + SESTchBoxShar_56 +
                        "' , '" + SESTchBoxShar_57 +
                        "' , '" + SESTchBoxShar_58 +
                        "' , '" + SESTchBoxShar_59 +
                        "' , '" + SESTchBoxShar_61 +
                        "' , '" + SESTchBoxShar_62 +
                        "' , '" + SESTchBoxShar_63 +
                        "' , '" + SESTchBoxShar_64 +
                        "' , '" + SESTchBoxShar_65 +
                        "' , '" + SESTchBoxShar_66 +
                        "' , '" + SESTchBoxShar_67 +
                        "' , '" + SESTchBoxShar_68 +
                        "' , '" + SESTchBoxShar_69 +
                        "' , '" + SESTchBoxShar_39 +
                        "' , '" + SESTchBoxShar_70 +
                        "' , '" + SESTchBoxShar_71 +
                        "' , '" + SESTchBoxShar_72 +
                        "' , '" + SESTchBoxShar_73 +
                        "' , '" + SESTchBoxShar_74 +
                        "') OR " + tb_ShardariRoulsStructure.colsHoraMashmol + " IN " + "('"
                        + SESTchBoxShora_01 +
                        "' , '" + SESTchBoxShora_02 +
                        "' , '" + SESTchBoxShora_03 +
                        "' , '" + SESTchBoxShora_04 +
                        "' , '" + SESTchBoxShora_05 +
                        "' , '" + SESTchBoxShora_06 +
                        "' , '" + SESTchBoxShora_07 +
                        "' , '" + SESTchBoxShora_08 +
                        "' , '" + SESTchBoxShora_09 +
                        "' , '" + SESTchBoxShora_10 +
                        "' , '" + SESTchBoxShora_11 +
                        "' , '" + SESTchBoxShora_12 +
                        "' , '" + SESTchBoxShora_13 +
                        "' , '" + SESTchBoxShora_14 +
                        "' , '" + SESTchBoxShora_15 +
                        "' , '" + SESTchBoxShora_16 +
                        "' , '" + SESTchBoxShora_17 +
                        "' , '" + SESTchBoxShora_18 +
                        "' , '" + SESTchBoxShora_19 +
                        "' , '" + SESTchBoxShora_20 +
                        "' , '" + SESTchBoxShora_21 +
                        "')"
                ,
                null, null, null, null, null);


        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {
            tb_ShahrdariRouls tmpInfo = ConvertToRecord(cursor);
            lstData.add(tmpInfo);
            cursor.moveToNext();
        }

        if (cursor.getCount() == 0) {
            return null;
        }


        cursor.close();
        return lstData;

    }

    public List<tb_ShahrdariRouls> GetRecordByLike(String txt) {

        List<tb_ShahrdariRouls> lstData = new ArrayList<tb_ShahrdariRouls>();

        Cursor cursor = database.query(false, tb_ShardariRoulsStructure.tableName, allColumns, tb_ShardariRoulsStructure.coltxt + " LIKE '%" + txt + "%'",
                null, null, null, null, null);


        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {
            tb_ShahrdariRouls tmpInfo = ConvertToRecord(cursor);
            lstData.add(tmpInfo);
            cursor.moveToNext();
        }

        if (cursor.getCount() == 0) {
            return null;
        }


        cursor.close();
        return lstData;

    }

    public List<tb_ShahrdariRouls> GetRecordBySubPosts(String txt) {

        List<tb_ShahrdariRouls> lstData = new ArrayList<tb_ShahrdariRouls>();

        Cursor cursor = database.query(false, tb_ShardariRoulsStructure.tableName, allColumns, tb_ShardariRoulsStructure.colsHoraMashmol + " IN " + "('" + txt + "')",null, null, null, null, null);

        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {
            tb_ShahrdariRouls tmpInfo = ConvertToRecord(cursor);
            lstData.add(tmpInfo);
            cursor.moveToNext();
        }

        if (cursor.getCount() == 0) {
            return null;
        }


        cursor.close();
        return lstData;

    }


    public List<tb_ShahrdariRouls> GetRecordBySubPostsForFavorite(int id) {

        List<tb_ShahrdariRouls> lstData = new ArrayList<tb_ShahrdariRouls>();

        Cursor cursor = database.query(false, tb_ShardariRoulsStructure.tableName, allColumns, tb_ShardariRoulsStructure.colPK_ShahrdariRouls + " = " + id ,null, null, null, null, null);

        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {
            tb_ShahrdariRouls tmpInfo = ConvertToRecord(cursor);
            lstData.add(tmpInfo);
            cursor.moveToNext();
        }

        if (cursor.getCount() == 0) {
            return null;
        }


        cursor.close();
        return lstData;

    }



    public List<tb_ShahrdariRouls> GetList() {
        List<tb_ShahrdariRouls> lstData = new ArrayList<tb_ShahrdariRouls>();

        Cursor cursor = database.query(tb_ShardariRoulsStructure.tableName,
                allColumns,
                null, null, null, null,
                tb_ShardariRoulsStructure.colPK_ShahrdariRouls + " DESC");
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            tb_ShahrdariRouls tmpInfo = ConvertToRecord(cursor);
            lstData.add(tmpInfo);
            cursor.moveToNext();
        }

        cursor.close();
        return lstData;
    }


    private tb_ShahrdariRouls ConvertToRecord(Cursor cursor) {
        tb_ShahrdariRouls data = new tb_ShahrdariRouls();


        data.PK_Shahrdari = cursor.getInt(0);
        data.RoulsNAme = cursor.getString(1);
        data.MadeNum = cursor.getString(2);
        data.Tabsare = cursor.getString(3);
        data.SharhZERO = cursor.getString(4);
        data.SharhOne = cursor.getString(5);
        data.SharhTwo = cursor.getString(6);
        data.ShoraiMashmol = cursor.getString(7);
        data.txtRouls = cursor.getString(8);

        return data;
    }

}
