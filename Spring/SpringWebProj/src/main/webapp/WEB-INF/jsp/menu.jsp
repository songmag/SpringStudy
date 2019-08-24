<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MenuList Page</title>
<link rel="stylesheet" href="/css/menu.css" type="text/css">
<link rel="stylesheet" href="/css/mainLayout.css" type="text/css">
</head>
<body>
	<div class="container">
		<div class="items">
			<h2>MenuList</h2>
			<c:forEach var="menu" items="${menu_list}">
				<div class="item">
					<a href="/list/post/${menu.menu_num}"><span><c:out value="${menu.menu_name}"/></span>
					<span><c:out value="${menu.menu_count}"/></span></a>
				</div>
			</c:forEach>
			<span class="item button">
				<span><a href="/logout">LogOut</a></span>
			</span>
			<span class="item button">
				<span><a href="/changeInfo">Change Identity</a></span>
			</span>
		</div>
	</div>
</body>
<script>
	<c:if test = "${!empty errorCode}"> 
		alert("${errorCode}");
	</c:if>
</script>
</html>