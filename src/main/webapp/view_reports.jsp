<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>My Reports</title>
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
    min-height: 90vh; 
  }
  </style>
</head>
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
    <div class="col">
      <!-- <h2>About Me</h2>
      <h5>Photo of me:</h5>
      <img src="https://bu.ac.bd/webform/user_images/310324.jpg" alt="DP" class="img-thumbnail">
      <p>Blood Group: <b>T+</b></p> --> 
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
      <!-- <hr class="d-sm-none">
    </div> -->
    <div class="col-lg-8">
      <h2>Your Reports</h2>
      </div>
      <!-- <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          
        </li>
        <li class="nav-item">
          
        </li>
        <li class="nav-item">
          
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Blood test report of 20 Jan, 2022</a>
        </li>
      </ul> -->
      <!-- <h5>Uploaded on 23 Jan, 2022</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Referred by: Dr. Erfan</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
      <br>
      <h2>Latest Conversation with doctors</h2>
      <h5>Last Updated, Sep 2, 2017</h5> -->
      <div class="container">
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Report Name</th>
              <th scope="col">Preview</th>
              <th scope="col">Uploaded Date</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
      		<c:forEach items="${reports}" var="report">

			<tr>
			<td scope="row">${report.reportName }</td>
			<td><iframe id="inlineFrameExample"
		    	title="Inline Frame Example"
		    	width="500"
		    	height="200"
		    	src="./report?action=viewReport&rid=${report.reportId}">
		</iframe></td>
			<td>${report.reportCreateDate }</td>
		<!-- 	<c:if test="${report.image}">                            
			<td>Image</td>
			</c:if>
			<c:if test="${!report.image}">                            
			<td>PDF</td>
			</c:if> -->
			<td> <a class=nav-link href="./report?action=viewReportFullScreen&rid=${report.reportId}">View Full Screen</a><a class="nav-link" href="./report?action=downloadReport&rid=${report.reportId}">Download</a>
	</tr>
	</c:forEach>
          </tbody>
        </table>
      </div>
      <!-- <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p> -->
    </div>
  </div>
</div>
</main>
<footer class="text-center text-lg-start bg-light text-muted">
  <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
    © 2023 Copyright:
    <p class="text-reset fw-bold ">Holy Bugs</p>
  </div>
</footer>

</body>
</html>
    