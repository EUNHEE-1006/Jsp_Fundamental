<%@page import="kr.or.kpc.dao.NoticeDao"%>
<%	
	NoticeDao dao = NoticeDao.getInstance();
	String json = dao.selectJson(0, 20);
	out.print(json);
	//application/json으로 변경!! xml이면 => application/xml
	//jsonformatter => 개행되지 않은 json 이쁘게!
	//웹페이지의 데이터는 arraylist로 할 수 있고, json으로 할 수 있다!!

%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=utf-8"%>


