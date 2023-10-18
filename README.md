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

3. oracle 연동 관련 오류 해결
	WARN 2884 --- [ restartedMain] o.a.t.u.s.StandardJarScanner : 
	Failed to scan [file:/C:/Users/Administrator.HEROLDPARK/.gradle/caches/modules-2/files-2.1/com.oracle.ojdbc/oraclepki/19.3.0.0/oracle.osdt/osdt_cert.jar] from classloader hierarchy
java.io.FileNotFoundException: C:\Users\Administrator.HEROLDPARK\.gradle\caches\modules-2\files-2.1\com.oracle.ojdbc\oraclepki\19.3.0.0\oracle.osdt\osdt_cert.jar (지정된 경로를 찾을 수 없습니다)

	해결 방법 => application.properties에 아래 내용 추가
	=> server.tomcat.additional-tld-skip-patterns=oraclepki.jar, osdt_core.jar, osdt_cert.jar
