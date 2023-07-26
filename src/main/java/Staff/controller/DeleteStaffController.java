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

@WebServlet("/DeleteStaffController")
public class DeleteStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDao staffDao;
    public DeleteStaffController() {
        super();
        staffDao =new StaffDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("StaffID"));
		//HttpSession session = request.getSession();
		staffDao.deletestaff(id);
		//request.setAttribute("staff", StaffDao.getAllStaff((int)session.getAttribute("currentUser")));
		request.setAttribute("staff", StaffDao.getAllStaff());
		RequestDispatcher view = request.getRequestDispatcher("ListStaff.jsp");
		view.forward(request, response);
	
	}

}
