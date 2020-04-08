package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Citizen;

import utils.CitizenUtils;



/**
 * Servlet implementation class Logincitizen
 */
@WebServlet("/login")
public class Logincitizen extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		CitizenUtils u = new CitizenUtils();
		Citizen citizen = u.LoginCitizen(email, password);
		
			
		if(citizen != null){
			System.out.println("ID: "+citizen.getCid());
			HttpSession session = request.getSession();
			session.setAttribute("citizen", citizen);
			response.sendRedirect("CitizenWelcome.jsp");
			System.out.println("Login Successfully");
		}
		//if(email.equals("user") && password.equals("user@123")){
		//	HttpSession session = request.getSession();
		//session.setAttribute("c", c);
	//	response.sendRedirect("PoliceWelcome.jsp");
		//}
			else {
			response.sendRedirect("HomePage.jsp");
			System.out.println("failed");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
