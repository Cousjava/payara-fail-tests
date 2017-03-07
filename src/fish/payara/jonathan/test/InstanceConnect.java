package fish.payara.jonathan.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InstanceConnect
 */
@WebServlet("/p3")
public class InstanceConnect extends ExtendedServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstanceConnect() {
        super();
        title = "Instance Connection";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		out.append("Served at: ").append(request.getContextPath());
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress("localhost", 28080), 10);		
		socket.close();
		footer();
	}
	
	

}
