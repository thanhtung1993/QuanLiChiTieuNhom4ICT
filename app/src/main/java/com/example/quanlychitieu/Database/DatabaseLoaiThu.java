package com.example.quanlychitieu.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.quanlychitieu.Model.ModelLoaiThu;

import java.util.ArrayList;
import java.util.List;



public class DatabaseLoaiThu  {


    SQLiteDatabase database;
    String TB="TAB";
    public DatabaseLoaiThu(Context context)
    {
        CreateDatabase createDatabase=new CreateDatabase(context);
        database=createDatabase.Open();
    }

    public long AddItem(ModelLoaiThu modelLoaiThu)
    {
        ContentValues contentValues=new ContentValues();

        contentValues.put(CreateDatabase.TB_LOAITHU_NAMELOAITHU, modelLoaiThu.getTenLoaiThu());
        long check=database.insert(CreateDatabase.TB_LOAITHU,null,contentValues);
        Log.d(TB, String.valueOf(check));
        return check;
    }
    public List<ModelLoaiThu> layLoaiThu(){

        List<ModelLoaiThu> list=new ArrayList<>();

        String TruyVan=" SELECT * FROM " + CreateDatabase.TB_LOAITHU;

        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ModelLoaiThu modelLoaiThu =new ModelLoaiThu();
            modelLoaiThu.setIdLoaiThu(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_LOAITHU_ID)));
            modelLoaiThu.setTenLoaiThu(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_LOAITHU_NAMELOAITHU)));
            list.add(modelLoaiThu);
            cursor.moveToNext();
        }
        Log.d("checkNao", String.valueOf(list));
        return list;
    }
    public boolean UpdateLoaiThu(ModelLoaiThu modelLoaiThu){

        ContentValues contentValues=new ContentValues();
        contentValues.put(CreateDatabase.TB_LOAITHU_NAMELOAITHU, modelLoaiThu.getTenLoaiThu());
        long check=database.update(CreateDatabase.TB_LOAITHU,contentValues,CreateDatabase.TB_LOAITHU_ID + " = " + modelLoaiThu.getIdLoaiThu(),null);
        if(check !=0){
            return true;
        }else {
            return false;
        }

    }
    public boolean deteleteItem(String id){

        long check= database.delete(CreateDatabase.TB_LOAITHU,CreateDatabase.TB_LOAITHU_ID+"=?",new String[]{String.valueOf(id)});
        if (check !=0){
            return true;
        }
        else {
            return false;
        }
    }
}
