<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:forEach var="item" items="${list}">
	<c:if test="${item.active==1}">
		<tr>
			<td>${item.firstName }&nbsp;${item.lastName }</td>
			<td>${item.email }</td>
			<td><c:if test="${item.haveAccount == 0}">
					<label class="control-label text-danger"><i
						class="fa fa-close"></i></label>
				</c:if> <c:if test="${item.haveAccount == 1}">
					<label class="control-label text-success"><i
						class="fa fa-check"></i><c:if test="${item.user.active == 0}"><label class="control-label text-danger">disabled</label></c:if></label>
				</c:if></td>
			<td>
			<c:choose>
				<c:when
					test="${fn:length(item.employeeOutlet)==fn:length(outletList)}">All Outlet
				</c:when>
				
				<c:otherwise>
					<c:forEach var="out" items="${item.employeeOutlet}"
						varStatus="loop">
						<c:if test="${loop.count<fn:length(item.employeeOutlet)-1}">${out.outlet.name},
					</c:if>
						<c:if test="${loop.count==fn:length(item.employeeOutlet)-1}">${out.outlet.name} &
					</c:if>
						<c:if test="${loop.count==fn:length(item.employeeOutlet)}"> ${out.outlet.name}
					</c:if>
					</c:forEach>
				</c:otherwise>
				</c:choose>
			</td>
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

