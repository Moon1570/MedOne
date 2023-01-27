<%@page import="model.PatientModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.PatientDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="patient_header.jsp" />

<%
int pid = (int) session.getAttribute("pid");
PatientDao db = new PatientDao();
PatientModel patientModel = db.getPatientById(pid);

if (patientModel.getDoctors().isEmpty()) {
	request.setAttribute("flag", "0");
} else {
	request.setAttribute("flag", "1");
	request.setAttribute("doctors", patientModel.getDoctors());

}
%>

<c:if test="${flag == 0 }">
		You don't have any doctors. Add one now? 
		 <form class="mx-1 mx-md-4"
		action="./patients?action=addDoctorsByPhone" method="post">

		<input type="text" name="doctorPhoneNumber"
			placeholder="enter doctor phone">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">Add Doctor</button>

	</form>

</c:if>


<c:if test="${flag == 1 }">
	<form action="./threads?action=addNewThread" method="post">

		<input type="text" name="threadNamer"><br> 
		<select
			name="dropdownDoctor" class="form-group" required="required">

			<option value="0">Please select a doctor</option>
			<c:forEach items="${doctors}" var="doctor">
				<option value="${doctor.doctorId}">${doctor.doctorName }</option>
			</c:forEach>
		</select> <br>
		<button type="submit">Start a new conversation</button>
	</form>

</c:if>

<hr />
<h2 class="h2">My threads</h2>

<table class="table table-striped">
	<tr>
		<th>Topic</th>
		<th>Doctor</th>
		<th>Date</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${threads }" var="thread">
		<tr>
			<td>${thread.threadName }</td>
			<td>${thread.doctorModel.doctorName }</td>
			<td>${thread.threadDate }</td>

			<td><a
				href="./threads?action=openThread&threadId=${thread.id }&ddid=${ddid}&pid=${pid}">Open</a></td>

		</tr>
	</c:forEach>
</table>

</main>



<footer class="text-center text-lg-start bg-light text-muted">
	<div class="text-center p-4"
		style="background-color: rgba(0, 0, 0, 0.05);">
		© 2023 Copyright:
		<p class="text-reset fw-bold">Holy Bugs</p>
	</div>
</footer>


</body>
</html>