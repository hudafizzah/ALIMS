<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
 //get session and check if session null, go to login page
if(session.getAttribute("currentSessionUser")==null)
	response.sendRedirect("index.html");%>
<%int id = (Integer) session.getAttribute("currentSessionUser");%>
<%@page import="connectionDB.ConnectionManager" %>
<%@page import="java.sql.*" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListEmployee</title>
</head>
<body>
  <form style="padding:50px 50px 50px 50px; text-align:center;">
		<table border="1">
			<tr>
				<th>Employee ID</th>
				<th> Name Employee</th>
				<th> Password</th>
				<th> Phone Number </th>
				<th> Role </th>
				<th> Department</th>
				<th> JobPosition</th>
				<th>Manager ID</th>
				<th colspan="10">Action</th>
			</tr>

	      <%
            try {
                Statement stat=null;
                ResultSet res=null;
                Connection con = ConnectionManager.getConnection();  
                stat = con.createStatement();
                String query = request.getParameter("q");
                String data;
                if(query!=null){
                	data="select * from Staff where n like '%" + query + "%' or LOWER (nameEmp) LIKE '%"+ query + "%'or Upper(nameEmp) LIKE '%" + query + "%' or  department like '%"+ query + "%'" ;
                }else{
                	data="select * from Employee order by EmpID desc";
                }

                 res = stat.executeQuery(data);
                while(res.next()) {
                	
                %>

                    <tr>
                        <td><%=res.getInt("StaffID")%></td>
                        <td><%=res.getString("staffEmp")%></td>
                        <td><%=res.getString("emppassword")%></td>
                        <td><%=res.getString("phoneNumber")%></td>
                        <td><%=res.getInt("department")%></td>
                        <td><%=res.getString("jobPosition")%></td>
                         <td><%=res.getInt("managerid")%></td>
                        
                          
                   
                <td><a class="btn-view" href="ViewMemberController?memberid=<%=res.getInt("memberid")%>">View</a></td>
				<td><a class="btn-update" href="UpdateMemberController?memberid=<%=res.getInt("memberid")%>">Updates</a></td>
				<td><a class="btn-delete" onclick= "confirmation(<%=res.getInt("memberid")%>)">Delete</a></td>
				 </tr>
                    <%
                    
                }

            }
            catch (Exception e) {}
            %>
							
		  
		</table>
		
		  
           </form><br>
		
		
		<script>
		function confirmation(id) {
			console.log(id);
			var r = confirm("Are you sure you want to delete?");
			if (r == true) {
				location.href = 'DeleteMemberController?memberid=' + id;
				alert("Member successfully deleted");
			} else {
				return false;
			}
		}
		</script>

</body>
</html>