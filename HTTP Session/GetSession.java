package session2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetSession() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession hs=request.getSession(false);
		String s1=(String)hs.getAttribute("book1");
		String s2=(String)hs.getAttribute("book2");
		String s3=(String)hs.getAttribute("book3");
		
		PrintWriter pw=response.getWriter();
		pw.println("<html> <body bgcolor=black text=red> <center>");
		pw.println("<h1><u> Selected Books Are</u></h1>");
		
		if(!s1.equals(null))
			pw.println(s1+"<br>");
		
		if(!s2.equals(null))
			pw.println(s2+"<br>");
		
		if(!s3.equals(null))
			pw.println(s3+"<br>");
		
        pw.println("</center> </body> </html>");
        
	}

}
