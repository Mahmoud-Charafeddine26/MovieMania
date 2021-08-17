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
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
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
	ServletException{

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);

		HttpSession session = request.getSession(true);

		String Username, Password, Admin;

		
		Username= request.getParameter("username");  
		Password= request.getParameter("pwd"); 
		Admin= request.getParameter("admin");
		
		if (Admin == null) {
			Admin="No";
		}
		else if (Admin == "on") {
			Admin="Yes";
		}
		RequestDispatcher rd = null;
		ConnectionDatabase cd = new ConnectionDatabase();
		Statement st=null;

		try{
			// Add User
			st = cd.connexion(request, response);

			int rs = st.executeUpdate( "Insert into User (Username,Password,Admin)"+  
					" values('"+Username+"', '"+Password+"', '"+Admin+"')");

			st.close();
			
			rd = request.getRequestDispatcher(
					"/HomePage.jsp");	
			rd.forward(request, response);

		}
		catch( SQLException ex ) {
			System.err.println( "Erreur Query" );
			System.exit(1);
		} catch (IOException e) {
			System.err.println( "Error Connexion" );


		} 
	}
	
	
}
