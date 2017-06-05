<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:forEach var="item" items="${list}">
	<tr>
		<td>${item.firstName }&nbsp;${item.lastName }</td>
		<td>${item.email }</td>
		<td><c:if test="${item.haveAccount == 0}">
				<label class="control-label text-danger"><i
					class="fa fa-close"></i></label>
			</c:if> <c:if test="${item.haveAccount == 1}">
				<label class="control-label text-success"><i
					class="fa fa-check"></i></label>
			</c:if></td>
		<td>
			<c:if test="${fn:length(item.outlet)==fn:length(outletList)}">All Outlet
			</c:if>
			<c:if test="${fn:length(item.outlet)==1}">
				<c:forEach var="out" items="${item.outlet}">${out.outlet.name}			
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(item.outlet)==2 && fn:length(item.outlet)!=fn:length(outletList)}">
				<c:forEach var="out" items="${item.outlet}" varStatus="loop">
					<c:if test="${loop.count==1}">${out.outlet.name}
					</c:if>
					<c:if test="${loop.count==2}">& ${out.outlet.name}
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(item.outlet)<fn:length(outletList) && fn:length(item.outlet)>2}">
				<c:forEach var="out" items="${item.outlet}" varStatus="loop">
					<c:if test="${loop.count<fn:length(item.outlet)-1}">${out.outlet.name},
					</c:if>
					<c:if test="${loop.count==fn:length(item.outlet)-1}">${out.outlet.name} &
					</c:if>
					<c:if test="${loop.count==fn:length(item.outlet)}"> ${out.outlet.name}
					</c:if>				
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
</c:forEach>
