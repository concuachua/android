package com.example.suphuy.assigmment_huyphpk00628.model;

/**
 * Created by SUPHUY on 9/19/2016.
 */
public class MucChiCha {
    //5 biến tạo bảng mục chi cha (huyphpk00628@fpt.edu.vn)
    private  int ID;
    private  String TenMucChi;
    private  String GhiChu;

    public MucChiCha() {
    }

    public MucChiCha( int ID, String tenMucChi,String ghiChu) {
        this.GhiChu = ghiChu;
        this.ID = ID;
        this.TenMucChi = tenMucChi;
    }
    public MucChiCha(String tenMucChi,String ghiChu) {
        this.GhiChu = ghiChu;
        this.TenMucChi = tenMucChi;
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

    public String getTenMucChi() {
        return TenMucChi;
    }

    public void setTenMucChi(String tenMucChi) {
        TenMucChi = tenMucChi;
    }
}
