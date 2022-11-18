<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/upload_style.css">

	<div class="wrapper_">
        <div class="uploadEnt">
<% if(id != null) { %>
        	<form action="/addEnt" method="get">
<% } else { %>
			<form action="/login/login.jsp">
<% } %>
               <table>
                <tr>
                    <td>기업명</td>
                    <td><input type="text" name="ent_name"></td>
                </tr>
                <tr>
                    <td>대표자</td>
                    <td><input type="text" name="representative"></td>
                </tr>
                <tr>
                    <td>업종</td>
                    <td><input type="text" name="sectors"></td>
                </tr>
                <tr>
                    <td>홈페이지</td>
                    <td><input type="url" name="url" placeholder="ex) https://www.page.com"></td>
                </tr>
                <tr>
                    <td>설립일</td>
                    <td><input type="date" name="establishment_date"></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <td>기업 소개</td>
                    <td><textarea name="explanation"cols="30" rows="10"></textarea></td>
                </tr>
                <tr>
                	<td></td>
                	<td><input type="submit" value="추가하기" id="sub"></td>
                </tr>
            </table>
           </form>
        </div>
    </div>

<%@ include file="/footer.jsp" %>