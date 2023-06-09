<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>


</style>
<meta charset="ISO-8859-1">
<title>View Staff</title>
</head>
<body>
<!-- -responsive navbar -->


   <form style= "padding:50px 50px 50px 50px; text-align:auto;">	
	<h1>Member Information</h1>
     	<table>
		<tr>
			<td id="col-span-25">Staff ID</td>
			<td id="col-span-75">:&nbsp;<c:out value="${s.StaffID}"/></td>
		</tr>
		
		<tr>
			<td id="col-span-25">Staff Name</td>
			<td id="col-span-75">:&nbsp;<c:out value="${s.staffname}"/></td>
		</tr>
		
		<tr>
			<td id="col-span-25">Phone Number</td>
			<td id="col-span-75">:&nbsp;<c:out value="${s.phoneNum}"/></td>
		</tr>
		
		<tr>
			<td id="col-span-25">Email Staff</td>
			<td id="col-span-75">:&nbsp;<c:out value="${s.EmailStaff}"/></td>
		</tr>
		
		<tr>
			<td id="col-span-25">Role</td>
			<td id="col-span-75">:&nbsp;<c:out value="${s.role}"/></td>
		</tr>
		
		<tr>
			<td id="col-span-25">Job Position</td>
			<td id="col-span-75">:&nbsp;<c:out value="${s.JobPosition}"/></td>
		</tr>
		
		<tr>
			<td id="col-span-25">Department</td>
			<td id="col-span-75">:&nbsp;<c:out value="${s.department}"/></td>
		</tr>
		<tr>
			<td id="col-span-25">Manager ID</td>
			<td id="col-span-75">:&nbsp;<c:out value="${s.managerID}"/></td>
		</tr>
		<tr>
			<td id="col-span-25">Staff Password</td>
			<td id="col-span-75">:&nbsp;<c:out value="${s.StaffPassword}"/></td>
		</tr>
	
	</table>
	<br></br>
	</form>


</body>
</html>