<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.*" %>
<%@ page import="connectionDB.*" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> <%-- Number formatter --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> <%-- SQL --%>
<link rel = "stlesheet" href ="css/bootstrap.css"></link>
<!DOCTYPE html>
<html>
<head>


<style>
  /*topsection*/
            .topsection{
                background-color: rgba(0,110,186,255);
                color: #ffffff;
                text-align: right;
                padding: 15px 0px;
            }

            .topsection .user{
                font-size: 16px;
                padding-right: 18px;
                display: flex;
                align-items: center;
                justify-content: right;
                font-weight: 600;
            }   

            .topsection .user i{
                font-size: 20px;
                padding-right: 5px;
            }
            /*topsection*/

            /*topbar*/
            .logo-section{
                text-align: center;
                padding: 20px 0px;
            }

            .logo-section img{
                width: 200px;
            }

            .navbar{
                display: flex;
                justify-content: center;
                align-items: center;
                flex-flow: row wrap;
            }

            .navbar a{
                text-decoration: none;
                font-size: 0.9em;
                font-weight: bold;
                padding: 0.5rem 1.9rem;
                color: #565b5f;
                text-transform: uppercase;
                margin-bottom: 10px;
            }

            .navbar a.active{
                font-weight: bold;
                border-bottom: 3px solid #FFB116;
                color: #000;
            }

            .topnav{
                border-bottom: 2px solid #e3e3e3;
            }

            /*topbar end*/

/*form{
  position: absolute;
  top: 50%;
  left: 50%;
  width: auto;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: white;
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
  font-family: verdana;
   font-size: 20px;
}*/
.loan-request-form-container {
  max-width: 500px;
  margin: 0 auto;
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.loan-request-form-container h2 {
  text-align: center;
  margin-bottom: 1rem;
}

form {
  display: flex;
  flex-wrap: wrap;
}

.form-group {
  width: 100%;
  margin-bottom: 1rem;
}

label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: bold;
}

input[type="text"],
textarea,
select {
  padding: 0.5rem;
  border-radius: 0.25rem;
  border: 1px solid #ccc;
  font-size: 1rem;
  width: 100%;
}

input[type="text"]:focus,
textarea:focus,
select:focus {
  border-color: #0066cc;
  outline: none;
}

button[type="submit"] {
  background-color: #4d814a;
  color: #fff;
  padding: 0.5rem 1rem;
  border-radius: 0.25rem;
  border: none;
  font-size: 1rem;
  cursor: pointer;
}

 .footer{
                border-top: 2px solid #e3e3e3;
                padding: 20px; 
                text-align: center;
                color: #5e5e5e;
                font-size: 14px;
            }

</style>
<meta charset="ISO-8859-1">
<title>Register Employee</title>
</head>
<body>
<div class="topsection">
            <div class="user">
                <i class="fa-solid fa-circle-user"></i>&nbsp; Register New Account</a>
            </div>
        </div>
        
        <div class="logo-section">
               <img src="assets/logo.png" />
            </div>

	
	<div class="loan-request-form-container">
  <form method="post" action = "CreateStaffController">
  
 

    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text"  name="Staffname" required>
    </div>

    <div class="form-group">
      <label for="Phone Number">Phone Number</label>
      <input type="tel" pattern="[0]{1}[1]{1}[0-9]{1}-[0-9]{7}" 
	   placeholder="012-3456789" name="phoneNum" required>
    </div>
    
      <div class="form-group">
      <label for="Email staff">Email Staff:</label>
      <input type="email"  name="EmailStaff" required>
    </div>
    
    <div class="form-group">
      <label for="Role">Role</label>
       <select  name="role">
        <option value="IT">IT Staff</option>
        <option value="Manager">Staff Manager</option>
        <option value="Staff">Staff</option>
        
      </select>
  
    </div>
    
    <div class="form-group">
      <label for="Job Position">Job Position</label>
      <select  name="JobPosition">
      <option value="service tech">Service Technician</option>
       <option value="Associate">Associate</option>
        <option value="admin">Admin</option>
        <option value="Client advisor">Client advisor</option>
         <option value="Production">Production Staff</option>
          <option value="Analyst">Analyst</option>
         <option value="Department Manager">Department Manager</option>
      </select>
    </div>
    
  <div class="form-group">
      <label for="department">Department</label>
      <select id="department" name="department">
        <option value="sales">Sales</option>
        <option value="marketing">Marketing</option>
        <option value="it">IT</option>
        <option value="hr">HR</option>
        <option value="f&B">F&B</option>
        <option value="Finance">Finance</option>
        <option value="Facilities">Facilities</option>
        <option value="procurement">Procurement</option>
        <option value="Pest Control">Pest Control</option>
        <option value="institutional">Institutional</option>
      </select>
    </div>
    
        <div class="form-group">
      <label for="ManagerID">Manager ID</label>
      <input type="text"  name="managerID" >
    </div>
    
  <div class="form-group">
      <label for="password"></label>
      <input type="hidden"  name="StaffPassword" >
    </div>
    
     <!-- - -- <div class="form-group">
      <label for="password">Re-enter Password</label>
      <input type="text"  name="confirmPassword" required>
    </div>

    <div class="form-group">
      <label for="department">Department:</label>
      <select id="department" name="department">
        <option value="sales">Sales</option>
        <option value="marketing">Marketing</option>
        <option value="it">IT</option>
        <option value="hr">HR</option>
      </select>
    </div>-->

    <button type="submit">Submit</button>
  </form>
</div>
	
	Have a ACCOUNT? <a href="index.html">Login</a>
	
	   <footer class="footer">
            © 2023. All Rights Reserved.
        </footer>
</body>
</html>
