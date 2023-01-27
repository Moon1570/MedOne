<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports</title>
</head>
<body>


<table border="1">
	<thead>My Doctors</thead>
	<tr>
		<th>Name</th>
		<th>Address</th>
		<th>Phone</th>
		<th>Image</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${doctors}" var="doctor">

	<tr>
		<td>${doctor.doctorName }</td>
		<td>${doctor.doctorAddress }</td>
		<td>${doctor.doctorPhone }</td>
		<td><img src="./doctors?action=getImage&did=${doctor.doctorId }"> </td>
		<td><a href="./report?action=downloadReport&rid=${report.reportId}">Download</a> 
		 <a href="./report?action=deleteReport&rid=${report.reportId }">Delete</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>