package com.example.quanlychitieu.Model;



public class ModelLoaiThu {

    int idLoaiThu;
    String TenLoaiThu;

    public ModelLoaiThu(int idLoaiThu, String tenLoaiThu) {
        this.idLoaiThu = idLoaiThu;
        TenLoaiThu = tenLoaiThu;
    }
    public ModelLoaiThu(String tenLoaiThu) {
        this.idLoaiThu = idLoaiThu;
        TenLoaiThu = tenLoaiThu;
    }


    public ModelLoaiThu() {
    }

    public int getIdLoaiThu() {
        return idLoaiThu;
    }

    public void setIdLoaiThu(int idLoaiThu) {
        this.idLoaiThu = idLoaiThu;
    }

    public String getTenLoaiThu() {
        return TenLoaiThu;
    }

    public void setTenLoaiThu(String tenLoaiThu) {
        TenLoaiThu = tenLoaiThu;
    }

    @Override
    public String toString() {
        return TenLoaiThu;
    }
}
