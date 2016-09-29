package com.example.suphuy.assigmment_huyphpk00628.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.suphuy.assigmment_huyphpk00628.model.Chi;
import com.example.suphuy.assigmment_huyphpk00628.model.ChoVay;
import com.example.suphuy.assigmment_huyphpk00628.model.ChuyenKhoan;
import com.example.suphuy.assigmment_huyphpk00628.model.LoaiTK;
import com.example.suphuy.assigmment_huyphpk00628.model.MucChiCha;
import com.example.suphuy.assigmment_huyphpk00628.model.MucChiCon;
import com.example.suphuy.assigmment_huyphpk00628.model.MucThu;
import com.example.suphuy.assigmment_huyphpk00628.model.SoTietKiem;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;
import com.example.suphuy.assigmment_huyphpk00628.model.Thu;
import com.example.suphuy.assigmment_huyphpk00628.model.Vay;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 9/18/2016. (huyphpk00628@fpt.edu.vn) (motcucgach7796@gmail.com)
 */
public class SQLite extends SQLiteOpenHelper {
    private static final int  Data_Version=1;
    private static final String Data_Name="QuanLyThuChi";
    private static final String TEXT="  TEXT,";
    private static final String LaKhoaChinh=" INTEGER PRIMARY KEY, ";
    //1 biến tạo bảng tài khoản (huyphpk00628@fpt.edu.vn)
    private static final String  Table_TK="TK";
    private static final String TK_ID="ID";
    private static final String TK_TenTK="TenTK";
    private static final String TK_LoaiTK="LoaiTK";
    private static final String TK_SoTien="SoTien";
    private static final String TK_AvaTar="Avatar";
    private static final String TK_GhiChu="GhiChu";
    //2 biến tạo bảng Loai tài khoản (huyphpk00628@fpt.edu.vn)
    private static final String  Table_LoaiTK="LoaiTK";
    private static final String LoaiTK_ID="ID";
    private static final String LoaiTK_TenTK="TenLoaiTK";
    private static final String LoaiTK_AvaTar="Avatar";
    private static final String LoaiTK_GhiChu="GhiChu";
    //3 biến tạo bảng sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    private static final String  Table_SoTietKiem="SoTietKiem";
    private static final String SoTietKiem_ID="ID";
    private static final String SoTietKiem_TenSoTK="TenSoTK";
    private static final String SoTietKiem_NganHang="NganHang";
    private static final String SoTietKiem_SoTienBanDau="SoTien";
    private static final String SoTietKiem_NgayGui="NgayGui";
    private static final String SoTietKiem_NgayHetHan="NgayhetHan";
    private static final String SoTietKiem_LaiXuat="LaiXuat";
    private static final String SoTietKiem_ChuyenTuTaiKhoan="ChuyenTuTaiKhoan";
    private static final String SoTietKiem_GhiChu="GhiChu";
    private static final String SoTietKiem_NgayTatToan="TatToan";
    //4 biến tạo bảng Chi (huyphpk00628@fpt.edu.vn)
    private static final String  Table_Chi="Chi";
    private static final String Chi_ID="ID";
    private static final String Chi_TenMucChi="TenMucChi";
    private static final String Chi_TuTaiKhoan="TuTaiKhoan";
    private static final String Chi_NgayChi="NgayChi";
    private static final String Chi_ChiChoAi="ChiChoAi";
    private static final String Chi_SoTien="SoTien";
    private static final String Chi_GhiChu="GhiChu";
    //5 biến tạo bảng mục chi cha (huyphpk00628@fpt.edu.vn)
    private static final String  Table_MucChiCha="MucChiCha";
    private static final String MucChiCha_ID="ID";
    private static final String MucChiCha_TenMucChi="TenMucChi";
    private static final String MucChiCha_GhiChu="GhiChu";
    //6 biến tạo bảng mục chi con (huyphpk00628@fpt.edu.vn)
    private static final String  Table_MucChiCon="MucChiCon";
    private static final String MucChiCon_ID="ID";
    private static final String MucChiCon_TenMucChi="TenMucChi";
    private  static final  String MucChiCon_idMucChiCha ="idMucChiCha";
    private static final String MucChiCon_GhiChu="GhiChu";
    //7 biến tạo bảng Thu (huyphpk00628@fpt.edu.vn)
    private static final String  Table_Thu="Thu";
    private static final String Thu_ID="ID";
    private static final String Thu_TenMucThu="TenMucThu";
    private static final String Thu_VaoTaiKhoan="MaTK";
    private static final String Thu_NgayThu="NgayChi";
    private static final String Thu_GhiChu="ChiChu";
    //8 biến tạo bảng mục thu (huyphpk00628@fpt.edu.vn)
    private static final String  Table_MucThu="MucThu";
    private static final String MucThu_ID="ID";
    private static final String MucThu_TenMucThu="TenMucThu";
    private static final String MucThu_GhiChu="GhiChu";
    //9 biến tạo bảng vay (huyphpk00628@fpt.edu.vn)
    private static final String  Table_Vay="Vay";
    private static final String Vay_ID="ID";
    private static final String Vay_NguoiChoVay="NguoiChoVay";
    private static final String Vay_SoTien="SoTien";
    private static final String Vay_LaiXuat="LaiXuat";
    private static final String Vay_NgayVay="NgayVay";
    private static final String Vay_KyHanTraLai="HanTraLai";
    private static final String Vay_NgayPhaiTra="NgayPhaiTra";
    private static final String Vay_GhiChu="GhiChu";
    private static final String Vay_DaTraSoTien="DaTraSoTien";
    private static final String Vay_DaTraLai="DaTraLai";
    //10 biến tạo bảng cho vay (huyphpk00628@fpt.edu.vn)
    private static final String  Table_ChoVay="ChoVay";
    private static final String ChoVay_ID="ID";
    private static final String ChoVay_NguoiVay="NguoiVay";
    private static final String ChoVay_SoTien="SoTien";
    private static final String ChoVay_LaiXuat="LaiXuat";
    private static final String ChoVay_NgayVay="NgayChoVay";
    private static final String ChoVay_KyHanTraLai="HanTraLai";
    private static final String ChoVay_NgayPhaiTra="NgayPhaiLay";
    private static final String ChoVay_GhiChu="GhiChu";
    private static final String ChoVay_DaTraSoTien="DaTraSoTien";
    private static final String ChoVay_DaTraLai="DaTraLai";
    //11 biến tạo bảng chuyển khoản (huyphpk00628@fpt.edu.vn)
    private static final String  Table_ChuyenKhoan="ChuyenKhoan";
    private static final String ChuyenKhoan_ID="ID";
    private static final String ChuyenKhoan_TuTK="TuTK";
    private static final String ChuyenKhoan_VaoTK="VaoTK";
    private static final String ChuyenKhoan_NgayChuyen="NgayChuyen";
    private static final String ChuyenKhoan_SoTien="SoTien";
    private static final String ChuyenKhoan_Phi="Phi";
    private static final String ChuyenKhoan_GhiChu="GhiChu";

    public SQLite(Context context) {
        super(context, Data_Name, null, Data_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // String câu truy vấn tạo bảng tk (huyphpk00628@fpt.edu.vn)
        String Create_Table_TK = "CREATE TABLE " + Table_TK + "("
                + TK_ID + LaKhoaChinh + TK_TenTK + TEXT+TK_LoaiTK+TEXT
                + TK_SoTien + TEXT+TK_GhiChu +TEXT +TK_AvaTar+ " INTEGER)";
        // String câu truy vấn tạo bảng loại tk (huyphpk00628@fpt.edu.vn)
        String Create_Table_LoaiTK = "CREATE TABLE " + Table_LoaiTK + "("
                + LoaiTK_ID + LaKhoaChinh + LoaiTK_TenTK + TEXT
               +LoaiTK_GhiChu +TEXT +LoaiTK_AvaTar+ " INTEGER)";
        // String câu truy vấn tạo bảng sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
        String Create_Table_SoTK = "CREATE TABLE " + Table_SoTietKiem + "("
                + SoTietKiem_ID + LaKhoaChinh + SoTietKiem_TenSoTK + TEXT
                +SoTietKiem_NganHang +TEXT +SoTietKiem_SoTienBanDau+ TEXT+SoTietKiem_NgayGui + TEXT
                +SoTietKiem_NgayHetHan +TEXT +SoTietKiem_LaiXuat+ TEXT
                +SoTietKiem_ChuyenTuTaiKhoan +TEXT +SoTietKiem_GhiChu+ TEXT +SoTietKiem_NgayTatToan+" TEXT)";
        // String câu truy vấn tạo bảng  Mục chi (huyphpk00628@fpt.edu.vn)
        String Create_Table_Chi = " CREATE TABLE " + Table_Chi + "("
                + Chi_ID + LaKhoaChinh+ Chi_TenMucChi +
                TEXT + Chi_TuTaiKhoan + TEXT +Chi_NgayChi+TEXT
                +Chi_ChiChoAi +Chi_SoTien+TEXT+ TEXT+Chi_GhiChu+" TEXT )";
        // String câu truy vấn tạo bảng  mục chi cha (huyphpk00628@fpt.edu.vn)
        String Create_Table_MucChiCha = " CREATE TABLE " + Table_MucChiCha + "("
                + MucChiCha_ID + LaKhoaChinh+ MucChiCha_TenMucChi +
                TEXT + MucChiCha_GhiChu +" TEXT )";
        // String câu truy vấn tạo bảng  mục chi con  (huyphpk00628@fpt.edu.vn)
        String Create_Table_MucChiCon = " CREATE TABLE " + Table_MucChiCon + "("
                + MucChiCon_ID + LaKhoaChinh+ MucChiCon_TenMucChi +TEXT+
                MucChiCon_idMucChiCha +" INTEGER ,"+ MucChiCon_GhiChu +" TEXT )";
        // String câu truy vấn tạo bảng  thu (huyphpk00628@fpt.edu.vn)
        String Create_Table_Thu = " CREATE TABLE " + Table_Thu + "("
                + Thu_ID + LaKhoaChinh+ Thu_TenMucThu +
                TEXT+ Thu_VaoTaiKhoan +TEXT+ Thu_NgayThu +
                TEXT + Thu_GhiChu +" TEXT )";
        // String câu truy vấn tạo bảng  mục thu (huyphpk00628@fpt.edu.vn)
        String Create_Table_MucThu = " CREATE TABLE " + Table_MucThu + "("
                + MucThu_ID + LaKhoaChinh+ MucThu_TenMucThu +
                TEXT + MucThu_GhiChu +" TEXT )";
        // String câu truy vấn tạo bảng vay (huyphpk00628@fpt.edu.vn)
        String Create_Table_Vay = "CREATE TABLE " + Table_Vay + "("
                + Vay_ID + LaKhoaChinh + Vay_NguoiChoVay + TEXT
                +Vay_SoTien +TEXT +Vay_LaiXuat+ TEXT+Vay_NgayVay + TEXT
                +Vay_KyHanTraLai +TEXT +Vay_NgayPhaiTra+ TEXT
                +Vay_GhiChu +TEXT +Vay_DaTraSoTien+ TEXT +Vay_DaTraLai+" TEXT)";
        // String câu truy vấn tạo bảng cho vay (huyphpk00628@fpt.edu.vn)
        String Create_Table_ChoVay = "CREATE TABLE " + Table_ChoVay + "("
                + ChoVay_ID + LaKhoaChinh + ChoVay_NguoiVay + TEXT
                +ChoVay_SoTien +TEXT +ChoVay_LaiXuat+ TEXT+ChoVay_NgayVay + TEXT
                +ChoVay_KyHanTraLai +TEXT +ChoVay_NgayPhaiTra+ TEXT
                +ChoVay_GhiChu +TEXT +ChoVay_DaTraSoTien+ TEXT +ChoVay_DaTraLai+" TEXT)";
        // String câu truy vấn tạo bảng chuyển khoản (huyphpk00628@fpt.edu.vn)
        String Create_Table_ChuyenKhoan = "CREATE TABLE " + Table_ChuyenKhoan + "("
                + ChuyenKhoan_ID + LaKhoaChinh + ChuyenKhoan_TuTK + TEXT
                +ChuyenKhoan_VaoTK +TEXT +ChuyenKhoan_NgayChuyen+ TEXT+ChuyenKhoan_SoTien + TEXT
                +ChuyenKhoan_Phi +TEXT +ChuyenKhoan_GhiChu+" TEXT)";
        // thực hiện tạo database (huyphpk00628@fpt.edu.vn)

        sqLiteDatabase.execSQL(Create_Table_TK);
        sqLiteDatabase.execSQL(Create_Table_LoaiTK);
        sqLiteDatabase.execSQL(Create_Table_SoTK);
        sqLiteDatabase.execSQL(Create_Table_MucChiCon);
        sqLiteDatabase.execSQL(Create_Table_MucChiCha);
        sqLiteDatabase.execSQL(Create_Table_Chi);
        sqLiteDatabase.execSQL(Create_Table_Thu);
        sqLiteDatabase.execSQL(Create_Table_MucThu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_TK);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_LoaiTK);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_Chi);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_MucChiCha);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_MucChiCon);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_ChoVay);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_Vay);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_ChuyenKhoan);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_SoTietKiem);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_Thu);
        sqLiteDatabase.execSQL("DROP IF EXISTS "+ Table_MucThu);

    }
    //1 sử lý liên quan tới  tài khoản (huyphpk00628@fpt.edu.vn)
    //1 sử lý liên quan tới  tài khoản (huyphpk00628@fpt.edu.vn)
    //1 sử lý liên quan tới  tài khoản (huyphpk00628@fpt.edu.vn)
    //1 sử lý liên quan tới  tài khoản (huyphpk00628@fpt.edu.vn)
    // function thêm tài khoản (huyphpk00628@fpt.edu.vn)
    public void addTK(TK taikhoan){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TK_TenTK,taikhoan.getTenTK());
        values.put(TK_LoaiTK,taikhoan.getLoaiTK());
        values.put(TK_SoTien,taikhoan.getSoTien());
        values.put(TK_AvaTar,taikhoan.getAvaTar());
        values.put(TK_GhiChu,taikhoan.getGhiChu());
        database.insert(Table_TK,null,values);
        database.close();
    }
    // function lấy 1 tài khoản  có id (huyphpk00628@fpt.edu.vn)
    public TK gettaikhoan(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_TK+ "  where "+TK_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        TK taikhoan = null;
        if (cursor != null) {
            cursor.moveToFirst();
            taikhoan = new
                    TK(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getInt(4), cursor.getString(5));
        }
        return taikhoan;
    }
    // function lấy danh sách tài khoản  (huyphpk00628@fpt.edu.vn)
    public ArrayList<TK> GetAllTK() {
        ArrayList<TK> listTK = new ArrayList<TK>();
        String selectQuery = "SELECT  * FROM " + Table_TK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                TK taikhoan = new TK();
                taikhoan.setID(Integer.parseInt(cursor.getString(0)));
                taikhoan.setTenTK(cursor.getString(1));
                taikhoan.setLoaiTK(cursor.getString(2));
                taikhoan.setSoTien(cursor.getString(3));
                taikhoan.setAvaTar(cursor.getInt(4));
                taikhoan.setGhiChu(cursor.getString(5));
                listTK.add(taikhoan);
            } while (cursor.moveToNext());
        }
        return listTK;
    }
    // function lấy danh sách tên tài khoản  (huyphpk00628@fpt.edu.vn)
    public ArrayList<String> GetAllTenTK() {
        ArrayList<String> Ten = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Table_TK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ten.add(cursor.getString(cursor.getColumnIndex(TK_TenTK)));
            } while (cursor.moveToNext());
        }
        return Ten;
    }
    // function lấy danh sách id tài khoản  (huyphpk00628@fpt.edu.vn)
    public ArrayList<Integer> GetAllIDTK() {
        ArrayList<Integer> id = new ArrayList<Integer>();
        String selectQuery = "SELECT  * FROM " + Table_TK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                id.add(cursor.getInt(cursor.getColumnIndex(TK_ID)));
            } while (cursor.moveToNext());
        }
        return id;
    }
    // function  đếm số tài khoản (huyphpk00628@fpt.edu.vn)
    public int GetTKCount() {
        String countQuery = "SELECT  * FROM " + Table_TK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật tài khoản (huyphpk00628@fpt.edu.vn)
    public int updateTK(TK taikhoan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TK_TenTK,taikhoan.getTenTK());
        values.put(TK_LoaiTK,taikhoan.getLoaiTK());
        values.put(TK_SoTien,taikhoan.getSoTien());
        values.put(TK_AvaTar,taikhoan.getAvaTar());
        values.put(TK_GhiChu,taikhoan.getGhiChu());
        return db.update(Table_TK, values, TK_ID + " = ?",
                new String[] { String.valueOf(taikhoan.getID()) });
    }
    // function  xóa tài khoản (huyphpk00628@fpt.edu.vn)
    public void deleteTK(TK taikhoan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_TK, TK_ID + " = ?",
                new String[] { String.valueOf(taikhoan.getID()) });
        db.close();
    }

    //2 sử lý liên quan tới  loại tài khoản (huyphpk00628@fpt.edu.vn)
    //2 sử lý liên quan tới  loại tài khoản (huyphpk00628@fpt.edu.vn)
    //2 sử lý liên quan tới  loại tài khoản (huyphpk00628@fpt.edu.vn)
    //2 sử lý liên quan tới  loại tài khoản (huyphpk00628@fpt.edu.vn)
    // function thêm loai tài khoản (huyphpk00628@fpt.edu.vn)
    public void addLoaiTK(LoaiTK loaitaikhoan){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(LoaiTK_TenTK,loaitaikhoan.getTenLoaiTK());
        values.put(LoaiTK_AvaTar,loaitaikhoan.getAvaTar());
        values.put(LoaiTK_GhiChu,loaitaikhoan.getGhiChu());
        database.insert(Table_LoaiTK,null,values);
        database.close();
    }
    // function lấy 1 loai tài khoản  có id (huyphpk00628@fpt.edu.vn)
    public LoaiTK GetLoaiTaiKhoan(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_LoaiTK+ "  where "+LoaiTK_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        LoaiTK taikhoan = null;
        if (cursor != null) {
            cursor.moveToFirst();
            taikhoan = new
                    LoaiTK(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3));
        }
        return taikhoan;
    }
    // function lấy danh sách loai tài khoản  (huyphpk00628@fpt.edu.vn)
    public ArrayList<LoaiTK> GetAllLoaiTK() {
        ArrayList<LoaiTK> listTK = new ArrayList<LoaiTK>();
        String selectQuery = "SELECT  * FROM " + Table_LoaiTK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                LoaiTK ltaikhoan = new LoaiTK();
                ltaikhoan.setID(Integer.parseInt(cursor.getString(0)));
                ltaikhoan.setTenLoaiTK(cursor.getString(1));
                ltaikhoan.setAvaTar(cursor.getInt(2));
                ltaikhoan.setGhiChu(cursor.getString(3));
                listTK.add(ltaikhoan);
            } while (cursor.moveToNext());
        }
        return listTK;
    }
    // function lấy danh sách loai tên tài khoản  (huyphpk00628@fpt.edu.vn)
    public ArrayList<String> GetAllTenLoaiTK() {
        ArrayList<String> Ten = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Table_LoaiTK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ten.add(cursor.getString(cursor.getColumnIndex(LoaiTK_TenTK)));
            } while (cursor.moveToNext());
        }
        return Ten;
    }
    // function lấy danh sách id loai tài khoản  (huyphpk00628@fpt.edu.vn)
    public ArrayList<Integer> GetAllIDLoaiTaiKhoan() {
        ArrayList<Integer> id = new ArrayList<Integer>();
        String selectQuery = "SELECT  * FROM " + Table_LoaiTK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                id.add(cursor.getInt(cursor.getColumnIndex(LoaiTK_ID)));
            } while (cursor.moveToNext());
        }
        return id;
    }
    // function  đếm số loai tài khoản (huyphpk00628@fpt.edu.vn)
    public int GetLoaiTKCount() {
        String countQuery = "SELECT  * FROM " + Table_LoaiTK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật loai tài khoản (huyphpk00628@fpt.edu.vn)
    public int updateLoaiTK(LoaiTK ltaikhoan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(LoaiTK_TenTK,ltaikhoan.getTenLoaiTK());
        values.put(LoaiTK_AvaTar,ltaikhoan.getAvaTar());
        values.put(LoaiTK_GhiChu,ltaikhoan.getGhiChu());
        return db.update(Table_LoaiTK, values, LoaiTK_ID + " = ?",
                new String[] { String.valueOf(ltaikhoan.getID()) });
    }
    // function  xóa loai tài khoản (huyphpk00628@fpt.edu.vn)
    public void deleteLoaiTK(LoaiTK ltaikhoan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_LoaiTK, LoaiTK_ID + " = ?",
                new String[] { String.valueOf(ltaikhoan.getID()) });
        db.close();
    }

    //3 function sử lý bảng sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    //3 function sử lý bảng sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    //3 function sử lý bảng sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    //3 function sử lý bảng sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    //3 function sử lý bảng sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    // function thêm 1 sổ tiết kiệm (huyphpk00628@fpt.edu.vn)

    public void addSoTietKiem(SoTietKiem soTietKiem){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(SoTietKiem_TenSoTK,soTietKiem.getTenSoTK());
        values.put(SoTietKiem_NganHang,soTietKiem.getNganHang());
        values.put(SoTietKiem_SoTienBanDau,soTietKiem.getSoTienBanDau());
        values.put(SoTietKiem_NgayGui,soTietKiem.getStringNgayGui());
        values.put(SoTietKiem_NgayHetHan,soTietKiem.getStringNgayHetHan());
        values.put(SoTietKiem_LaiXuat,String.valueOf(soTietKiem.getLaiXuat()));
        values.put(SoTietKiem_ChuyenTuTaiKhoan,soTietKiem.getChuyenTuTaiKhoan());
        values.put(SoTietKiem_GhiChu,soTietKiem.getGhiChu());
        values.put(SoTietKiem_NgayTatToan,soTietKiem.getStringNgayTatToan());
        database.insert(Table_SoTietKiem,null,values);
        database.close();
    }
    // function lấy 1 sổ tiết kiệm  có id (huyphpk00628@fpt.edu.vn)
    public SoTietKiem GetSoTietKiem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_SoTietKiem+ "  where "+SoTietKiem_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        SoTietKiem soTietKiem = null;
        if (cursor != null) {
            cursor.moveToFirst();
            soTietKiem = new
                    SoTietKiem(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                  Double.valueOf(cursor.getString(6)),   cursor.getString(7),
                    cursor.getString(8), cursor.getString(9));
        }
        return soTietKiem;
    }
    // function lấy danh sách sổ tiết kiệm  (huyphpk00628@fpt.edu.vn)
    public ArrayList<SoTietKiem> GetAllSoTietKiem() {
        ArrayList<SoTietKiem> listSoTietKiem = new ArrayList<SoTietKiem>();
        String selectQuery = "SELECT  * FROM " + Table_SoTietKiem;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                SoTietKiem soTietKiem = new SoTietKiem();
                soTietKiem.setID(Integer.parseInt(cursor.getString(0)));
                soTietKiem.setTenSoTK(cursor.getString(1));
                soTietKiem.setNganHang(cursor.getString(2));
                soTietKiem.setSoTienBanDau(cursor.getString(3));
                soTietKiem.setStringNgayGui(cursor.getString(4));
                soTietKiem.setStringNgayHetHan(cursor.getString(5));
                soTietKiem.setLaiXuat(Double.valueOf(cursor.getString(6)));
                soTietKiem.setChuyenTuTaiKhoan(cursor.getString(7));
                soTietKiem.setGhiChu(cursor.getString(8));
                soTietKiem.setStringNgayTatToan(cursor.getString(9));
                listSoTietKiem.add(soTietKiem);
            } while (cursor.moveToNext());
        }
        return listSoTietKiem;
    }
    // function lấy danh sách tên sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    public ArrayList<String> GetAllTenSoTietKiem() {
        ArrayList<String> Ten = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Table_SoTietKiem;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ten.add(cursor.getString(cursor.getColumnIndex(SoTietKiem_TenSoTK)));
            } while (cursor.moveToNext());
        }
        return Ten;
    }
    // function lấy danh sách id sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    public ArrayList<Integer> GetAllIDSoTietKiem() {
        ArrayList<Integer> id = new ArrayList<Integer>();
        String selectQuery = "SELECT  * FROM " + Table_SoTietKiem;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                id.add(cursor.getInt(cursor.getColumnIndex(SoTietKiem_ID)));
            } while (cursor.moveToNext());
        }
        return id;
    }
    // function  đếm số sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    public int GetSoTietKiemCount() {
        String countQuery = "SELECT  * FROM " + Table_SoTietKiem;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    public int updateSoTietKiem(SoTietKiem soTietKiem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(SoTietKiem_TenSoTK,soTietKiem.getTenSoTK());
        values.put(SoTietKiem_NganHang,soTietKiem.getNganHang());
        values.put(SoTietKiem_SoTienBanDau,soTietKiem.getSoTienBanDau());
        values.put(SoTietKiem_NgayGui,soTietKiem.getStringNgayGui());
        values.put(SoTietKiem_NgayHetHan,soTietKiem.getStringNgayHetHan());
        values.put(SoTietKiem_LaiXuat,String.valueOf(soTietKiem.getLaiXuat()));
        values.put(SoTietKiem_ChuyenTuTaiKhoan,soTietKiem.getChuyenTuTaiKhoan());
        values.put(SoTietKiem_GhiChu,soTietKiem.getGhiChu());
        values.put(SoTietKiem_NgayTatToan,soTietKiem.getStringNgayTatToan());
        return db.update(Table_SoTietKiem, values, SoTietKiem_ID + " = ?",
                new String[] { String.valueOf(soTietKiem.getID()) });
    }
    // function  xóa sổ tiết kiệm (huyphpk00628@fpt.edu.vn)
    public void deleteSoTietKiem(SoTietKiem soTietKiem) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_SoTietKiem, SoTietKiem_ID + " = ?",
                new String[] { String.valueOf(soTietKiem.getID()) });
        db.close();
    }
    //4 function sử lý bảng Chi (huyphpk00628@fpt.edu.vn)
    //4 function sử lý bảng Chi (huyphpk00628@fpt.edu.vn)
    //4 function sử lý bảng Chi (huyphpk00628@fpt.edu.vn)
    //4 function sử lý bảng Chi (huyphpk00628@fpt.edu.vn)
    //4 function sử lý bảng Chi (huyphpk00628@fpt.edu.vn)

    // function thêm 1 sổ bảng Chi(huyphpk00628@fpt.edu.vn)

    public void addChi(Chi chi){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Chi_TenMucChi,chi.getTenMucChi());
        values.put(Chi_TuTaiKhoan,chi.getTuTaiKhoan());
        values.put(Chi_NgayChi,chi.getStringNgayChi());
        values.put(Chi_ChiChoAi,chi.getChiChoAi());
        values.put(Chi_SoTien,chi.getSoTien());
        values.put(Chi_GhiChu,chi.getGhiChu());
        database.insert(Table_Chi,null,values);
        database.close();
    }
    // function lấy 1 bảng chi có id (huyphpk00628@fpt.edu.vn)
    public Chi GetChi(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_Chi+ "  where "+Chi_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        Chi chi = null;
        if (cursor != null) {
            cursor.moveToFirst();
            chi = new
                    Chi(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6));
        }
        return chi;
    }
    // function lấy danh sách bảng chi  (huyphpk00628@fpt.edu.vn)
    public ArrayList<Chi> GetAllChi() {
        ArrayList<Chi> listChi = new ArrayList<Chi>();
        String selectQuery = "SELECT  * FROM " + Table_Chi;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Chi chi = new Chi();
                chi.setID(Integer.parseInt(cursor.getString(0)));
                chi.setTenMucChi(cursor.getString(1));
                chi.setTuTaiKhoan(cursor.getString(2));
                chi.setStringNgayChi(cursor.getString(3));
                chi.setChiChoAi(cursor.getString(4));
                chi.setSoTien(cursor.getString(5));
                chi.setGhiChu(cursor.getString(6));
                listChi.add(chi);
            } while (cursor.moveToNext());
        }
        return listChi;
    }

    // function  đếm số  bảng chi (huyphpk00628@fpt.edu.vn)
    public int GetChiCount() {
        String countQuery = "SELECT  * FROM " + Table_Chi;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật 1 bảng chi (huyphpk00628@fpt.edu.vn)
    public int updateChi(Chi chi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Chi_TenMucChi,chi.getTenMucChi());
        values.put(Chi_TuTaiKhoan,chi.getTuTaiKhoan());
        values.put(Chi_NgayChi,chi.getStringNgayChi());
        values.put(Chi_ChiChoAi,chi.getChiChoAi());
        values.put(Chi_SoTien,chi.getSoTien());
        values.put(Chi_GhiChu,chi.getGhiChu());
        return db.update(Table_Chi, values, Chi_ID + " = ?",
                new String[] { String.valueOf(chi.getID()) });
    }
    // function  xóa 1 bảng chi (huyphpk00628@fpt.edu.vn)
    public void deleteChi(Chi chi) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_Chi, Chi_ID + " = ?",
                new String[] { String.valueOf(chi.getID()) });
        db.close();
    }
    //5 function sử lý bảng mục chi cha (huyphpk00628@fpt.edu.vn)
    //5 function sử lý bảng mục chi cha (huyphpk00628@fpt.edu.vn)
    //5 function sử lý bảng mục chi cha (huyphpk00628@fpt.edu.vn)
    //5 function sử lý bảng mục chi cha (huyphpk00628@fpt.edu.vn)
    //5 function sử lý bảng mục chi cha (huyphpk00628@fpt.edu.vn)

    // function thêm 1 sổ bảng mục chi cha(huyphpk00628@fpt.edu.vn)

    public void addMucChiCha(MucChiCha mucChiCha){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MucChiCha_TenMucChi,mucChiCha.getTenMucChi());
        values.put(MucChiCha_GhiChu,mucChiCha.getGhiChu());
        database.insert(Table_MucChiCha,null,values);
        database.close();
    }
    // function lấy 1 bảng mục chi cha có id (huyphpk00628@fpt.edu.vn)
    public MucChiCha GetMucChiCha(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_MucChiCha+ "  where "+MucChiCha_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        MucChiCha mucChiCha = null;
        if (cursor != null) {
            cursor.moveToFirst();
            mucChiCha = new
                    MucChiCha(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        }
        return mucChiCha;
    }
    // function lấy danh sách bảng mục chi cha (huyphpk00628@fpt.edu.vn)
    public ArrayList<MucChiCha> GetAllMucChiCha() {
        ArrayList<MucChiCha> listMucChiCha= new ArrayList<MucChiCha>();
        String selectQuery = "SELECT  * FROM " + Table_MucChiCha;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MucChiCha mucChiCha = new MucChiCha();
                mucChiCha.setID(Integer.parseInt(cursor.getString(0)));
                mucChiCha.setTenMucChi(cursor.getString(1));
                mucChiCha.setGhiChu(cursor.getString(2));
                listMucChiCha.add(mucChiCha);
            } while (cursor.moveToNext());
        }
        return listMucChiCha;
    }

    // function  đếm số  bảng mục chi cha (huyphpk00628@fpt.edu.vn)
    public int GetMucChiChaCount() {
        String countQuery = "SELECT  * FROM " + Table_MucChiCha;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật 1 bảng mục chi cha (huyphpk00628@fpt.edu.vn)
    public int updateMucChiCha(MucChiCha mucChiCha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MucChiCha_TenMucChi,mucChiCha.getTenMucChi());
        values.put(MucChiCha_GhiChu,mucChiCha.getGhiChu());
        values.put(MucChiCha_GhiChu,mucChiCha.getGhiChu());
        return db.update(Table_MucChiCha, values, MucChiCha_ID + " = ?",
                new String[] { String.valueOf(mucChiCha.getID()) });
    }
    // function  xóa 1 bảng MucChiCha (huyphpk00628@fpt.edu.vn)
    public void deleteMucChiCha(MucChiCha mucChiCha) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_MucChiCha, MucChiCha_ID + " = ?",
                new String[] { String.valueOf(mucChiCha.getID()) });
        db.close();
    }
    // function  lấy tất cả tên bảng MucChiCha (huyphpk00628@fpt.edu.vn)
    public ArrayList<String> GetAllTenMucChiCha() {
        ArrayList<String> Ten = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Table_MucChiCha;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ten.add(cursor.getString(cursor.getColumnIndex(MucChiCha_TenMucChi)));
            } while (cursor.moveToNext());
        }
        return Ten;
    }
    // function lấy danh sách id MucChiCha  (huyphpk00628@fpt.edu.vn)
    public ArrayList<Integer> GetAllIDMucChiCha() {
        ArrayList<Integer> id = new ArrayList<Integer>();
        String selectQuery = "SELECT  * FROM " + Table_MucChiCha;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                id.add(cursor.getInt(cursor.getColumnIndex(MucChiCha_ID)));
            } while (cursor.moveToNext());
        }
        return id;
    }

    //6 function sử lý bảng mục chi con (huyphpk00628@fpt.edu.vn)
    //6 function sử lý bảng mục chi con (huyphpk00628@fpt.edu.vn)
    //6 function sử lý bảng mục chi con (huyphpk00628@fpt.edu.vn)
    //6 function sử lý bảng mục chi con (huyphpk00628@fpt.edu.vn)
    //6 function sử lý bảng mục chi con (huyphpk00628@fpt.edu.vn)



    public void addMucChiCon(MucChiCon mucChiCon){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MucChiCon_TenMucChi,mucChiCon.getTenMucChi());
        values.put(MucChiCon_idMucChiCha,mucChiCon.getMucChiCha());
        values.put(MucChiCon_GhiChu,mucChiCon.getGhiChu());
        database.insert(Table_MucChiCon,null,values);
        database.close();
    }
    // function lấy 1 bảng mục chi con có id (huyphpk00628@fpt.edu.vn)
    public MucChiCon GetMucChiCon(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_MucChiCon+ "  where "+MucChiCon_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        MucChiCon MucChiCon = null;
        if (cursor != null) {
            cursor.moveToFirst();
            MucChiCon = new
                    MucChiCon(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)
                    , cursor.getString(3));
        }
        return MucChiCon;
    }
    // function lấy danh sách bảng mục chi con (huyphpk00628@fpt.edu.vn)
    public ArrayList<MucChiCon> GetAllMucChiCon() {
        ArrayList<MucChiCon> listMucChiCon = new ArrayList<MucChiCon>();
        String selectQuery = "SELECT  * FROM " + Table_MucChiCon;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MucChiCon mucChiCon = new MucChiCon();
                mucChiCon.setID(Integer.parseInt(cursor.getString(0)));
                mucChiCon.setTenMucChi(cursor.getString(1));
                mucChiCon.setMucChiCha(cursor.getInt(2));
                mucChiCon.setTenMucChi(cursor.getString(2));
                listMucChiCon.add(mucChiCon);
            } while (cursor.moveToNext());
        }
        return listMucChiCon;
    }

    // function  đếm số  bảng mục chi con (huyphpk00628@fpt.edu.vn)
    public int GetMucChiConCount() {
        String countQuery = "SELECT  * FROM " + Table_MucChiCon;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật 1 bảng mục chi con (huyphpk00628@fpt.edu.vn)
    public int updateMucChiCon(MucChiCon MucChiCon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MucChiCon_TenMucChi,MucChiCon.getTenMucChi());
        values.put(MucChiCon_GhiChu,MucChiCon.getMucChiCha());
        values.put(MucChiCon_GhiChu,MucChiCon.getGhiChu());
        return db.update(Table_MucChiCon, values, MucChiCon_ID + " = ?",
                new String[] { String.valueOf(MucChiCon.getID()) });
    }
    // function  xóa 1 bảng MucChiCon (huyphpk00628@fpt.edu.vn)
    public void deleteMucChiCon(MucChiCon MucChiCon) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_MucChiCon, MucChiCon_ID + " = ?",
                new String[] { String.valueOf(MucChiCon.getID()) });
        db.close();
    }
    // function  lấy tất cả tên bảng MucChiCon (huyphpk00628@fpt.edu.vn)
    public ArrayList<String> GetAllTenMucChiCon() {
        ArrayList<String> Ten = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Table_MucChiCon;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ten.add(cursor.getString(cursor.getColumnIndex(MucChiCon_TenMucChi)));
            } while (cursor.moveToNext());
        }
        return Ten;
    }
    // function  lấy tất cả tên bảng MucChiCon theo mục cha (huyphpk00628@fpt.edu.vn)
    public ArrayList<String> GetAllTenMucChiConInCha(int mucchicha) {
        ArrayList<String> Ten = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Table_MucChiCon+" where "
                + MucChiCon_idMucChiCha + " = " +String.valueOf(mucchicha) ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ten.add(cursor.getString(cursor.getColumnIndex(MucChiCon_TenMucChi)));
            } while (cursor.moveToNext());
        }
        return Ten;
    }
    // function lấy danh sách id MucChiCon  (huyphpk00628@fpt.edu.vn)
    public ArrayList<Integer> GetAllIDMucChiCon() {
        ArrayList<Integer> id = new ArrayList<Integer>();
        String selectQuery = "SELECT  * FROM " + Table_MucChiCon ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                id.add(cursor.getInt(cursor.getColumnIndex(MucChiCon_ID)));
            } while (cursor.moveToNext());
        }
        return id;
    }



    //7 function sử lý bảng Thu (huyphpk00628@fpt.edu.vn)
    //7 function sử lý bảng Thu (huyphpk00628@fpt.edu.vn)
    //7 function sử lý bảng Thu (huyphpk00628@fpt.edu.vn)
    //7 function sử lý bảng Thu (huyphpk00628@fpt.edu.vn)
    //7 function sử lý bảng Thu (huyphpk00628@fpt.edu.vn)



    public void addThu(Thu thu){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Thu_TenMucThu,thu.getTenMucThu());
        values.put(Thu_VaoTaiKhoan,thu.getVaoTaiKhoan());
        values.put(Thu_NgayThu,thu.getStringNgayThu());
        values.put(Thu_GhiChu,thu.getGhiChu());
        database.insert(Table_Thu,null,values);
        database.close();
    }
    // function lấy 1 bảng mục thucó id (huyphpk00628@fpt.edu.vn)
    public Thu GetThu(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_Thu+ "  where "+Thu_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        Thu Thu = null;
        if (cursor != null) {
            cursor.moveToFirst();
            Thu = new
                    Thu(cursor.getInt(0), cursor.getString(1), cursor.getString(2)
                    , cursor.getString(3),cursor.getString(4));
        }
        return Thu;
    }
    // function lấy danh sách bảng thu (huyphpk00628@fpt.edu.vn)
    public ArrayList<Thu> GetAllThu() {
        ArrayList<Thu> listThu = new ArrayList<Thu>();
        String selectQuery = "SELECT  * FROM " + Table_Thu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Thu thu = new Thu();
                thu.setID(Integer.parseInt(cursor.getString(0)));
                thu.setTenMucThu(cursor.getString(1));
                thu.setVaoTaiKhoan(cursor.getString(2));
                thu.setStringNgayThu(cursor.getString(3));
                thu.setGhiChu(cursor.getString(4));
                listThu.add(thu);
            } while (cursor.moveToNext());
        }
        return listThu;
    }

    // function  đếm số  bảng thu(huyphpk00628@fpt.edu.vn)
    public int GetThuCount() {
        String countQuery = "SELECT  * FROM " + Table_Thu;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật 1 bảng mục thu (huyphpk00628@fpt.edu.vn)
    public int updateThu(Thu thu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Thu_TenMucThu,thu.getTenMucThu());
        values.put(Thu_VaoTaiKhoan,thu.getVaoTaiKhoan());
        values.put(Thu_NgayThu,thu.getStringNgayThu());
        values.put(Thu_GhiChu,thu.getGhiChu());
        return db.update(Table_Thu, values, Thu_ID + " = ?",
                new String[] { String.valueOf(thu.getID()) });
    }
    // function  xóa 1 bảng Thu (huyphpk00628@fpt.edu.vn)
    public void deleteThu(Thu thu) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_Thu, Thu_ID + " = ?",
                new String[] { String.valueOf(thu.getID()) });
        db.close();
    }
    // function  lấy tất cả tên bảng Thu (huyphpk00628@fpt.edu.vn)
    public ArrayList<String> GetAllTenThu() {
        ArrayList<String> Ten = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Table_Thu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ten.add(cursor.getString(cursor.getColumnIndex(Thu_TenMucThu)));
            } while (cursor.moveToNext());
        }
        return Ten;
    }
    // function lấy danh sách id Thu  (huyphpk00628@fpt.edu.vn)
    public ArrayList<Integer> GetAllIDThu() {
        ArrayList<Integer> id = new ArrayList<Integer>();
        String selectQuery = "SELECT  * FROM " + Table_Thu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                id.add(cursor.getInt(cursor.getColumnIndex(Thu_ID)));
            } while (cursor.moveToNext());
        }
        return id;
    }


    //8 function sử lý bảng mục MucThu (huyphpk00628@fpt.edu.vn)
    //8 function sử lý bảng mục MucThu (huyphpk00628@fpt.edu.vn)
    //8 function sử lý bảng mục MucThu (huyphpk00628@fpt.edu.vn)
    //8 function sử lý bảng mục MucThu (huyphpk00628@fpt.edu.vn)


    public void addMucThu(MucThu mucThu){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MucThu_TenMucThu,mucThu.getTenMucChu());
        values.put(MucThu_GhiChu,mucThu.getGhiChu());
        database.insert(Table_MucThu,null,values);
        database.close();
    }
    // function lấy 1 bảng mục MucThucó id (huyphpk00628@fpt.edu.vn)
    public MucThu GetMucThu(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_MucThu+ "  where "+MucThu_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        MucThu MucThu = null;
        if (cursor != null) {
            cursor.moveToFirst();
            MucThu = new
                    MucThu(cursor.getInt(0), cursor.getString(1), cursor.getString(2)
                  );
        }
        return MucThu;
    }
    // function lấy danh sách bảng MucThu (huyphpk00628@fpt.edu.vn)
    public ArrayList<MucThu> GetAllMucThu() {
        ArrayList<MucThu> listMucThu = new ArrayList<MucThu>();
        String selectQuery = "SELECT  * FROM " + Table_MucThu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MucThu mucThu = new MucThu();
                mucThu.setID(Integer.parseInt(cursor.getString(0)));
                mucThu.setTenMucChu(cursor.getString(1));
                mucThu.setGhiChu(cursor.getString(2));
                listMucThu.add(mucThu);
            } while (cursor.moveToNext());
        }
        return listMucThu;
    }

    // function  đếm số  bảng MucThu(huyphpk00628@fpt.edu.vn)
    public int GetMucThuCount() {
        String countQuery = "SELECT  * FROM " + Table_MucThu;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật 1 bảng mục MucThu (huyphpk00628@fpt.edu.vn)
    public int updateMucThu(MucThu mucThu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MucThu_TenMucThu,mucThu.getTenMucChu());
        values.put(MucThu_GhiChu,mucThu.getGhiChu());
        return db.update(Table_MucThu, values, MucThu_ID + " = ?",
                new String[] { String.valueOf(mucThu.getID()) });
    }
    // function  xóa 1 bảng MucThu (huyphpk00628@fpt.edu.vn)
    public void deleteMucThu(MucThu mucThu) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_MucThu, MucThu_ID + " = ?",
                new String[] { String.valueOf(mucThu.getID()) });
        db.close();
    }
    // function  lấy tất cả tên bảng MucThu (huyphpk00628@fpt.edu.vn)
    public ArrayList<String> GetAllTenMucThu() {
        ArrayList<String> Ten = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + Table_MucThu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ten.add(cursor.getString(cursor.getColumnIndex(MucThu_TenMucThu)));
            } while (cursor.moveToNext());
        }
        return Ten;
    }
    // function lấy danh sách id MucThu  (huyphpk00628@fpt.edu.vn)
    public ArrayList<Integer> GetAllIDMucThu() {
        ArrayList<Integer> id = new ArrayList<Integer>();
        String selectQuery = "SELECT  * FROM " + Table_MucThu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                id.add(cursor.getInt(cursor.getColumnIndex(MucThu_ID)));
            } while (cursor.moveToNext());
        }
        return id;
    }

    //9 function sử lý bảng mục Vay (huyphpk00628@fpt.edu.vn)
    //9 function sử lý bảng mục Vay (huyphpk00628@fpt.edu.vn)
    //9 function sử lý bảng mục Vay (huyphpk00628@fpt.edu.vn)
    //9 function sử lý bảng mục Vay (huyphpk00628@fpt.edu.vn)


    public void addVay(Vay vay){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Vay_NguoiChoVay,vay.getNguoiChoVay());
        values.put(Vay_SoTien,vay.getSoTien());
        values.put(Vay_LaiXuat,String.valueOf(vay.getLaiXuat()));
        values.put(Vay_NgayVay,vay.getStringNgayVay());
        values.put(Vay_KyHanTraLai,String.valueOf(vay.getKyHanTraLai()));
        values.put(Vay_NgayPhaiTra,vay.getStringNgayPhaiTra());
        values.put(Vay_GhiChu,vay.getGhiChu());
        values.put(Vay_DaTraSoTien,vay.getDaTraSoTien());
        values.put(Vay_DaTraLai,String.valueOf(vay.getDaTraLai()));
        database.insert(Table_Vay,null,values);
        database.close();
    }
    // function lấy 1 bảng mục Vay có id (huyphpk00628@fpt.edu.vn)
    public Vay GetVay(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_Vay+ "  where "+Vay_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        Vay vay = null;
        if (cursor != null) {
            cursor.moveToFirst();
            vay = new Vay();
            vay.setID(Integer.parseInt(cursor.getString(0)));
            vay.setNguoiChoVay(cursor.getString(1));
            vay.setSoTien(cursor.getString(2));
            vay.setLaiXuat(Double.valueOf(cursor.getString(3)));
            vay.setStringNgayVay(cursor.getString(4));
            vay.setKyHanTraLai(Integer.valueOf(cursor.getString(5)));
            vay.setStringNgayPhaiTra(cursor.getString(6));
            vay.setGhiChu(cursor.getString(7));
            vay.setDaTraSoTien(cursor.getString(8));
            vay.setDaTraLai(Integer.valueOf(cursor.getString(9)));

        }
        return vay;
    }
    // function lấy danh sách bảng Vay (huyphpk00628@fpt.edu.vn)
    public ArrayList<Vay> GetAllVay() {
        ArrayList<Vay> listVay = new ArrayList<Vay>();
        String selectQuery = "SELECT  * FROM " + Table_Vay;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                Vay vay = new Vay();
                vay.setID(Integer.parseInt(cursor.getString(0)));
                vay.setNguoiChoVay(cursor.getString(1));
                vay.setSoTien(cursor.getString(2));
                vay.setLaiXuat(Double.valueOf(cursor.getString(3)));
                vay.setStringNgayVay(cursor.getString(4));
                vay.setKyHanTraLai(Integer.valueOf(cursor.getString(5)));
                vay.setStringNgayPhaiTra(cursor.getString(6));
                vay.setGhiChu(cursor.getString(7));
                vay.setDaTraSoTien(cursor.getString(8));
                vay.setDaTraLai(Integer.valueOf(cursor.getString(9)));
                listVay.add(vay);
            } while (cursor.moveToNext());
        }
        return listVay;
    }

    // function  đếm số  bảng Vay(huyphpk00628@fpt.edu.vn)
    public int GetVayCount() {
        String countQuery = "SELECT  * FROM " + Table_Vay;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật 1 bảng mục Vay (huyphpk00628@fpt.edu.vn)
    public int updateVay(Vay vay) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Vay_NguoiChoVay,vay.getNguoiChoVay());
        values.put(Vay_SoTien,vay.getSoTien());
        values.put(Vay_LaiXuat,String.valueOf(vay.getLaiXuat()));
        values.put(Vay_NgayVay,vay.getStringNgayVay());
        values.put(Vay_KyHanTraLai,String.valueOf(vay.getKyHanTraLai()));
        values.put(Vay_NgayPhaiTra,vay.getStringNgayPhaiTra());
        values.put(Vay_GhiChu,vay.getGhiChu());
        values.put(Vay_DaTraSoTien,vay.getDaTraSoTien());
        values.put(Vay_DaTraLai,String.valueOf(vay.getDaTraLai()));
        return db.update(Table_Vay, values, Vay_ID + " = ?",
                new String[] { String.valueOf(vay.getID()) });
    }
    // function  xóa 1 bảng Vay (huyphpk00628@fpt.edu.vn)
    public void deleteVay(Vay Vay) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_Vay, Vay_ID + " = ?",
                new String[] { String.valueOf(Vay.getID()) });
        db.close();
    }


//10 function sử lý bảng mục ChoVay (huyphpk00628@fpt.edu.vn)
    //10 function sử lý bảng mục ChoVay (huyphpk00628@fpt.edu.vn)
    //10 function sử lý bảng mục ChoVay (huyphpk00628@fpt.edu.vn)
    //10 function sử lý bảng mục ChoVay (huyphpk00628@fpt.edu.vn)


    public void addChoVay(ChoVay choVay){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ChoVay_NguoiVay,choVay.getNguoiVay());
        values.put(ChoVay_SoTien,choVay.getSoTien());
        values.put(ChoVay_LaiXuat,String.valueOf(choVay.getLaiXuat()));
        values.put(ChoVay_NgayVay,choVay.getStringNgayVay());
        values.put(ChoVay_KyHanTraLai,String.valueOf(choVay.getKyHanTraLai()));
        values.put(ChoVay_NgayPhaiTra,choVay.getStringNgayPhaiTra());
        values.put(ChoVay_GhiChu,choVay.getGhiChu());
        values.put(ChoVay_DaTraSoTien,choVay.getDaTraSoTien());
        values.put(ChoVay_DaTraLai,String.valueOf(choVay.getDaTraLai()));
        database.insert(Table_ChoVay,null,values);
        database.close();
    }
    // function lấy 1 bảng mục ChoVay có id (huyphpk00628@fpt.edu.vn)
    public ChoVay GetChoVay(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_ChoVay+ "  where "+ChoVay_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        ChoVay ChoVay = null;
        if (cursor != null) {
            cursor.moveToFirst();
            ChoVay = new ChoVay();
            ChoVay.setID(Integer.parseInt(cursor.getString(0)));
            ChoVay.setNguoiVay(cursor.getString(1));
            ChoVay.setSoTien(cursor.getString(2));
            ChoVay.setLaiXuat(Double.valueOf(cursor.getString(3)));
            ChoVay.setStringNgayVay(cursor.getString(4));
            ChoVay.setKyHanTraLai(Integer.valueOf(cursor.getString(5)));
            ChoVay.setStringNgayPhaiTra(cursor.getString(6));
            ChoVay.setGhiChu(cursor.getString(7));
            ChoVay.setDaTraSoTien(cursor.getString(8));
            ChoVay.setDaTraLai(Integer.valueOf(cursor.getString(9)));

        }
        return ChoVay;
    }
    // function lấy danh sách bảng ChoVay (huyphpk00628@fpt.edu.vn)
    public ArrayList<ChoVay> GetAllChoVay() {
        ArrayList<ChoVay> listChoVay = new ArrayList<ChoVay>();
        String selectQuery = "SELECT  * FROM " + Table_ChoVay;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                ChoVay ChoVay = new ChoVay();
                ChoVay.setID(Integer.parseInt(cursor.getString(0)));
                ChoVay.setNguoiVay(cursor.getString(1));
                ChoVay.setSoTien(cursor.getString(2));
                ChoVay.setLaiXuat(Double.valueOf(cursor.getString(3)));
                ChoVay.setStringNgayVay(cursor.getString(4));
                ChoVay.setKyHanTraLai(Integer.valueOf(cursor.getString(5)));
                ChoVay.setStringNgayPhaiTra(cursor.getString(6));
                ChoVay.setGhiChu(cursor.getString(7));
                ChoVay.setDaTraSoTien(cursor.getString(8));
                ChoVay.setDaTraLai(Integer.valueOf(cursor.getString(9)));
                listChoVay.add(ChoVay);
            } while (cursor.moveToNext());
        }
        return listChoVay;
    }

    // function  đếm số  bảng ChoVay(huyphpk00628@fpt.edu.vn)
    public int GetChoVayCount() {
        String countQuery = "SELECT  * FROM " + Table_ChoVay;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật 1 bảng mục ChoVay (huyphpk00628@fpt.edu.vn)
    public int updateChoVay(ChoVay choVay) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ChoVay_NguoiVay,choVay.getNguoiVay());
        values.put(ChoVay_SoTien,choVay.getSoTien());
        values.put(ChoVay_LaiXuat,String.valueOf(choVay.getLaiXuat()));
        values.put(ChoVay_NgayVay,choVay.getStringNgayVay());
        values.put(ChoVay_KyHanTraLai,String.valueOf(choVay.getKyHanTraLai()));
        values.put(ChoVay_NgayPhaiTra,choVay.getStringNgayPhaiTra());
        values.put(ChoVay_GhiChu,choVay.getGhiChu());
        values.put(ChoVay_DaTraSoTien,choVay.getDaTraSoTien());
        values.put(ChoVay_DaTraLai,String.valueOf(choVay.getDaTraLai()));
        return db.update(Table_ChoVay, values, ChoVay_ID + " = ?",
                new String[] { String.valueOf(choVay.getID()) });
    }
    // function  xóa 1 bảng ChoVay (huyphpk00628@fpt.edu.vn)
    public void deleteChoVay(ChoVay choVay) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_ChoVay, ChoVay_ID + " = ?",
                new String[] { String.valueOf(choVay.getID()) });
        db.close();
    }



    //11 function sử lý bảng mục chuyển khoản (huyphpk00628@fpt.edu.vn)
    //11 function sử lý bảng mục chuyển khoản (huyphpk00628@fpt.edu.vn)
    //11 function sử lý bảng mục chuyển khoản (huyphpk00628@fpt.edu.vn)
    //11 function sử lý bảng mục chuyển khoản (huyphpk00628@fpt.edu.vn)



    public void addChuyenKhoan(ChuyenKhoan chuyenKhoan){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ChuyenKhoan_TuTK,chuyenKhoan.getTuTK());
        values.put(ChuyenKhoan_VaoTK,chuyenKhoan.getVaoTK());
        values.put(ChuyenKhoan_NgayChuyen,String.valueOf(chuyenKhoan.getNgayChuyen()));
        values.put(ChuyenKhoan_SoTien,chuyenKhoan.getSoTien());
        values.put(ChuyenKhoan_Phi,chuyenKhoan.getPhi());
        values.put(ChuyenKhoan_GhiChu,chuyenKhoan.getGhiChu());
        database.insert(Table_ChuyenKhoan,null,values);
        database.close();
    }
    // function lấy 1 bảng mục ChuyenKhoan có id (huyphpk00628@fpt.edu.vn)
    public ChuyenKhoan GetChuyenKhoan(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + Table_ChuyenKhoan+ "  where "+ChuyenKhoan_ID+" ="+ String.valueOf(id);
        Cursor cursor=db.rawQuery(selectQuery,null);
        ChuyenKhoan chuyenKhoan = null;
        if (cursor != null) {
            cursor.moveToFirst();
            chuyenKhoan = new ChuyenKhoan();
            chuyenKhoan.setID(Integer.parseInt(cursor.getString(0)));
            chuyenKhoan.setTuTK(cursor.getString(1));
            chuyenKhoan.setVaoTK(cursor.getString(2));
            chuyenKhoan.setStringNgayChuyen(cursor.getString(3));
            chuyenKhoan.setSoTien(cursor.getString(4));
            chuyenKhoan.setPhi(cursor.getString(5));
            chuyenKhoan.setGhiChu(cursor.getString(6));
        }
        return chuyenKhoan;
    }
    // function lấy danh sách bảng ChuyenKhoan (huyphpk00628@fpt.edu.vn)
    public ArrayList<ChuyenKhoan> GetAllChuyenKhoan() {
        ArrayList<ChuyenKhoan> listChuyenKhoan = new ArrayList<ChuyenKhoan>();
        String selectQuery = "SELECT  * FROM " + Table_ChuyenKhoan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                ChuyenKhoan chuyenKhoan = new ChuyenKhoan();
                chuyenKhoan = new ChuyenKhoan();
                chuyenKhoan.setID(Integer.parseInt(cursor.getString(0)));
                chuyenKhoan.setTuTK(cursor.getString(1));
                chuyenKhoan.setVaoTK(cursor.getString(2));
                chuyenKhoan.setStringNgayChuyen(cursor.getString(3));
                chuyenKhoan.setSoTien(cursor.getString(4));
                chuyenKhoan.setPhi(cursor.getString(5));
                chuyenKhoan.setGhiChu(cursor.getString(6));
                listChuyenKhoan.add(chuyenKhoan);
            } while (cursor.moveToNext());
        }
        return listChuyenKhoan;
    }

    // function  đếm số  bảng ChuyenKhoan(huyphpk00628@fpt.edu.vn)
    public int GetChuyenKhoanCount() {
        String countQuery = "SELECT  * FROM " + Table_ChuyenKhoan;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int dem=cursor.getCount();
        cursor.close();
        return dem ;
    }
    // function  cập nhật 1 bảng mục ChuyenKhoan (huyphpk00628@fpt.edu.vn)
    public int updateChuyenKhoan(ChuyenKhoan chuyenKhoan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ChuyenKhoan_TuTK,chuyenKhoan.getTuTK());
        values.put(ChuyenKhoan_VaoTK,chuyenKhoan.getVaoTK());
        values.put(ChuyenKhoan_NgayChuyen,String.valueOf(chuyenKhoan.getNgayChuyen()));
        values.put(ChuyenKhoan_SoTien,chuyenKhoan.getSoTien());
        values.put(ChuyenKhoan_Phi,chuyenKhoan.getPhi());
        values.put(ChuyenKhoan_GhiChu,chuyenKhoan.getGhiChu());
        return db.update(Table_ChuyenKhoan, values, ChuyenKhoan_ID + " = ?",
                new String[] { String.valueOf(chuyenKhoan.getID()) });
    }
    // function  xóa 1 bảng ChuyenKhoan (huyphpk00628@fpt.edu.vn)
    public void deleteChuyenKhoan(ChuyenKhoan ChuyenKhoan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_ChuyenKhoan, ChuyenKhoan_ID + " = ?",
                new String[] { String.valueOf(ChuyenKhoan.getID()) });
        db.close();
    }

}
