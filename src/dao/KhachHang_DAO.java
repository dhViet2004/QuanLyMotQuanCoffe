package dao;

import connectDB.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.KhachHang;

public class KhachHang_DAO {
    private Connection connection;

    public KhachHang_DAO() {
        connection = ConnectionDB.getConnectionDB();
    }

    public List<KhachHang> getAllCustomers() throws SQLException {
        List<KhachHang> customers = new ArrayList<>();
        String query = "SELECT * FROM KhachHang";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                KhachHang customer = new KhachHang();
                customer.setMaKhachHang(resultSet.getString("maKhachHang"));
                customer.setHoTen(resultSet.getString("hoTen"));
                customer.setDiemThanhVien(resultSet.getInt("diemThanhVien"));
                customers.add(customer);
            }
        }
        return customers;
    }

    public void insertCustomer(KhachHang customer) throws SQLException {
        String query = "INSERT INTO KhachHang (maKhachHang, hoTen, diemThanhVien) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getMaKhachHang());
            preparedStatement.setString(2, customer.getHoTen());
            preparedStatement.setInt(3, customer.getDiemThanhVien());
            preparedStatement.executeUpdate();
        }
    }

    public void updateCustomer(KhachHang customer) throws SQLException {
        String query = "UPDATE KhachHang SET hoTen = ?, diemThanhVien = ? WHERE maKhachHang = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getHoTen());
            preparedStatement.setInt(2, customer.getDiemThanhVien());
            preparedStatement.setString(3, customer.getMaKhachHang());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteCustomer(String maKhachHang) throws SQLException {
        String query = "DELETE FROM KhachHang WHERE maKhachHang = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maKhachHang);
            preparedStatement.executeUpdate();
        }
    }
}
