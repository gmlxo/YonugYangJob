<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="login-box">
        <h1>Sign in</h1>
        <form action="#" method="post">
            <div class="login-box-input">
                <input type="text" name="id"  required>
                <label> ID</label>
            </div>
            
            <div class="login-box-input">
                <input type="password" name="password" required>
                <label> Password</label>
            </div>
            <div class="login-label">
                <input type="submit" value="Sign in"><br>
                <label><a href="signUp.html">Sign Up</a> &nbsp; | 
                &nbsp; <a href="find.html">Find ID/Password</a></label>
            </div>
        </form>
    </div>
</body>
</html>