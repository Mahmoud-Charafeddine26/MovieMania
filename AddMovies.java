package Main;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.ConnectionDatabase;

/**
 * Servlet implementation class AddMovies
 */
@WebServlet("/AddMovies")
public class AddMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovies() {
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
	ServletException{
		
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);

		HttpSession session = request.getSession(true);

		
		String Name, Author, Genre, Image, Description,DurationS, RateS;
		int Duration, Rate;
		
		Name= request.getParameter("Name");  
		Author= request.getParameter("Author"); 
		Genre= request.getParameter("Genre");
		Image= request.getParameter("Image");  
		Description= request.getParameter("Description"); 
		DurationS= request.getParameter("Duration");
		RateS= request.getParameter("Rate");
		
		Duration = Integer.parseInt(DurationS);
		Rate = Integer.parseInt(RateS);
		
		System.out.println(Image+ "    "+ Duration + "     " + Rate);
		
		RequestDispatcher rd = null;
		ConnectionDatabase cd = new ConnectionDatabase();
		Statement st=null;

		try{
			// Add User
			st = cd.connexion(request, response);

			int rs = st.executeUpdate( "Insert into Movies (Name,Author,Duration,Genre,Rate, Image,Description )"+  
					" values('"+Name+"', '"+Author+"', '"+Duration+"','"+Genre+ "', '"+Rate+ "', '"+Image+"','"+Description+ "')");

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
