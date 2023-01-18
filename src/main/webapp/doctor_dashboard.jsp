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
		session = request.getSession();
		if (session.getAttribute("did") == "false" || session.getAttribute("did") == null) {
			//	request.getRequestDispatcher("admin-login.jsp");
			response.sendRedirect("doctor_login.jsp");

		}
%>

Hello Doctor, ${dname}

</body>
</html>