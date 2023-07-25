package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
	
	public void init(ServletConfig config) throws ServletException {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String s1=request.getParameter("uname");
			String s2=request.getParameter("pword");
			PreparedStatement pstmt=con.prepareStatement("select * from unifo where uname=? and pword=?");
			
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
						
			ResultSet rs=pstmt.executeQuery();
			PrintWriter pw=response.getWriter();
			pw.println ("<html> <body bgcolor=red text=yellow> <h1>");
			if(rs.next())
			{
				pw.println("welcome\t"+s1);
			}
			else
			{
			pw.println("Invalid Password");
			}

			pw.println("</h1> </body> </html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
