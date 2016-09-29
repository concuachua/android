package com.example.suphuy.assigmment_huyphpk00628.model;

/**
 * Created by SUPHUY on 9/19/2016.  (huyphpk00628@fpt.edu.vn) phạm hoàng huy 01293223225
 */
public class TK {
    //2 biến tạo bảng tài khoản (huyphpk00628@fpt.edu.vn)
    private int ID;
    private  String TenTK;
    private String LoaiTK;
    private  String SoTien;
    private int AvaTar;
    private  String GhiChu;

    public TK() {

    }
    public TK( String TenTK, String LoaiTK, String SoTien,  String GhiChu) {
        this.GhiChu = GhiChu;
        this.LoaiTK = LoaiTK;
        this.SoTien = SoTien;
        this.TenTK = TenTK;
    }
    public TK(int ID, String TenTK, String LoaiTK, String SoTien, int AvaTar, String GhiChu) {
        this.AvaTar = AvaTar;
        this.GhiChu = GhiChu;
        this.ID = ID;
        this.LoaiTK = LoaiTK;
        this.SoTien = SoTien;
        this.TenTK = TenTK;
    }
    public TK( String TenTK, String LoaiTK, String SoTien, int AvaTar, String GhiChu) {
        this.AvaTar = AvaTar;
        this.GhiChu = GhiChu;
        this.LoaiTK = LoaiTK;
        this.SoTien = SoTien;
        this.TenTK = TenTK;
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

    public String getLoaiTK() {
        return LoaiTK;
    }

    public void setLoaiTK(String loaiTK) {
        LoaiTK = loaiTK;
    }

    public String getSoTien() {
        return SoTien;
    }

    public void setSoTien(String soTien) {
        SoTien = soTien;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String tenTK) {
        TenTK = tenTK;
    }
}
