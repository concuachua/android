package com.example.suphuy.assigmment_huyphpk00628.model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SUPHUY on 9/19/2016.  (huyphpk00628@fpt.edu.vn) phạm hoàng huy 01293223225
 */
public class Thu {
    //7 biến tạo bảng Thu (huyphpk00628@fpt.edu.vn)
    private  int ID;
    private  String TenMucThu;
    private  String VaoTaiKhoan;
    private Date NgayThu;
    private  String GhiChu;
    DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    public Thu() {
    }

    public Thu(int ID, String TenMucThu, String VaoTaiKhoan, String NgayThu, String GhiChu) {
        this.GhiChu = GhiChu;
        this.ID = ID;
        try {
            this.NgayThu = dateFormat.parse(NgayThu);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.TenMucThu = TenMucThu;
        this.VaoTaiKhoan = VaoTaiKhoan;
    }
    public Thu( String TenMucThu, String VaoTaiKhoan, String NgayThu, String GhiChu) {
        this.GhiChu = GhiChu;
        try {
            this.NgayThu = dateFormat.parse(NgayThu);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.TenMucThu = TenMucThu;
        this.VaoTaiKhoan = VaoTaiKhoan;
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

    public Date getNgayThu() {
        return NgayThu;
    }

    public void setNgayThu(Date ngayThu) {
        NgayThu = ngayThu;
    }
    public String getStringNgayThu(){
        return dateFormat.format(NgayThu);
    }
    public void setStringNgayThu(String date){
        try {
            NgayThu=dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getTenMucThu() {
        return TenMucThu;
    }

    public void setTenMucThu(String tenMucThu) {
        TenMucThu = tenMucThu;
    }

    public String getVaoTaiKhoan() {
        return VaoTaiKhoan;
    }

    public void setVaoTaiKhoan(String vaoTaiKhoan) {
        VaoTaiKhoan = vaoTaiKhoan;
    }
}
