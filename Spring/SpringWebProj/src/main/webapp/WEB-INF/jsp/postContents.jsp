<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contents Page</title>
</head>
<body>
	<p><c:out value = "${post.data.post_name}"/></p>
	<p><c:out value = "${post.data.post_contents}"/></p>
	<c:forEach var="comment" items="${post.comment_list}">
		<p>
			<c:out value="${comment.context}"></c:out>
			<c:out value="${comment.comment_date}"></c:out>
		</p>
	</c:forEach>
</body>
<script>
	<c:if test = "${!empty errorCode}"> 
		alert("${errorCode}");
	</c:if>
</script>
</html>