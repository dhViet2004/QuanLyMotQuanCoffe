package entity;

public class KhachHang {
    private String maKhachHang;
    private String hoTen;
    private int diemThanhVien;

    // Constructors
    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String hoTen, int diemThanhVien) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.diemThanhVien = diemThanhVien;
    }

    // Getters and setters
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getDiemThanhVien() {
        return diemThanhVien;
    }

    public void setDiemThanhVien(int diemThanhVien) {
        this.diemThanhVien = diemThanhVien;
    }

    // toString() method
    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", diemThanhVien=" + diemThanhVien +
                '}';
    }

    public Object getMaKH() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
