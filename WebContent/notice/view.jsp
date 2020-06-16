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
    		<h3>공지사항 작성</h3>
    			<form method = "post" name ="f" action="save.jsp">
				  <div class="form-group">
				    <label for="writer">작성자</label>
				    <input type="text" class="form-control" id="writer" name="writer" placeholder="박은희">
				  </div>
				   <div class="form-group">
				    <label for="titel">제목</label>
				    <input type="text" class="form-control" id="titel" name="titel" placeholder="살려줘">
				  </div>
				  
				 
				  <div class="form-group">
				    <label for="content">내용</label>
				    <textarea class="form-control" id="content" rows="10">안녕하세요..</textarea>
				  </div>
				</form>
    			<a href="" id="updateNotice" class="btn btn-outline-success">수정</button>
    			<a href="list.jsp" id="deleteNotice" class="btn btn-outline-danger">삭제</button>
    			<a href="list.jsp" class="btn btn-outline-primary">목록</button>
    		</div>
<%@ include file = "../inc/footer.jsp"%>