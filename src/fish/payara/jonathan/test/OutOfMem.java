package fish.payara.jonathan.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutOfMem
 */
@WebServlet("/p1")
public class OutOfMem extends ExtendedServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutOfMem() {
        super();
        title = "Out of Memory Error";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		out.append("Served at: ").append(request.getContextPath());
		
		ArrayList<Integer> large = new ArrayList<Integer>();
		while (true){
			large.add(5);
		}
	}

}
