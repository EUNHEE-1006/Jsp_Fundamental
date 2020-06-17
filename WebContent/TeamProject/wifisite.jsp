<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>서울시 공공와이파이 검색지도</title>
    <style>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
   <style>
          html {
      height: 100%;
   }   
   body {
       width:100%;
       height:100%;
       margin: 0;
        padding-top: 0;
        padding-bottom: 40px;
        font-family: "Nanum Gothic", arial, helvetica, sans-serif;
        background-repeat: no-repeat;
        background:linear-gradient(to bottom right, #0098FF, #6BA8D1);
   } 
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-top: 100px; /* Added */
        margin-bottom: 100px; /* Added */
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
   }   
   .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
            box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
   } 
</style>
</head>
<body>
	   <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #3F729B ;">
	     <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
	       <a class="navbar-brand" href="#">서울시 공공와이파이</a>       
	     </div>
	   </nav>

	   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	   <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
         <div class="card align-middle" style="width:20rem; border-radius:20px;">
            <div class="card-title" style="margin-top:30px;">
            <h2 class="card-title text-center" style="color:#113366;">서울시 공공와이파이</h2>
         </div>
         
      	<div class="card-body">
            <form class="form-signin" method="POST" name="f" action="wifimap.jsp">
              <h5 class="form-signin-heading">장소를 입력하세요</h5>
              <label for="inputEmail" class="sr-only">장소명 입력</label>
              <input type="text" id="keyword" name="keyword" class="form-control" placeholder="장소명 입력" required autofocus><BR>
              <button type="submit" id="btn" class="btn btn-lg btn-primary btn-block" >검색</button>
            </form>           
        </div> 
<script src="/js/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>       

<script>
    $('#btn').click(function(e){
    	e.preventDefault();
    	f.submit();
    });
</script>   
</body>
</html>
