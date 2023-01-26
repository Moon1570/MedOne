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

	<c:if test="${relStatus =='0' }">                            
		<td>No member found with this phone</td>
	</c:if>
	<c:if test="${relStatus =='1' }">                            
		<td>Found</td>
	</c:if>
	<c:if test="${relStatus =='2' }">                            
		<td>You can't add yourself as relative</td>
	</c:if>

</body>
</html>