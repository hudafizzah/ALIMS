<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<%@ page import="connectionDB.*"%>
<%@ page import="model.Application"%>
<%@ page import="model.Asset"%>
<%@ page import="Asset.dao.AssetDao"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Staff"%>
<%@ page import="Application.dao.ApplicationDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- import google font -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Update Approved Application Form</title>
<style>
html, body {
	font-family: 'Raleway', sans-serif;
	scroll-behavior: smooth;
	margin: 0;
}

a {
	color: #000;
	text-decoration: none;
	background-color: transparent;
}

p, h1, h2, h3, h4, h5, h6 {
	margin: 0;
}

/*topsection*/
.topsection {
	background-color: rgba(0, 110, 186, 255);
	color: #ffffff;
	text-align: right;
	padding: 15px 0px;
}

.topsection .user {
	font-size: 16px;
	padding-right: 18px;
	display: flex;
	align-items: center;
	justify-content: right;
	font-weight: 600;
}

.topsection .user i {
	font-size: 20px;
	padding-right: 5px;
}
/*topsection*/

/*topbar*/
.logo-section {
	text-align: center;
	padding: 20px 0px;
}

.logo-section img {
	width: 200px;
}

.navbar {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-flow: row wrap;
}

.navbar a {
	text-decoration: none;
	font-size: 0.9em;
	font-weight: bold;
	padding: 0.5rem 1.9rem;
	color: #565b5f;
	text-transform: uppercase;
	margin-bottom: 10px;
}

.navbar a.active {
	font-weight: bold;
	border-bottom: 3px solid #FFB116;
	color: #000;
}

.topnav {
	border-bottom: 2px solid #e3e3e3;
}

/*topbar end*/
/*banner*/
.banner {
	min-height: 100vh;
	background-image: url(assets/bg.jpg);
	background-size: cover;
	background-position: center center;
	background-repeat: no-repeat;
	position: relative;
}

.overlay {
	background: rgba(0, 0, 0, 0.5);
	width: 100%;
	height: 100%;
	position: absolute;
}

.banner-text {
	min-height: 100vh;
	position: relative;
	width: 100%;
	color: #fff;
	height: 100%;
}

.banner-text .box {
	padding: 5%;
	height: 100%;
	min-height: 100vh;
}

.banner-text .box .card {
	padding: 70px;
}

.banner-text h1 {
	font-size: 50px;
	padding-bottom: 20px;
}

.banner-text h2 {
	font-size: 30px;
	padding-bottom: 20px;
}

.banner-text span {
	color: #FFB116;
}

.opt button {
	background: #e3e3e3;
	color: #5e5e5e;
	padding: 16px 20px;
	border-radius: 6px;
	cursor: pointer;
	font-weight: 500;
	outline: none;
	border: none;
	box-shadow: none;
	font-size: 14px;
	font-weight: 600;
	text-transform: uppercase;
}

.inner {
	display: flex;
	align-items: center;
	gap: 20px;
	margin-top: 30px;
}

.inner-center {
	justify-content: center;
}

.inner .innercard-full {
	width: 100%;
	padding: 30px;
	background: #f6f2f2;
	border-radius: 8px;
	min-height: 250px;
	position: relative;
}

.innercard .content {
	color: #454545;
	padding: 15px 5px;
}

.innercard img {
	width: 50px;
	position: absolute;
	right: 0;
	top: 0;
	margin-top: 12px;
	margin-right: 20px;
}

.form-title {
	color: #000;
	text-transform: uppercase;
	font-weight: 500;
	font-size: 20px;
	padding-bottom: 20px;
}

.rowBtn {
	display: flex;
	justify-content: right;
	align-items: center;
}

.btnInfo {
	background-color: #C1E1C1;
	color: #000;
	padding: 15px 20px;
	margin-right: 10px;
	border-radius: 4px;
	border: 0;
	box-shadow: none;
}

.btnAlert {
	background-color: #28557f !important;
	color: #ffffff !important;
	padding: 15px 20px;
	margin-right: 10px;
	border-radius: 4px;
	border: 0;
	box-shadow: none;
}

.fcolumn {
	flex-direction: column;
}

.loan-request-form-container {
	max-width: 500px;
	margin: 0 auto;
	background-color: #f9f9f9;
	padding: 30px;
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

input[type="text"], textarea, select {
	padding: 0.5rem;
	border-radius: 0.25rem;
	border: 1px solid #ccc;
	font-size: 1rem;
	width: 100%;
}

input[type="text"]:focus, textarea:focus, select:focus {
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

button[type="reset"] {
	background-color: grey;
	color: #fff;
	padding: 0.5rem 1rem;
	border-radius: 0.25rem;
	border: none;
	font-size: 1rem;
	cursor: pointer;
}

.footer {
	border-top: 2px solid #e3e3e3;
	padding: 20px;
	text-align: center;
	color: #5e5e5e;
	font-size: 14px;
}
</style>
</head>
<body>
<div class="topsection">
            <div class="user">
                <i class="fa-solid fa-circle-user"></i>&nbsp;IT STAFF</a>
            </div>
        </div>

        <section class="topnav">

	        <div class="logo-section">
               <img src="assets/logo.png" />
            </div>
            <nav class="navbar">
		   		<a href="DashboardITSTAFF.jsp" >
                    Dashboard
                </a>

                <a href="ListAsset.jsp">
                    List Asset
                </a>
                <a href="ListApprovedApplication.jsp" class="active">
                    List Approved Application
                </a>
               <a href="ListReturnAsset.jsp">
                    List Return Asset
                </a>
                <a href="ListOutdatedAsset.jsp">
                    List Outdated Asset
                </a>
                <a href="#">
                    Manage Inventory
                </a>
                <a href="index.html">
                    Logout
                </a>

            </nav>
           

        </section>

        <section class="banner">

		<div class="loan-request-form-container">

								<form method="post" action="UpdateApplication">
                                <% 
                                     	ApplicationDao dao = new ApplicationDao();
										Application a = dao.getApplicationById(Integer.parseInt(request.getParameter("applicationId")));
									%>

                                <div class="form-body">

									<h2>Update Application</h2>
										<br>
									<div class="form-group">
										<label for="appid">Application ID</label>
										 <input type="text" name="appid" value="<%= a.getAppid() %>" readonly>
									</div>

									<div class="form-group">
										<label for="purpose">Purpose</label> 
										<input name="purpose" type="text" class="forminput" placeholder="Purpose/Reason" value="<%= a.getPurpose() %>"  />
									</div>
									<div class="form-group">
										<label for="total asset">Total Laptops</label> 
										<input name="total_asset" type="text" class="forminput" placeholder="Total Laptops" value="<%= a.getTotal_asset() %>"  />
									</div>
									<div class="form-group">
										<label for="startdateloan">Start Date Loan</label> 
										<input name="startdateloan" type="date" class="forminput" placeholder="Date Loaned" value="<%= a.getStartdateloan() %>" />
									</div>
					
									<div class="form-group">
										<label for="date returned">Date Return</label> 
										<input name="datereturned" type="date" class="forminput" placeholder="Date Returned" value="<%= a.getDatereturned() %>" />
									</div>
					
									<div class="form-group">
										<label for="appmodelid">Asset Model</label> <select
											name="appmodelid">
											<%
											List<Asset> assets = AssetDao.getAllAssetsList();
											for (Asset asset : assets) {
												boolean isSelected = a.getAssetid() == asset.getAssetID();
											%>
											<option value="<%=asset.getAssetID()%>" <%= isSelected ? " selected" : "" %>><%=asset.getCompleteAssetString()%></option>
											<%
											}
											%>
										</select>
									</div>
					
									<input type="hidden" name="StaffID"
										value="<%=session.getAttribute("staffID")%>">
										
                                </div>
                                <div class="rowBtn">
                                    
                                    <button type="submit" class="btnInfo">Update Info</button>
                                    <button onclick="window.location.href='UpdateSmsAlertForm.jsp';"class="btnAlert">Update & Sms Alert</button>

                                </div>
                                </form>
                            </div>
            
        </section>


        <footer class="footer">
            © 2023. All Rights Reserved.
        </footer>



</body>
</html>