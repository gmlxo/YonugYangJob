<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/login_style.css">
<div class="wrapper">
	<div class="login-box">
				<!-- 로그인 페이지 -->
        <h1>Sign in</h1>
        <form action="/login" method="post">
            <div class="login-box-input">
                <input type="text" name="id"  required>
                <label> ID</label>
            </div>
            
            <div class="login-box-input">
                <input type="password" name="pwd" required>
                <label> Password</label>
            </div>
            <div class="login-label">
                <input type="submit" value="Sign in"><br>
									<!-- 회원가입 페이지로 이동 -->
                <label><a href="signUP.jsp">Sign Up</a> &nbsp; | 
								<!-- 아이디 / 비밀번호 찾기 페이지로 이동 -->
                &nbsp; <a href="find.jsp">Find ID/Password</a></label>
            </div>
        </form>
    </div>
</div>
<%@ include file="/footer.jsp" %>