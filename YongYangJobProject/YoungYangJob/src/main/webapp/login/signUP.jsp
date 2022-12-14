<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/login_style.css">
<div class="wrapper_up">
	<div class="sign-box">
        <h1>Sign up</h1>
				<!-- 회원가입 페이지 -->
        <form action="/signUp" method="post">
            <div class="login-box-input">
                <input type="text" name="id" required>
                <label>ID</label>
            </div>
            <div class="login-box-input">
                <input type="text" name="name" required>
                <label>Name</label>
            </div>
            <div class="login-box-input">
                <input type="password" name="pwd" required>
                <label>Password</label>
            </div>
            <div class="login-box-input">
                <input type="text" name="email" required>
                <label>Email</label>
            </div>
            <div class="login-label">
                <input type="submit" value="Sign Up" id="signUp-but"><br>
            </div>
        </form>
    </div>
</div>
<%@ include file="/footer.jsp" %>