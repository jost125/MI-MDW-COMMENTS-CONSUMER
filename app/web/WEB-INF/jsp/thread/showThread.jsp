<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../layout/header.jsp" %>
<%@include file="../layout/menu.jsp" %>

<h2>${thread.name}</h2>

<c:if test="${!empty comments}">
	<c:forEach items="${comments}" var="comment">
		<div class="comment">
			<div class="comment-header">
				<div class="comments-header-left">
					<div class="comment-author-name">
						${comment.authorName}
					</div>
				</div>

			</div>
			<div class="comment-text">
				<c:choose>
					<c:when test="${comment.blocked}"><i>Comment is blocked for it's abuse content</i></c:when>
					<c:otherwise>${comment.text}</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:forEach>
</c:if>

<form:form method="POST" modelAttribute="commentForm" action="/thread/postMessage/${thread.id}">
	<form:errors path="*" cssClass="errors" element="div" />
		<p>
			<label for="authorName">Author</label><form:input path="authorName" />
		</p>
		<p>
			<label for="text">Text</label><form:textarea path="text" />
		</p>
		<p>
			<input type="submit" value="Post" />
		</p>
</form:form>

<%@include file="../layout/tail.jsp" %>
