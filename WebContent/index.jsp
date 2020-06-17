
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	헬로우 제이에스피... not git
	<%
		for(int i = 0 ; i<100; i++){
			out.println("hello<br>");
		}
	%>
</body>
</html>
<!--자동으로 servlet 파일로 만들어줌. 그래서 jsp가 나옴. jsp container는 자동으로 servlet 파일을 만들어줌-->