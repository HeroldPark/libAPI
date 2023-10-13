<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<main>
	<section>
		<h1>Search</h1>
		<c:if test="${msgVO.msgCode eq '0000'}" >
			<div>정상 조회했습니다.</div><br/>
			<c:forEach items="${userList}" var="list" varStatus="status">
				<li>순번 : ${list.seq}</li>
				<li>번호 : ${list.TUserNo}</li>
				<li>성함 : ${list.TUserName}</li>
				<li>휴대폰 : ${list.TUserHp}</li>
				<li>생일 : ${list.TUserBirth}</li>
				<li>등록일 : ${list.TRegDate}</li>
				<li>탈퇴여부 : ${list.TDelYn}</li>
				<li>탈퇴일 : ${list.TDelDate}</li><br/>
			</c:forEach>
		</c:if>
		<c:if test="${msgVO.msgCode eq '9999'}" >
			<div>비정상 조회되었습니다.</div>
		</c:if>
	</section>
</main>