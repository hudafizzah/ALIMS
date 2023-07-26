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

            .inner .innercard-md{
                width: 80%;
                padding: 30px;
                background: #f6f2f2;
                border-radius: 8px;
                min-height: 250px;
                position: relative;
            }

            .inner .innercard{
                width: calc(100% / 3);
                padding: 30px;
                background: #f6f2f2;
                border-radius: 8px;
                min-height: 250px;
                position: relative;
            }

            .innercard .title{
                text-align: center;
                color: #454545;
                text-transform: uppercase;
                font-weight: 600;
                font-size: 18px;
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

            .forminput{
                width: -webkit-fill-available;
                border: 1px solid #c2c2c2;
                border-radius: 4px;
                padding: 10px;
                min-height: 20px;
            }

            .form-body{
                display: flex;
                align-items: center;
                gap: 10px;
                flex-flow: row wrap;
                justify-content: center;
                margin-bottom: 20px;
            }

            .form-body .fgroup{
                min-width: 49%;
            }

            .form-body .fgroup input, .form-body .fgroup select{
                margin-top: 8px;
            }

            .form-body .fgroup label{
                color: #5e5e5e;
                font-size: 14px;
                font-weight: 500;
            }

            .form-normal{
                 margin-bottom: 20px;
            }

            .form-normal .fgroup{
                margin-bottom: 20px;
            }

            .form-normal input, .form-normal select, .form-normal textarea{
                margin-top: 8px;
            }

            .form-normal label{
                color: #5e5e5e;
                font-size: 14px;
                font-weight: 500;
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
            /*banner*/


            /*content*/

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
			<i class="fa-solid fa-circle-user"></i>&nbsp; IT STAFF</a>
		</div>
	</div>

	<section class="topnav">

		<div class="logo-section">
			<img src="assets/logo.png" />
		</div>
		<nav class="navbar">

			<a href="#" class="active"> Homepage </a> <a href="#"> Register
				Asset </a> <a href="ListAsset.jsp"> List Asset </a> <a href="#">
				List Application </a> <a href="#"> List Return Asset </a> <a href="#">
				List Out Dated Asset </a> <a href="index.html"> Logout </a>
		</nav>
	</section>
	<section class="banner">

		<div class="overlay"></div>
		<div class="banner-text">

			<div class="box">
				<div class="card">



					<div class="inner inner-center">

						<div class="innercard-md">

							<div class="form-title">
								<label>Staff ID</label> :&nbsp; ${sessionScope.s.staffID} <br>
							</div>
							<form method="post" action="ManageProfileITStaffController">
								<div class="form-body">

									<input type="hidden" name="staffId" value="${sessionScope.s.staffID}">
									<div class="fgroup">
										<label>Name</label>:&nbsp; <input type="text" name="staffName"
										    class="forminput" placeholder="Name"
											value="${sessionScope.s.staffname}" /><br>
									</div>
									<div class="fgroup">
										<label>Phone Number</label>:&nbsp; <input type="text" name="phoneNum"
										    class="forminput" placeholder="Phone Number"
											value="${sessionScope.s.phoneNum}" /><br>
									</div>
									<div class="fgroup">
										<label>Email</label>:&nbsp; <input type="email" name="emailStaff"
										    class="forminput" placeholder="Email Staff"
											value="${sessionScope.s.emailStaff}" /><br>
									</div>
									<div class="fgroup">
										<label>Department</label>:&nbsp; <input type="text" name="department"
										    class="forminput" placeholder="Department"
											value="${sessionScope.s.department}" /><br>
									</div>
									<div class="fgroup">
										<label>Job Position</label>:&nbsp; <input type="text" name="jobPosition"
										    class="forminput" placeholder="Job Position"
											value="${sessionScope.s.jobPosition}" /><br>
									</div>
									<div class="fgroup">
										<label>Staff Password</label>:&nbsp; <input type="text" name="staffPassword"
										    class="forminput" placeholder="Password"
											value="${sessionScope.s.staffPassword}" /><br>
									</div>
									
								</div>
								<div class="rowBtn">

									<button type="submit" class="btnInfo">Update Info</button>

								</div>
							</form>
						</div>

					</div>
				</div>
			</div>

		</div>

	</section>


	<footer class="footer"> © 2023. All Rights Reserved. </footer>



</body>
</html>