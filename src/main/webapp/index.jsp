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
 Hello ${name} <br>
 Upload Report <br>
                 <form class="mx-1 mx-md-4" action="./report?action=reportUpload" method="post" enctype="multipart/form-data">
 
 						<input type="text" name="reportName" placeholder="enter report name"> <br>
 						<input class="input-field" type="file" name="reportImage" required="required" id="file" onchange="return fileValidation()">
						<br>
						<button type="submit" class="btn btn-primary btn-lg">Login</button>
							
				</form>
				
		<br>
		<a href="./report?action=viewAll">View all reports</a>
 
 
 
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