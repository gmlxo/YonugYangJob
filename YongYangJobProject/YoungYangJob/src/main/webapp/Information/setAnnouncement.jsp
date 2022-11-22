<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/upload_style.css">
<% ArrayList<Ent_emp_VO> annList = (ArrayList<Ent_emp_VO>)request.getAttribute("annList"); %>		
	<div class="wrapper">
<%
	if(annList != null){
		for(Ent_emp_VO ann : annList){
%>
	<div class="uploadAnn">
            <div class="headAnn">
                <div class="company_name">
                    company name <%=  %>
                </div>
                <div class="head">
                    <div class="title_ann_upload">
                        <b>title <%= %> </b>
                    </div>
                    <div class="support">
                        <a href="<%= %>">지원하러 가기 <%= %></a>&nbsp;
                    </div>
                </div>
            </div>
            <div class="contentsAnn">
                <table>
                    <tr>
                        <td>
                            <dl>
                                <dt>경력</dt>
                                <dd><%= %></dd>
                            </dl>
                        </td>
                        <td>
                            <dl>
                                <dt>학력</dt>
                                <dd><%= %></dd>
                            </dl>
                        </td>
                        <td>
                            <dl>
                                <dt>근무 형태</dt>
                                <dd><%= %></dd>
                            </dl>
                        </td>
                        <td>
                            <dl>
                                <dt>기간</dt>
                                <dd>D - <%= %></dd>
                            </dl>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <dl>
                                <dt>분야</dt>
                                <dd><%= %></dd>
                            </dl>
                        </td>
                        <td>
                            <dl>
                                <dt>담당자 이름</dt>
                                <dd>%= %></dd>
                            </dl>
                        </td>
                        <td colspan="2">
                            <dl class="up">
                                <dt>담당자 연락처</dt>
                                <dd><%= %></dd>
                            </dl>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <dl class="up">
                                <dt>홈페이지</dt>
                                <dd><a href="<%= %>"><%= %></a></dd>
                            </dl>
                        </td>
                        <td colspan="2">
                            <dl class="up">
                                <dt>기업 주소</dt>
                                <dd><%= %></dd>
                            </dl>
                        </td>
                    </tr>
                </table>
                <label class="ann_con"> 내용's</label>
            </div>
        </div>
<%
		}
	}
%>
    </div>
    
<%@ include file="/footer.jsp" %>
