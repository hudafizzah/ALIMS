<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<%@ page import="java.sql.*" %> 
<%@ page import = "connectionDB.ConnectionManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
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
		
<title>List Asset</title>
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
                background-position: center center;
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
                background: rgba(0,110,186,255);
                color: #ffffff;
            }

            .delete{
                background: #f40505;
                color: #ffffff;
            }

            .update{
                background: #FFB116;
                color: #000;
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
                <a href="#" class="active">
                    Homepage
                </a>
                  <a href="RegisterAsset.jsp">
                    Register Asset
                </a>
                <a href="#" class="active">
                    List Asset
                </a>
                <a href="ListApprovedApplication.jsp">
                    List Approved Application
                </a>
                <a href="ListReturnAsset.jsp">
                    List Return Asset
                </a>
                <a href="ListOutdatedAsset.jsp">
                    List Outdated Asset
                </a>
                <a href="manageInventory.jsp">
                    Manage Inventory
                </a>
                <a href="index.html">
                    Logout
                </a>

            </nav>

        </section>

        <section class="banner">

            <div class="overlay"></div>
            <div class="banner-text">

                <div class="box">
                    <div class="card">

                        <div class="opt">
                           <button onclick="window.location.href='RegisterAsset.jsp';" type="button" class="btnAlert"> 
                                Add Asset
                            </button>
                            <button type="button" href="#"> 
                                Add Inventory
                            </button>
                        </div>


        
                        <div class="inner inner-center">

                           
                            <div class="innercard-full">

                                <div class="form-title">
                                    Manage Asset
                                </div>

                                <div class="filter-row">
                                    <div class="show">
                                        <p>Show</p>
                                        <select>
                                            <option selected>10</option>
                                            <option>15</option>
                                            <option>25</option>
                                            <option>50</option>
                                        </select>
                                        <p>Entries</p>
                                    </div>

                                    <input type="text" placeholder="Search By Model Name" />
                                </div>


                                <div class="table-box">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>
                                                    ASSET ID
                                                </th>
                                                <th>
                                                    MODEL NAME
                                                </th>
                                                <th>
                                                    ASSET DATE PURCHASE
                                                </th>
                                                <th>
                                                    MANUFACTURER
                                                </th>
                                                <th>
                                                    INVENTORY ID
                                                </th>
                                                <th>
                                                    STAFF ID
                                                </th>
                                                <th colspan = "2">ACTION</th>
                                                  
                                            </tr>
                                        </thead>
               
                
                                        <tbody>
                                        <c:forEach items = "${Asset}" var ="a">
                                            <tr>
                                                <td><c:out value = "${a.AssetID} "/></td>
                                                <td><c:out value = "${a.modelname} "/></td>
                                                <td><c:out value = "${a.asset_datepurchase} "/></td>
                                                <td><c:out value = "${a.manufacturer} "/></td>
                                                <td><c:out value = "${a.inventoryid} "/></td>
                                                <td><c:out value = "${a.StaffID} "/></td>
                                                  
                                                
                                                  <td>
                                                    
                                                       <div> <button class="button view">View</button>
                                                        <button class="button update">Update</button>
                                                        <button class="button delete">Delete</button>
                                                    </div>
                                                 
                                              </td>
                                              </tr>
                                                </c:forEach>
                                        </tbody>
                                       
                                    </table>
                                
                        </div>
                    </div>
                </div>
                
            </div>
            
        </section>


        <footer class="footer">
            © 2023. All Rights Reserved.
        </footer>


</body>
</html>