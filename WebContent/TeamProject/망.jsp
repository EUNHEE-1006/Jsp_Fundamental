<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WifiDemo</title>
    <script type="text/javascript" src="/js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=584122908c5e5b6321790a074641d512&libraries=services"></script>
    <script>
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
                    	// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
                    	var infowindow = new kakao.maps.InfoWindow({zIndex:1});

                    	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                    	    mapOption = {
                    	        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
                    	        level: 3 // 지도의 확대 레벨
                    	    };  

                    	// 지도를 생성합니다    
                    	var map = new kakao.maps.Map(mapContainer, mapOption); 

                    	// 장소 검색 객체를 생성합니다
                    	var ps = new kakao.maps.services.Places(); 
                    	var arraylist = new Array()
                    	// 키워드로 장소를 검색합니다
                    	ps.keywordSearch(arraylist, placesSearchCB); 
                    	function search(){
                        	var keyword = "강남구 광평로"//document.getElementById('keyword').value;
                        	var listEl = new Array();
                        	var index =0;
                        	
                        	const obj = JSON.parse(xhr.responseText);
                        	const listArray = obj.DATA;

                     	for(var i=0; i<listArray.length; i++){
                            const listObj = listArray[i];
                			var placename =listObj.place_name;
                				
        	                if(placename.indexOf(keyword)!=-1){
        	                   		listEl[index++] = listObj; 
        	                	}	
        	            
                     		}   
                     	for(var j=0; j<listEl.length; j++){
        	            	console.log(listEl.length);
        	            	}
                     	return listEl;
 					    }

                    	// 키워드 검색 완료 시 호출되는 콜백함수 입니다
                    	function placesSearchCB (data, status, pagination) {
                    	    if (status === kakao.maps.services.Status.OK) {

                    	        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
                    	        // LatLngBounds 객체에 좌표를 추가합니다
                    	        var bounds = new kakao.maps.LatLngBounds();

                    	        for (var i=0; i<data.length; i++) {
                    	            displayMarker(data[i]);    
                    	            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
                    	        }       

                    	        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
                    	        map.setBounds(bounds);
                    	    } 
                    	}

                    	// 지도에 마커를 표시하는 함수입니다
                    	function displayMarker(place) {
                    	    
                    	    // 마커를 생성하고 지도에 표시합니다
                    	    var marker = new kakao.maps.Marker({
                    	        map: map,
                    	        position: new kakao.maps.LatLng(place.y, place.x) 
                    	    });

                    	    // 마커에 클릭이벤트를 등록합니다
                    	    kakao.maps.event.addListener(marker, 'click', function() {
                    	        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
                    	        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
                    	        infowindow.open(map, marker);
                    	    });
                    	}
       			}
             }
         });        
 	});
    
    //console.log(arraylist[0].category);
    </script>
</head>
<body>
    <button id ="btn">가져오기</button>
    
    
</body>
</html>