package session2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class SetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SetSession() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String s1=request.getParameter("book1");
		String s2=request.getParameter("book2");
		String s3=request.getParameter("book3");
		
		HttpSession hs=request.getSession();
		hs.setAttribute("book1", s1);
		hs.setAttribute("book2", s2);
		hs.setAttribute("book3", s3);
		PrintWriter pw=response.getWriter();
		pw.println("<html> <body bgcolor=black text=red ><center>");
		pw.println("<h1> Your Books Are Added To Cart</h1>");
		pw.println("<a href=get> Next</a>");
		pw.println("</center> </body> </html>");
	}

}
