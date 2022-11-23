<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/upload_style.css">
	
        <div class="uploadCom">
            <h2>게시물 올리기</h2>
<!-- id 값이 null 값이면 로그인 페이지로, null 값이 아니면 게시물 올리기 -->
<% if(id != null) { %>
        	<form action="/ity" method="get">
<% } else { %>
			<form action="/login/login.jsp">
<% } %>
            	<table class="tabCom">
                	<tr>
                    	<td>title</td>
                    	<td><input type="text" name="title" id=""></td>
                    	<td>올리는 사람</td>
                    	<td><input type="text" name="id" value="<%=id%>" readonly></td>
                	</tr>
                	<tr>
                    	<td>내용</td>
                    	<td colspan="3"><textarea name="contents" id="comText"></textarea></td>
                	</tr>
            	</table>
            	<div class="comBu"><input type="submit" value="게시하기" id="comSub"></div>
            </form>
    </div>
		
<%@ include file="/footer.jsp" %>
</body>
</html>