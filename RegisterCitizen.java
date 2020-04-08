package servlets;

import java.io.IOException;
import java.util.List;
import java.lang.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Citizen;
import utils.CitizenUtils;


/**
 * Servlet implementation class RegisterCitizen
 */
@WebServlet("/registration")
public class RegisterCitizen extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String cname = request.getParameter("cname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		long adharno = Long.parseLong(request.getParameter("adharno"));
		String address = request.getParameter("address");
		long mobileno = Long.parseLong(request.getParameter("mobileno"));
		
		Citizen citizen = new Citizen(0,cname,email,password,dob,adharno,address,mobileno);
		System.out.println(citizen.getCname());
		CitizenUtils u = new CitizenUtils();
		boolean flag = u.addCitizen(citizen);
		System.out.println(flag);
		if(flag){
			request.setAttribute("action", "Citizenregistration");
			request.setAttribute("result", "success");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
			System.out.println("Success..!");
		}else{
			request.setAttribute("action", "CitizenRegistration");
			request.setAttribute("result", "failed");
			RequestDispatcher dis = request.getRequestDispatcher("HomePage.jsp");
			dis.forward(request, response);
			System.out.println("Failed..!");
		}
}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
