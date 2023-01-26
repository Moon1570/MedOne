<%@page import="dao.DrugDao"%>
<%@page import="model.DrugModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Drugs</title>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.20/b-1.6.1/b-flash-1.6.1/datatables.min.js"></script>
	<script type="text/javascript">
        $(document).ready(function () {
            $("#myTable").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
        </script>
</head>
<body>


Directory of drugs

<table id="myTable"
				class="table table-striped table-bordered table-hover text-center">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Drug ID</th>
						<th scope="col">Drug Name</th>
						<th scope="col">Drug Type</th>
						<th scope="col">Drug Manufacturer</th>
				</thead>
				<tbody>

		 <% 
		 DrugDao db = new DrugDao();
			List<DrugModel> drugModels = db.getAllDrugs();

		 for(DrugModel c: drugModels){ %>
                    <tr>
                             <td><%=c.getDrugId()%></td>
                         <td><%=c.getBrandName()%></td>
                         <td><%=c.getType()%></td>
                         <td><%=c.getManufacturer()%></td>
                         
                    </tr>
                <% } %>
				</tbody>
</table>


 
</body>
</html>