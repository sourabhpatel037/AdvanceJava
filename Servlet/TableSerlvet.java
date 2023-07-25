package p1;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TableSerlvet
 */
public class TableSerlvet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see GenericServlet#GenericServlet()
	 */
	public TableSerlvet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		pw.println("<html> <body bgcolor=black text=orange>");
		pw.println("<table border = 10>");
		
		for(int i = 1;  i<=50; i++)
		{
			pw.println("<tr> <td> 5 </td>");
			pw.println("<td> x </td>");
			pw.println("<td>" +i+ "</td>");
			pw.println("<td> = </td>");
			pw.println("<td>" + 5*i + "</td>");
		}
		pw.println("</tr> </table> </body> </html>");
		
	}

}
