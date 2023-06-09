package Staff.dao;
import java.sql.*;


import java.util.*;
import connectionDB.*;
import model.Staff;



public class StaffDao {
	
	//Connection object
	Connection connection = null;
	static Connection con = null;
	static PreparedStatement ps = null;
	static java.sql.Statement st = null;
	static ResultSet rs = null;
    static int StaffID;
    static String StaffPassword, EmailStaff;
    private int managerID;
    private String staffname, phoneNum, department, JobPosition,role;
	//Staff attributes
	
	/*int StaffID;           //PK
    String Staffname;
    String StaffPassword;
    String phoneNum;
    String role;
    String department;
    String EmailStaff;
    String JobPosition;
    int managerID;  */             //FK
    
    //check staff current password
    public static Staff checkstaffpassword(Staff s) {
		StaffID = s.getStaffID();
		StaffPassword = s.getStaffPassword();
		
		try {
			//connect to db
			con = ConnectionManager.getConnection();
			//create statement
			ps=con.prepareStatement("SELECT * FROM Staff WHERE StaffID = ? AND StaffPassword = ?");
			ps.setInt(1, StaffID);
			ps.setString(2, StaffPassword);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				s.setStaffID(rs.getInt("StaffID"));
				s.setValid(true);
			}
			else {
				s.setValid(false);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
    
    //get staff by id
    public static Staff getStaffById (int StaffID) {
    	Staff s = new Staff ();
    	try {
    		//call getConnection method
    		con = ConnectionManager.getConnection();
    		//create statement
    		ps=con.prepareStatement("SELECT * FROM staff Where StaffID = ?");
    		ps.setInt(1, StaffID);
    		
    		//execute query
    		rs=ps.executeQuery();
    		if(rs.next()){
    			s.setStaffID(rs.getInt("StaffID"));
    			s.setStaffname(rs.getString("staffname"));
    			s.setPhoneNum(rs.getString("phoneNum"));
    			s.setEmailStaff(rs.getString("EmailStaff"));
     			s.setRole(rs.getString("role"));
      			s.setJobPosition(rs.getString("JobPosition"));
      			s.setDepartment(rs.getString("department"));
      			s.setManagerID(rs.getInt("managerID"));
    			s.setStaffPassword(rs.getString("StaffPassword"));
  
    		}
    		//close connection
    		con.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return s;
    }
    
    //CRUD
    //create new Staff (IT STAFF only yg create staff and manager)
    public void createStaff (Staff newStaff) {
		//get values
    	staffname = newStaff.getStaffname();
		phoneNum =newStaff.getPhoneNum();
		EmailStaff = newStaff.getEmailStaff();
		role =newStaff.getRole();
		JobPosition = newStaff.getJobPosition();
		department= newStaff.getDepartment();
		managerID = newStaff.getManagerID();
		StaffPassword = staffname.substring(0,2) + phoneNum.substring(7,10);
	
		System.out.println("successful get");
    	
    	try {
    		//get connection
    		connection = ConnectionManager.getConnection();
    		
    	
    		//Prepare SQL Statement
    		
    		PreparedStatement createStaffSQL = connection.prepareStatement
    		("Insert into staff(Staffname,phoneNum, EmailStaff,role, JobPosition,department,managerID,StaffPassword)Values (?,?,?,?,?,?,?,?)");
    		
    		//set values
    		createStaffSQL.setString(1, staffname);
			createStaffSQL.setString(2, phoneNum);
			createStaffSQL.setString(3, EmailStaff);
			createStaffSQL.setString(4, role);
			createStaffSQL.setString(5, JobPosition);
			createStaffSQL.setString(6, department);
			createStaffSQL.setInt(7, managerID);
			createStaffSQL.setString(8, StaffPassword);
			
			// Execute SQL
			createStaffSQL.executeUpdate();
			// Check SQL
			System.out.println("successful inserted");
			//close connection
			con.close();
				
    	} catch (Exception e) {
			e.printStackTrace();
    	}
    }
    
//get all staff
	//public static List<Staff>getAllStaff(int managerID) {
		//List<Staff> staff = new ArrayList<Staff>();
		public static List<Staff>getAllStaff() {
			List<Staff> staff = new ArrayList<Staff>();	
		try {
			//call getConnection() method
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps=con.prepareStatement("SELECT * FROM  staff WHERE managerID = ? ORDER BY StaffID");
  			//ps.setInt(1, managerID);
  			//execute query
  			rs = ps.executeQuery();
  			
  			while(rs.next()) {  //process result
  				Staff s = new Staff();
  				s.setStaffID(rs.getInt("StaffID"));
				s.setStaffname(rs.getString("Staffname"));
				s.setPhoneNum(rs.getString("phoneNum"));
			    s.setEmailStaff(rs.getString("EmailStaff"));
				s.setRole(rs.getString("role"));
				s.setJobPosition(rs.getString("JobPosition"));
				s.setDepartment(rs.getString("department"));
				//s.setManagerID(managerID);
				s.setManagerID(rs.getInt("managerID"));
				s.setStaffPassword(rs.getString("StaffPassword"));
  				staff.add(s);
  			}
  			//close connection
  			con.close();
		}catch(Exception e) {
  			e.printStackTrace();
		
	}
    
    return staff;
    
	}
	
    //update staff
    /* 1. update utk staff, 2. update utk IT staff (superadmin)*/
   /* public void UpdateStaff(Staff existingStaff, boolean isStaff) throws SQLException{
    	
    	try {
    		// Get connection
 			connection = ConnectionManager.getConnection();
 			
			// Get values (Basic attributes)
 			StaffID = existingStaff.getStaffID();
 			Staffname = existingStaff.getStaffname();
    		StaffPassword = existingStaff.getStaffPassword();
    		phoneNum = existingStaff.getPhoneNum();
    		department= existingStaff.getDepartment();
    		EmailStaff = existingStaff.getEmailStaff();
    		role = existingStaff.getRole();
    		JobPosition = existingStaff.getJobPosition();
    		managerID = existingStaff.getManagerID();
    		
    		//if updater is staff (normal staff/manager)
    		if(isStaff) {
    			
    			//if this acc is superadmin
    			if(role.equalsIgnoreCase(" Staff")) {
    				
    				//prepare SQL Statement
    				PreparedStatement updateStaffSQL = connection.prepareStatement("UPDATE staff" + "SET staffname= ?, phoneNum=?" + 
    				"department = ?, EmailStaff = ?	, role = ?, JobPosition=? "+ "WHERE managerID = ?");
    				
    				//Set? values
    				//updateStaffSQL.setString();
    			}
    			else if (role.equalsIgnoreCase("Manager")){
    				
    			}
    			else if(role.equalsIgnoreCase("Staff")) {
    				
    			}
    		}
    	
    			
   
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }*/
	//update staff
	public void updatestaff (Staff existingStaff) {
  		StaffID = existingStaff.getStaffID();
  		EmailStaff =existingStaff.getEmailStaff();
  		StaffPassword =existingStaff.getStaffPassword();
  		phoneNum =existingStaff.getPhoneNum();
  		department=existingStaff.getDepartment();
    	
    	 try {
    		 //call getConnection method
    		 con = ConnectionManager.getConnection ();
    		 
    		 //create statement
    		ps = con.prepareStatement("UPDATE staff SET EmailStaff=?, StaffPassword=?, phoneNum=?, department=? WHERE StaffID=?");
     		ps.setString(1, EmailStaff);
     		ps.setString(2, StaffPassword);
     		ps.setString(3, phoneNum);
     		ps.setString(4, department);
     		ps.setInt(5, StaffID);
    		 
     		//execute query
     		ps.executeUpdate();
     		
     		System.out.println("Successfully updated");
     		
     		//close connection
     		con.close();
     		
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }
  	}
	
	//change staff password
  	public void ChangeStaffPassword(Staff existingpass, String new_pass) {
  		StaffID = existingpass.getStaffID();
  		try {
  			//connect to db
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps = con.prepareStatement("UPDATE Staff SET StaffPassword=? WHERE StaffID=?");
  			ps.setString(1, new_pass);
  			ps.setInt(2, StaffID);
  			
  			//execute query
  			ps.executeUpdate();
  			
  			System.out.println("Successfully update password");
  			//close connection
  			con.close();
  			
  		}catch(SQLException e) {
			e.printStackTrace();
		}
  	}
  	
  	//delete staff
  	public void deletestaff (int id) {
  		try {
  			//call getConnection method
  			con= ConnectionManager.getConnection();
  			
  			//create statement
  			ps = con.prepareStatement("DELETE FROM staff where staffid=?");
  			ps.setInt(1, id);
  			
  			//execute query
  			ps.executeUpdate();
  			
  			//close connection 
  			con.close();
  		}catch (Exception e) {
  			e.printStackTrace();
  		}
  	}


}
