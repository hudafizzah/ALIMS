<%@ page import="java.sql.*"%>
<%@ page import="connectionDB.*"%>
<%@ page import="model.Application"%>
<%@ page import="model.Staff"%>
<%@ page import="Application.dao.ApplicationDao"%>
<%@ page import="Staff.dao.StaffDao"%>
<%@ page import="java.util.List"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
 	<!-- import google font -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>List Application</title>
<style>
     html, body{
                font-family: 'Raleway', sans-serif;
                scroll-behavior: smooth;
                margin: 0;
            }

            a{
                color: #000;
                text-decoration: none;
                background-color: transparent;
            }

            p, h1, h2, h3, h4, h5, h6{
                margin: 0;
            }

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

            /*banner*/
            .banner{
                min-height: 100vh;
                background-image: url(assets/bg.jpg);
                background-size: cover;
                background-position: down center;
                background-repeat: no-repeat;
                position: relative;
            }


            .overlay{

                background: rgba(0,0,0, 0.5);
                width: 100%;
                height: 100%;
                position: absolute;
            }

            .banner-text{
                min-height: 100vh;
                position: relative;
                width: 100%;
                color: #fff;
                height: 100%;
                
            }

            .banner-text .box{
                padding: 5%;
                height: 100%;
                min-height: 100vh;
            }

            .banner-text .box .card{
                padding: 40px;
            }

            .banner-text h1{
                font-size: 50px;
                padding-bottom: 20px;
            }

            .banner-text h2{
                font-size: 30px;
                padding-bottom: 20px;
            }

            .banner-text span{
                color: #FFB116;
            }

            .opt button{
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

            .inner{
                display: flex;
                align-items: center;
                gap: 20px;
                margin-top: 30px;
            }

            .inner-center{
                justify-content: center;
            }

            .inner .innercard-full{
                width: 100%;
                padding: 30px;
                background: #f6f2f2;
                border-radius: 8px;
                min-height: 250px;
                position: relative;
            }


            .innercard .content{
                color: #454545;
                padding: 15px 5px;
            }

            .innercard img{
                width: 50px;
                position: absolute;
                right: 0;
                top: 0;
                margin-top: 12px;
                margin-right: 20px;
            }
            
             .form-title{
                color: #000;
                text-transform: uppercase;
                font-weight: 500;
                font-size: 20px;
                padding-bottom: 20px;
            }


            .rowBtn{
                display: flex;
                justify-content: right;
                align-items: center;
            }

            .btnInfo{
                background-color: #C1E1C1;
                color: #000;
                padding: 15px 20px;
                margin-right: 10px;
                border-radius: 4px;
                border: 0;
                box-shadow: none;
            }

            .btnAlert{
                background-color: #28557f !important;
                color: #ffffff!important;
                padding: 15px 20px;
                margin-right: 10px;
                border-radius: 4px;
                border: 0;
                box-shadow: none;
            }

            .fcolumn{
                flex-direction: column;
            }

            /*table*/
            .table-box{
                overflow-x: auto;
            }
            .table {
                border: 1px solid #EEEEEE;
                border-collapse: collapse;
                margin-bottom: 40px;
                width: 100%;
            }

            .table thead tr th{
                background: rgba(0,110,186,255);
                border: 1px solid #EEEEEE;
                color: #ffffff;
                padding: 10px 20px;
                white-space: nowrap;
            }

            .table tbody tr td{
                background: #e3e3e3;
                border: 1px solid #EEEEEE;
                color: #5e5e5e;
                padding: 10px 20px;
                text-align: center;
                font-weight: 500;
            }

            .action{
                display: flex;
                align-items: center;
                justify-content: center;
                gap: 6px;
            }

            .button{
                border: 0;
                padding: 10px 20px;
                background: #5e5e5e;
                border-radius: 4px;
            }

            .view{
                background: #76756d;
                color: #ffffff;
            }
             .Approve{
                background: #1683ff;
                color: #ffffff;
            }

            .delete{
                background: #f40505;
                color: #ffffff;
            }


            /*filter*/
            .filter-row{
                display: flex;
                align-items: center;
                justify-content: space-between;
                margin-bottom: 20px;
            }

            .show{
                display: flex;
                align-items: center;
                gap: 10px;
                color: #5e5e5e;
                font-weight: 500;
            }

            .filter-row .show select{
                height: 30px;
                border-radius: 4px;
                border: 1px solid #bfbfbf;
                min-width: 80px;
            }


            .filter-row input{
                height: 30px;
                border-radius: 4px;
                border: 1px solid #bfbfbf;
                min-width: 180px;
                padding: 0px 10px; 
            }

            /*table*/

            .footer{
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
                <i class="fa-solid fa-circle-user"></i>&nbsp; Manager</a>
            </div>
        </div>

 <section class="topnav">

	        <div class="logo-section">
               <img src="assets/logo.png" />
            </div>
            <nav class="navbar">
           
				<a href="ManagerHomepage" >
                    Home Manager
                </a>
                <a href="ListApplication.jsp" class="active">
                    List Application
                </a>
                <a href="index.html">
                    Logout
                </a>

            </nav>

<section class="banner">
           <div class="overlay"></div>
              <div class="banner-text">
              
              
                        <div class="inner inner-center">

                           
                            <div class="innercard-full">

                                <div class="form-title">
                                    Manage Asset
                                </div>

                                <div class="filter-row">
                                    <div class="show">
                                        
                                      
                                    </div>

                                    <input type="text" placeholder="Search By APP ID" />
                                </div>


                                <div class="table-box">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>
                                                    APPLICATION ID
                                                </th>
                                                <th>
                                                    STAFF NAME
                                                </th>
                                                <th>
                                                    STAFF ID
                                                </th>
                                                 <th>
                                                    MODEL NAME
                                                </th>
                                                <th>
                                                    TOTAL LAPTOP
                                                </th>
                                                <th>
                                                    PURPOSE
                                                </th>

                                                <th>
                                                    LOAN PERIOD
                                                </th>
                                               
                                                <th>
                                                    START DATE LOAN
                                                </th>
                                                <th>
                                                     DATE RETURN
                                                </th>
                                                  <th>
                                                     APPLICATION STATUS
                                                </th>
                                              
                                                  <th>
                                                    ACTION
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                              <% 
                                            	ApplicationDao dao = new ApplicationDao();
										        List<Application> applications = dao.getAllApplications();
										        for (Application eachApp : applications) {
										        	String status = eachApp.getStatus_app();
										            boolean done = status.equalsIgnoreCase("Approved") || status.equalsIgnoreCase("Declined");
										    %>
										    <tr>
										        <td><%= eachApp.getAppid() %></td>
										        <td><%= StaffDao.getStaffNameById(eachApp.getStaffid()) %></td>
										        <td><%= eachApp.getStaffid() %></td>
										        <td><%= eachApp.getModelName() %></td>
										        <td><%= eachApp.getTotal_asset() %></td>
										        <td><%= eachApp.getPurpose() %></td>
										        <td><%= eachApp.getLoanPeriodDetails() %></td>
										        <td><%= eachApp.getStartdateloan().toString() %></td>
										        <td><%= eachApp.getDatereturned().toString() %></td>
										        <td><%= eachApp.getStatus_app() %></td>
										    	<td>
                                                    <div class="action">
											        <a href="ApproveController?applicationId=<%= eachApp.getAppid() %>"
											           class="button Approve" style="<%= done ? "pointer-events: none" : "" %>">Approve</a>
											        <a href="DeclineController?applicationId=<%= eachApp.getAppid() %>"
											           class="button delete" style="<%= done ? "pointer-events: none" : "" %>">Decline</a>
											    </div>
                                                </td>
										    </tr>
										    <% } %>
                                        </tbody>
                                       
                                       
                                    </table>
                                    	
                                </div>
                                
                            </div>
                           
                        </div>
                        </div>  	
                             
                    
               
              
              
           
          </section>
          
                 <footer class="footer">
            � 2023. All Rights Reserved.
        </footer>

</body>
</html>