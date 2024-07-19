<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Manager</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.css"
	rel="stylesheet" crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.js"
	crossorigin="anonymous"></script>
</head>
<body class="bg-dark text-light font-monospace">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">Contact Manager</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 gap-2">
					<li class="nav-item"><a href="addContact.jsp"
						class="nav-link btn btn-outline-danger text-light">Add a
							Contact</a></li>
					<li class="nav-item"><a href="editByID.jsp"
						class="nav-link btn btn-outline-danger text-light">Edit a
							Contact</a></li>
					<li class="nav-item"><a
						href="ContactInfos"
						class="nav-link btn btn-outline-danger text-light">Show All
							The Contacts</a></li>
					<li class="nav-item"><a href="deleteContact.jsp"
						class="nav-link btn btn-outline-danger text-light">Delete a
							Contact</a></li>
					<li class="nav-item"><a href="searchChoice.jsp"
						class="nav-link btn btn-outline-danger text-light">Search The
							Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>