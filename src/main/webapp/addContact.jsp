<jsp:include page="header.jsp"></jsp:include>
<div
	class="fluid-container d-flex flex-wrap flex-column justify-content-center align-items-center">
	<div class="row mt-3 text-center">
		<h1 class="h1">Enter Details to Add Contact</h1>
	</div>
	<div class="row py-5">
		<div class="fluid-container">
			<form action="ContactInfos" method="post">
				<div class="mb-3">
					<input type="text" class="form-control" id="id"
						placeholder="Enter ID" name="id">
				</div>
				<div class="mb-3">
					<input type="text" class="form-control" id="firstName"
						placeholder="First Name" name="firstName">
				</div>
				<div class="mb-3">
					<input type="text" class="form-control" id="lastName"
						placeholder="Last Name" name="lastName">
				</div>
				<div class="mb-3">
					<input type="tel" class="form-control" id="mobile"
						placeholder="Mobile Number" name="mobile">
				</div>
				<div class="input-group mb-3">
					<label class="input-group-text" for="category">Select
						Category</label> <select class="form-select" id="category" name="category">
						<option selected disabled></option>
						<option value="Home">Home</option>
						<option value="Friend">Friend</option>
						<option value="Family">Family</option>
						<option value="Colleague">Colleague</option>
					</select>
				</div>
				<button type="submit" class="btn btn-outline-danger text-center">Submit</button>
			</form>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>