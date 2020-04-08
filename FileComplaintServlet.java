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
import beans.Citizen;

@WebServlet("/FileComplaintServlet")
public class FileComplaintServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Citizen st = null;
		HttpSession session = request.getSession(false);
		if(session != null){
			st = (Citizen)session.getAttribute("st");
		}
		CitizenUtils u = new CitizenUtils();
		
			
			RequestDispatcher dis = request.getRequestDispatcher("complaint.jsp");
			dis.include(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
