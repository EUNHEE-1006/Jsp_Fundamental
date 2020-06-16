<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../inc/header.jsp"%>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb justify-content-end">
    <li class="breadcrumb-item"><a href="#">홈</a></li>
    <li class="breadcrumb-item"><a href="#">공지사항</a></li>
  </ol>
</nav>
    <div class ="container">
    	<div class = "row">
    		<div class ="col-md-12">
    		<h3>공지사항 상세내용</h3>
    			<form method = "post" name ="f" action="save.jsp">
				  <div class="form-group">
				    <label for="writer">작성자</label>
				    <input type="text" class="form-control" id="writer" name="writer" placeholder="작성자를 입력해주세요">
				  </div>
				   <div class="form-group">
				    <label for="titel">제목</label>
				    <input type="text" class="form-control" id="titel" name="titel" placeholder="제목을 입력해주세요">
				  </div>
				  
				 
				  <div class="form-group">
				    <label for="content">내용</label>
				    <textarea class="form-control" id="content" rows="10"></textarea>
				  </div>
				</form>
    			<a href="" id="saveNotice" class="btn btn-outline-danger" style="margin-bottom : 20px">저장</button>
    			<a href="list.jsp" class="btn btn-outline-success">목록</button>
    		</div>
<%@ include file = "../inc/footer.jsp"%>