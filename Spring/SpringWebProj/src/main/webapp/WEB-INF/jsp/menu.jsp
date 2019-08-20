<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MenuList Page</title>
</head>
<body>
	<c:forEach var="menu" items="${menu_list}">
		<a href="/menu/list/${menu.menu_num}"><span><c:out value="${menu.menu_name}"/></span>
		<span><c:out value="${menu.menu_count}"/></span></a><br>
	</c:forEach>
	<button><a href="/logout">logOut</a></button>
</body>
</html>