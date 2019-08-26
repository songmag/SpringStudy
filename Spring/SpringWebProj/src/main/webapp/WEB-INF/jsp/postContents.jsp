<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contents Page</title>
<link rel="stylesheet" href="/css/postContents.css" type="text/css">
<link rel="stylesheet" href="/css/mainLayout.css" type="text/css">
</head>
<body>
	<div class="container">
		<div><c:out value = "${post.data.post_name}"/></div>
		<div>
			<c:out value = "${post.data.post_contents}"/>
		</div>
			<c:forEach var="comment" items="${post.comment_list}">
			<p>
				<c:out value="${comment.context}"></c:out>
				<c:out value="${comment.comment_date}"></c:out>
			</p>
			</c:forEach>
			<div>
				<form action="/comment/${post.data.post_num}">
					<div class="inputBox">
						<input type="text" name="comment_context"/> 
					</div>
					<input type="submit" value="제출"/>
				</form>
			</div>
	</div>
</body>
<script>
	<c:if test = "${!empty errorCode}"> 
		alert("${errorCode}");
	</c:if>
</script>
</html>