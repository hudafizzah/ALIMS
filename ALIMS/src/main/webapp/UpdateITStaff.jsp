<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>UpdateITStaffAccount</title>
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
            .loan-request-form-container h2 {
  				text-align: center;
	  				margin-bottom: 1rem;
			}
			
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
           
				<a href="#" class="active">
                    Homepage
                </a>
                <a href="#">
                    Register Asset
                </a>
                <a href="#">
                    List Asset
                </a>
                <a href="#">
                    List Staff
                </a>
                 <a href="#">
                    List Application
                </a>
                <a href="#">
                    List Return Asset
                </a>
             	 <a href="#">
                    List Out Dated Asset
                </a>
                <a href="index.html">
                    Logout
                </a>
            </nav>
 </section>
 
 <section class= "banner">
 
 <div class="loan-request-form-container">
        <form action="ManageProfileITStaffController" method="post" style= "padding:50px 50px 50px 50px; text-align:auto;">
		<div class= "form">
		<label>Staff ID</label> :&nbsp; $(s.staffID)  <br><br>
		<input type="text" name="StaffID" value="<c:out value= "${s.StaffID }"/>"/><br>
		</div>
		
		<label >Name</label>:&nbsp;
		<input type="text" name="staffname" value="<c:out value= "${s.staffname }"/>"/><br>
	    <label>Phone Number</label>:&nbsp;
		<input type="text" name="phoneNum" value="<c:out value="${s.phoneNum}"/>"/><br>
		<label>Staff Email</label>:&nbsp;
		<input type="text" name="EmailStaff" value="<c:out value="${s.EmailStaff}"/>"/><br>
		<label>Department</label>:&nbsp;
		<input type="text" name="department" value="<c:out value="${s.department}"/>"/><br>
		<label>Password</label>:&nbsp;
		<input type="password" name="StaffPassword" value="<c:out value="${s.StaffPassword}"/>"/><br>
		
		<input type="submit" value="Submit"/>
		<input type="reset" value="Reset"/>
	
 
 </form>
 </div>
  </section>

</body>
</html>