<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/setEnt_style.css">

	<div class="headerEnt">
        <a href="/ityList">
            < 전체 게시글 </a>
    </div>
    <br>
    <div class="set">
        <div class="heEnt">
            <div class="tit-box">
                <div class="tit">
                    <h2>&nbsp;title</h2>
                </div>
                <div class="declaration">
                    <a href="/popUp/declaration_popUP.jsp">신고</a>&nbsp;&nbsp;
                </div>
            </div>
            <div class="pro-box">
                <div class="profile">
                    &nbsp;<img src="https://cdn-icons-png.flaticon.com/512/456/456283.png" alt="userPro">
                    <div class="profileText">
                        <label class="userName">nickname</label><br>
                        <label class="dayPro">n일 전</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="entContents">
            <label>&nbsp;contentssssssss</label>
            <div class="br"></div>
        </div>
    </div>
    <div class="entComent">
        <form action="#">
        	<input type="hidden" name="id" value="<%=id%>">
        	<textarea name="" id="" cols="30" rows="10"></textarea>
        	<input type="submit" value="댓글달기">
        </form>
    </div>
    <div class="setComent">
        <div class="setCom">
            &nbsp;<img src="https://cdn-icons-png.flaticon.com/512/456/456283.png" alt="userPro">
            <div class="comProfileText">
                <label class="userName">nickname</label>
            </div>
            <div class="setTitCom">
                <div class="titCom"><label>titleeeee</label></div>
                <div class="dayCom">
                    <label>n일 전</label>
                </div>
            </div>
        </div>
    </div>
    <div class="setComent">
        <div class="setCom">
            &nbsp;<img src="https://cdn-icons-png.flaticon.com/512/456/456283.png" alt="userPro">
            <div class="comProfileText">
                <label class="userName">nickname</label>
            </div>
            <div class="setTitCom">
                <div class="titCom"><label>titleeeee</label></div>
                <div class="dayCom">
                    <label>n일 전</label>
                </div>
            </div>
        </div>
    </div>

<%@ include file="/footer.jsp" %>