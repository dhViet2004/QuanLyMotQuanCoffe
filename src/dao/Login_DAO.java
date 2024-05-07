package dao;

import connectDB.ConnectionDB;
import entity.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_DAO {

    public Login authenticateUser(Login login) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Login authenticatedUser = null;

        try {
            ConnectionDB.getInstance().connect(); // Gọi phương thức connect từ ConnectionDB
            con = ConnectionDB.getConnectionDB();
            String query = "SELECT * FROM [User] WHERE username COLLATE SQL_Latin1_General_CP1_CS_AS = ? AND password COLLATE SQL_Latin1_General_CP1_CS_AS = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, login.getUsername()); // Không cần chuyển đổi chữ hoa/thường ở đây
            preparedStatement.setString(2, login.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // User tồn tại trong cơ sở dữ liệu
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                authenticatedUser = new Login(username, password);
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
        return authenticatedUser;
    }
}
