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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Friend;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");

		if(userId == null){
			response.sendRedirect("WelcomeServlet");
		}else{




		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String x = request.getParameter("x");
		request.setAttribute("x", x);

		String address1 = request.getParameter("address");

		String age1 = request.getParameter("age");

		System.out.println(age1);

		int select = Integer.parseInt(x);

		switch(select){

		case 1:
		System.out.println("case1");


		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}



		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kadai?useUnicode=true&characterEncoding=utf8","root","root")){


			String sql = "SELECT ID,NAME,AGE,ADDRESS FROM FRIEND WHERE ADDRESS = \"" + address1 + "\"";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			List<Friend> arrayFriendAddress = new ArrayList<>();

			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				String address = rs.getString("ADDRESS");

				System.out.println(id + name + age + address);

				Friend friend = new Friend(id,name,age,address);
				arrayFriendAddress.add(friend);

			}
			HttpSession session = request.getSession();

			session.setAttribute("arrayFriendAddress", arrayFriendAddress);




		}catch(SQLException e) {
			e.printStackTrace();
		}

		break;


		case 2:
			try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kadai?useUnicode=true&characterEncoding=utf8","root","root")){


				String sql = "SELECT ID,NAME,AGE,ADDRESS FROM FRIEND WHERE " + age1 + "";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				ResultSet rs = pStmt.executeQuery();

				List<Friend> arrayFriendAddress = new ArrayList<>();

				while(rs.next()) {
					int id = rs.getInt("ID");
					String name = rs.getString("NAME");
					int age = rs.getInt("AGE");
					String address = rs.getString("ADDRESS");

					System.out.println(id + name + age + address);

					Friend friend = new Friend(id,name,age,address);
					arrayFriendAddress.add(friend);

				}
				HttpSession session = request.getSession();

				session.setAttribute("arrayFriendAddress", arrayFriendAddress);




			}catch(SQLException e) {
				e.printStackTrace();
			}



		System.out.println("case2");
		break;

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchResult.jsp");
		dispatcher.forward(request, response);
	}

}
