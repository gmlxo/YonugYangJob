<%@page import="java.util.ArrayList"%>
<%@page import="vo.Ent_emp_VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="header.jsp" %>
<!-- 제목 옆 로고 넣어주기 -->
<link rel="stylesheet" href="/css/index_style.css">

<div class="box">
<%
	/* index list 값을 받아옴 */
	ArrayList<Ent_emp_VO> indexList = (ArrayList<Ent_emp_VO>) request.getAttribute("indexList");
	/* null 값이 아니면 실행 */
	if(indexList != null) {
		/* index listㅇㅔ 값이 있는 만큼 반복 */
		for(Ent_emp_VO vo : indexList){
%>
	<!-- 채용 공고 제목을 setAnn servlet에 보내줌 -->
    <div class="index-box" onclick="location.href='/setAnn?title=<%=vo.getEmp_title()%>';">
        <div class="enterprise">
            <!-- 기업 로고 -->
            <img src="<%= vo.getEnt_logo_img() %>" alt="logo"> <br>
            <!-- 기업 이름 -->
            <b>&nbsp; <%= vo.getCompany_name() %></b><br>
            <!-- 간단한 취업 정보 -->
            	<label class="conInto">&nbsp; <%= vo.getEmp_contents() %> </label><br>
        </div>
        <div class="etc-box">
            <!-- 분야 -->
            <label class="secInto">&nbsp; #<%= vo.getEnt_sectors() %> </label>
			<!-- D-day -->
             <label class="day"> D - <%= vo.getEmp_day() %> </label>
        </div>
    </div>
<% 
		}
	} else {
		response.sendRedirect("/index?n=1");
	}
%></div>
<%@ include file="footer.jsp" %>