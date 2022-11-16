<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>

	<div class="box-popUp">
        <div class="search-box-popUp">
            <form action="#" method="get">
                &nbsp;<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
                viewBox="0 0 16 16">
                <path
                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
            </svg> <input type="search" name="search" placeholder="지역, 직무, 회사, 키워드로 검색하세요.">
            <input type="submit" value="검색">
            </form>
        </div>
        <div class="contents-box">
            <p>&nbsp;<b>tag</b> : contents</p>
        </div>
    </div>

<%@ include file="/footer.jsp" %>