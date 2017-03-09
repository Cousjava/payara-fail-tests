package fish.payara.jonathan.test;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
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
        title = "Error 1";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		out.append("Served at: ").append(request.getContextPath());
		
		ArrayList<String> large = new ArrayList<String>();
		
		MemoryMXBean memory = ManagementFactory.getMemoryMXBean();
		MemoryUsage heap = memory.getHeapMemoryUsage();
		
		
		int maxHeap = 150*1024*1024;
		boolean cont = true;
		while(cont){
			
			if (heap.getUsed() >= maxHeap){
				cont = false;
			}
			large.add("Here's some text to go in the array");
		}
		//out.println(large.size());
	}

}
