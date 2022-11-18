<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/postings_style.css">

	<div class="wrapper">
        <form action="#" method="post">
            <table>
                <tr>
                    <td><b>이름</b></td>
                    <td><input type="text" name="" id=""></td>
                    <td><b>이메일</b></td>
                    <td><input type="email" name="" id=""></td>
                </tr>
                <tr>
                    <td><b>기업명</b></td>
                    <td colspan="3"><input type="text" name="" id="col3"></td>
                </tr>
                <tr>
                    <td><b>채용 홈페이지</b></td>
                    <td colspan="3"><input type="url" name="" id="col3"></td>
                </tr>
                <tr>
                    <td><b>제목</b></td>
                    <td colspan="3"><input type="text" name="" id="col3"></td>
                </tr>
                <tr>
                    <td><b>경력</b></td>
                    <td>
                        <select>
                            <option value="1">무관</option>
                            <option value="2">~ 2년</option>
                            <option value="5">~ 5년</option>
                            <option value="8">~ 10년</option>
                            <option value="9">10년 ~</option>
                        </select>
                    </td>
                    <td><b>학력</b></td>
                    <td>
                        <select>
                            <option value="1">고졸</option>
                            <option value="2">대졸_2년제</option>
                            <option value="4">대졸_4년제</option>
                            <option value="5">대학원 이상</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><b>근무형태</b></td>
                    <td colspan="3">
                        <select id="col3">
                            <option value="1">계약직</option>
                            <option value="2">정규직</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><b>내용</b></td>
                    <td colspan="3"><textarea name="" id="text" cols="30" rows="10"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td>
                    <td colspan="2"><input type="reset"></td>
                </tr>
            </table>
        </form>
    </div>

<%@ include file="/footer.jsp" %>