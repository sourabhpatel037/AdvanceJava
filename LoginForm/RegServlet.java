package login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
   
	public void init(ServletConfig config) {
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
	
		
			
				try {
					String s1=request.getParameter("fname");
					String s2=request.getParameter("lname");
					String s3=request.getParameter("uname");
					String s4=request.getParameter("pword");
					
					PreparedStatement pstmt=con.prepareStatement("insert into unifo values(?,?,?,?)");
					pstmt.setString(1, s1);
					pstmt.setString(2, s2);
					pstmt.setString(3, s3);
					pstmt.setString(4, s4);
					pstmt.executeUpdate();

					PrintWriter pw= response.getWriter();
					pw.println("<html> <body bgcolor=red text=black> <center>");
					pw.println("<h1> You Have Registered SuccessFully </h1>");
					pw.println("<a href = login.html> Login</a>");
					pw.println("</center> </body> </html>");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
  }
}
