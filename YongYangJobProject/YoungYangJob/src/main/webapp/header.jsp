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
<!-- 부트스트립 css 연결 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<!-- 부트스트립 js 연결 -->
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
		<!-- n = 1 이면 index jsp 로, n = 2 면 jobs jsp 로 이동 -->
                <li><a href="/index?n=1" class="nav-link px-2 link-secondary">Home</a></li>
                <li><a href="/index?n=2" class="nav-link px-2 link-dark hov"> 채용정보 </a></li>
		<!-- n = 2 이면 두번쨰 쿼리 실행 _ all --> 
                <li><a href="/entList?n=2" class="nav-link px-2 link-dark hov"> 기업정보 </a></li>
                <li><a href="/ityList" class="nav-link link-dark hov"> 커뮤니티 </a></li>
                <li><div class="search-box-popUp">
                    	<!-- 검색 -->
			<form action="/seaEntList" method="get">
                        <!-- 돋보기? 아이콘 _ 검색 아이콘 -->
			&nbsp;<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-search" viewBox="0 0 16 16">
                            <path
                                d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                        </svg>  
			<!-- n = 1 이면 첫번쨰 쿼리 실행 _ 검색 -->
                       	<input type="hidden" name="n" value="1">
                        <input type="search" name="keyword" placeholder="지역, 분야, 회사로 검색하세요.">
                        <input type="submit" value="검색" id="heaberSub">
                    </form>
                </div></li>
            </ul>
            <div class="col-md-3 text-end">
<%
	/* id 값이 없으면 로그인 회원가입 버튼 보이기 */
	if(id ==  null) {
%>
                <!-- 로그인 버튼 -->
                <button type="button" class="btn btn-outline-primary me-2"
                    onclick="location.href='/login/login.jsp'">Sign in</button>
                <!-- 회원가입 버튼 -->
                <button type="button" class="btn btn-primary" onclick="location.href='/login/signUP.jsp'">
                    Sign up</button>
<%
	/*  id 값이 있다면 user ID 와 로그아웃 보이기 */
	} else {
%>
			| &nbsp; <%= id %> &nbsp; | &nbsp; 
			<a href="/signOut">로그아웃</a> &nbsp; |	
<% 
	}
%>
			</div>
        </header>
    </div>
