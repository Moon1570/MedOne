<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Relative</title>
</head>
<body>
	
<jsp:include page="patient_header.jsp" />

	<section class="vh-90" style="background-color: #eee;">
  <div >
    <div class="row d-flex justify-content-center align-items-center h-90">
      <div class="col-md-8 col-xl-4">
      <h2 class="h2"> Relative Profile</h2><br>
      <p>Is this the person you are looking for?</p>
	<form action="./patients?action=addRelationship	" method="post" >
		<input type="hidden" value="${relative.patientId }" name="rid">

        <div class="card" style="border-radius: 15px;">
          <div class="card-body text-center">
            <div class="">
              <img src="./patients?action=getImage&pid=${relative.patientId}"
                class="rounded-circle img-fluid" style="width: 200px;" />
            </div>
            <h4 class="mb-2">${relative.patientName }</h4>
            <p class="text-muted mb-4">${relative.patientAddress } </p>
            <div class="mb-4 pb-2">
    		<a href="tel:${relative.patientPhone}">${relative.patientPhone }</a>
            </div>
            		<input type="text" placeholder="Relation" name="relationName">
            <br><br>
            <button type="submit" class="btn btn-primary btn-rounded btn-lg">
              Add Relative
            </button>
           
            </div>
          </div>
        </div>

	</form>

      </div>
    </div>
  </div>
</section>

</body>
</html>