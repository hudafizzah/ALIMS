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

@WebServlet("/ManageProfileManagerController")
public class ManageProfileManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StaffDao staffDao;   
    public ManageProfileManagerController() {
        super();
        staffDao = new StaffDao();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int StaffID = Integer.parseInt(request.getParameter("StaffID"));
		request.setAttribute("s", StaffDao.getStaffById(StaffID));
		RequestDispatcher view = request.getRequestDispatcher("UpdateManager.jsp");
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
		
		//StaffDao.updateStaffModel(staff);
		
		//Create Session
		HttpSession session = request.getSession();
		
		request.setAttribute("s", staff);
		session.setAttribute("s", staff);
		RequestDispatcher view = request.getRequestDispatcher("ManagerHomepage.jsp");
		view.forward(request, response);
	}

}
