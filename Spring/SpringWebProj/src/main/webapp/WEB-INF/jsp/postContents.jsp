<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contents Page</title>
<link rel="stylesheet" href="/css/post_contents.css" type="text/css">
<link rel="stylesheet" href="/css/mainLayout.css" type="text/css">
</head>
<body>
	<div class="container">
		<div class="items post">
			<div class="item post-name">
				<c:out value = "${post.data.post_name}"/>
			</div>
			<div class="item post-contents">
				<c:out value="${post.data.post_contents}" escapeXml="false"/>
				<!-- escapeXml 이 true 인경우 &lt 등으로 표시가 됨 <br> -->
			</div>
		</div>
		
		<div class="comment InputBox items">
				<c:forEach var="comment" items="${post.comment_list}">
				<div class="item">
					<span class="comment-context"><c:out value="${comment.context}"></c:out></span>
					<span class="comment-date"><c:out value="${comment.comment_date}"></c:out></span>
					<span class="comment-user-id"><c:out value="${comment.user_id}"/></span>
				</div>
				</c:forEach>
			<form action="/post/comment/${post.data.post_num}" method="post">
				<div class="inputBox item">
					<input type="text" name="context" placeholder="Comment 입력"/> 
				</div>
				<div class="inputBox item">
					<input type="submit" value="제출"/>
				</div>
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