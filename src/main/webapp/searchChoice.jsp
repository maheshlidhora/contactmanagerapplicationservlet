<jsp:include page="header.jsp"></jsp:include>
<div
	class="fluid-container d-flex flex-wrap flex-column justify-content-center align-items-center">
	<div class="row mt-3 text-center">
		<h1 class="h1">Search in The Contact List</h1>
	</div>
	<div class="row py-5">
		<div class="fluid-container">
			<form action="SearchInfos" method="post">
				<div class="input-group mb-3">
					<label class="input-group-text" for="searchChoice">Search
						By:</label> <select onchange="changeHandler()" class="form-select"
						id="searchChoice" name="searchChoice">
						<option selected disabled></option>
						<option value="ID">ID</option>
						<option value="First Name">First Name</option>
						<option value="Last Name">Last Name</option>
						<option value="Mobile Number">Mobile Number</option>
						<option value="Category">Category</option>
					</select>
				</div>
				<div class="mb-3">
					<input type="text" class="form-control" id="searchChoiceValue"
						name="searchChoiceValue">
				</div>
				<button type="submit" class="btn btn-outline-danger text-center">Submit</button>
			</form>
		</div>
	</div>
</div>
<script>
	function changeHandler() {
		let myChoice = document.getElementById("searchChoice").value;
		let searchBox = document.getElementById("searchChoiceValue");
		searchBox.placeholder = "Enter " + myChoice;
	}
</script>
<jsp:include page="footer.jsp"></jsp:include>