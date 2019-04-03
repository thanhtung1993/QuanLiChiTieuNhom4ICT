package com.example.quanlychitieu.Model;



public class LoaiChi {

    int idloaiChi;
    String TenLoaiChi;


    public LoaiChi(int idloaiChi, String tenLoaiChi) {
        this.idloaiChi = idloaiChi;
        TenLoaiChi = tenLoaiChi;
    }

    public LoaiChi(String tenLoaiChi) {
        TenLoaiChi = tenLoaiChi;
    }
    public LoaiChi() {
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
