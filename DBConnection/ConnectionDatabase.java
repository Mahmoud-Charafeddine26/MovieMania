package DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConnectionDatabase
 */
@WebServlet("/ConnectionDatabase")
public class ConnectionDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ConnectionDatabase() {
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connexion(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connexion(request, response);
	}
	
	
	public Statement connexion (HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
		Statement st = null;
		
		
		try {
			String DRIVER_JDBC = "net.ucanaccess.jdbc.UcanaccessDriver";
			Class.forName(DRIVER_JDBC);
			
			Connection	conn = DriverManager.getConnection("jdbc:ucanaccess://C://Users//mahmo//OneDrive//Desktop//MovieMania//MovieManiaDB.accdb");
			 st = conn.createStatement();
			
			return st;
	}
		catch( SQLException ex ) {
			System.err.println( "Error 404" );
			ex.printStackTrace();
			System.exit(1);
			
			} catch (ClassNotFoundException e) {
				System.err.println( "Class Driver JDBC Not Found" );
				e.printStackTrace();
			}
		return st;
}
}
