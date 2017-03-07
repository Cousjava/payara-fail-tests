package fish.payara.jonathan.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TooManyConnections
 */
@WebServlet({ "/TooManyConnections", "/p2" })
public class TooManyConnections extends ExtendedServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource
	DataSource ds1;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TooManyConnections() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws SQLException 
	 * @throws  
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		out.append("Served at: ").append(request.getContextPath());
		try {
			Connection conn1 = ds1.getConnection();
			out.print("Connected once...");
			Connection conn2 = ds1.getConnection();
			out.print("twice...");
			Connection conn3 = ds1.getConnection();
			out.print("third conncetion made...");
			Connection conn4 = ds1.getConnection();
			out.print("fourth...");
			Connection conn5 = ds1.getConnection();
			out.print("and fifth");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		footer();
	}

}
