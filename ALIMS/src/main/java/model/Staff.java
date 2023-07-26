package model;

public class Staff {
	private int StaffID;
    private String Staffname;
    private String StaffPassword;
    private String phoneNum;
    private String department;
    private String EmailStaff;
    private String role;
    private String JobPosition;
    private int managerID;
    private boolean valid;
    
    //constructor:to initialize the object
    
    //with ID

	public Staff(int staffID, String staffname, String staffPassword, String phoneNum, String department,
			String emailStaff, String role, String jobPosition, int managerID, boolean valid) {
		super();
		StaffID = staffID;
		Staffname = staffname;
		StaffPassword = staffPassword;
		this.phoneNum = phoneNum;
		this.department = department;
		EmailStaff = emailStaff;
		this.role = role;
		JobPosition = jobPosition;
		this.managerID = managerID;
		this.setValid(valid);
	}
	//without ID
	public Staff(String staffname, String staffPassword, String phoneNum, String department, String emailStaff,
			String role, String jobPosition, int managerID, boolean valid) {
		super();
		Staffname = staffname;
		StaffPassword = staffPassword;
		this.phoneNum = phoneNum;
		this.department = department;
		EmailStaff = emailStaff;
		this.role = role;
		JobPosition = jobPosition;
		this.managerID = managerID;
	}
    //default
	public Staff() {
		
	}
	//setter
	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}

	public String getStaffname() {
		return Staffname;
	}

	public void setStaffname(String staffname) {
		Staffname = staffname;
	}

	public String getStaffPassword() {
		return StaffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		StaffPassword = staffPassword;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmailStaff() {
		return EmailStaff;
	}

	public void setEmailStaff(String emailStaff) {
		EmailStaff = emailStaff;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getJobPosition() {
		return JobPosition;
	}

	public void setJobPosition(String jobPosition) {
		JobPosition = jobPosition;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	@Override
	public String toString() {
		return "Staff [StaffID=" + StaffID + ", Staffname=" + Staffname + ", StaffPassword=" + StaffPassword
				+ ", phoneNum=" + phoneNum + ", department=" + department + ", EmailStaff=" + EmailStaff + ", role="
				+ role + ", JobPosition=" + JobPosition + ", managerID=" + managerID + ", valid=" + valid + "]";
	}
    
}

