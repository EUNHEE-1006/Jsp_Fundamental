<%	
	JSONObject obj = new JSONObject(); 
	obj.put("name", "park");
	obj.put("age", 26);
	obj.put("address","안양");
	
	JSONArray array = new JSONArray();
	
	JSONObject obj1 = new JSONObject();
	obj1.put("no", "1");
	obj1.put("storeName", "강남스토어1");
	
	JSONObject obj2 = new JSONObject();
	obj2.put("no", "2");
	obj2.put("storeName", "강남스토어2");

	JSONObject obj3 = new JSONObject();
	obj3.put("no", "3");
	obj3.put("storeName", "강남스토어3");
	
	array.add(obj1);
	array.add(obj2);
	array.add(obj1);
	
	obj.put("items", array);
	out.print(obj.toJSONString());
	//application/json으로 변경!! xml이면 => application/xml
	//json object는 개행이 안됨.
	//개행이 되면 => db에서 뽑아낸 것.
%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=utf-8"%>


