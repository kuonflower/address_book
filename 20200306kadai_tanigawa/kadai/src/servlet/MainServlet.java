package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Friend;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("initメゾット開始！");
////		HttpSession session = request.getSession()
////		List<Friend> arrayFriend = (List<Friend>)session.getAttribute("arrayFriend");
//
//
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}



		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kadai?useUnicode=true&characterEncoding=utf8","root","root")){


			String sql = "SELECT ID,NAME,AGE,ADDRESS FROM FRIEND";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			List<Friend> arrayFriend = new ArrayList<>();

			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				String address = rs.getString("ADDRESS");

				System.out.println(id + name + age + address);

				Friend friend = new Friend(id,name,age,address);
				arrayFriend.add(friend);

			}
			ServletContext application = this.getServletContext();
			application.setAttribute("arrayFriend",arrayFriend);




		}catch(SQLException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");

		if(userId == null){
			response.sendRedirect("WelcomeServlet");
		}else{



		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		System.out.println("doPost" + name + age + address);
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kadai?useUnicode=true&characterEncoding=utf8","root","root")){

			System.out.println(name + age + address);
		String sql =  "INSERT INTO `FRIEND` (`ID`, `NAME`, `AGE`, `ADDRESS`) VALUES (NULL, '" + name + "', '" + age + "', '"+ address +"')";
//				String sql = "INSERT INTO FRIEND (ID, NAME, AGE, ADDRESS) VALUES (NULL, '" + name + "', " + age + ", '" + address + "')";
		System.out.println(sql);
		PreparedStatement pStmt = conn.prepareStatement(sql);

		pStmt.executeUpdate();

















		}catch(SQLException e) {
			e.printStackTrace();
		}

//		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/kadai","root","root")){
//
//
//			String sql = "SELECT ID,NAME,AGE,ADDRESS FROM FRIEND";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			ResultSet rs = pStmt.executeQuery();
//
//			List<Friend> arrayFriend = new ArrayList<>();
//
//			while(rs.next()) {
//				 int id = rs.getInt("ID");
//				 name = rs.getString("NAME");
//				 int age1 = rs.getInt("AGE");
//				 address = rs.getString("ADDRESS");
//
//				System.out.println(id + name + age + address);
//
//				Friend friend = new Friend(id,name,age1,address);
//				arrayFriend.add(friend);
//
//			}
//			ServletContext application = this.getServletContext();
//			application.setAttribute("arrayFriend",arrayFriend);
//
//
//
//
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}

		doGet(request, response);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
//		dispatcher.forward(request, response);
	}

}
