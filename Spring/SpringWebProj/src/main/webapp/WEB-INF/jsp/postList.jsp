<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PostList ${list.menu.menu_name} </title>
<link rel="stylesheet" href="/css/contents.css" type="text/css">
<link rel="stylesheet" href="/css/mainLayout.css" type="text/css">
</head>
<body>
	<div class="container">
            <div class="items">
                  <div class="item">
                        <span>썸네일</span>
                        <span>제목</span>
                        <span>날짜</span>
                        <span>작성자</span>
                  </div>
            <c:forEach var="post" items="${list.post_list}">
            <div class="item">
              <a href="/post/contents/${post.post_num}">
                  <span><img src="${post.thumbnail}"></span>
                  <span class="name"><c:out value="${post.post_name}"/></span>
                  <span><c:out value="${post.post_date}"/></span>
                  <span><c:out value="${post.id}"/></span>
            </a>
            </div>
            </c:forEach>
            <div class="counting">
            	<c:choose>
            		<c:when test="${list.menu.menu_count > 10}">
            			<c:forEach begin="0" end="2" step="1" varStatus="status">
            				<span>${status.count}</span>
            			</c:forEach>
            			<span>...</span>
            			<c:forEach begin="${list.menu.menu_count-2}" end="${list.menu.menu_count-1}" step="1" varStatus="status">
            				<span>${status.index}</span>
            			</c:forEach>
            		</c:when>
            		<c:when test="${list.menu.menu_count < 10 && list.menu.menu_count != 1}">
            			<c:forEach begin="1" end="${list.menu.menu_count-1}" step="1" varStatus="status">
            				<span>${status.count}</span>
            			</c:forEach>
            		</c:when>
            		<c:otherwise><span></span></c:otherwise>
            	</c:choose>
            </div>
            <div class="button">
                  <a href="/post/insert">Posting</a>
            </div>
      </div>
      </div>
</body>

<script>
	<c:if test = "${!empty errorCode}"> 
		alert("${errorCode}");
	</c:if>
</script>
</html>