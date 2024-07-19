<%@page
	import="com.jspiders.contactmanagerapplicationservlet.entity.Contact"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<div
	class="fluid-container d-flex flex-wrap flex-column justify-content-center align-items-center">
	<div class="row mt-3 text-center pb-5">
		<h1 class="h1">All The Contacts</h1>
	</div>
	<%
	List<Contact> contacts = (List<Contact>) request.getAttribute("list");
	%>
	<%
	for (Contact contact : contacts) {
	%>
	<div class="row">
		<div class="card border border-3 border-danger bg-dark px-0 mb-3"
			style="width: 25rem;">
			<div class="card-header bg-danger">
				ID:
				<%=contact.getId()%></div>
			<div class="card-body text-danger">
				<h5 class="card-title m-0 text-light">
					<span class="text-danger fw-bolder">FULL NAME : </span><%=contact.getFirstName()%>
					<%=contact.getLastName()%>
				</h5>
				<p class="card-text m-0 text-light">
					<span class="text-danger fw-bolder">CONTACT: </span><%=contact.getMobileNumber()%>
				</p>
				<p class="card-text m-0 text-light">
					<span class="text-danger fw-bolder">CATEGORY: </span><%=contact.getCategory()%>
				</p>
			</div>
		</div>
	</div>
	<%
	}
	%>
</div>
<jsp:include page="footer.jsp"></jsp:include>