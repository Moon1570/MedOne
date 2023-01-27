<%@page import="dao.PatientDao"%>
<%@page import="model.PatientModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<jsp:include page="patient_header.jsp" />

<%

int pid = (int) session.getAttribute("pid");
PatientDao db = new PatientDao();
PatientModel patientModel = db.getPatientById(pid);

request.setAttribute("doctors", patientModel.getDoctors());

%>





<div class="container">
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Name</th>
              <th scope="col">Address</th>
              <th scope="col">Phone</th>
              <th scope="col">Image</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
      		<c:forEach items="${doctors}" var="doctor">

			<tr>
			<td scope="row">${doctor.doctorName }</td>
			<td>${ doctor.doctorAddress}</td>
			<td>${doctor.doctorPhone }</td>
			<td><img src="./doctors?action=getImage&did=${doctor.doctorId }"></td>
			<td><a href="./patients?action=deleteDoctorFromPatientList&did=${doctor.doctorId }">Delete</a></td>
		<!-- 	<c:if test="${report.image}">                            
			<td>Image</td>
			</c:if>
			<c:if test="${!report.image}">                            
			<td>PDF</td>

			</c:if> -->
	</c:forEach>
          </tbody>
        </table>
      </div>


</main>
<footer class="text-center text-lg-start bg-light text-muted">
  <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
    � 2023 Copyright:
    <p class="text-reset fw-bold ">Holy Bugs</p>
  </div>
</footer>


</body>
</html>