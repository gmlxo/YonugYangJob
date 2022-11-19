<%@page import="vo.CommunityVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<% ArrayList<CommunityVO> ityList = (ArrayList<CommunityVO>)request.getAttribute("ityList"); %>
<link rel="stylesheet" href="/css/community_style.css">

	<div class="wrapper">
	<a href="/upload/community.jsp">게시물 올리기</a><br>
	
<%
	if(ityList != null){
		for(CommunityVO ity : ityList){
%>
        <div class="contentsNity" onclick="location.href='/comList?ity_idx=<%=ity.getIty_idx()%>';">
            <h3><%= ity.getIty_title() %></h3>
            <div class="content"><%= ity.getIty_contents() %></div>
            	<div class="etcCon">
                	<div class="etc">
                    	<%= ity.getUser_id() %> 님 &nbsp; <%= ity.getIty_day() %> 일 전
                	</div>
            	</div>
            <div class="line"></div>
        	</div>
<%
		}
	}
%>
	</div>
<%@ include file="/footer.jsp" %>