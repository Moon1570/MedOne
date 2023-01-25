<%@page import="com.mchange.v2.sql.filter.SynchronizedFilterDataSource"%>
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
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader ("Expires", 0);
		session = request.getSession();
		if (session.getAttribute("pid") == "false" || session.getAttribute("pid") == null) {
			//	request.getRequestDispatcher("admin-login.jsp");
			response.sendRedirect("login.jsp");

		}
%>



<body>
 Hello ${name}, ${msg } , name = ${singleReport.reportName }  <br>
 <iframe id="inlineFrameExample"
		    title="Inline Frame Example"
		    width="300"
		    height="200"
		    src="./report?action=viewReport&rid=${singleReport.reportId}">
		</iframe>
 
 Upload Report <br>
                 <form class="mx-1 mx-md-4" action="./report?action=reportUpload" method="post" enctype="multipart/form-data">
 
 						<input type="text" name="reportName" placeholder="enter report name"> <br>
 						<input class="input-field" type="file" name="reportImage" required="required" id="file" onchange="return fileValidation()">
						<br>
						<button type="submit" class="btn btn-primary btn-lg">Login</button>
							
				</form>
				
		<br>
		<a href="./report?action=viewAll">View all reports</a>
 
 <a href="./patients?action=logout">Logout</a>
 
 <script>
        function fileValidation() {
            var fileInput =
                document.getElementById('file');
             
            var filePath = fileInput.value;
         
            // Allowing file type
            var allowedExtensions =
                    /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
             
            if (!allowedExtensions.exec(filePath)) {
                alert('Invalid file type');
                fileInput.value = '';
                return false;
            }
            else
            {
             
                // Image preview
                if (fileInput.files && fileInput.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function(e) {
                        document.getElementById(
                            'imagePreview').innerHTML =
                            '<img src="' + e.target.result
                            + '"/>';
                    };
                     
                    reader.readAsDataURL(fileInput.files[0]);
                }
            }
        }
    </script>
</body>
</html>