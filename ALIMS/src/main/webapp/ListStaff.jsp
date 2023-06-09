 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%//prevent Caching of JSP Pages
 response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
//get session and check if session null, go to login page
if(session.getAttribute("currentSessionUser")==null)
	response.sendRedirect("index.html");%>
<%int id = (Integer) session.getAttribute("currentSessionUser");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
table {

  background-color: white;
  overflow: hidden;
  width: %;
  border-radius: 10px;
  justify-content: center;
  align-items: center;
  min-height: 10px;
  border: solid 1px black;
  text-align:center;
}

th, td {
  font-family:'Motnserrat',sans-serif;
  text-align: left;
  font-size: 16px;
  padding: 10px;
}

th {
  background-color: #7691ab;
  color: white;
}
.btn-view{
  background-color: gray;
  color: white;
  cursor: pointer;
  padding: 10px 20px;
  border-radius: 8px;
  font-size: 14px;
  margin-right: 5px;
}

.btn-update{
  background-color:#37cc53;
  cursor: pointer;
  color: white;
  padding: 10px 20px;
  border-radius: 8px;
   font-size: 14px;
    margin-right: 5px;
}
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');
.btn-delete{
  background-color: #d6524b;
  color: white;
  cursor: pointer;
  padding: 10px 20px;
  border-radius: 8px;
   font-size: 14px;
  
</style>
</head>
<body>
<header>
<a href="#" class="logo" >ECOLAB Corporation</a>
<div class="nav">
		<ul>
      <li><a href="#">Register Asset</a></li>
      <li><a href="#">List Asset</a></li>
      <li><a href="ListStaffController">List Staff</a></li>
      <li><a href="#">List Application</a></li>
      <li><a href="#">List Return Asset</a></li>
       <li><a href="#">List Out dated Asset</a></li>
      <li><a href="#"><img src="assets/profile.png" ></a>
    	<ul>
            <li><a href="#">Settings</a></li>
            <li><a href="index.html">Logout</a></li>
          </ul>
      </li>
    </ul>
</div>

   <form style="padding:50px 50px 50px 50px; text-align:center;">
		<table border="1">
			<tr>
				<th>Staff ID</th>
				<th> Name</th>
				<th>Phone Number</th>
				<th> Email</th>
				<th> Role</th>
				<th>Job Position</th>
				<th> Department </th>
				<th>ManagerID</th>
				<th>Password</th>
				<th colspan="8">Action</th>
			</tr>
			<c:forEach items ="${Staff}" var="s" varStatus="Staff">
			<tr>
				<td><c:out value="${s.StaffID}" /></td>
				<td><c:out value="${s.staffname}" /></td>
				<td><c:out value="${s.phoneNum}" /></td>
				<td><c:out value="${s.EmailStaff}" /></td>
				<td><c:out value="${s.role}" /></td>
				<td><c:out value="${s.JobPosition}" /></td>
				<td><c:out value="${s.department}" /></td>
			    <td><c:out value="${s.managerID}" /></td>
			    <td><c:out value="${s.StaffPassword}" /></td>
			   
				<td><a class=" btn-view" href="<c:out value="${s.StaffID}"/>">View</a></td>
				<td><a class=" btn-update" href="<c:out value="${s.StaffID}"/>">Update</a></td>
				<td><a class=" btn-delete" onclick= "confirmation(<c:out value="${s.StaffID}"/>">Delete</a></td>
				
			</tr>
			</c:forEach>
		</table>
		
		<script>
		function confirmation(id) {
			console.log(id);
			var r = confirm("Are you sure you want to delete?");
			if (r == true) {
				location.href = "DeleteStaffController?StaffID=" + id;
				alert("Admin successfully deleted");
			} else {
				return false;
			}
		}
		</script>	
		</form>

</body>
</html>