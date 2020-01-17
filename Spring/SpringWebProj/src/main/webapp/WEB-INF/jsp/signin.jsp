<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/signin.css" type="text/css">
<link rel="stylesheet" href="/css/mainLayout.css" type="text/css">
<meta charset="UTF-8">
<title>SignIn Page</title>
</head>
<body>
    <div class="container">
        <div class="form">
        <h2>WelCome To Programming Page</h2>
        <form action="/signin/checking" method="post" autocomplete="off">
            <div class="inputBox">
            <input type="text" name="id" id="id" placeholder="ID">
            </div>
            <div class="inputBox">
            <input type="password" name="pw" id="pw" placeholder="PW">
            </div>
            <div class="inputBox">
            <input type="text" name="name" id="name" placeholder="Name">
            </div>
            <div class="inputBox">
            <input type="text" name="address" id="address" placeholder="Address">
            </div>
            <div class="inputBox">
            <input type="text" name="phone_number" id="phone_number" placeholder="Phone_Number">           
            </div>
            <div class="inputBox">
            <textarea name="self_instruction" id="self_instruction" cols="30" rows="10" placeholder="Self_Instruction"></textarea>
            </div>
            <div class="inputBox">
            <input type="submit" value="가입">
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