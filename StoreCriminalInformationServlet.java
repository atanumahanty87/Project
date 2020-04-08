package servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Criminal;
import utils.PoliceUtils;

/**
 * Servlet implementation class StoreCriminalInformationServlet
 */
@WebServlet("/storecriminal")
public class StoreCriminalInformationServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String crname = request.getParameter("crname");
		String crime = request.getParameter("crime");
		String description = request.getParameter("description");
		String identification = request.getParameter("identification");
		
		Criminal st = new Criminal(0,crname,crime,description,identification);
		
		PoliceUtils u = new PoliceUtils();
		
		int crid = 0;
		
		if( u.addCriminal(st)){
			
			request.setAttribute("Criminal", st);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("PoliceWelcome.jsp");
			dispatcher.forward(request, response);
			System.out.println("Success");
		}else{
			System.out.println("failed");
		}
		
	}

	}


