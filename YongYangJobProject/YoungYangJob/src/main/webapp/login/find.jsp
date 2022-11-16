<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/find_style.css">

	` <div class="wrapper">
        <div class="contents">
            <div class="notice">
                <div class="tabs">
                    <div class="tab-id-find">아이디 찾기</div>
                    <div class="tab-pw-find">비밀번호 찾기</div>
                </div>
                <div class="id-find-box">
                    <table>
                        <tr>
                            <td id="col">이름</td>
                            <td id="bor"><input type="text" name="" id="inp"></td>
                        </tr>
                        <tr>
                            <td id="col">이메일</td>
                            <td id="bor"><input type="email" name="" id="inp"></td>
                        </tr>
                    </table>
                </div>
                <div class="pw-find-box">
                    <table>
                        <tr>
                            <td id="col">아이디</td>
                            <td id="bor"><input type="text" name="" id="inp"></td>
                        </tr>
                        <tr>
                            <td id="col">이메일</td>
                            <td id="bor"><input type="email" name="" id="inp"></td>
                        </tr>
                    </table>
                </div>
                <script src="/js/find_script.js"></script>
            </div>
        </div>
    </div>
    
<%@ include file="/footer.jsp" %>