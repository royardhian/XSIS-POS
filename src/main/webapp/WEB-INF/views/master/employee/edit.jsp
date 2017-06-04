<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="form-employee" action="" method="POST" class="form">
	<!-- validasi saat save -->
	<input type="hidden" id="action" name="action" value="update" /> <input
		type="hidden" id="id" name="id" value="${item.id }" /> <input
		type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label" for="firstName">First Name</label> <input
					type="text" name="firstName" id="firstName"
					value="${item.firstName }" class="form-control" />
			</div>
		</div>

		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label" for="lastName">Last Name</label> <input
					type="text" name="lastName" id="lastName" value="${item.lastName }"
					class="form-control" />
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<input type="hidden" id="getTitle" name="getTitle"
					value="${item.title }"> <label class="control-label"
					for="title">Title</label> <select name="title" id="title"
					class="form-control">
					<option>Mr.</option>
					<option>Mrs.</option>
				</select>
			</div>
		</div>

		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label" for="email">Email</label> <input
					type="email" name="email" id="email" value="${item.email }"
					class="form-control" />
			</div>
		</div>
	</div>

	<!-- status add outlet -->
	<input type="hidden" id="editOutlet" name="editOutlet" value="no" />

	<div class="box box-info">
		<div class="box-header">
			<h3 class="box-title">Assign Outlet</h3>
			<div class="box-tools">
				<button type="button" id="btn-show-outlet"
					class="btn btn-primary btn-sm">Edit Outlet</button>
				<button type="button" id="btn-cancel-outlet"
					class="btn btn-danger btn-sm">Cancel</button>
				<button type="button" id="btn-add-outlet"
					class="btn btn-primary btn-sm">
					<i class="fa fa-plus"></i>
				</button>
			</div>
		</div>
		<div class="box-body">
			<table id="outlet-table" class="table table-considered">
				<thead>
					<tr>
						<td class="col-md-4">Outlet</td>
						<td class="col-md-4">id</td>
						<td class="col-md-1">Action</td>
					</tr>
				</thead>
				<tbody id="list-outlet">
					<c:set var="count" value="0" scope="page" />
					<c:forEach var="outlet" items="${item.outlet}">
						<tr id="${count}">
							<td><input type="text" id="outletName_${count}_name"
								name="outletName[${count}]" value="${outlet.outlet.name}"
								class="form-control outletName" readonly /></td>
							<td><input type="text" id="outletId_${count}_id"
								name="outletId[${count}]" value="${outlet.outlet.id}"
								class="form-control outletId" readonly /></td>
							<td class="col-md-1">
								<button type="button"
									class="btn btn-danger btn-xs btn-delete-outlet">
									<i class="fa fa-trash-o"></i>
								</button>
							</td>
						</tr>
						<c:set var="count" value="${count + 1}" scope="page" />
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<div class="row">
		<div class="form-group col-md-12">
			<div class="Account" align="center">
				<input type="hidden" id="haveAccount" name="haveAccount"
					value="${item.haveAccount }"> <input type="hidden" id="RID"
					name="RID" value="${item.user.roleId }">
				<button type="button" id="btn-show-account"
					class="btn btn-primary btn-sm">Add Account</button>
				<button type="button" id="btn-cancel-account"
					class="btn btn-danger btn-sm">Cancel Add Account</button>
			</div>
		</div>
	</div>

	<!-- status add account -->
	<input type="hidden" id="add-account" name="add-account" value="no" />

	<div class="row" id="role-account" style="display: none">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="roleId">Role</label> <select
					id="roleId" name="roleId" class="form-control">
					<option value="0">none</option>
					<c:forEach var="role" items="${roleList}">
						<option value="${role.id}">${role.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="userName">Username</label> <input
					type="text" name="userName" id="userName"
					value="${item.user.username }" class="form-control" />
			</div>
		</div>

		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="password">Password</label> <input
					type="text" name="password" id="password"
					value="${item.user.password }" class="form-control" />
			</div>
		</div>
	</div>

	<div class="modal-footer">
		<button type="button" class="btn btn-default pull-left"
			data-dismiss="modal">
			<i class="fa fa-close"></i> Close
		</button>
		<button type="submit" class="btn btn-primary">
			<i class="glyphicon glyphicon-floppy-disk"></i> Simpan
		</button>
	</div>
</form>

<script type="text/javascript">
	$(".date-picker").datepicker({
		autoclose : true,
		format : 'mm/dd/yyyy',
	});

	var HA = $('#haveAccount').val();
	if (HA == 1) {
		$("#modal-form").find("#role-account").show();
		$("#btn-show-account").hide();
	}

	var role = $('#RID').val();
	$("#roleId").val(role);

	var title = $('#getTitle').val();
	$("#title").val(title);
</script>