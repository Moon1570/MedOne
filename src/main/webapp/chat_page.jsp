<%@page import="model.ReportModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.ReportDao"%>
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
		<form action="./messages?action=sendMessage&threadId=${threadId }"
			method="post">
			${ddid }
			<textarea name="myMessage"></textarea>
			<br> <input type="hidden" value="${pid }" name="pid"> <input
				type="hidden" value="${ddid }" name="ddid">
			<button type="submit">Send Message</button>

		</form>
	</c:if>
	
		
		<%
				int pid = (int)session.getAttribute("pid");
				ReportDao reportDao = new ReportDao();
				List<ReportModel> reportModels = reportDao.getAllReportByPatientId(pid);
				if(!reportModels.isEmpty()){
					request.setAttribute("reports", reportModels);
					request.setAttribute("flag_rep", "1");
				} else {
					request.setAttribute("flag_rep", "0");
				}
			%>
			
		<c:if test="${flag_rep == 0 }">
		No reports to share. Want to add some?
		</c:if>
		
		<c:if test="${flag_rep == 1 }">
		<form action="./threads?action=shareReport&threadId=${threadId }">
		<select name="dropdownReport" required="required">
			<option value="0">Share a report</option>
			<c:forEach items="${reports}" var="report">
				<option value="${report.reportId}">${report.reportName }</option>
			</c:forEach>
		</select> 
		<button type="button">Share</button>
		</form>
		</c:if>
		
		
		
		
		
	<c:if test="${flag ==1 }">
		<table>
			<tr>
				<td>sender</td>
				<td>Receiver</td>
				<td>message</td>
				<td>Date</td>

			</tr>
			<c:forEach items="${messages }" var="message">
				<tr>
					<td>${message.sender }</td>
					<td>${message.receiver }</td>
					<td>${message.messages }</td>
					<td>${message.messageDate }</td>
				</tr>
			</c:forEach>
			<form action="./messages?action=sendMessage&threadId=${threadId }"
				method="post">
				<textarea name="myMessage"></textarea>
				<input type="hidden" value="${pid }" name="pid"> <input
					type="hidden" value="${ddid }" name="ddid"> <br>
				<button type="submit">Send Message</button>

			</form>
			


		</table>
	</c:if>
</body>
</html>