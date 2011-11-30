<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../layout/header.jsp" %>
<%@include file="../layout/menu.jsp" %>

<c:forEach var="thread" items="${threads}">
	${thread.name}
</c:forEach>

<%@include file="../layout/tail.jsp" %>
