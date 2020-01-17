<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PostInsert Page</title>
<link rel="stylesheet" href="/css/postInsert.css" type="text/css">
<link rel="stylesheet" href="/css/mainLayout.css" type="text/css">
</head>
<body>
	<div class="container">
        <div class="items">
                <form class="form" action="/post/insert/checker" method="post">
                    <div class="inputBox half"><input type="text" placeholder="Post_Name" name="post_name" id="post_name"></div>
                    <div class="inputBox half">
                    	<select name="menu_num">
                    		<c:forEach var="menu" items="${menu}" varStatus="status">
                    			<option value="${menu.menu_num}">${menu.menu_name}</option>
                    		</c:forEach>
                    	</select>
                    	</div>
                    <div class="inputBox"><div id="thumbnail_label">ThumbNail</div><input type="file" name="thumbnail" id="thumbnail"></div>
                    <div class="inputBox contents"><textarea name="post_contents" placeholder = "Contents" id="post_contents" cols="30" rows="10"></textarea></div>
                    <div class="inputBox"><input type="submit" value="제출"></div>
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