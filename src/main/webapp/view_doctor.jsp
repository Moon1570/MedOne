<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script language="javascript">
function closeWin() {
   window.close();
}
</script>
</head>
<body>

	
	Is it the right doctor?<br>
	Name = ${doctor.doctorName}<br>
	Address = ${doctor.doctorAddress}<br>

	
	<img src="./doctors?action=getImage&did=${doctor.doctorId}">	
	
	<form action="./patients?action=addDoctor" method="post" >
		<input type="hidden" value="${doctor.doctorId }" name="did">
		<button type="submit">Add Doctor</button>

	</form>
</body>
</html>