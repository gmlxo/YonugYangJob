<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/dec_style.css">
<%    
	/* 신고할 게시물의 idx 를 받아온다 */
    String ity_idx = request.getParameter("ity_idx");
%>
	<div class="dec">
        <div class="h2-box">
            <h2>신고하기</h2>
        </div>
        <div class="back-box">
            <a href="javascript:history.back();">
								<!-- X 이미지 가져오기 -->
                <img src="/image/x.svg" alt="">
            </a>
        </div>
        <div class="decContexts">
						<!-- 게시물 신고하기 -->
            <form action="/delIty" method="get">
                <div class="lpop_cont">
                    <ul class="list_report">
                        <li>
                            <span class="inpRdo">
                                <input type="radio" name="report" id="report1" value="slander">
                                <label class="lbl" for="report1">비방/욕설</label>
                            </span>
                        </li>
                        <li>
                            <span class="inpRdo">
                                <input type="radio" name="report" id="report2" value="fFacts">
                                <label class="lbl" for="report2">허위사실</label>
                            </span>
                        </li>
                        <li>
                            <span class="inpRdo">
                                <input type="radio" name="report" id="report3" value="prsinExpsr">
                                <label class="lbl" for="report3">개인정보노출</label>
                            </span>
                        </li>
                        <li>
                            <span class="inpRdo">
                                <input type="radio" name="report" id="report4" value="indecent">
                                <label class="lbl" for="report4">음란성</label>
                            </span>
                        </li>
                        <li>
                            <span class="inpRdo">
                                <input type="radio" name="report" id="report5" value="posting">
                                <label class="lbl" for="report5">게시글 도배</label>
                            </span>
                        </li>
                        <li>
                            <span class="inpRdo">
                                <input type="radio" name="report" id="report6" value="inpPrm">
                                <label class="lbl" for="report6">부적절한 홍보</label>
                            </span>
                        </li>
                        <li>
                            <span class="inpRdo">
                                <input type="radio" name="report" id="report7" value="etc">
                                <label class="lbl" for="report7">기타</label>
                            </span>
                        </li>
                    </ul>
                    <div class="textDec">
											<!-- 게시물 idx 값 보내주기 -->
                    	<input type="hidden" value="<%= ity_idx %>" name="ity_idx">
                        <textarea name="report" placeholder="세부사항을 입력해주세요"></textarea>
                    </div>
                    <div class="decBu">
                        <input type="submit" value="신고">
                    </div>
                </div>
            </form>
        </div>
    </div>
    
<%@ include file="/footer.jsp" %>