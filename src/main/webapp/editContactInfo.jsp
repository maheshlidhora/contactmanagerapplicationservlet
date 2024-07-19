<%@page
	import="com.jspiders.contactmanagerapplicationservlet.entity.Contact"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<div
	class="fluid-container d-flex flex-wrap flex-column justify-content-center align-items-center">
	<div class="row mt-3 text-center">
		<h1 class="h1">Enter Correct Details to Edit Contact</h1>
	</div>
	<%
	List<Contact> contacts = (List<Contact>) request.getAttribute("list");
	%>
	<%
	for (Contact contact : contacts) {
	%>
	<div class="row py-5">
		<div class="fluid-container">
			<form action="EditContactDetails" method="post">
				<div class="mb-3">
					<input type="text" class="form-control" id="id"
						placeholder="Enter ID" name="id" value="<%=contact.getId()%>"
						readonly disable>
				</div>
				<div class="mb-3">
					<input type="text" class="form-control" id="firstName"
						placeholder="First Name" name="firstName"
						value="<%=contact.getFirstName()%>">
				</div>
				<div class="mb-3">
					<input type="text" class="form-control" id="lastName"
						placeholder="Last Name" name="lastName"
						value="<%=contact.getLastName()%>">
				</div>
				<div class="mb-3">
					<input type="tel" class="form-control" id="mobile"
						placeholder="Mobile Number" name="mobile"
						value="<%=contact.getMobileNumber()%>">
				</div>
				<div class="input-group mb-3">
					<label class="input-group-text" for="category">Select Category</label> 
					<select class="form-select" id="category" name="category">
						<%
						String [] options = {"Home", "Friend", "Family", "Colleague"};
						%>
						<%
						for (int i = 0; i < options.length; i++) {
						%>
							<%
							if(options[i].equals(contact.getCategory())){
							%>
								<option selected value="<%=options[i]%>"><%=options[i]%></option>
							<% 
							} else{
							%>		
								<option value="<%=options[i]%>"><%=options[i]%></option>
							<%	
							}
							%>
						<%
						}
						%>
					</select>
				</div>
				<button type="submit" class="btn btn-outline-danger text-center">Submit</button>
			</form>
		</div>
	</div>
	<%
	}
	%>
</div>
<jsp:include page="footer.jsp"></jsp:include>