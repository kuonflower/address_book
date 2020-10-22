package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {

	private final String DB_PATH = "jdbc:mysql://localhost:3306/kadai";
	private final String DB_CHARACTER_ENCODING = "?useUnicode=true&characterEncoding=utf8";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public AccountDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Account findByLogin(Login login){
		Account account = null;

		//データベース接続
		try(Connection conn = DriverManager.getConnection(DB_PATH + DB_CHARACTER_ENCODING,DB_USER,DB_PASS)){
			String sql = "SELECT USERID,PASS,NAME,AGE,ADDRESS FROM userData WHERE  USERID = ? AND PASS = ?";




			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();


			if(rs.next()){

				String userId = rs.getString("userId");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("AGE");
				String address = rs.getString("ADDRESS");

				account = new Account(userId,pass,name,age,address);

			}




		}catch(SQLException e){
			e.printStackTrace();
		}
		return account;
	}
}
