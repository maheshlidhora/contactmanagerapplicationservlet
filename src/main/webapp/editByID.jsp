<jsp:include page="header.jsp"></jsp:include>
<div
	class="fluid-container d-flex flex-wrap flex-column justify-content-center align-items-center">
	<div class="row mt-3 text-center">
		<h1 class="h1">Edit a Contact</h1>
	</div>
	<div class="row py-5">
		<div class="fluid-container">
			<form action="EditInfos" method="post">
				<div class="mb-3">
					<input type="text" class="form-control" id="id"
						placeholder="Enter ID" name="id">
				</div>
				<button type="submit" class="btn btn-outline-danger text-center">Submit</button>
			</form>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>