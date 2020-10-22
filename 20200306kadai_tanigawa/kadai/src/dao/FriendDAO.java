package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Friend;

public class FriendDAO {

	public boolean update(Friend friend){




		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kadai?useUnicode=true&characterEncoding=utf8","root","root")){

//			System.out.println(name + age + address);
		String sql =  "UPDATE FRIEND SET NAME = ? ,AGE = ? ,ADDRESS = ? WHERE FRIEND.ID = ?";
//				String sql = "INSERT INTO FRIEND (ID, NAME, AGE, ADDRESS) VALUES (NULL, '" + name + "', " + age + ", '" + address + "')";
		System.out.println(sql);
		PreparedStatement pStmt = conn.prepareStatement(sql);

		pStmt.setString(1, friend.getName());
		pStmt.setInt(2, friend.getAge());
		pStmt.setString(3, friend.getAddress());
		pStmt.setInt(4, friend.getId());

		int result = pStmt.executeUpdate();

		if(result == 1){
			return true;
		}else{
			return false;
		}



		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}




	}

}
