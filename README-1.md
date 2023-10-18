# Spring Boot libAPI

1. 서버환경
	OS : 리눅스/windows
    Framework : spring boot(tomcat 내장)
	WAS : 톰캣
	JAVA : jdk1.8
	DATABASE : oracle

2. JSON 형식으로 데이터 교환
    - php로 작업하실 경우 src\main\webapp\WEB-INF\view\home\main.jsp 파일을 참고하여 작업하시면 됩니다.
    - request/response : main.jsp
    - 여기서 보내고 받는 형식을 수정해서 사용해야 할 것입니다.

3. Oracle 설정
    - src\main\resources\application.properties
    - oracle 설치 정보가 아래와 다를 경우 소스에서 변경하여 libAPI.war 파일을 다시 제작하면 됩니다.
    - 직접 작업하는 방법은 아래 적어 놓았습니다.(7. War 파일 수정 방법)

    spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
    spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/orcl
    spring.datasource.username=system
    spring.datasource.password=oracle

4. 실행 방법
    - jdk-1.8 이상 설치

    - 내장 tomcat을 이용할 경우 : Apache Tomcat/9.0.63 실행(설치 불필요함.)
    - 실행 : java -jar ./libAPI.war
    - 접속 : http://localhost:8080/main (json data type)

    - 외장 tomcat을 이용할 경우
    - tomcat 설치 방법 참고 : https://kitty-geno.tistory.com/191

5. 사용 방법 (참조 : main.jsp)
    - 등록인 경우
        mode="idcardUserReg", userNo, userName, userHp, userBirth 입력

    - 찾기인 경우에는 searchType에 따라 searchKey에 올바른 값을 입력해야 할 것입니다.
        - mode="idcardUserSearch"
        - searchType=all, searchKey=<userNo, userName, userBirth>의 값 중에 한개 입력합니다.
        - searchType=userNo, userNo=userNo의 값 입력
        - searchType=userName, userName=userName의 값 입력
        - searchType=userBirth, userBirth=userBirth의 값 입력

    - 탈퇴인 경우
        mode : "idcardUserDel"
        userNo : "1234567890"

5. source 위치
    개발용 PC : D:\박용렬\유지보수\libAPI

6. 참고로 mariadb 사용할 경우 수정사항
    - src\main\resources\application.properties에서 mariadb 사용으로 수정(mariadb 설치와 database 도 함께)
    - src\main\resources\public\mybatis\mapper\UserMapper.xml에서 now()가 있는 부분 주석해제(반대로 oracle type은 주석처리)
    - 접속 방법 :  http://localhost:8080
    - 나머지는 메뉴대로 하면 됩니다.(src\main\webapp\WEB-INF\view\home\index.jsp)

7. War 파일 수정 방법
    1) war 파일 풀기
        > jar xvf libAPI.war

    2) 수정
        - 특정 파일에서 수정 작업

    3) war 파일 제작
        > jar cvf libAPI.war *

    4) war 파일 확인
        > jar tvf libAPI.war

    