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
import beans.Criminal;
import utils.PoliceUtils;

/**
 * Servlet implementation class UpdateCriminal
 */
@WebServlet("/UpdateCriminal")
public class UpdateCriminal extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int crid = Integer.parseInt(request.getParameter("crid"));
		String crname = request.getParameter("crname");
		String crime = request.getParameter("crime");
		String description = request.getParameter("description");
		String identification = request.getParameter("identification");
			
		
		Criminal c = new Criminal(crid,crname,crime,description,identification);
		
		PoliceUtils u = new PoliceUtils();
		if(u.UpdateCriminal(c)){
			HttpSession session = request.getSession(false);
			if(session != null)
				session.removeAttribute("c");
			request.setAttribute("action", "StudentUpdation");
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
