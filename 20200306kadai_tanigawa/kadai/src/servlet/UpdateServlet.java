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
import model.UpdateFriendLogic;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
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



		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");


		String idString = request.getParameter("id");
		String name = request.getParameter("name");
		String ageString = request.getParameter("age");
		String address = request.getParameter("address");

		int id = Integer.parseInt(idString);
		int age = Integer.parseInt(ageString);

		request.setAttribute("id", id);

		System.out.println("doPost"+ id + name + age + address);

		Friend friend = new Friend(id,name,age,address);
		UpdateFriendLogic bo = new UpdateFriendLogic();
		bo.execute(friend);

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
				id = rs.getInt("ID");
				name = rs.getString("NAME");
				age = rs.getInt("AGE");
				address = rs.getString("ADDRESS");

				System.out.println(id + name + age + address);

				friend = new Friend(id,name,age,address);
				arrayFriend.add(friend);

			}
			ServletContext application = this.getServletContext();
			application.setAttribute("arrayFriend",arrayFriend);




		}catch(SQLException e) {
			e.printStackTrace();
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateResult.jsp");
		dispatcher.forward(request, response);
	}

}
