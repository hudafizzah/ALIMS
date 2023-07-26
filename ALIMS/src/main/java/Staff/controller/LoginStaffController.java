package Staff.controller;

import java.io.IOException;

import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Staff;
import Staff.dao.*;
import connectionDB.ConnectionManager;

@WebServlet("/LoginStaffController")
public class LoginStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginStaffController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost (request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//set content type
		response.setContentType("text/html");
		
		// Get action
				String action = request.getParameter("action");
				System.out.println(action);
	//filter action
		try {
			
			switch(action) {
			
			case "login":
				  login(request, response);
				 break;
			
			case "logout":
				  logout (request, response);
				  break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
//additional methods-------
//login
	private void login(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, SQLException, IOException{
		//get values
		String EmailStaff = request.getParameter("EmailStaff");	
		String StaffPassword = request.getParameter("StaffPassword");
		
		//Create Session
		HttpSession session = request.getSession();
		
		// Create dispatcher
		RequestDispatcher toPage = null;
		
		try {
			//get connection
			Connection connection = ConnectionManager.getConnection();
			
			// Prepare Statement - Check staff

			PreparedStatement checkStaffSQL =connection.prepareStatement
					("SELECT * FROM STAFF where EmailStaff = ? AND StaffPassword = ?");
			//set? values
			checkStaffSQL.setString(1, EmailStaff);
			checkStaffSQL.setString(2, StaffPassword);
			
			System.out.println(checkStaffSQL);
		
			//EXECUTE QUERY
			ResultSet resultStaff = checkStaffSQL.executeQuery();

			//use boolean for following action
			if(resultStaff.next()) {  
				Staff s = new Staff();
			String role = resultStaff.getString("role");
			
			session.setAttribute("currentSessionUser",resultStaff.getInt("staffID"));
			session.setAttribute("staffID", resultStaff.getInt("staffID"));
			
			//session.setAttribute("currentUser", s.getStaffID());
			//request.setAttribute("s", StaffDao.getStaffById(s.getStaffID()));
			
			//session.setAttribute("currentSessionUser", s.getManagerID());
			request.setAttribute("s", StaffDao.getStaffById(resultStaff.getInt("staffID")));
			session.setAttribute("s", StaffDao.getStaffById(resultStaff.getInt("staffID")));
			
			if(role.equalsIgnoreCase("IT Staff")){
				//redirect to IT's home page
				toPage = request.getRequestDispatcher("ITStaff Homepage.jsp");
				toPage.forward(request, response);
				//check
				System.out.println("ee");
			}
			else if (role.equalsIgnoreCase("Staff Manager")) {
		
				//redirect to manager's home page
				toPage = request.getRequestDispatcher("ManagerHomepage.jsp");
				toPage.forward(request, response);
				//check
				System.out.println("manager ada");
			}
			else if(role.equalsIgnoreCase("Staff")){
				
				//redirect to staff's home page
				toPage = request.getRequestDispatcher("NormalStaff Homepage.jsp");
				toPage.forward(request, response);
				//check
				System.out.println("ada");
			}
		
			}
			else {   //if not staff (redirect login page again)
				
				// Set status: login failed
				request.setAttribute("status", "loginfailed");
				
				// Redirect back to login page
				toPage = request.getRequestDispatcher("index.html");
				toPage.forward(request, response);
				
				// Check
				System.out.println("Login failed / Not a registered user.");
			}
			
			
		}catch (Exception e) {
				e.printStackTrace();	
			}
		}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, SQLException, IOException{
	
		// Get current session
				HttpSession session = request.getSession();
				
				// Invalidate/terminate session
				session.invalidate();
				
				// Redirect to login page
				response.sendRedirect("index.html");
	}

}
