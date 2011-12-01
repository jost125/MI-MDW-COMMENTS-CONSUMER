<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../layout/header.jsp" %>
<%@include file="../layout/menu.jsp" %>

<a href="thread/create">Create new thread</a>

<c:if test="${!empty threads}">
	<ul>
		<c:forEach var="thread" items="${threads}">
			<li class="${thread.closed ? "closed" : "opened"}"><a href="thread/${thread.id}">${thread.name}</a></li>
		</c:forEach>
	</ul>
</c:if>

<%@include file="../layout/tail.jsp" %>
