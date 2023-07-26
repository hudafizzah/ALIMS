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
@WebServlet("/ManageProfileITStaffController")
public class ManageProfileITStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StaffDao staffDao;
    public ManageProfileITStaffController() {
        super();
    staffDao = new StaffDao();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int StaffID = (int) request.getSession().getAttribute ("currentSessionUser");
		int StaffID = Integer.parseInt(request.getParameter("StaffID"));
		request.setAttribute("s", StaffDao.getStaffById(StaffID));
		RequestDispatcher view = request.getRequestDispatcher("UpdateITStaff.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("staffId"));
		String name = request.getParameter("staffName");
		String phone = request.getParameter("phoneNum");
		String email = request.getParameter("emailStaff");
		String department = request.getParameter("department");
		String job = request.getParameter("jobPosition");
		String password = request.getParameter("staffPassword");
		
		Staff staff = StaffDao.getStaffById(id);
		staff.setStaffname(name);
		staff.setPhoneNum(phone);
		staff.setEmailStaff(email);
		staff.setDepartment(department);
		staff.setJobPosition(job);
		staff.setStaffPassword(password);
		
		StaffDao.updateStaff(staff);
		
		//Create Session
		HttpSession session = request.getSession();
		
		request.setAttribute("s", staff);
		session.setAttribute("s", staff);
		RequestDispatcher view = request.getRequestDispatcher("UpdateITStaff.jsp");
		view.forward(request, response);
		
		/*
		String action = request.getParameter("action");
		Staff s = new Staff();
		
		//CONDITION IF CHANGE PASSWORD
		if(action.equalsIgnoreCase("change_pass")) {
			//TO CHANGE PASSWORD
			//s.setStaffID((int) request.getSession().getAttribute("currentSessionUser"));
			s. setStaffID(Integer.parseInt(request.getParameter("StaffID")));
			s.setStaffPassword(request.getParameter("current_pass"));
			String new_pass = request.getParameter("new_pass");
			//CHECK CURRENT PASSWORD
			s = StaffDao.checkstaffpassword(s);
			//IF PASSWORD VALID
			if(s.isValid()== true) {
				//CHANGE PASSWORD
				staffDao.ChangeStaffPassword(s, new_pass);
				s.setStaffPassword(new_pass);
			}
		}
		//CONDITION IF UPDATE PROFILE
		if(action.equalsIgnoreCase("update_profile")) {
			//TO UPDATE PROFILE
			//s.setStaffID((int) request.getSession().getAttribute("StaffID"));
	        s.setStaffID(Integer.parseInt(request.getParameter("StaffID")));
			s.setStaffname(request.getParameter("staffname"));
			s.setPhoneNum(request.getParameter("phoneNum"));
			s.setEmailStaff(request.getParameter("EmailStaff"));
			s.setStaffPassword(request.getParameter("StaffPassword"));
	
			//UPDATE PROFILE
			staffDao.updatestaff(s);
		}
		//FORWARD TO MANAGE MEMBER
		request.setAttribute("s", StaffDao.getStaffById(s.getStaffID()));
		RequestDispatcher view = request.getRequestDispatcher("UpdateITStaff.jsp");
		view.forward(request, response);
		*/
		
	}

}
