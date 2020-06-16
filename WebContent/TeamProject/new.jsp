<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WifiDemo</title>
    <script type="text/javascript" src="/js/jquery-3.5.1.js"></script>
    <script>
    function search(){
    	var keyword = "강남구 광평로"//document.getElementById('keyword').value;
    	var listEl = new Array();
    	var index =0;
    	
    	$(function(){
            $('#btn').click(function(){
                $.ajax({ //jquery가 자동으로 넘겨주니까. ajax처럼 보이지만, 내부적으론 아니야.
                    url : 'seoulwifi.json', 
                    type : 'GET',
                    dataType : 'jsonp',
                    error : function(){
                        alert('error');
                    },
                    success : function(obj){
                        $('#sel').append(JSON.stringify(obj));
                        
                    }
                });
                /*xhr.onreadystatechange = function(){
                    if(xhr.readyState == 4 && xhr.status ==200){
                        console.log(xhr.responseText);

                        //문자열을 javascript 객체로 변환
                        
                    }
                };*/
            });

        })
    </script>
</head>
<body>
    <button id ="btn">가져오기</button>
    
    
</body>
</html>