<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<main>
	<nav class="menu text-menu first">
		<h1>메인 메뉴</h1>
		<ul>
			<!-- 요청값 : 회원번호,이름,핸드폰번호,생년월일 --> 	<!-- 결과 : 정상여부 Y/N -->
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserReg&userNo=122323423423&userName=홍길동&userHp=010-1234-5678&userBirth=2001-10-02">등록</a></li>
			
			<!-- 요청값 : 검색조건(전체,회원번호,이름,생년월일) -->	<!-- 결과 : 정상여부 Y/N, 회원번호,이름,핸드폰번호,생년월일 -->
			<!-- searchType=all 일때 searchKey=<USER_NO, USER_NAME, USER_BIRTH> 중에서 아무것이나 입력할 수 있습니다. -->
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=all&searchKey=122323423423">전체조회(번호)</a></li>
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=all&searchKey=홍길동">전체조회(이름)</a></li>
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=all&searchKey=2001-10-02">전체조회(생년월일)</a></li>
			
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=userNo&userNo=122323423423">회원번호 조회</a></li>
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=userName&userName=홍길동">이름 조회</a></li>
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=userBirth&userBirth=2001-10-02">생년월일 조회</a></li>
			
			<!-- 요청값 : 회원번호 -->							  <!-- 결과 : 정상여부 Y/N -->
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserDel&USER_NO=122323423423">탈퇴</a></li>
		</ul>
	</nav>
</main>