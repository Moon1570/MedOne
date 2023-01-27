<%@page import="model.PatientModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.PatientDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thread Create</title>
</head>
<body>
	<%
int pid = (int) session.getAttribute("pid");
PatientDao db = new PatientDao();
PatientModel patientModel = db.getPatientById(pid);


if(patientModel.getDoctors().isEmpty()){
	request.setAttribute("flag", "0");
} else{
	request.setAttribute("doctors", patientModel.getDoctors());

}
%>

	<c:if test="${flag == 0 }">
		You don't have any doctors. Add one now? 
		 <form class="mx-1 mx-md-4"
			action="./patients?action=addDoctorsByPhone" method="post"
			target=_blank>

			<input type="text" name="doctorPhoneNumber"
				placeholder="enter doctor phone"> <br>
			<button type="submit" class="btn btn-primary btn-lg">Add
				Doctor</button>

		</form>
	</c:if>
	<form action="./threads?action=addNewThread" method="post">

	${msg }
		<select name="dropdownDoctor" required="required">
			<option value="0">Please select a doctor</option>
			<c:forEach items="${doctors}" var="doctor">
				<option value="${doctor.doctorId}">${doctor.doctorName }</option>
			</c:forEach>
		</select> 
		<button type="submit">Start a new conversation</button>
	</form>
</body>
</html>