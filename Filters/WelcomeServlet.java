package filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WelcomeServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s=request.getParameter("uname");
		PrintWriter pw=response.getWriter();
		pw.println("<html> <body bgcolor=red text=white><h1>");
		pw.println("Welcome"+s);
		pw.println("</h1> </body> </html>");
	
	}

}
