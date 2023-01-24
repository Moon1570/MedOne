<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports</title>
</head>
<body>


<table border="1">
	<thead>Reports</thead>
	<tr>
		<th>Name</th>
		<th>Upload Date</th>
		<th>Type</th>
		<th>View</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${reports}" var="report">

	<tr>
		<td>${report.reportName }</td>
		<td>${report.reportCreateDate }</td>
		<c:if test="${report.image}">                            
			<td>Image</td>
		</c:if>
		<c:if test="${!report.image}">                            
			<td>PDF</td>
		</c:if>
		<td> <a href="./report?action=viewReportFullScreen&rid=${report.reportId}">View Full Screen</a>
		<iframe id="inlineFrameExample"
		    title="Inline Frame Example"
		    width="300"
		    height="200"
		    src="./report?action=viewReport&rid=${report.reportId}">
		</iframe>
		<td><a href="./report?action=downloadReport&rid=${report.reportId}">Download</a> Edit Delete</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>