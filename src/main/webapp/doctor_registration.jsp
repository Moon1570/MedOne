<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script type="text/javascript">
$('.datepicker').datepicker({
	  inline: true
	});
</script>
<title>Registration</title>
</head>
<body>


<section class="vh-100" style="background-color: #fff;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
    <a class="navbar-brand row d-flex justify-content-center" href="#">
            <img src="https://i.ibb.co/ykQgB00/medone-logo-1.png"
                 height="50"
                 width="150"
                 alt="MDB Logo"
                 loading="lazy" />
        </a>
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                <form class="mx-1 mx-md-4" action="./doctors?action=reg" method="post" enctype="multipart/form-data">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" class="form-control"  name="doctorName" required/>
                      <label class="form-label" for="form3Example1c">Your Name</label>
                    </div>
                  </div>
                  
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="email" id="form3Example3c" class="form-control" name="doctorEmail" required/>
                      <label class="form-label" for="form3Example3c">Your Email</label>
                    </div>
                  </div>
            
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" class="form-control"  name="doctorPhone" required/>
                      <label class="form-label" for="form3Example1c">Your Phone</label>
                    </div>
                  </div>
<!-- 
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="email" id="form3Example3c" class="form-control" />
                      <label class="form-label" for="form3Example3c">Your Email</label>
                    </div>
                  </div>
 -->
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="password" id="form3Example4c" class="form-control" name="doctorPassword"  required/>
                      <label class="form-label" for="form3Example4c">Password</label>
                    </div>
                  </div>

                 <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fa-solid fa fa-address-card fa-lg pr-1" aria-hidden="true" ></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" class="form-control"  name="doctorAddress" required/>
                      <label class="form-label" for="form3Example1c">Your Address</label>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4"> 
                  <label for="formFileSm" class="form-label">Upload your photo:</label>
                  <input class="form-control form-control-sm" id="formFileSm" type="file" name="doctorImage" required="required">
				 </div>
                <div class="d-flex flex-row align-items-center mb-4"> 
                  <label for="formFileSm" class="form-label">Upload your certificate:</label>
                  <input class="form-control form-control-sm" id="formFileSm" type="file" name="doctorCert" required="required">
				 </div>
				 <div class="md-form md-outline input-with-post-icon datepicker d-flex flex-row align-items-center mb-4">
  					<label for="formDatesm" class="form-label">Date of Birth:</label>
  					<input placeholder="Select date" type="date" id="example" class="form-control" name="doctorDOB" required="required">
				</div>

<!-- 
                  <div class="form-check d-flex justify-content-center mb-5">
                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                    <label class="form-check-label" for="form2Example3">
                      I agree all statements in <a href="#!">Terms of service</a>
                    </label>
                  </div>
 -->
                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" class="btn btn-primary btn-lg">Register</button>
                  </div>

                </form>

              </div>
              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                

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