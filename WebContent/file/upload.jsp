<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("/upload/files");
	//이클립스 디렉토리와 서비스 되는 디렉토리가 다르다. 
	//file을 수정하면, 자동으로 서비스 되는 파일로 업로드 해준다.
	
	MultipartRequest mr =null;
	try{
		mr = new MultipartRequest(
				request, 
				path, //파일경로
				10*1024*1024, ///파일크기
				"utf-8",//인코딩 타입
				//파일이름이 중복되었을 때, 파일 명 끝에 1, 2, 3순으로 이름을 변경해주는 클래스 
				new DefaultFileRenamePolicy()			
		);	
		//multipartRequest 객체가 생성되면 파일 업로드 완료
	}catch(Exception e){
		e.printStackTrace();
	}
	
	String name = mr.getParameter("name");
	String fileName = mr.getFilesystemName("file"); //중복되면, filename 과 uploadname이 다름
	String uploadName = mr.getOriginalFileName("file");
	
	
%>
name : <%=name%><br>
file system name : <a href="/upload/files/<%=fileName%>"><%=fileName%></a><br>
file origin name : <%=uploadName%>