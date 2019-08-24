<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginPage</title>
<link rel="stylesheet" href="/css/login.css" type="text/css">
<link rel="stylesheet" href="/css/mainLayout.css" type="text/css">
</head>
<body>
    <div class="container">
   <div class="form">
    	<h2>Login</h2>
    	<form action="/login/checking" method="post" autocomplete="off">
    	<div class="inputBox">
       	<input type="text" name="id" id="id" placeholder="UserId">
      </div>
    <div class="inputBox">  
      <input type="password" name="pw" id="pw" placeholder="UserPw">
     </div>
     <div class="inputBox">
        <input type="submit" value="Login">
      </div>
      <p>Sign In <a href="/signin">Click</a></p>
      <p>Forget Password? <a href="#">Click </a></p>
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