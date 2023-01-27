<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
	
<jsp:include page="patient_header.jsp" />

	<section class="vh-90" style="background-color: #eee;">
  <div >
    <div class="row d-flex justify-content-center align-items-center h-90">
      <div class="col-md-8 col-xl-4">
      <h2 class="h2"> Doctor Profile</h2><br>
      <p>Is this the doctor you are looking for?</p>
	<form action="./patients?action=addDoctor" method="post" >
        	<input type="hidden" value="${doctor.doctorId }" name="did">

        <div class="card" style="border-radius: 15px;">
          <div class="card-body text-center">
            <div class="">
              <img src="./doctors?action=getImage&did=${doctor.doctorId}"
                class="rounded-circle img-fluid" style="width: 200px;" />
            </div>
            <h4 class="mb-2">${doctor.doctorName}</h4>
            <p class="text-muted mb-4">${doctor.doctorAddress} </p>
            <div class="mb-4 pb-2">
    		<a href="tel:${doctor.doctorPhone}">${doctor.doctorPhone}</a>
            </div>
            <button type="submit" class="btn btn-primary btn-rounded btn-lg">
              Add Doctor
            </button>
           
            </div>
          </div>
        </div>

	</form>

      </div>
    </div>
  </div>
</section>

	
	
	
	
	<footer class="text-center text-lg-start bg-light text-muted">
  <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
    © 2023 Copyright:
    <p class="text-reset fw-bold">Holy Bugs</p>
  </div>
</footer>
</body>
</html>