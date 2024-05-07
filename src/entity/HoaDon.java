/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author viet6
 */
public class HoaDon {
    private String maHoaDon;
    private LocalDate ngayMua;
    private String maNhanVien;
    private String maKhachHang;
    private double tongTien;

    // Constructor
    public HoaDon(String maHoaDon, LocalDate ngayMua1, String maNhanVien, String maKhachHang, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayMua = ngayMua;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.tongTien = tongTien;
    }

    // Getters
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public LocalDate getNgayMua() {
        return ngayMua;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public double getTongTien() {
        return tongTien;
    }

    // Setters (if needed)
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setNgayMua(LocalDate ngayMua) {
        this.ngayMua = ngayMua;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }


}