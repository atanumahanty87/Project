package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Citizen;
import beans.LoginData;
import utils.CitizenUtils;
import utils.PoliceUtils;

/**
 * Servlet implementation class PoliceLoginServlet
 */
@WebServlet("/adminlogin")
public class PoliceLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PoliceUtils u = new PoliceUtils();
		LoginData login = u.AdminLogin(email, password);
		
			
		if(login != null && login.getEmail().equals(email) && login.getPassword().equals(password)){
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			response.sendRedirect("PoliceWelcome.jsp");
			System.out.println("Login Successfully");
		}
		//if(email.equals("user") && password.equals("user@123")){
		//	HttpSession session = request.getSession();
		//session.setAttribute("c", c);
	//	response.sendRedirect("PoliceWelcome.jsp");
		//}
			else {
			HttpSession session1 = request.getSession();
			session1.setAttribute("login", login);
			response.sendRedirect("HomePage.jsp");
			System.out.println("failed");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

