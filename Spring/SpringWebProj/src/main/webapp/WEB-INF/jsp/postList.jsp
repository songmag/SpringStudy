<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PostList ${list.menu.menu_name} </title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>날짜</th>
                <th>작성자</th>
            </tr>
        </thead>
	<c:forEach var="post" items="${list.post_list}">
        <tr>
            <td><c:out value="${post.post_num}"/></td>
            <td><a href="/post/contents/${post.post_num}"><c:out value="${post.post_name}"/></a></td>
            <td><c:out value="${post.post_date}"/></td>
            <td><c:out value="${post.id_num}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>