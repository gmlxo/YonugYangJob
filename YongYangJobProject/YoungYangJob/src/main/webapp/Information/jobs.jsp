<%@page import="vo.Ent_emp_VO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/index_style.css">

	<div class="wrapper">
        <div class="job-sea">
						<!-- 검색한 지역에 맞게 정보 가져오게 하기 -->
            <form action="/seaJob" method="get">
                <input type="search" id="jobSea" name="keyword" placeholder=" 지역을 입력해 주세요">
                <input type="submit" value="검색">
            </form>
        </div> <br>
        <div class="box">
<%
  /* index list 값 받아오기 */
	ArrayList<Ent_emp_VO> indexList = (ArrayList<Ent_emp_VO>) request.getAttribute("indexList");
	/* null 값이 아니면 실행 */
	if(indexList != null) {
		for(Ent_emp_VO vo : indexList){
%>
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
	}
%>
    </div>
   </div>

<%@ include file="/footer.jsp" %>