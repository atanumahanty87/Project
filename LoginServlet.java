package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		String uname = req.getParameter("un");
		String upass = req.getParameter("up");
		
		//String sb = req.getParameter("sbmt");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		 
		if(uname.equals("user123") && upass.equals("user@123")){
			out.print("Welcome ");
		}else{
			out.print("Try Again..!");
			out.print("<a href=\"login.html\">Login Page</a>");
		}
		out.close();
	}

}
