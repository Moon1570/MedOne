<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<title>Login</title>
</head>
<body>


<section class="vh-100" style="background-color: #fff;">
  <div class="container h-100">
  
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-9">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Registration</p>

                <form class="mx-1 mx-md-4" action="./patients?action=reg" method="post" enctype="multipart/form-data">


                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" class="form-control"  name="patientName"/>
                      <label class="form-label" for="form3Example1c">Your Name</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example3c" class="form-control" name="patientPhone"/>
                      <label class="form-label" for="form3Example3c">Your Phone</label>
                    </div>
                  </div>
 
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="password" id="form3Example4c" class="form-control" name="patientPassword" />
                      <label class="form-label" for="form3Example4c">Password</label>
                    </div>
                  </div>

				<div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" class="form-control"  name="patientAddress"/>
                      <label class="form-label" for="form3Example1c">Your Address</label>
                    </div>
                  </div>

				<div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" class="form-control"  name="bloodGroup"/>
                      <label class="form-label" for="form3Example1c">Your Blood Group</label>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
					<input class="input-field" type="file" name="patientImage"
							required="required">                      
							<label class="form-label" for="form3Example1c">Your Image</label>
                    </div>
                  </div>
					
					
					<div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
					<input class="input-field" type="date" name="patientDOB" required="required">
                     
							<label class="form-label" for="form3Example1c">Your DOB</label>
                    </div>
                  </div>
					    
							



                  <div class="d-flex justify-content-left mx-4 mb-3 mb-lg-4">
                    <button type="submit" class="btn btn-primary btn-lg">Registration</button>
                  </div>

                </form>
                
                <div class="text-center">
    				<p class="text-danger">Are you a Doctor?   <a href="./doctors?action=login">Doctor's Login</a></p>
  				</div>
                <div class="text-center">
    				<p class="text-danger">Already Registered?   <a href="./patients?action=login">Login</a></p>
  				</div>

              </div>
             
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>


</body>
</html>