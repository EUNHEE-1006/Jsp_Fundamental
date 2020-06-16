<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.kpc.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../inc/header.jsp"%>
<%
	String tempPage = request.getParameter("page");
	int cPage =0;
	if(tempPage ==null || tempPage.length()==0) {
		cPage =1;
	}
	
	try {
		cPage = Integer.parseInt(tempPage);
	}catch(NumberFormatException e){
		cPage =1;
		
	}
	/*
	cPage = 1 => 1-10 =>start : 0
	cPage = 2 => 11-20 =>start : 10
	cPage = 3 => 21-30 =>start : 20
	*/
	NoticeDao dao = NoticeDao.getInstance();
	int start = (cPage-1)*10;
	//ArrayList<NoticeDto> list = dao.select(start, 10);
%>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb justify-content-end">
    <li class="breadcrumb-item"><a href="#">홈</a></li>
    <li class="breadcrumb-item"><a href="#">공지사항</a></li>
  </ol>
</nav>
  	
    <div class ="container">
    	<div class = "row">
    		<div class ="col-md-12">
    		<h3>공지사항 리스트</h3>
    		<div class="table-responsive">
	    		<table class="table table-hover">
	    		<colgroup>
	    			<col width = "10%"/>
	    			<col width = "15%"/>
	    			<col width = "60%"/>
	    			<col width = "15%"/>
	    		</colgroup>
					  <thead>
					    <tr>
					      <th scope="col">번호</th>
					      <th scope="col">작성자</th>
					      <th scope="col">제목</th>
					      <th scope="col">등록날짜</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row">1</th>
					      <td>Mark</td>
					      <td><a href="view.jsp">Otto</a></td>
					      <td>@mdo</td>
					    </tr>
					    <tr>
					      <th scope="row">2</th>
					      <td>Jacob</td>
					      <td>Thornton</td>
					      <td>@fat</td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td colspan="2">Larry the Bird</td>
					      <td>@twitter</td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td colspan="2">Larry the Bird</td>
					      <td>@twitter</td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td colspan="2">Larry the Bird</td>
					      <td>@twitter</td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td colspan="2">Larry the Bird</td>
					      <td>@twitter</td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td colspan="2">Larry the Bird</td>
					      <td>@twitter</td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td colspan="2">Larry the Bird</td>
					      <td>@twitter</td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td colspan="2">Larry the Bird</td>
					      <td>@twitter</td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td colspan="2">Larry the Bird</td>
					      <td>@twitter</td>
					    </tr>
					    
					  </tbody>
				</table>
				<nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				    <li class="page-item disabled">
				      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
				    </li>
				    <li class="page-item"><a class="page-link" href="#">1</a></li>
				    <li class="page-item"><a class="page-link" href="#">2</a></li>
				    <li class="page-item"><a class="page-link" href="#">3</a></li>
				    <li class="page-item">
				      <a class="page-link" href="#">Next</a>
				    </li>
				  </ul>
				</nav>
				<div class ="text-right" style="margin-bottom : 20px">
				<a href="write.jsp"" class="btn btn-outline-primary">글쓰기</button>
				</div>
			</div>	
    		</div>
    	</div>
    </div>
    		
<%@ include file = "../inc/footer.jsp"%>