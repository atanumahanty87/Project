package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.CitizenUtils;

import utils.PoliceUtils;
import beans.Complaint;


/**
 * Servlet implementation class PendingStatus
 */
@WebServlet("/PendingStatus")
public class PendingStatus extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int coid = Integer.parseInt(request.getParameter("coid"));
		PoliceUtils u = new PoliceUtils();
		Complaint ct = u.PendingComplaint();
		HttpSession session = request.getSession(false);
		if(session != null){
			session.setAttribute("ct", ct);
		}
		//request.setAttribute("st", st);
		RequestDispatcher dis = request.getRequestDispatcher("PendingStatus.jsp");
		dis.forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
