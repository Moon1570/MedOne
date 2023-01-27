<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chat Page</title>
</head>
<body>
	<c:if test="${flag ==0 }">
		No message history. Why don't you try sending one?
		<form action="./messages?action=sendMessage&threadId=${threadId }" method="post">
		    <textarea name="myMessage"></textarea>
		    <br>
		    <button type="submit">Send Message</button>
		
		</form>
	</c:if>
	<c:if test="${flag ==1 }">
		<table>
			<tr>
				<td>sender</td>
				<td>message</td>
				<td>Date</td>
				
			</tr>
			<c:forEach items="${messages }" var="message">
			<tr>
				<td>
					
					<c:if test="${not message.isPatient }">
					Doctor
					</c:if>
					<c:if test="${message.isPatient }">
					You
					</c:if>
				</td>
				<td>${message.messages }</td>
				<td>${message.messageDate }</td>
				
			</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>