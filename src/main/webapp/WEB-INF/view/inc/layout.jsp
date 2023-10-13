<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>코딩 전문가를 만들기 위한 온라인 강의 시스템</title>
    <meta charset="UTF-8">
    <title>공지사항목록</title>
	
    <link href="/css/layout.css" type="text/css" rel="stylesheet" />
    <link href="/css/index.css" type="text/css" rel="stylesheet" />
    <link href="/user/css/bo/common.css" type="text/css" rel="stylesheet" />
    
    <!-- jquery -->
    <script src="/home/js/jquery.min.js"></script>
        
    <script src="/user/js/common.js"></script>
</head>

<body>
    <!-- header 부분 -->
	<tiles:insertAttribute name="header" />
 
    <!-- --------------------------- <body> --------------------------------------- -->
	<tiles:insertAttribute name="main" />

    <!-- ------------------- <footer> --------------------------------------- -->
	
</body>

</html>