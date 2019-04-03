package com.example.quanlychitieu.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.quanlychitieu.Model.ModelLoaiChi;

import java.util.ArrayList;
import java.util.List;



public class DatabaseLoaiChi {

    SQLiteDatabase database;
    String TB="TAB";
    public DatabaseLoaiChi(Context context)
    {
        CreateDatabase createDatabase=new CreateDatabase(context);
        database=createDatabase.Open();
    }

    public long AddItem(ModelLoaiChi modelLoaiChi)
    {
        ContentValues contentValues=new ContentValues();

        contentValues.put(CreateDatabase.TB_LOAICHI_NAMELOAICHI, modelLoaiChi.getTenLoaiChi());
        long check=database.insert(CreateDatabase.TB_LOAICHI,null,contentValues);
        Log.d(TB, String.valueOf(check));
        return check;
    }
    public List<ModelLoaiChi> layLoaiChi(){

        List<ModelLoaiChi> list=new ArrayList<>();

        String TruyVan=" SELECT * FROM " + CreateDatabase.TB_LOAICHI;

        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ModelLoaiChi modelLoaiChi =new ModelLoaiChi();
            modelLoaiChi.setIdloaiChi(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_LOAICHI_ID)));
            modelLoaiChi.setTenLoaiChi(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_LOAICHI_NAMELOAICHI)));
            list.add(modelLoaiChi);
            cursor.moveToNext();
        }

        return list;
    }
    public boolean UpdateLoaiChi(ModelLoaiChi modelLoaiChi){

        ContentValues contentValues=new ContentValues();

        contentValues.put(CreateDatabase.TB_LOAICHI_NAMELOAICHI,(modelLoaiChi.getTenLoaiChi()));

        long check=database.update(CreateDatabase.TB_LOAICHI,contentValues,CreateDatabase.TB_LOAITHU_ID + " = " + modelLoaiChi.getIdloaiChi(),null);

        if(check !=0){
            return true;
        }else {
            return false;
        }

    }
    public boolean deteleteItemLoaiChi(String id){

        long check= database.delete(CreateDatabase.TB_LOAICHI,CreateDatabase.TB_LOAICHI_ID+"=?",new String[]{String.valueOf(id)});
        if (check !=0){
            return true;
        }
        else {
            return false;
        }
    }
}
