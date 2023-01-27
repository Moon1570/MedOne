<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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



<body class="container">
 
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
        <a class="nav-link" href="my_doctors.jsp">My Doctors</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./threads?action=startNewChat">Message Doctor</a>
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

<br><br>
