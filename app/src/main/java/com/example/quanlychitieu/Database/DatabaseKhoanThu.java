package com.example.quanlychitieu.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.quanlychitieu.Model.ModelKhoanThu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class DatabaseKhoanThu  {

    String Ngay,TaiKhoan,SoTien,MoTa,LoaiThu;
    SQLiteDatabase database;
    String TB="TAB";
    public DatabaseKhoanThu(Context context)
    {
        CreateDatabase createDatabase=new CreateDatabase(context);
        database=createDatabase.Open();
    }

    public static String Today="SELECT * FROM " + CreateDatabase.TB_KHOANTHU+" WHERE "+CreateDatabase.TB_KHOANTHU_NGAY+" ='"+chooseDate()+"'";

    public static String ThisWeek = "SELECT * FROM "+CreateDatabase.TB_KHOANTHU+" WHERE strftime('%W',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%W',date('now')) " +
            "AND  strftime('%m',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%m',date('now'))"+
            "AND strftime('%Y',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%Y',date('now'))";

    public static String ThisYear="SELECT * FROM "+CreateDatabase.TB_KHOANTHU+" WHERE strftime('%Y',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%Y',date('now'))";

    public static String ThisMonth="SELECT * FROM "+CreateDatabase.TB_KHOANTHU+" WHERE strftime('%Y',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%Y',date('now')) " +
            "AND  strftime('%m',"+CreateDatabase.TB_KHOANTHU_NGAY+") = strftime('%m',date('now'))";



    public long AddKhoanThu(ModelKhoanThu modelKhoanThu)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(CreateDatabase.TB_KHOANTHU_NGAY, modelKhoanThu.getNgay());
        contentValues.put(CreateDatabase.TB_KHOANTHU_TAIKHOAN, modelKhoanThu.getTaiKhoan());
        contentValues.put(CreateDatabase.TB_KHOANTHU_SOTIEN, modelKhoanThu.getSoTien());
        contentValues.put(CreateDatabase.TB_KHOANTHU_MOTA, modelKhoanThu.getMoTa());
        contentValues.put(CreateDatabase.TB_KHOANTHU_LOAITHU, modelKhoanThu.getLoaiThu());
        long check=database.insert(CreateDatabase.TB_KHOANTHU,null,contentValues);
        Log.d(TB, String.valueOf(check));
        return check;
    }
    public List<ModelKhoanThu> layKhoanThu(){

        List<ModelKhoanThu> list=new ArrayList<>();

        String TruyVan=" SELECT * FROM " + CreateDatabase.TB_KHOANTHU;

        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ModelKhoanThu modelKhoanThu =new ModelKhoanThu();
            modelKhoanThu.setId(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_ID)));
            modelKhoanThu.setNgay(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_NGAY)));
            modelKhoanThu.setLoaiThu(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_LOAITHU)));
            modelKhoanThu.setMoTa(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_MOTA)));
            modelKhoanThu.setSoTien(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_SOTIEN)));
            modelKhoanThu.setTaiKhoan(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_TAIKHOAN)));
            list.add(modelKhoanThu);
            cursor.moveToNext();
        }
        Log.d("checkNao", String.valueOf(list));
        return list;
    }

    public List<ModelKhoanThu> layKhoanThuTheoNgayThangNam(String truyvan){

        List<ModelKhoanThu> list=new ArrayList<>();

        Cursor cursor=database.rawQuery(truyvan,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ModelKhoanThu modelKhoanThu =new ModelKhoanThu();
            modelKhoanThu.setId(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_ID)));
            modelKhoanThu.setNgay(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_NGAY)));
            modelKhoanThu.setLoaiThu(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_LOAITHU)));
            modelKhoanThu.setMoTa(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_MOTA)));
            modelKhoanThu.setSoTien(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_SOTIEN)));
            modelKhoanThu.setTaiKhoan(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_KHOANTHU_TAIKHOAN)));
            list.add(modelKhoanThu);
            cursor.moveToNext();
        }
        //Log.d("checkNao", String.valueOf(list));
        return list;
    }




    public static String chooseDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// bắt buộc phải định dạng theo năm tháng ngày
        String currentDate = sdf.format(calendar.getTime());
        return currentDate;
    }

}
