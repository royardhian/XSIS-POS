<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="form-item" method="post" class="form-horizontal">

	<!-- validasi saat save -->
	<input type="hidden" id="action" name="action" value="insert"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-3" for="nama">Nama Item</label>
				<div class="col-md-9">
					<input type="text" id="name" name="name" class="form-control" />
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-3" for="categoryId">Kategori</label>
				<div class="col-md-9">
					<select id="categoryId" name="categoryId" class="form-control">
						<option value="">= Pilih Kategori =</option>
						<c:forEach var="category" items="${categoryList}">
							<option value="${category.id}"> ${category.name} </option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>
	<br/>
	<div class="row">
		<div class="col-md-12">
			<div class="box box-info">
				<div class="box-header">
					<h3 class="box-title">Data Item Variant</h3>
					<div class="box-tools">
			         	<button type="button" id="btn-add-variant" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></button>
			         </div>
				</div>
				<div class="box-body">
					<table class="table table-considered">
						<thead>
							<tr>
								<td class="col-md-4">Variant Name</td>
								<td class="col-md-2">Unit Price</td>
								<td class="col-md-2">SKU</td>
								<td class="col-md-2">Beginning Stock</td>
								<td class="col-md-1">Alert At</td>
								<td class="col-md-1">Action</td>
							</tr>
						</thead>
						<tbody id="list-variant">
						
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>
		<button type="submit" id="btn-save-item" class="btn btn-primary"><i class="glyphicon glyphicon-floppy-disk"></i> Simpan</button>
	</div>
</form>