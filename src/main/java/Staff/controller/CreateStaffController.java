package Staff.controller;
import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Staff.dao.StaffDao;
//import java.sql.*;
import model.Staff;

@WebServlet("/CreateStaffController")
public class CreateStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDao staffDao;
    public CreateStaffController() {
        super();
        staffDao =new StaffDao();
    }
   // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//doPost(request,response);
   // }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Staff staff = new Staff();
		//HttpSession session = request.getSession ();
		//session.setAttribute("managerid", 0);
		Random random = new Random();
		int staffID = random.nextInt(10000000);
		staff.setStaffID(staffID);
		staff.setStaffname(request.getParameter("Staffname"));
		staff.setStaffPassword(request.getParameter("StaffPassword"));
		staff.setPhoneNum(request.getParameter("phoneNum"));
		staff.setRole(request.getParameter("role"));
		staff.setDepartment(request.getParameter("department"));
		staff.setEmailStaff(request.getParameter("EmailStaff"));
		staff.setJobPosition(request.getParameter("JobPosition"));
		staff.setStaffPassword(request.getParameter("staffPassword"));
	    System.out.println("managerid:" +  request.getParameter("managerID"));
	    String manager = request.getParameter("managerID");
		try {
			staff.setManagerID(Integer.parseInt(manager));
		} catch (Exception e) {
			staff.setManagerID(staffID);
		}
		//System.out.println(session.getAttribute("successful pass"));
		//staff.setManagerID((int)session.getAttribute("currentUser"));
	    staffDao.createStaff(staff);
		

	
	    System.out.println("print staff");
		//System.out.println(session.getAttribute("successful pass"));
	    
		//request.setAttribute("staff", StaffDao.getAllStaff((int)session.getAttribute("currentUser")));
		request.setAttribute("staff", StaffDao.getAllStaff());
		RequestDispatcher view = request.getRequestDispatcher("ListStaff.jsp");
		view.forward(request, response);
		
	}
		

		

}
