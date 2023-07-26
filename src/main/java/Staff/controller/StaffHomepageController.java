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
import model.Staff;


@WebServlet("/StaffHomepageController")
public class StaffHomepageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDao staffdao; 
    public StaffHomepageController() {
        super();
        staffdao = new StaffDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		int id = (int)session.getAttribute("currentUser");
		RequestDispatcher view = request.getRequestDispatcher("NormalStaff Homepage.jsp");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Staff s = new Staff();
		//HttpSession session = request.getSession(true);
		s.setStaffID(Integer.parseInt(request.getParameter("StaffID")));
		s.setStaffname(request.getParameter("staffname"));
		s.setStaffPassword(request.getParameter("StaffPassword"));
		s.setDepartment(request.getParameter("department"));
		s.setEmailStaff(request.getParameter("EmailStaff"));
		s.setJobPosition(request.getParameter("JobPosition"));
		s.setRole(request.getParameter("role"));
		s.setManagerID(Integer.parseInt(request.getParameter("managerID")));
   
		StaffDao.updateStaff(s);
		//request.setAttribute("staff", StaffDao.getAllStaff((int)session.getAttribute("currentUser")));
		request.setAttribute("Staff", StaffDao.getAllStaff());
		RequestDispatcher view = request.getRequestDispatcher("listStaff.jsp");
		view.forward(request, response);
	}
}
