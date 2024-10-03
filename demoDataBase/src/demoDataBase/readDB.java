package demoDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class readDB {

	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:sqlserver://LAPTOP-JRIFV9V1\\MSSQLSERVER1:1433;databaseName=mydb";

		String user = "sa";
		String password = "123!@#";

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Ket noi thanh cong");
//			String sql = "SELECT * FROM hocsinh";
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);

//			while (rs.next()) {
//				int id = rs.getInt(1);
//				String ho = rs.getString(2);
//				String ten = rs.getString("ten");
//				System.out.println("___________*____________");
//				System.out.println("id la:" + id);
//				System.out.println("ho la:" + ho);
//				System.out.println("ten la:" + ten);

//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
