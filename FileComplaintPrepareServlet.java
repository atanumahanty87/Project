package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CitizenUtils;
import beans.Citizen;
import beans.Complaint;

/**
 * Servlet implementation class FileComplaintPrepareServlet
 */
@WebServlet("/complaintProcess")
public class FileComplaintPrepareServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int coid=Integer.parseInt(request.getParameter("coid"));
		String descr = request.getParameter("descr");
		//String codate = request.getParameter("codate");
		int cid = Integer.parseInt(request.getParameter("cid"));
		Citizen citizen = new Citizen();
		citizen.setCid(cid);
		Complaint ct = new Complaint(0,descr,null,"none",citizen);
		CitizenUtils u = new CitizenUtils();
		

		if(u.Complaint(ct)){
			System.out.println("Done");
			request.setAttribute("action", "FileComplaint");
			request.setAttribute("result", "success");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
			System.out.println("Sucess!");
			
		}else{
			request.setAttribute("action", "FileComplaint");
			request.setAttribute("result", "failed");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
			System.out.println("Failed..!"); 
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);
	}

}
