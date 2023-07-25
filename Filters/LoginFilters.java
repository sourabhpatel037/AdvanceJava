package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class LoginFilters extends HttpFilter implements Filter {
       
   Connection con;
    public LoginFilters() {
        super();
        
    }
    public void init(FilterConfig fConfig) throws ServletException {
	     try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tigre");
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			chain.doFilter(request, response);
      String s1=request.getParameter("uname");
      String s2= request.getParameter("pword");
      java.sql.PreparedStatement pstmt=con.prepareStatement("select * from unifo where uname=? and pword=?");
      pstmt.setString(1,s1);
      pstmt.setString(2,s2);
      ResultSet rs=pstmt.executeQuery();
      if (rs.next())
      {
			   chain.doFilter(request, response);
      }
      else
      {
			   PrintWriter pw=response.getWriter();
			   pw.println("<html> <body bgcolor=black text=red> <h1>");
			   pw.println("Invalid Usename/Password");
			   pw.println("</h1> </body> </html>");
			   RequestDispatcher rd=request.getRequestDispatcher("login.html");
			   rd.include(request, response);
      }
		} catch (IOException |ServletException |SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	
	}

	public void destroy() {
        try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
