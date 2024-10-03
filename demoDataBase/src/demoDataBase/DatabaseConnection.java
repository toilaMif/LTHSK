package demoDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
//    	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection con = null;
        String url = "jdbc:sqlserver://localhost:3306;databaseName=mydb";
        String user = "sa";
        String password = "123!@#";

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

