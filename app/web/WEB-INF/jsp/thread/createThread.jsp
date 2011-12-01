<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="../layout/header.jsp" %>
<%@include file="../layout/menu.jsp" %>

<h2>New thread</h2>

<form:form method="POST" modelAttribute="threadForm" action="/thread/create">
	<form:errors path="*" cssClass="errors" element="div" />
	<p>
		<label for="email">Thread name</label><form:input path="name" />
		<input type="submit" value="Create" />
	</p>
</form:form>

<%@include file="../layout/tail.jsp" %>
