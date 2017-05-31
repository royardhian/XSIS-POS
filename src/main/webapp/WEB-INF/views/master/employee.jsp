
<%
	request.setAttribute("contextName", request.getContextPath());
%>
<!-- modal -->
<div id="modal-form" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 id="modal-title">Form Kategori</h4>
			</div>
			<div class="modal-body"></div>
		</div>
	</div>
</div>

<div id="modal-outlet" class="modal modal-primary" tabindex="-1"
	role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">�</span>
				</button>
				<h4 id="modal-title" class="modal-title">Assign Outlet</h4>
			</div>
			<div class="modal-body">
			</div>
		</div>
	</div>
</div>

<!-- list -->
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Employee List</h3>
		<div class="box-tools">
			<div class="input-group input-group-sm" style="width: 250px;">
				<input type="text" id="txt-search" class="form-control pull-right"
					placeholder="Search">

				<div class="input-group-btn">
					<button type="button" id="btn-search" class="btn btn-default">
						<i class="fa fa-search"></i>
					</button>
					<button type="button" id="btn-add" class="btn btn-primary">
						<i class="fa fa-plus"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="box-body">
		<!-- <button id="SH">Hide/Show</button> -->
		<table id="listEmployee" class="table table-responsive table-striped">
			<thead>
				<tr>
					<td>Name</td>
					<td>Email</td>
					<td>Have Account</td>
					<td>Active</td>
					<td>Role</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody id="list-data">

			</tbody>
		</table>
	</div>
</div>

<script>
/* 	$('#SH').on('click', function() {
		var $rowsNo = $('#listEmployee tbody tr').filter(function() {
			return $.trim($(this).find('td').eq(3).text()) === "0"
		}).toggle();
	});
 */
	function loadData() {
		$.ajax({
			url : '${contextName}/master/employee/list',
			dataType : 'html',
			type : 'get',
			success : function(result) {
				$("#list-data").html(result);

			}
		});

	}

	$(document).ready(function() {
		// panggil method load data
		loadData();

		$("#btn-add").click(function() {
			$.ajax({
				url : '${contextName}/master/employee/add',
				dataType : 'html',
				type : 'get',
				success : function(result) {
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Add Employee");
					$("#modal-form").modal("show");
				}
			});
		});
		

		// modal Outlet
		$("#modal-form").on("click","#btn-add-variant",function(){
			$.ajax({
				url : '${contextName}/master/employee/addOutlet',
				dataType : 'html',
				type : 'get',
				success : function(result) {
					$("#modal-outlet").find(".modal-body").html(result);
					$("#var-action").val("insert");
					$("#modal-outlet").modal("show");
				}
			});
		});
		
		// add variant
		$("#modal-outlet").on("click",".btn-add-outlet",function(){
			var id = $(this).val();
			var name = $(this).attr("data-name");
			var idiot = [];
			var status="print";

			$("#list-outlet tr").each(function (index) {
			     idiot[index] = $(this).find("td:first-child").html();
			});
			console.log(id+idiot[0]);
			if(idiot.length==0){
				var data = "<tr><td class='data-cell'>"+ id +"</td><td>"+name+"</td></tr>";
				$("#list-outlet").append(data);		
			}
			else if(jQuery.inArray(id, idiot) != -1){
				alert("data sudah ada");	
			}
			else{
				var data = "<tr><td class='data-cell'>"+ id +"</td><td>"+name+"</td></tr>";
				$("#list-outlet").append(data);
			}
					
		});
		
		//delete variant
		$("#modal-form").on("click",".btn-delete-variant", function(e){
			e.preventDefault();
			$(this).parent().parent().remove();
			
			$.each($("#modal-form").find("#list-outlet >tr"), function(index, item){
				var trID = $(this).attr("id");
				// replace id
				$(this).attr('id',index);
				
				$(this).find(":input[type='text']").each(function(key,val){
					// Replaced Name
                    var oldName = $(this).attr('name');
                   	var newName = oldName.replace('[' + trID + ']', '[' + index + ']');
                    $(this).attr('name', newName);
         
					// Replaced ID
                    var oldID = $(this).attr('id');
                    var newID = oldID.replace('_' + trID + '_', '_' + index + '_');
                    $(this).attr('id', newID);
                 
				});
			});
		});
	

		// saat haveAccount di checked		
		$("#modal-form").on("change", "#haveAccount", function() {

			if (this.checked == true) {
				$(this).attr('value', '1');
				$("#modal-form").find("#role-account").show();
			} else {
				$(this).attr('value', '0');
				$("#modal-form").find("#role-account").hide();
			}
		});

		// edit data
		$("#list-data").on("click", ".btn-edit", function() {
			var vId = $(this).val();
			$.ajax({
				url : '${contextName}/master/employee/edit',
				data : {
					id : vId
				},
				dataType : 'html',
				type : 'get',
				success : function(result) {
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Edit Employee");
					$("#modal-form").modal("show");
				}
			});
		});

		//delete
		$("#list-data").on('click', '.btn-delete', function() {
			var id = $(this).val();
			$.ajax({
				url : '${contextName}/master/employee/delete',
				data : {
					'id' : id
				},
				type : 'get',
				dataType : 'html',
				success : function(result) {
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Menghapus Data Employee");
					$("#modal-form").addClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});

		// save, edit, delete
		$("#modal-form").on("submit", "#form-employee", function() {
			var vData = $(this).serialize();
			$.ajax({
				url : '${contextName}/master/employee/save.json',
				type : 'post',
				data : vData,
				success : function(result) {
					if (result.message == "success") {
						$("#modal-form").modal("hide");
						loadData();
					}
				}
			});
			return false;
		});
	});
	
</script>