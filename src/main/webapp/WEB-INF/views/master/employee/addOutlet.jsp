<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="form-variant" class="form-horizontal">
	<input type="hidden" id="var-action" name="var-action" value="insert">
	<input type="hidden" id="id" name="id">


	<div class="form-group">
		<label class="control-label col-md-3" for="roleId">Select Role</label>
		<div class="col-md-9">
			<select id="outletId" name="outletId" class="form-control">
				<option value="0">none</option>
				<c:forEach var="outlet" items="${outletList}">
					<option value="${outlet.id}">${outlet.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="modal-footer">
		<button type="button" class="btn btn-default pull-left"
			data-dismiss="modal">
			<i class="fa fa-close"></i> Close
		</button>
		<button type="button" id="btn-add-outlet" class="btn btn-primary">
			<i class="fa fa-plus"></i> Add
		</button>
	</div>
</form>