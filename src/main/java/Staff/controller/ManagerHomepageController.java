package Staff.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Staff.dao.*;

@WebServlet("/ManagerHomepageController")
public class ManagerHomepageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDao staffdao;    
    public ManagerHomepageController() {
        super();
        staffdao = new StaffDao();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		int id = (int)session.getAttribute("currentSessionUser");
		RequestDispatcher view = request.getRequestDispatcher("ManagerHomepage.jsp");
		view.forward(request, response);
		

	}

}
