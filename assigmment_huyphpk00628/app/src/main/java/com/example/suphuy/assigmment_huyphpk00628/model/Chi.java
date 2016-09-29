package com.example.suphuy.assigmment_huyphpk00628.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SUPHUY on 9/19/2016.  (huyphpk00628@fpt.edu.vn) phạm hoàng huy 01293223225
 */
public class Chi {
    //4 biến tạo bảng Chi (huyphpk00628@fpt.edu.vn)
    private  int ID;
    private  String TenMucChi;
    private  String TuTaiKhoan;
    private Date NgayChi;
    private  String ChiChoAi;
    private  String SoTien;
    private  String GhiChu;
    DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

    public Chi() {
    }

    public Chi(int ID, String TenMucChi, String TuTaiKhoan, String NgayChi, String ChiChoAi,String SoTien, String GhiChu) {
        this.GhiChu = GhiChu;
        this.ChiChoAi = ChiChoAi;
        this.ID = ID;
        try {
            this.NgayChi = dateFormat.parse(NgayChi);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.TenMucChi = TenMucChi;
        this.SoTien=SoTien;
        this.TuTaiKhoan = TuTaiKhoan;
    }
    public Chi( String TenMucChi, String TuTaiKhoan, String NgayChi, String ChiChoAi,String SoTien, String GhiChu) {
        this.GhiChu = GhiChu;
        this.ChiChoAi = ChiChoAi;
        try {
            this.NgayChi = dateFormat.parse(NgayChi);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.TenMucChi = TenMucChi;
        this.SoTien=SoTien;

        this.TuTaiKhoan = TuTaiKhoan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String chi_GhiChu) {
        GhiChu = chi_GhiChu;
    }

    public String getChiChoAi() {
        return ChiChoAi;
    }

    public void setChiChoAi(String chiChoAi) {
        ChiChoAi = chiChoAi;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getNgayChi() {
        return NgayChi;
    }

    public void setNgayChi(Date ngayChi) {
        NgayChi = ngayChi;
    }
    public String getStringNgayChi(){
        return dateFormat.format(NgayChi);
    }
    public void setStringNgayChi(String date){
        try {
            NgayChi=dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getTenMucChi() {
        return TenMucChi;
    }

    public void setTenMucChi(String tenMucChi) {
        TenMucChi = tenMucChi;
    }

    public String getTuTaiKhoan() {
        return TuTaiKhoan;
    }

    public void setTuTaiKhoan(String tuTaiKhoan) {
        TuTaiKhoan = tuTaiKhoan;
    }

    public String getSoTien() {
        return SoTien;
    }

    public void setSoTien(String soTien) {
        SoTien = soTien;
    }
}
