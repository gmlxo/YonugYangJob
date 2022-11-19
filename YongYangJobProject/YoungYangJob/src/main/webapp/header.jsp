<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id, type, a_url;
	id = (String) session.getAttribute("logOK");
	type = (String) session.getAttribute("type");	
	a_url = "#";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yang Yang Job</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
        <script src="/js/jquery.js"></script>
    <link rel="stylesheet" href="/css/sub_style.css">
</head>
<body>

	<div class="container">
        <header
            class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
            <div class="logo">
                <p>logo</p>
            </div>

            <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/index.jsp" class="nav-link px-2 link-secondary">Home</a></li>
                <li><a href="/Information/jobs.jsp" class="nav-link px-2 link-dark hov"> 채용정보 </a></li>
                <li><a href="/Information/enterprise.jsp" class="nav-link px-2 link-dark hov"> 기업정보 </a></li>
                <li><a href="/Information/setCommunity.jsp" class="nav-link link-dark hov"> 커뮤니티 </a></li>
                <li><a href="/pop up/search_popUP.jsp" id="search" class="nav-link px-2 link-dark">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-search" viewBox="0 0 16 16">
                            <path
                                d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                        </svg></a></li>
            </ul>
            <div class="col-md-3 text-end">
<%
	if(id ==  null) {
%>
                <!-- 로그인 버튼 -->
                <button type="button" class="btn btn-outline-primary me-2"
                    onclick="location.href='/login/login.jsp'">Sign in</button>
                <!-- 회원가입 버튼 -->
                <button type="button" class="btn btn-primary" onclick="location.href='/login/signUP.jsp'">
                    Sign up</button>
<%
	} else {
		if(type.equals("2")) {
			a_url = "기업_";
		} else if(type.equals("3")){
			a_url = "all";
		} else {
			a_url = "지원자_";
		}
%>
			| &nbsp; <a href="<%=a_url%>"><%= id %></a> &nbsp; | &nbsp; 
			<a href="/signOut">로그아웃</a> &nbsp; |	
<% 
	}
%>
			</div>
        </header>
    </div>