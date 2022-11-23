<%@page import="vo.EnterpriseVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/enterprise_style.css">
<%
  /* 정보 총 개수 */
	int count = (int) request.getAttribute("count");	
	/* ent list 값 받아오기 */
	ArrayList<EnterpriseVO> entList = (ArrayList<EnterpriseVO>) request.getAttribute("entList");
%>
	<div class="wrapper">
        <div class="information">
            <div class="headerEnt">
                <label> <b>기업 정보 </b>총 <%= count %> 건</label>
            </div><br>
<%
  /* ent list 가 null 이 아닐때 실행 */
	if(entList != null) {
		/* vo의 값이 있는 만큼 반복한다 */
		for(EnterpriseVO ent : entList){
%>
            <div class="ent">
                <h3><%= ent.getEnt_name() %></h3>
                <div class="contentsEnt">
                    <table>
                        <tr>
                            <td>
                                <dl>
                                    <dt>설립일</dt>
                                    <dd><%= ent.getEstablishment_date() %></dd>
                                </dl>
                            </td>
                            <td>
                                <dl>
                                    <dt>대표자</dt>
                                    <dd><%= ent.getRepresentative() %></dd>
                                </dl>
                            </td>
                            <td>
                                <dl>
                                    <dt>분야</dt>
                                    <dd><%= ent.getSectors() %></dd>
                                </dl>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="addEnt">
                                <dl>
                                    <dt>기업 주소</dt>
                                    <dd><%= ent.getAddress() %></dd>
                                </dl>
                            </td>
                            <td  colspan="3">
                                <dl>
                                    <dt>홈페이지</dt>
                                    <dd><a href="<%= ent.getUrl() %>"><%= ent.getUrl() %></a></dd>
                                </dl>
                            </td>
                         </tr>
                         <tr>
                            <td colspan="5">
                                <dl>
                                    <dt>정보</dt>
                                    <dd><%= ent.getExplanation() %></dd>
                                </dl>
                            </td>
                         </tr>
                    </table>
                </div>
            </div>
            <br>
            <div class="line"></div>
<%
		}
	}
%>
            </div>
            </div>
<%@ include file="/footer.jsp" %>