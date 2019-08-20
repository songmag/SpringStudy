<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        <form action="/signin" method="post" autocomplete="off">
            <input type="text" name="id" id="id" placeholder="ID"><br>
            <input type="password" name="pw" id="pw" placeholder="PW"><br>
            <input type="text" name="name" id="name" placeholder="Name"><br>
            <input type="text" name="address" id="address" placeholder="Address"><br>
            <input type="text" name="phone_number" id="phone_number" placeholder="Phone_Number"><br>           
            <textarea name="self_instruction" id="self_instruction" cols="30" rows="10" placeholder="Self_Instruction"></textarea><br>
            <input type="submit" value="가입"><br>
        </form>
    </div>    
</body>
</html>