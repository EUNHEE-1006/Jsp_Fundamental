<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.kpc.dao.MemberDao"%>
<%@page import="kr.or.kpc.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title>Script Element</title>
</head>
<body>
	<%!
		private String name;
		public int plus(int a, int b){
			return a+b;
		}
	%>
	
	<%
		/*private int age;
		public int minus(int a, int b){
			return a-b;
		}*/
		int result = plus(10,20);
		//출력1
		out.println(result);
	%>
	<%= //출력2
	
		result %>
	<%  MemberDto dto = new MemberDto(1, "박은희", "서울");
	%>
	
	<%=dto.getName() %>, <%=dto.getNum() %>
	
	<%
		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberDto> list = dao.select();
	%>
	<table>
		<tr>
			<th>번호</th><th>이름</th><th>주소</th>
		</tr>
		<%for(MemberDto memberDto : list){%>
		<tr>
			<td><%=memberDto.getNum() %>
			<td><%=memberDto.getName() %>
			<td><%=memberDto.getAddr() %>
			
		</tr>
		
		<%} %>
	
	</table>
	
</body>
</html>