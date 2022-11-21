<%@page import="java.util.ArrayList"%>
<%@page import="vo.Ent_emp_VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="header.jsp" %>
<link rel="stylesheet" href="/css/index_style.css">

<div class="box">
<%
	ArrayList<Ent_emp_VO> indexList = (ArrayList<Ent_emp_VO>) request.getAttribute("indexList");
	if(indexList != null) {
		for(Ent_emp_VO vo : indexList){
%>
    <div class="index-box">
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
		response.sendRedirect("/index");
	}
%></div>
<%@ include file="footer.jsp" %>