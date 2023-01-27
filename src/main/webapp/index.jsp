<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MedOne Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
 .fakeimg {
    height: 200px;
    background: #aaa;
  }
  main{
    min-height: 80vh;
  }
</style>
</head>

<%
		session = request.getSession();
		if (session.getAttribute("pid") == "false" || session.getAttribute("pid") == null) {
			//	request.getRequestDispatcher("admin-login.jsp");
			response.sendRedirect("login.jsp");

		}
%>



<body>
 
 <main>
<!-- <div class="jumbotron text-center" style="margin-bottom:0">
  <h1>MedOne</h1>
  <p>One Stop Medical Services</p> 
</div> -->

<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <a class="navbar-brand" href="index.jsp">
    <img src="https://i.ibb.co/YQpHjHK/medone-logo-1.png" width="150" height="50" class="d-inline-block align-top" alt="">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="./report?action=viewAll">My Reports</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="doctor.jsp">My Doctors</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="chat.jsp">Consult Online</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="relative_list.jsp">My Relatives</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./patients?action=logout">Logout</a>
      </li>    
    </ul>
  </div>  
</nav>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-3">
      <h2>About Me</h2>
      <h5>${name}</h5>
      <img src="https://www.dlf.pt/dfpng/middlepng/569-5693658_dummy-user-image-png-transparent-png.png" alt="DP" class="img-thumbnail">
      <p>Blood Group: <b>A+</b></p>
      <br><br>
      <h3>Add Relative:</h3>
      <form class="" action="./patients?action=addRelativesByPhone" method="post">
 			<input type="text" name="relativePhoneNumber" placeholder="enter relative's phone number"> <br>
			<button type="submit" class="btn btn-primary btn-md">Add relatives</button>
							
		</form>
      <!-- <h3>Some Links</h3>
      <p>Lorem ipsum dolor sit ame.</p>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">Active</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul> -->
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-8">
      <h2>Last Uploaded Report</h2>
      <h5>Uploaded on 23 Jan, 2022</h5>
      
      <iframe id="inlineFrameExample"
		    title="Inline Frame Example"
		    width="500"
		    height="200"
		    src="./report?action=viewReport&rid=${singleReport.reportId}">
		</iframe>
      
      <!--  
      <div class="fakeimg">Not Available</div>
      -->
      
      <p>Referred by: Dr. John</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
      <br>
      <h2>Upload Report</h2>
      <form class="mx-1 mx-md-4" action="./report?action=reportUpload" method="post" enctype="multipart/form-data">
 
 						<input type="text" name="reportName" placeholder="enter report name" class="form-control"> <br><br>
 						<input class="input-field" type="file" name="reportImage" required="required" id="file" onchange="return fileValidation()">
						<br>

						<button type="submit" class="btn btn-primary btn-md">upload</button>

	  </form>
      <br><br><br>
      <h2>Latest Advices from Doctors</h2>
      <h5>Last Updated, Sep 2, 2017</h5>
      <div class="card">
        <div class="card-body">
          <h4 class="card-title">Dr. John</h4>
          <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
          <a href="#" class="btn btn-primary">See Profile</a>
        </div>
      </div>
      <a href="./threads?action=startNewChat">Start chat with your doctor</a><br>
      <a href="./threads?action=myThreads">My Threads</a>
      <!-- <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p> -->
    </div>
  </div>
</div>
</main>

<footer class="text-center text-lg-start bg-light text-muted">
  <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
    © 2023 Copyright:
    <p class="text-reset fw-bold">Holy Bugs</p>
  </div>
</footer>

</body>
</html>