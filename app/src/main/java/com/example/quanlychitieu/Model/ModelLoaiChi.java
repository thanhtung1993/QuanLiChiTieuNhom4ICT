package com.example.quanlychitieu.Model;



public class ModelLoaiChi {

    int idloaiChi;
    String TenLoaiChi;


    public ModelLoaiChi(int idloaiChi, String tenLoaiChi) {
        this.idloaiChi = idloaiChi;
        TenLoaiChi = tenLoaiChi;
    }

    public ModelLoaiChi(String tenLoaiChi) {
        TenLoaiChi = tenLoaiChi;
    }
    public ModelLoaiChi() {
    }
    public int getIdloaiChi() {
        return idloaiChi;
    }

    public void setIdloaiChi(int idloaiChi) {
        this.idloaiChi = idloaiChi;
    }

    public String getTenLoaiChi() {
        return TenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        TenLoaiChi = tenLoaiChi;
    }

    @Override
    public String toString() {
        return TenLoaiChi;
    }
}
