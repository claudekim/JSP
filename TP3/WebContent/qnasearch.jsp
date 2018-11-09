<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/candy-box.css" />
<script type="text/javascript" src="css/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="css/bootstrap.min.js"></script>

<title>�˻� ��� ����</title>
</head>
<body>
	<div class="container"
		style="background-color: #ffffff; margin-top: 50px; border-radius: 5px;">
		<!--�׺���̼� ���� -->
		<jsp:include page="nav.jsp" />
		<!--�׺���̼� �� ���� -->
		<!-- ��ǰ���������� -->
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="page-header">
					<h2>�˻��������</h2>
				</div>
			</div>
		</div>
	<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<table class="table table-striped table-hover">
		<tr>
			<td colspan="8">
				<form action="qnasearch.four" method="post">
					<input type="hidden" name="gnum" value="${gnum}">
					
					<select name="searchName">
						<option value="qid">�ۼ���</option>
						<option value="qtitle">����</option>
					</select>
					<input name="searchValue">
					<input type="submit" value="�˻�">
				</form>
			</td>
		</tr>
	
	
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>�ۼ���</th>
			<th>��ȸ��</th>
		</tr>
		
		<c:forEach items="${qnasearchlist}" var="dto">
		<tr>
			<td>${dto.qnum}</td>
			<td>
				<c:forEach begin="1" end="${dto.repIndent}">
					RE : 
				</c:forEach>
			
				<a href="qnaread.four?qnum=${dto.qnum}">${dto.qtitle}</a>
			
			</td>
			<td>${dto.qid}</td>
			<td>${dto.qwriteday}</td>
			<td>${dto.readcnt}</td>
		</tr>
	
		</c:forEach>
		
		
		
		
		
		
	</table>
	<br>
	<a href="itemRead.four?gnum=${gnum}">	<button type="button" class="btn btn-primary">�� ���ư���</button></a></div>
	<br></div><br></div>
</body>
</html>