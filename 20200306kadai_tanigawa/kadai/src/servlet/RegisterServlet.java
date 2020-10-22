package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		System.out.println("doPost" + userId + pass + name + age + address);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kadai?useUnicode=true&characterEncoding=utf8","root","root")){

			System.out.println(name + age + address);
		String sql =  "INSERT INTO `USERDATA` (`USERID`,`PASS`, `NAME`, `AGE`, `ADDRESS`) VALUES ('" + userId + "', '" + pass + "','" + name + "', '" + age + "', '"+ address +"')";
//				String sql = "INSERT INTO FRIEND (ID, NAME, AGE, ADDRESS) VALUES (NULL, '" + name + "', " + age + ", '" + address + "')";
		System.out.println(sql);
		PreparedStatement pStmt = conn.prepareStatement(sql);

		pStmt.executeUpdate();





		}catch(SQLException e) {
			e.printStackTrace();
		}




		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerResult.jsp");
		dispatcher.forward(request, response);
	}

}
