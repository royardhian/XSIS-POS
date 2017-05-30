<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:forEach var="item" items="${list}">
	<tr <c:if test="${item.active == 0}">style="display: none"</c:if>>
		<td>${item.firstName}</td>
		<td>${item.email}</td>
		<td class="HA">${item.haveAccount}</td>
		<td>${item.active}</td>
		<td>${item.user.role.name}</td>

		<td>
			<button type="button" class="btn btn-success btn-xs btn-edit"
				value="${item.id}">
				<i class="fa fa-edit"></i>
			</button>
			<button type="button" class="btn btn-danger btn-xs btn-delete"
				value="${item.id}">
				<i class="fa fa-trash"></i>
			</button>
		</td>
	</tr>
	<script>
		$('.HA').filter(function() {
			return $.trim(this.innerHTML) === "1"
		}).html('<span class="glyphicon glyphicon-ok"></span>');

		$('.HA').filter(function() {
			return $.trim(this.innerHTML) === "0"
		}).html('<span class="glyphicon glyphicon-remove"></span>');

	</script>
</c:forEach>
