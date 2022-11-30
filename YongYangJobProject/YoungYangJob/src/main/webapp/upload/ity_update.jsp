<%@page import="vo.CommentVO"%>
<%@page import="vo.CommunityVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>

<% 
	/* setIty 값을 받아옴 _ 게시글용 */
	ArrayList<CommunityVO> setIty = (ArrayList<CommunityVO>)request.getAttribute("ity");
%>
<link rel="stylesheet" href="/css/setEnt_style.css">

	<div class="headerEnt">
				<!-- 게시글 전체 보러 가기 -->
        <a href="/ityList">
            < 전체 게시글 </a>
    </div>
    <br>
<%
	/* null 값이 아니면 실행 */
	if(setIty != null) {
	/* list 값이 있는 만큼 반복 */
		for(CommunityVO ity : setIty){
%>
    <div class="set">
        <div class="heEnt">
            <div class="tit-box">
                <div class="tit">
                    <h2>&nbsp;<%= ity.getIty_title() %></h2>
                </div>
                <div class="declaration">
<%
			if(ity.getUser_id().equals(id)) {
%>
				|&nbsp;<a href="/ityUpdate">저장</a>&nbsp;|
               &nbsp;<a href="/userDelete?ity_idx=<%= ity.getIty_idx() %>">삭제</a>&nbsp;|&nbsp;&nbsp;
<%
			}
%>
				</div>
            </div>
            <div class="pro-box">
                <div class="profile">
                    &nbsp;<img src="https://cdn-icons-png.flaticon.com/512/456/456283.png" alt="userPro">
                    <div class="profileText">
                        <label class="userName"><%= ity.getUser_id() %></label><br>
                        <label class="dayPro"><%= ity.getIty_day() %>일 전</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="entContents">
            <label>&nbsp; <textarea id="ityUpdateText"><%= ity.getIty_contents() %></textarea> </label>
            <div class="br"></div>
        </div>
    </div>
<%
		}
	}
%>

<%@ include file="/footer.jsp" %> 