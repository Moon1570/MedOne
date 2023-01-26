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
${relStatus }
	<c:if test="${relStatus =='0' }">                            
		<td>No member found with this phone</td>
	</c:if>
	<c:if test="${relStatus =='3' }">                            
		<td>Already added as a relative</td>
	</c:if>
	
	<c:if test="${relStatus =='2' }">                            
		<td>You can't add yourself as relative</td>
	</c:if>
	<c:if test="${relStatus =='1' }">                            
		<td>Found</td>
	
	
	Is it the right person?<br>
	Name = ${relative.patientName}<br>
	<img src="./patients?action=getImage&pid=${relative.patientId}">
	
	<form action="./patients?action=addRelationship" method="post" >
		<input type="hidden" value="${relative.patientId }" name="rid">
		<input type="text" placeholder="Relation" name="relationName">
		<button type="submit">Submit</button>
	</form>
</c:if>
</body>
</html>