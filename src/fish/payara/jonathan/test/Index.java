package fish.payara.jonathan.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet({ "/Index", "/" })
public class Index extends ExtendedServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        title = "Payara Problems App";
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		out.append("Served at: ").println(request.getContextPath());
		out.println("<a href=\"/webfail/OutOfMem\">Out of Memory Error</a>&nbsp;");
		out.println("<a href=\"/webfail/TMC\">Too Many Connections</a>&nbsp;");
		footer();
	}
	

}
