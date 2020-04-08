package servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Complaint;
import utils.CitizenUtils;


/**
 * Servlet implementation class CheckStatusServlet
 */
@WebServlet("/CheckStatusServlet")
public class CheckStatusServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int coid = Integer.parseInt(request.getParameter("coid"));
		CitizenUtils u = new CitizenUtils();
		Complaint st = u.viewStatus(coid);
		HttpSession session = request.getSession(false);
		if(session != null){
			session.setAttribute("st", st);
		}
		//request.setAttribute("st", st);
		RequestDispatcher dis = request.getRequestDispatcher("displayStatusDetails.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
