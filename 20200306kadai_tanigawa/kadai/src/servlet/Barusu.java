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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Barusu
 */
@WebServlet("/Barusu")
public class Barusu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");

		if(userId == null){
			response.sendRedirect("WelcomeServlet");
		}else{



		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/barusu.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}



		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kadai?useUnicode=true&characterEncoding=utf8","root","root")){


			String sql = "DELETE FROM FRIEND";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.executeUpdate();









		}catch(SQLException e) {
			e.printStackTrace();
		}





		response.sendRedirect("MainServlet");
	}

}
