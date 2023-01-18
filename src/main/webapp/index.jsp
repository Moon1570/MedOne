<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MedOne</title>
</head>

<%
		session = request.getSession();
		if (session.getAttribute("pid") == "false" || session.getAttribute("pid") == null) {
			//	request.getRequestDispatcher("admin-login.jsp");
			response.sendRedirect("login.jsp");

		}
%>



<body>
 Hello ${name}
</body>
</html>