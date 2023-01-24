<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
</head>
<body>

		
		<div style="position:relative; width:100%; height:0px; padding-bottom:56.25%;">
    <iframe style="position:absolute; left:0; top:0; width:100%; height:100%"
         src="./report?action=viewReport&rid=${report.reportId}">
    </iframe>
</div>
</body>
</html>