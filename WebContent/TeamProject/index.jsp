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
    search();
    
    function search(){
    	 var keyword = "강남구 광평로"//document.getElementById('keyword').value;
    	 var listEl = [];
    	 var index =0;
        var xhr;
        if(window.XMLHttpRequest){
            xhr = new XMLHttpRequest();
        }else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP")
        }
        if(xhr ==null){
            alert("Error create xhr object");
        }
        $(function(){
            $('#btn').click(function(){
                let url = 'seoulwifi.json';
                xhr.open('GET', url, true); 
                xhr.send(null);
                xhr.onreadystatechange = function(){
                    if(xhr.readyState == 4 && xhr.status ==200){
                        //console.log(xhr.responseText);
                        const obj = JSON.parse(xhr.responseText);
                        const listArray = obj.DATA;

                        let message = "<ul>"

                     	for(var i=0; i<listArray.length; i++){
                            	const listObj = listArray[i];
                				var placename =listObj.place_name;
                				
        	                   	 if(placename.indexOf(keyword)!=-1){
        	                   		let category = listObj.category;
                                    let gu_nm = listObj.gu_nm;
                                    message +="<li>" + category + "("+ gu_nm + ")"+ "</li>" 
        	                   		listEl[index++] = listObj; 
        	                   	 	}
                            }
                        message += "</ul>";
                        $('#sel').append(message);  
                    }
                }
           });
      });
    }
    </script>
</head>
<body>
    <button id ="btn">가져오기</button>
    <div id ="sel">

    </div>
    
</body>
</html>