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
import utils.PoliceUtils;

/**
 * Servlet implementation class ComplainUpdatePrepareServlet
 */
@WebServlet("/ComplainUpdate")
public class ComplainUpdatePrepareServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PoliceUtils u  = new PoliceUtils();
		List<Complaint> cList = u.getAllComplains();
		
		HttpSession session = request.getSession(false);
		//List<Complaint> cList = u.getAllComplains();
		session.setAttribute("cList", cList);
		RequestDispatcher dis = request.getRequestDispatcher("AllComplains.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}

