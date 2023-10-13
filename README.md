# Spring Boot libAPI

> 1. 2023-09-28
	- API 개발을 위한 Spring boot project
	- Smart library API 개발

> 2. 개발 요구 사항
	서버환경
	OS : 리눅스
	WAS : 톰캣 
	JAVA : jdk1.8
	DATABASE : Oralce


> 3. 실행 방법
	선제 조건으로 jdk-1.8 버젼 이상이 설치되어 있어야 합니다.(windows나 linux 모두에 설치 가능합니다.)
	송부드리는 libAPI.war 파일을 아무곳에나 복사해 놓고 해당 위치에서 아래 명령어를 실행합니다.(tomcat은 내장되어 있어 따로 설치할 필요 없습니다.)
	그러면 "error -- Hello world." 까지 실행되면 정상입니다.(error는 오류가 아닙니다.)

	PS C:\Users\DeltaX_20\Downloads> java -jar ./libAPI.war
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.0)

2023-10-13 16:16:48.417  INFO 2588 --- [           main] c.j.w.SpringBootWebApplication           : Starting SpringBootWebApplication using Java 17.0.6 on Shane with PID 2588 (C:\Users\DeltaX_20\Downloads\libAPI.war started by Shane in C:\Users\DeltaX_20\Downloads)
2023-10-13 16:16:48.426  INFO 2588 --- [           main] c.j.w.SpringBootWebApplication           : The following 1 profile is active: "local"
2023-10-13 16:16:50.118  INFO 2588 --- [           main] o.s.b.w.e.t.TomcatWebServer              : Tomcat initialized with port(s): 8080 (http)
2023-10-13 16:16:50.130  INFO 2588 --- [           main] o.a.c.c.StandardService                  : Starting service [Tomcat]
2023-10-13 16:16:50.130  INFO 2588 --- [           main] o.a.c.c.StandardEngine                   : Starting Servlet engine: [Apache Tomcat/9.0.63]
2023-10-13 16:16:51.476  INFO 2588 --- [           main] o.a.j.s.TldScanner                       : At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
2023-10-13 16:16:51.818  INFO 2588 --- [           main] o.a.c.c.C.[.[.[/]                        : Initializing Spring embedded WebApplicationContext
2023-10-13 16:16:51.818  INFO 2588 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3299 ms
Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
2023-10-13 16:16:52.186  INFO 2588 --- [           main] o.a.t.a.TilesAccess                      : Publishing TilesContext for context: org.springframework.web.servlet.view.tiles3.SpringWildcardServletTilesApplicationContext
2023-10-13 16:16:52.554  INFO 2588 --- [           main] o.s.b.w.e.t.TomcatWebServer              : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-13 16:16:52.564  INFO 2588 --- [           main] c.j.w.SpringBootWebApplication           : Started SpringBootWebApplication in 4.72 seconds (JVM running for 5.68)
2023-10-13 16:16:52.567  INFO 2588 --- [           main] c.j.w.SpringBootWebApplication           : info -- 헬로우 월드.
2023-10-13 16:16:52.567  WARN 2588 --- [           main] c.j.w.SpringBootWebApplication           : warn -- Hello world.
2023-10-13 16:16:52.567 ERROR 2588 --- [           main] c.j.w.SpringBootWebApplication           : error -- Hello world.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


4. 웹 브라우져에서 다음과 같이 접속합니다.
	
	http://localhost:8080/

	그러면 아래 index.jsp 코드가 화면으로 나타남니다.
	다음은 index.jsp 내용 입니다. 결과를 확인하기 위해서 mariadb를 설치하고 boarddb를 uploading 해야 합니다.
	같이 송부드린 boarddb.sql을 mariadb에 uploading 하시기 바랍니다.(tbl_idcard 테이블 한개 입니다.)

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<main>
	<nav class="menu text-menu first">
		<h1>메인 메뉴</h1>
		<ul>
			<!-- 요청값 : 회원번호,이름,핸드폰번호,생년월일 --> 	<!-- 결과 : 정상여부 Y/N -->
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserReg&USER_NO=122323423423&USER_NAME=홍길동&USER_HP=010-1234-5678&USER_BIRTH=2001-10-02">등록</a></li>
			
			<!-- 요청값 : 검색조건(전체,회원번호,이름,생년월일) -->	<!-- 결과 : 정상여부 Y/N, 회원번호,이름,핸드폰번호,생년월일 -->
			<!-- searchType=all 일때 searchKey=<USER_NO, USER_NAME, USER_BIRTH> 중에서 아무것이나 입력할 수 있습니다. -->
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=all&searchKey=122323423423">전체조회(번호)</a></li>
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=all&searchKey=홍길동">전체조회(이름)</a></li>
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=all&searchKey=2001-10-02">전체조회(생년월일)</a></li>
			
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=userNo&USER_NO=122323423423">회원번호 조회</a></li>
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=userName&USER_NAME=홍길동">이름 조회</a></li>
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserSearch&searchType=userBirth&USER_BIRTH=2001-10-02">생년월일 조회</a></li>
			
			<!-- 요청값 : 회원번호 -->							  <!-- 결과 : 정상여부 Y/N -->
			<li><a class="" href="http://localhost:8080/_API/UserApi.do?mode=idcardUserDel&USER_NO=122323423423">탈퇴</a></li>
		</ul>
	</nav>
</main>
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

5. 현재 버젼은 우선 mariadb로 개발했습니다.
   결과 먼저 확인하시고 다음에 Oracle로 변경하겠습니다.
   그리고 tomcat 따로 실행하기 위해서 libAPI.war 파일 풀어서 작업하는 방법도 다음에 알려드리겠습니다.
   일단 war 파일 푸는 명령어는 jar -xvf libAPI.war 하면 현재 위치에 풀림니다.

   Search 기능 구현을 위해서 searchType, searchKey를 추가했으니 위에서 확인하시기 바랍니다.

6. 결과 확인하시고 수정 사항 알려주시기 바랍니다.
   
   이상입니다.