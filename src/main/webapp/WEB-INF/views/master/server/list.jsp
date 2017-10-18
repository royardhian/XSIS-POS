<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:forEach var="item" items="${list}">
	<c:if test="${item.active==1}">
		<tr>
			<td>${item.serverName}</td>
			<td>${item.serverIp}</td>
			<td>${item.pass.username}</td>
			<td>${item.pass.password}</td>
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
	</c:if>
</c:forEach>

