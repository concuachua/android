package com.example.suphuy.assigmment_huyphpk00628.model;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by SUPHUY on 9/19/2016.
 */
public class ChoVay {
    //10 biến tạo bảng cho vay (huyphpk00628@fpt.edu.vn)
    private  int ID;
    private  String NguoiVay;
    private  String SoTien;
    private  Double LaiXuat;
    private Date NgayVay;
    private int KyHanTraLai;
    private Date NgayPhaiTra;
    private String GhiChu;
    private String DaTraSoTien;
    private int DaTraLai;
    DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");


    public ChoVay() {
    }

    public ChoVay(int ID, String NguoiChoVay, String SoTien, Double LaiXuat, String NgayVay, int KyHanTraLai, String NgayPhaiTra, String GhiChu, String DaTraSoTien, int DaTraLai) {
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
        this.NguoiVay = NguoiChoVay;
        this.SoTien = SoTien;
    }

    public ChoVay( String NguoiChoVay, String SoTien, Double LaiXuat, String NgayVay, int KyHanTraLai, String NgayPhaiTra, String GhiChu, String DaTraSoTien, int DaTraLai) {
        this.DaTraLai = DaTraLai;
        this.DaTraSoTien = DaTraSoTien;
        this.GhiChu = GhiChu;
        this.KyHanTraLai = KyHanTraLai;
        this.LaiXuat = LaiXuat;
        try {
            this.NgayPhaiTra = dateFormat.parse(NgayPhaiTra);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            this.NgayVay = dateFormat.parse(NgayVay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.NguoiVay = NguoiChoVay;
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

    public Double getLaiXuat() {
        return LaiXuat;
    }

    public void setLaiXuat(Double laiXuat) {
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

    public String getNguoiVay() {
        return NguoiVay;
    }

    public void setNguoiVay(String nguoiVay) {
        NguoiVay = nguoiVay;
    }

    public String getSoTien() {
        return SoTien;
    }

    public void setSoTien(String soTien) {
        SoTien = soTien;
    }
}
