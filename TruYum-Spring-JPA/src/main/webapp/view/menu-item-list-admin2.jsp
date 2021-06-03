<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="Headder2.jsp"%>
<!doctype html>
<html>
	
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link type="text/css" rel="stylesheet" href="./style/style.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<title>Menu Item Title Admin</title>
</head>
  <body> 
    <!-- Fill code here -->


<center>

<div class="body">
		<div class="menu-item-heading">
			<h1 class="body-text-heading" id="">Menu Items</h1>
		</div>
		<div id="menu-Item-List-Result" class="table-div-my">
		 <table class="mdl-data-table mdl-js-data-table">
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Active</th>
					<th>Date of Launch</th>
					<th>Category</th>
					<th>Free Delivery</th>
					<th>Action</th>
				</tr>
				<c:forEach var="eachitem" items="${menuItemListAdmin}">
					<tr>
						<td>${eachitem.name}</td>
						<td>Rs. ${eachitem.price}</td>
						<td>${eachitem.active}</td>
						<td><fmt:formatDate value="${eachitem.dateOfLaunch}"
								pattern="yyyy-MM-dd" /></td>
						<td>${eachitem.category}</td>
						<td>${eachitem.freeDelivery}</td>
						<td><a href="/show-edit-menu-item?menuItemId=${eachitem.id}">Edit</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>










</center>


  </body>
</html>
