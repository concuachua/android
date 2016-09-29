package com.example.suphuy.assigmment_huyphpk00628.model;

/**
 * Created by SUPHUY on 9/19/2016.  (huyphpk00628@fpt.edu.vn) phạm hoàng huy 01293
 */
public class LoaiTK {
    //2 biến tạo bảng Loai tài khoản (huyphpk00628@fpt.edu.vn)
    private int ID;
    private  String TenLoaiTK;
    private int AvaTar;
    private  String GhiChu;

    public LoaiTK() {
    }
    public LoaiTK(int ID, String TenTK, int AvaTar, String GhiChu) {
       this.AvaTar = AvaTar;
        this.GhiChu = GhiChu;
        this.ID = ID;
        this.TenLoaiTK = TenTK;
    }
    public LoaiTK( String TenTK, int AvaTar, String GhiChu) {
        this.AvaTar = AvaTar;
        this.GhiChu = GhiChu;
        this.TenLoaiTK = TenTK;
    }

    public int getAvaTar() {
        return AvaTar;
    }

    public void setAvaTar(int avaTar) {
        AvaTar = avaTar;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenLoaiTK() {
        return TenLoaiTK;
    }

    public void setTenLoaiTK(String tenLoaiTK) {
        TenLoaiTK = tenLoaiTK;
    }
}

