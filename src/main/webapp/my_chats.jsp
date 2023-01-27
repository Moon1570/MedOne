<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<th>Doctor Name</th>
		<th>Date</th>
	</tr>
	<c:forEach items="${threads }" var="thread">
	<tr>
		<td>${thread.doctorModel.doctorName }</td>
		<td>${thread.threadDate }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>