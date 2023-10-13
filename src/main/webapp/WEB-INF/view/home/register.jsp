<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<main>
	<section>
		<h1>Register</h1>
		<c:if test="${msgVO.msgCode eq '0000'}" >
			<div>"${userVO.TUserName}" 회원님이 정상 등록되었습니다.</div>
		</c:if>
		<c:if test="${msgVO.msgCode eq '9999'}" >
			<div>"${userVO.TUserName}" 회원님이 등록 오류입니다.</div>
		</c:if>
	</section>
</main>