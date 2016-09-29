package com.example.suphuy.assigmment_huyphpk00628.model;


/**
 * Created by SUPHUY on 9/19/2016.  (huyphpk00628@fpt.edu.vn) phạm hoàng huy 01293223225
 */
public class MucThu {
    //8 biến tạo bảng mục thu (huyphpk00628@fpt.edu.vn)
    private  int ID;
    private  String TenMucChu;
    private  String GhiChu;

    public MucThu() {
    }

    public MucThu(int ID, String TenMucChi, String GhiChu) {
        this.GhiChu = GhiChu;
        this.ID = ID;
        this.TenMucChu = TenMucChi;
    }
    public MucThu(String TenMucChi, String GhiChu) {
        this.GhiChu = GhiChu;
        this.TenMucChu = TenMucChi;
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

    public String getTenMucChu() {
        return TenMucChu;
    }

    public void setTenMucChu(String tenMucChu) {
        TenMucChu = tenMucChu;
    }
}
