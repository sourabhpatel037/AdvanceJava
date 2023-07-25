package scl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 * @param <Connection>
 */
public class MyServlet<Connection> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ServletContext sc=getServletContext();
		Connection con=(Connection)sc.getAttribute("oracle");
		PrintWriter pw=response.getWriter();
		pw.println("<html> <body bgcolor=black text=red> <h1>");
		pw.println("Connection Object Obtained Successfully");
		pw.println("</h1> </body> </html>");
	}

}
