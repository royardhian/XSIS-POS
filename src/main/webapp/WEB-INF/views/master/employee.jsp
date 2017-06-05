
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
					<span aria-hidden="true">×</span>
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
					$("#modal-form").removeClass("modal-danger");
				}
			});
		});
		

		// modal Outlet
		$("#modal-form").on("click","#btn-add-outlet",function(){
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
		
		//show outlet edit
		$("#modal-form").on("click","#btn-show-outlet",function(){
			$("#outlet-table").show();		
			$("#btn-show-outlet").hide();
			$("#editOutlet").attr("value","yes");
			$("#btn-cancel-outlet").show();
			$("#btn-add-outlet").show();
		});
		
		//cancel outlet edit
		$("#modal-form").on("click","#btn-cancel-outlet",function(){
			$("#outlet-table").hide();		
			$("#btn-show-outlet").show();
			$("#editOutlet").attr("value","no");
			$("#btn-cancel-outlet").hide();
			$("#btn-add-outlet").hide();
		});
		
		$("#modal-form").on("click","#btn-show-account",function(){
			$("#btn-show-account").hide();
			$("#btn-cancel-account").show();
			$("#role-account").show();
			$("#add-account").attr("value","yes");
		});
		
		$("#modal-form").on("click","#btn-cancel-account",function(){
			$("#btn-show-account").show();
			$("#btn-cancel-account").hide();
			$("#role-account").hide();
			$("#add-account").attr("value","no");
		});
		
		$("#modal-form").on("click","#btn-disable-account",function(){
			$("#btn-disable-account").hide();
			$("#btn-enable-account").show();
			$("#role-account").hide();
			$("#disable-account").attr("value","disable");
		});
		
		$("#modal-form").on("click","#btn-enable-account",function(){
			$("#btn-disable-account").show();
			$("#btn-enable-account").hide();
			$("#role-account").show();
			$("#disable-account").attr("value","enable");
		});
	
		// add outlet
		$("#modal-outlet").on("click",".btn-add-outlet",function(){
			
			var action = $("#out-action").val();
			var id = $(this).val();
			var name = $(this).attr("data-name");
			var idiot = [];
			var status="print";

			$("#list-outlet tr").each(function (index) {
			     idiot[index] = $(this).find("td:nth-child(2)").find("input").val();
			});
			
			console.log(action+id+idiot[0]);
			
			if(idiot.length==0 && action=="insert"){
				var row = $("#modal-form").find("#list-outlet >tr").length;
				var data = '<tr id="'+ row +'">'+
				'<td><input type="text" id="outletLName_'+ row +'_name" name="outletName['+ row +']" value="'+
					name +'" class="form-control outletName" readonly /></td>'+
				'<td><input type="text" id="outletId_'+ row +'_id" name="outletId['+ row +']" value="'+
					id +'" class="form-control outletName" readonly /></td>' +
				'<td class="col-md-1">'+
					'<button type="button" class="btn btn-danger btn-xs btn-delete-outlet"><i class="fa fa-trash-o"></i> </button> '+
				'</td>' +
				'</tr>';
				$("#list-outlet").append(data);		
			}
			else if(jQuery.inArray(id, idiot) != -1){
				alert("data sudah ada");	
			}
			else{
				if(action=="insert"){
				var row = $("#modal-form").find("#list-outlet >tr").length;
				var data = '<tr id="'+ row +'">'+
				'<td><input type="text" id="outletName_'+ row +'_name" name="outletName['+ row +']" value="'+
					name +'" class="form-control outletName" readonly /></td>'+
				'<td><input type="text" id="outletId_'+ row +'_id" name="outletId['+ row +']" value="'+
					id +'" class="form-control outletName" readonly /></td>' +
				'<td class="col-md-1">'+
					'<button type="button" class="btn btn-danger btn-xs btn-delete-outlet"><i class="fa fa-trash-o"></i> </button> '+
				'</td>' +
				'</tr>';
			$("#list-outlet").append(data);
				}
			}
					
		});
		
		//delete outlet
		$("#modal-form").on("click",".btn-delete-outlet", function(e){
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
					$("#modal-form").removeClass("modal-danger");
					$("#outlet-table").hide();
					$("#btn-cancel-outlet").hide();
					$("#btn-add-outlet").hide();
					$("#btn-cancel-account").hide();
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