<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>

	<head>
		<link href="/css/jquery-ui.css" type="text/css" rel="stylesheet" />
		
		<script src="/js/jquery-3.6.4.min.js"></script>
	</head>
	
	<body>
	    <!-- header 부분 : tiles.xml에 있는 이름이어야 한다. -->
	
		<!-- --------------------------- <visual> --------------------------------------- -->
		<!-- visual 부분 -->
	
		<!-- --------------------------- <body> --------------------------------------- -->
		<div id="body">
			<div class="content-container clearfix">
	
				<!-- --------------------------- aside --------------------------------------- -->
				<!-- aside 부분 -->
	
				<!-- --------------------------- main --------------------------------------- -->
				<tiles:insertAttribute name="main" />
				
			</div>
		</div>
	
	    <!-- ------------------- <footer> --------------------------------------- -->
	
	</body>
    
</html>