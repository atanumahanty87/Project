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
import beans.Complaint;
import utils.PoliceUtils;

/**
 * Servlet implementation class UpdateComplaint
 */
@WebServlet("/updateStatus")
public class UpdateComplaint extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int coid = Integer.parseInt(request.getParameter("coid"));
		String descr = request.getParameter("descr");
		String date = request.getParameter("date");
		String status = request.getParameter("status");
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		Citizen citizen = new Citizen();
		citizen.setCid(cid);
		
		Complaint ct = new Complaint(coid,descr,date,status,citizen);
		
		PoliceUtils u = new PoliceUtils();
		if(u.updateStatus(ct)){
			HttpSession session = request.getSession(false);
			if(session != null)
				session.removeAttribute("ct");
			request.setAttribute("action", "StatusUpdation");
			request.setAttribute("result", "success");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		}else{
			request.setAttribute("action", "StudentUpdation");
			request.setAttribute("result", "failed");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
