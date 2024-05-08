/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import connectDB.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import src.Enitty.ChiTietHoaDon;

/**
 *
 * @author viet6
 */
public class ChiTietHoaDon_DAO {
    private Connection con;

    public ChiTietHoaDon_DAO() {
        con= ConnectionDB.getInstance().getConnectionDB();
    }

    // Thêm hóa đơn vào cơ sở dữ liệu
    public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws SQLException {
        String sql = "INSERT INTO ChiTietHoaDon(maHoaDon, maSanPham, soLuong, gia) VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, chiTietHoaDon.getMaHoaDon());
            ps.setString(2, chiTietHoaDon.getMaSanPham());
            ps.setInt(3, chiTietHoaDon.getSoLuong());
            ps.setDouble(4, chiTietHoaDon.getGia());
            ps.executeUpdate();
            System.out.println("Thêm hóa chi tiet hoa don thanh cong.");
        } catch (SQLException e) {
            System.out.println("Loi khi them chi tiet hoa don: " + e.getMessage());
        }
    }

    // Lấy danh sách tất cả các hóa đơn từ cơ sở dữ liệu
    public List<ChiTietHoaDon> layDanhSachChiTietHoaDon() throws SQLException {
        List<ChiTietHoaDon> danhSachCTHD = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                String maSP = rs.getString("maSanPham");
                int soLuong = rs.getInt("soLuong");
                double tongTien = rs.getInt("gia");
                ChiTietHoaDon cthd = new ChiTietHoaDon( maHoaDon, maSP, soLuong, tongTien);
                danhSachCTHD.add(cthd);
            }
        }
        return danhSachCTHD;
    }
}
