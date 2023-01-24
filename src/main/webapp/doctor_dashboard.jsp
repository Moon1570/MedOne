<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader ("Expires", 0);
		session = request.getSession();
		if (session.getAttribute("did") == "false" || session.getAttribute("did") == null) {
			//	request.getRequestDispatcher("admin-login.jsp");
			response.sendRedirect("doctor_login.jsp");

		}
%>

Hello Doctor, ${dname}

<br>

<form action="./doctors?action=getPatientReport" method="post">
<input type="text" name="patientInfo" placeholder="phone">
<button type="submit">Search</button>
</form>

<form action="./doctors?action=addPatient" method="post">
<input type="text" name="patientInfo" placeholder="phone">
<button type="submit">Search</button>
</form>

</body>
</html>