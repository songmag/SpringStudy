<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/signin.css" type="text/css">
<link rel="stylesheet" href="/css/mainLayout.css" type="text/css">
<meta charset="UTF-8">
<title>ChangeInfo Page</title>
</head>
<body>
    <div class="container">
        <div class="form">
        <h2>WelCome To Programming Page</h2>
        <form action="/changeInfo/checking" method="post" autocomplete="off">
            <div class="inputBox">
            <input type="text" name="id" id="id" placeholder="ID" disabled value="${user.id}">
            </div>
            <div class="inputBox">
            <input type="password" name="pw" id="pw" placeholder="Change Pw">
            </div>
            <div class="inputBox">
            <input type="text" name="name" id="name" placeholder="${user.name}">
            </div>
            <div class="inputBox">
            <input type="text" name="address" id="address" placeholder="${user.address}">
            </div>
            <div class="inputBox">
            <input type="text" name="phone_number" id="phone_number" placeholder="${user.phone_number}">           
            </div>
            <div class="inputBox">
            <textarea name="self_instruction" id="self_instruction" cols="30" rows="10" placeholder="${user.self_instruction}"></textarea>
            </div>
            <div class="inputBox">
                <input class="left_position" type="submit" value="정보 변경">
                <a href="/login" class="right_position">취소</a>
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