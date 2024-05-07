package dao;

import connectDB.ConnectionDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entity.HoaDon;

public class HoaDon_Dao {

    private Connection con;

    public HoaDon_Dao() {
        con= ConnectionDB.getInstance().getConnectionDB();
    }

    // Thêm hóa đơn vào cơ sở dữ liệu
    public void themHoaDon(HoaDon hoaDon) throws SQLException {
        String sql = "INSERT INTO HoaDon(maHoaDon, ngayMua, maNhanVien, maKhachHang, tongTien) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, hoaDon.getMaHoaDon());
            LocalDate currentDate = LocalDate.now();
            ps.setDate(2, Date.valueOf(currentDate));
            ps.setString(3, hoaDon.getMaNhanVien());
            ps.setString(4, hoaDon.getMaKhachHang());
            ps.setDouble(5, hoaDon.getTongTien());
            ps.executeUpdate();
            System.out.println("Thêm hóa đơn thành công.");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm hóa đơn: " + e.getMessage());
        }
    }

    // Lấy danh sách tất cả các hóa đơn từ cơ sở dữ liệu
    public List<HoaDon> layDanhSachHoaDon() throws SQLException {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                LocalDate ngayMua = rs.getDate("ngayMua").toLocalDate(); // Chuyển đổi java.sql.Date thành LocalDate
                String maNhanVien = rs.getString("maNhanVien");
                String maKhachHang = rs.getString("maKhachHang");
                int tongTien = rs.getInt("tongTien");
                HoaDon hoaDon = new HoaDon(maHoaDon, ngayMua, maNhanVien, maKhachHang, tongTien);
                danhSachHoaDon.add(hoaDon);
            }
        }
        return danhSachHoaDon;
    }

    // Xóa hóa đơn từ cơ sở dữ liệu dựa trên mã hóa đơn
    public void xoaHoaDon(String maHoaDon) throws SQLException {
        String sql = "DELETE FROM HoaDon WHERE maHoaDon = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maHoaDon);
            ps.executeUpdate();
            System.out.println("Xóa hóa đơn thành công.");
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa hóa đơn: " + e.getMessage());
        }
    }

    // Cập nhật thông tin hóa đơn
    public void capNhatHoaDon(HoaDon hoaDon) throws SQLException {
        String sql = "UPDATE HoaDon SET ngayMua = ?, maNhanVien = ?, maKhachHang = ?, tongTien = ? WHERE maHoaDon = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(hoaDon.getNgayMua())); // Chuyển đổi LocalDate thành java.sql.Date
            ps.setString(2, hoaDon.getMaNhanVien());
            ps.setString(3, hoaDon.getMaKhachHang());
            ps.setDouble(4, hoaDon.getTongTien());
            ps.setString(5, hoaDon.getMaHoaDon());
            ps.executeUpdate();
            System.out.println("Cập nhật hóa đơn thành công.");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật hóa đơn: " + e.getMessage());
        }
    }
}
