<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="form-variant" class="form-horizontal">
	<input type="hidden" id="out-action" name="out-action" value="insert">
	<input type="hidden" id="id" name="id">


	<div class="form-group">
		<div id="checkbox-outlet" class="col-md-12">
			<table class="table table-considered">
				<tr>
					<th colspan="2" align="center">Select Role</th>
				</tr>

				<c:forEach var="outlet" items="${outletList}">
					<tr>
						<td>${outlet.name }</td>
						<td><button class="btn btn-success btn-flat btn-xs btn-add-outlet" type="button" value="${outlet.id}" data-name="${outlet.name}"><i class="fa fa-check"> </i></button></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

	<div class="modal-footer">
		<button type="button" id="btn-add-outlet" class="btn btn-success" data-dismiss="modal">
			<i class="fa fa-check"></i> Done
		</button>
	</div>
</form>