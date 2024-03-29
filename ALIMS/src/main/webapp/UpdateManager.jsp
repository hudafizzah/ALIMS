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
<title>UpdateManager Account</title>
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
           
 .RegisterAsset-form-container {
  max-width: 500px;
  margin: 0 auto;
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.RegisterAsset-form-container h2 {
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
           
				<a href="ManagerHomepage" class="active">
                    Home Manager
                </a>
                <a href="ListApplication.jsp">
                    List Application
                </a>
               
                <a href="index.html">
                    Logout
                </a>

            </nav>

        </section> 
   

			<section class = "banner">

							<div class="RegisterAsset-form-container">
								<label>Staff ID</label> &nbsp; ${sessionScope.s.staffID} <br><br>
							
							<form method="post" action="ManageProfileManagerController">
								<div class="form-group">

									<input type="hidden" name="staffId" value="${sessionScope.s.staffID}">
									<div class="form-group">
										<label>Name</label> <input type="text" name="staffName"
										    class="forminput" placeholder="Name"
											value="${sessionScope.s.staffname}" /><br>
									</div>
									<div class="form-group">
										<label>Phone Number</label> <input type="text" name="phoneNum"
										    class="forminput" placeholder="Phone Number"
											value="${sessionScope.s.phoneNum}" /><br>
									</div>
									<div class="form-group">
										<label>Email</label> <input type="email" name="emailStaff"
										    class="forminput" placeholder="Email Staff"
											value="${sessionScope.s.emailStaff}" /><br>
									</div>
									<div class="form-group">
										<label>Department</label> <input name="department"
										    class="forminput" placeholder="Department"
											value="${sessionScope.s.department}" /><br>
									</div>
									 <div class="form-group">
										<label>Job Position</label> <input type="text" name="jobPosition"
										    class="forminput" placeholder="Job Position"
											value="${sessionScope.s.jobPosition}" /><br>
									</div>
									<div class="form-group">
										<label>Staff Password</label> <input type="text" name="staffPassword"
										    class="forminput" placeholder="Password"
											value="${sessionScope.s.staffPassword}" /><br>
									</div>
									
								</div>
								<div class="rowBtn">

									<button type="submit" class="btnInfo"  >Update Info</button>

								</div>
							</form>
						</div>
						
						</section>

		 <footer class="footer">
            � 2023. All Rights Reserved.
        </footer>
        
</body>
</html>