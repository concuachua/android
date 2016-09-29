package com.example.suphuy.assigmment_huyphpk00628.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SUPHUY on 9/19/2016.  (huyphpk00628@fpt.edu.vn) phạm hoàng huy 01293223225
 */
public class Vay {
    //9 biến tạo bảng vay (huyphpk00628@fpt.edu.vn)
    private  int ID;
    private  String NguoiChoVay;
    private  String SoTien;
    private  double LaiXuat;
    private  Date NgayVay;
    private  int KyHanTraLai;
    private Date NgayPhaiTra;
    private  String GhiChu;
    private  String DaTraSoTien;
    private  int DaTraLai;
    DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

    public Vay() {
    }

    public Vay(int ID, String NguoiChoVay, String SoTien, double LaiXuat, String NgayVay, int KyHanTraLai, String NgayPhaiTra, String GhiChu, String DaTraSoTien, int DaTraLai) {
        this.DaTraLai = DaTraLai;
        this.DaTraSoTien = DaTraSoTien;
        this.GhiChu = GhiChu;
        this.ID = ID;
        this.KyHanTraLai = KyHanTraLai;
        this.LaiXuat = LaiXuat;
        try {
            this.NgayPhaiTra = dateFormat.parse(NgayPhaiTra);
            this.NgayVay = dateFormat.parse(NgayVay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.NguoiChoVay = NguoiChoVay;
        this.SoTien = SoTien;
    }
    public Vay( String NguoiChoVay, String SoTien, double LaiXuat, String NgayVay, int KyHanTraLai, String NgayPhaiTra, String GhiChu, String DaTraSoTien, int DaTraLai) {
        this.DaTraLai = DaTraLai;
        this.DaTraSoTien = DaTraSoTien;
        this.GhiChu = GhiChu;
        this.KyHanTraLai = KyHanTraLai;
        this.LaiXuat = LaiXuat;
        try {
            this.NgayPhaiTra = dateFormat.parse(NgayPhaiTra);
            this.NgayVay = dateFormat.parse(NgayVay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.NguoiChoVay = NguoiChoVay;
        this.SoTien = SoTien;
    }
    public int getDaTraLai() {
        return DaTraLai;
    }

    public void setDaTraLai(int daTraLai) {
        DaTraLai = daTraLai;
    }

    public String getDaTraSoTien() {
        return DaTraSoTien;
    }

    public void setDaTraSoTien(String daTraSoTien) {
        DaTraSoTien = daTraSoTien;
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

    public int getKyHanTraLai() {
        return KyHanTraLai;
    }

    public void setKyHanTraLai(int kyHanTraLai) {
        KyHanTraLai = kyHanTraLai;
    }

    public double getLaiXuat() {
        return LaiXuat;
    }

    public void setLaiXuat(double laiXuat) {
        LaiXuat = laiXuat;
    }

    public Date getNgayPhaiTra() {
        return NgayPhaiTra;
    }

    public void setNgayPhaiTra(Date ngayPhaiTra) {
        NgayPhaiTra = ngayPhaiTra;
    }
    public String getStringNgayPhaiTra(){
        return dateFormat.format(NgayPhaiTra);
    }
    public void setStringNgayPhaiTra(String date){
        try {
            NgayPhaiTra=dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Date getNgayVay() {
        return NgayVay;
    }

    public void setNgayVay(Date ngayVay) {
        NgayVay = ngayVay;
    }

    public String getStringNgayVay(){
        return dateFormat.format(NgayVay);
    }

    public void setStringNgayVay(String date){
        try {
            NgayVay=dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public String getNguoiChoVay() {
        return NguoiChoVay;
    }

    public void setNguoiChoVay(String nguoiChoVay) {
        NguoiChoVay = nguoiChoVay;
    }

    public String getSoTien() {
        return SoTien;
    }

    public void setSoTien(String soTien) {
        SoTien = soTien;
    }
}
