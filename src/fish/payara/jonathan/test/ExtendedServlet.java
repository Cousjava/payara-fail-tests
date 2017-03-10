package fish.payara.jonathan.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Extras
 */
@WebServlet("/extra")
public class ExtendedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected PrintWriter out;
    
    protected String title = "";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtendedServlet() {
        super();
        
    }

	/**
	 * @throws  
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		  // Set to expire far in the past.
		response.setHeader("Expires", "-1");

		  // Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		  // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		  // Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		
		header();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void header(){
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body>");
	}
	
	public void footer(){
		out.println("</body></html>");
	}

}
