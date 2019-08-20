<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginPage</title>
<link rel="stylesheet" href="jsp/../css/Login.css" type="text/css">
</head>
<body>
    <div class="container">
    <h2>Login</h2>
    <form action="/login" class="form" method="post">
    <div class="inputBox">
       <input type="text" name="id" id="id" placeholder="UserId">
    </div>
    <div class="inputBox">  
      <input type="password" name="pw" id="pw" placeholder="UserPw">
     </div>
     <div class="inputBox">
        <input type="submit" value="Login">
      </div>
      <p>Sign In <a href="/signin" method="get">Click</a></p>
      <p>Forget Password? <a href="#">Click </a></p>
    </form>
    </div>
</body>
</html>