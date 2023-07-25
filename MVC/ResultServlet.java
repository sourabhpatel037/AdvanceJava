package mvc2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getParameter("hno");
		int hno=Integer.parseInt(s);
		ResultDAO rdao=new ResultDAO();
		ResultBean rb=rdao.getResult(hno);
		request.setAttribute("data", rb);
		RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
		rd.forward(request, response);
	}

}
