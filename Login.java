package Main;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.ConnectionDatabase;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		connexion(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		connexion(request, response);
	}

	public void connexion (HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);

		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;

		// Login data 
		int ID;
		String Username = request.getParameter("username");
		String Password = request.getParameter("pwd");
		String Admin = null;
		
		
		ConnectionDatabase cd = new ConnectionDatabase();
		ResultSet rs;
		Statement st=null;
		

		// User Connexion
		st = cd.connexion(request, response);
		
		try {

			rs = st.executeQuery( "SELECT * FROM User WHERE Username='" + Username + "' AND Password='" + Password + "'" );
			while (rs.next()) {
				ID = rs.getInt("ID");
				Username = rs.getString("Username");
				Password = rs.getString("Password");
				Admin = rs.getString("Admin");

			}
			rs.close();
			st.close();


		} catch (SQLException e) {
			System.out.println("DataBase Probleme");
			e.printStackTrace();
		}

		if (Admin.equals("Yes")){
			rd = request.getRequestDispatcher("Admin/HomePage.jsp");
			rd.forward(request, response);
		}
		else if (Admin.equals("No")){
			rd = request.getRequestDispatcher("User/HomePage.jsp");	
			rd.forward(request, response);

		}


	}	
}
