<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:forEach var="outletList" items="${outletList}" varStatus="loop">
	<c:set var="allOutlet" value="${loop.index}" />
</c:forEach>

<c:forEach var="item" items="${list}">
<c:if test="${item.active == 1}">
	<tr >
		<td>${item.firstName}</td>
		<td>${item.email}</td>
		<td><c:if test="${item.haveAccount==1}">
				<i class="fa fa-check"></i>
			</c:if> <c:if test="${item.haveAccount==0}">
				<i class="fa fa-close"></i>
			</c:if></td>
		<td><c:forEach var="outlet" items="${item.outlet}"
				varStatus="loop">
				<c:set var="lengthOutlet" value="${loop.index }" />
			</c:forEach> <c:set var="totalOutlet" value="${lengthOutlet }"></c:set> <c:if
				test="${totalOutlet==allOutlet }">
				<c:out value="All Outlet"></c:out>
			</c:if> <c:if test="${totalOutlet < allOutlet }">
				<c:forEach var="outlet" items="${item.outlet}" varStatus="loop">
					<c:out value="${outlet.outlet.name}"></c:out>
				</c:forEach>
			</c:if></td>
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

</c:if>
</c:forEach>
