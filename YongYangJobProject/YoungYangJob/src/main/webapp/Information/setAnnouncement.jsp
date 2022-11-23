<%@page import="vo.Ent_emp_VO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/upload_style.css">
<!-- index or job jsp 에서 정보를 더 자세히 보여주는 곳 -->
<!-- ann list 값을 받아온다 -->
<% ArrayList<Ent_emp_VO> annList = (ArrayList<Ent_emp_VO>)request.getAttribute("annList"); %>		
	<div class="wrapper">
<%
	/* null 값이 아니면 실행 */
	if(annList != null){
		/* ann list 값이 있는 만큼 실행 */
		for(Ent_emp_VO ann : annList){
%>
	<div class="uploadAnn">
            <div class="headAnn">
                <div class="company_name">
                     <%= ann.getCompany_name() %>
                </div>
                <div class="head">
                    <div class="title_ann_upload">
                        <b> <%= ann.getEmp_title() %> </b>
                    </div>
                    <div class="support">
                        <a href="<%= ann.getEmp_url() %>">지원하러 가기 </a>&nbsp;
                    </div>
                </div>
            </div><br>
            <div class="contentsAnn">
                <table>
                    <tr>
                        <td>
                            <dl>
                                <dt>경력</dt>
                                <dd><%= ann.getEmp_career() %></dd>
                            </dl>
                        </td>
                        <td>
                            <dl>
                                <dt>학력</dt>
                                <dd><%= ann.getEmp_education() %> 이상</dd>
                            </dl>
                        </td>
                        <td>
                            <dl>
                                <dt>근무 형태</dt>
                                <dd><%= ann.getEmp_work_type() %></dd>
                            </dl>
                        </td>
                        <td>
                            <dl>
                                <dt>기간</dt>
                                <dd>D - <%= ann.getEmp_day() %></dd>
                            </dl>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <dl>
                                <dt>분야</dt>
                                <dd><%= ann.getEnt_sectors() %></dd>
                            </dl>
                        </td>
                        <td>
                            <dl>
                                <dt>담당자 이름</dt>
                                <dd><%= ann.getEmp_name() %></dd>
                            </dl>
                        </td>
                        <td colspan="2">
                            <dl class="up">
                                <dt>담당자 연락처</dt>
                                <dd><%= ann.getEmp_email() %></dd>
                            </dl>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <dl class="up">
                                <dt>홈페이지</dt>
                                <dd><a href="<%= ann.getEnt_url() %>"><%= ann.getEnt_url() %></a></dd>
                            </dl>
                        </td>
                        <td colspan="2">
                            <dl class="up">
                                <dt>기업 주소</dt>
                                <dd><%= ann.getEnt_address() %></dd>
                            </dl>
                        </td>
                    </tr>
                </table><br>
                <label class="ann_con"> <%= ann.getEmp_contents() %></label>
            </div>
        </div>
<%
		}
	}
%>
    </div>
    
<%@ include file="/footer.jsp" %>
