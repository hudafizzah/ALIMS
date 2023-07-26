package Application.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Application.dao.ApplicationDao;

@WebServlet("/DeclineController")
public class DeclineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationDao applicationDao; 
    
    public DeclineController() {
        super();
        applicationDao =new ApplicationDao();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int appid = Integer.parseInt(request.getParameter("applicationId"));
    	applicationDao.updateApplicationStatus(appid, "Declined");
    	RequestDispatcher view = request.getRequestDispatcher("ListApplication.jsp");
		view.forward(request, response);
		
	}

	

}
