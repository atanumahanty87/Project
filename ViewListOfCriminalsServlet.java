package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Complaint;
import beans.Criminal;
import utils.CitizenUtils;
import utils.PoliceUtils;

/**
 * Servlet implementation class ViewListOfCriminalsServlet
 */
@WebServlet("/displayAllCriminal")
public class ViewListOfCriminalsServlet extends HttpServlet {
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CitizenUtils u = new CitizenUtils();
		List<Criminal> criminalList = u.getAllCriminals();
		HttpSession session = request.getSession(false);
		if(session != null){
			session.setAttribute("criminalList", criminalList);
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("DisplayAllCriminal.jsp");
		dis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
