<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/login_style.css">

	<div class="login-box">
        <h1>sign up</h1>
        <form action="#" method="post">
            <div class="login-box-input">
                <input type="text" name="id" required>
                <label>ID</label>
            </div>
            <div class="login-box-input">
                <input type="password" name="password" required>
                <label>Password</label>
            </div>
            <div class="login-box-input">
                <input type="text" name="name" required>
                <label>Name</label>
            </div>
            <div class="login-box-input">
                <input type="text" name="date_of_birth" required>
                <label>Birth</label>
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
    
<%@ include file="/footer.jsp" %>