<%@page import="vo.CommunityVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<% 
	/* setIty 값을 받아옴 _ 게시글용 */
	ArrayList<CommunityVO> setIty = (ArrayList<CommunityVO>)request.getAttribute("ity");
	/* comList 값을 받아옴 _ 댓글용*/
	ArrayList<CommentVO> comList = (ArrayList<CommentVO>)request.getAttribute("comList"); 
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
	if(setIty != null)
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
                    <a href="/userDelete?ity_idx=<%= ity.getIty_idx() %>">게시글 내리기</a>&nbsp;&nbsp;	
<% 
				} else {
%>
				<a href="/popUp/declaration_popUP.jsp?ity_idx=<%= ity.getIty_idx() %>">신고</a>&nbsp;&nbsp;
<%
				}
%></div>
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
            <label>&nbsp;<%= ity.getIty_contents() %></label>
            <div class="br"></div>
        </div>
    </div>
	<!-- 댓글 달기 -->
	<div class="entComent">
<%
	if(id != null) {
%>
    <form action="/com">
<%
	} else {
%>
        <form action="/login/login.jsp">
<%
	}
%>
					<!-- user id 값을 보내기용 -->
        	<input type="hidden" name="id" value="<%=id%>">
					<!-- 게시물 idx 를 보내기용 -->
        	<input type="hidden" name="ity" value="<%=ity.getIty_idx()%>">
        	<textarea name="contents" cols="30" rows="10"></textarea>
        	<input type="submit" value="댓글달기">
        </form>
    </div>
<%
		}
	
	/* 값이 있으면 실행 */
	if(comList != null){
		/* list 값이 있는 만큼 반복 */
		for(CommentVO com : comList){
%>
    <div class="setComent">
        <div class="setCom">
            &nbsp;<img src="https://cdn-icons-png.flaticon.com/512/456/456283.png" alt="userPro">
            <div class="comProfileText">
                <label class="userName"><%= com.getUser_id() %></label>
            </div>
            <div class="setTitCom">
                <div class="titCom"><label><%= com.getCom_contents() %></label></div>
                <div class="dayCom">
                    <label><%= com.getCom_day() %> 일 전</label>
                </div>
            </div>
        </div>
    </div>
<%
		}
	}
%>
<%@ include file="/footer.jsp" %>