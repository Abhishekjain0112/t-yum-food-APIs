<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link type="text/css" rel="stylesheet" href="./style/style.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<title>TruYum</title>


</head>

<body>
	<input type="hidden" id="page" value="customer">
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
	
	
		<header class="mdl-layout__header bg-danger" >
		
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title">truYum</span> 

 								<span class="material-icons">
               							 local_dining </span>

				<div class="mdl-layout-spacer"></div>
				<nav class="mdl-navigation">
					<a class="mdl-navigation__link" href="/show-menu-list-customer">Menu</a> <a
						class="mdl-navigation__link" href="/cart">Cart</a>
				</nav>
			</div>
		</header>
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title">Select Role</span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="/show-menu-list-admin">Admin</a>
				<a class="mdl-navigation__link" href="/show-menu-list-customer">Customer</a>
			</nav>
		</div>
		<main class="mdl-layout__content">
			<div class="page-content">
				<!-- Your content goes here -->
				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--3-col"></div>
					<div class="mdl-cell--6-col">
						<caption>
							<h3>Edit Menu Item Status</h3>
							<p class="notif" style="text-align: left;">Menu Item Details
								saved successfully</p>
						</caption>
					</div>
					<div class="mdl-cell mdl-cell--3-col"></div>
				</div>
			</div>
		</main>
      <!-- footer start from here  -->
       <footer class="navbar page-footer py-sm-2 py-md-0  bg-danger ">
        <!-- Copyright -->
        <div class="footer-copyright text-center py-3" >© 2019 Copyright:
          <a href="#"> TruYum.com</a>
        </div>
        <!-- Copyright -->
      
      </footer>	
	</div>
</body>

</html>
