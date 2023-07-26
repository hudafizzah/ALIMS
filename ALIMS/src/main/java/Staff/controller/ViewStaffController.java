package Staff.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Staff.dao.StaffDao;

@WebServlet("/ViewStaffController")
public class ViewStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StaffDao staffDao;
    public ViewStaffController() {
        super();
        staffDao = new StaffDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int StaffID = (int)session.getAttribute("currentSessionUser");
		//int StaffID = Integer.parseInt(request.getParameter("StaffID"));
		request.setAttribute("s",StaffDao.getStaffById(StaffID));
		RequestDispatcher view = request.getRequestDispatcher("ITStaff Homepage.jsp");
		view.forward(request, response);

	}


}
