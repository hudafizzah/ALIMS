package Application.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Application.dao.ApplicationDao;

@WebServlet("/ApproveApplicationIT")
public class ApproveControllerIT extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ApplicationDao applicationDao;
	
	public ApproveControllerIT() {
        super();
        applicationDao =new ApplicationDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int applicationId = Integer.parseInt(request.getParameter("applicationId"));
    	applicationDao.updateApplicationStatus(applicationId, "Approved");
    	RequestDispatcher view = request.getRequestDispatcher("ListApprovedApplication.jsp");
		view.forward(request, response);
    }
    
}
