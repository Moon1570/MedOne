<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" class="table">
	<thead>Patients</thead>
	<tr>
		<th>Name</th>
		<th>Location</th>
		<th>Phone</th>
		<th>Image</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${patients}" var="patient">

	<tr>
		<td>${patient.patientName }</td>
		<td>${patient.patientAddress}</td>                        
		<td>${patient.patientPhone }</td>
		<td>
		<img alt="patient Image"  src="./patients?action=getImage&pid=${patient.patientId}" style="max-height: 100px; max-width: 100px" >
		<td>Delete</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>