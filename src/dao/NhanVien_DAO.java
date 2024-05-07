package dao;

import connectDB.ConnectionDB;
import entity.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVien_DAO {

    private Connection con;

    public NhanVien_DAO() {
        this.con = ConnectionDB.getInstance().getConnectionDB();
    }

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM NhanVien";
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien(
                        resultSet.getString("maNhanVien"),
                        resultSet.getString("hoTen"),
                        resultSet.getString("chucVu"),
                        resultSet.getString("boPhan"),
                        resultSet.getString("email"),
                        resultSet.getString("soDienThoai")
                );
                nhanVienList.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nhanVienList;
    }

    public NhanVien getNhanVienByMaNhanVien(String maNhanVien) {
        NhanVien nhanVien = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM NhanVien WHERE maNhanVien = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, maNhanVien);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nhanVien = new NhanVien(
                        resultSet.getString("maNhanVien"),
                        resultSet.getString("hoTen"),
                        resultSet.getString("chucVu"),
                        resultSet.getString("boPhan"),
                        resultSet.getString("email"),
                        resultSet.getString("soDienThoai")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nhanVien;
    }

    public NhanVien getUserByUserPassword(String username, String password) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connectDB.ConnectionDB.getInstance().connect(); // Gọi phương thức connect từ ConnectionDB
            con = connectDB.ConnectionDB.getConnectionDB();
            String query = "SELECT NV.* FROM [User] U " +
                           "JOIN NhanVien NV ON U.maNhanVien = NV.maNhanVien " +
                           "WHERE U.username = ? AND U.password = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Trả về một đối tượng NhanVien nếu có kết quả từ câu truy vấn
                return new NhanVien(
                    resultSet.getString("maNhanVien"),
                    resultSet.getString("hoTen"),
                    resultSet.getString("chucVu"),
                    resultSet.getString("boPhan"),
                    resultSet.getString("email"),
                    resultSet.getString("soDienThoai")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Trả về null nếu không tìm thấy nhân viên hoặc có lỗi xảy ra
        return null;
    }
}
