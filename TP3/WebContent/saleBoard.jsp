<%@page import="com.dto.ItemPageTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

<title>��ǰ �Ұ� ������</title>
</head>
<body>
	<div class="container"
		style="background-color: #ffffff; margin-top: 50px; border-radius: 5px;">
		<!--�׺���̼� ���� -->
		<jsp:include page="nav.jsp" />
		<!--�׺���̼� �� ���� -->

		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="page-header">
					<h2>��ǰ �Խ���</h2>
				</div>
			</div>
		</div>
		<!-- ���̺� �˻��������� -->
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<form action="itemSearch.four" method="get">
				<div class="col-lg-1">
					<div class="form-group">
						<select class="form-control" name="searchName"
							style="width: 90px;">
							<option value="gcontent">����</option>
							<option value="gtitle">����</option>
						</select>
					</div>
				</div>
				<div class="col-lg-2">
					<div class="input-group" style="width: 262px; text-align: right;">
						<input name="searchValue" class="form-control"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="submit">�˻�</button>
						</span>
					</div>
				</div>
			</form>
		</div>

		<!-- ���̺�������� -->
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th style="width: 55px; text-align: center;">��ȣ</th>
							<th style="text-align: center;">��ǰ��</th>
							<th style="width: 120px; text-align: center;">�ۼ���</th>
							<th style="width: 80px; text-align: center;">��ȸ��</th>
							<th style="width: 80px; text-align: center;">���Ǳ�</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${Ito.itemList}" var="dto">
							<tr>
								<td style="text-align: center">${dto.gnum}</td>
								<td style="padding: 2px 10px 2px 10px"><a
									href="itemRead.four?gnum=${dto.gnum}&id=${login.id}"
									style="text-decoration: none">${dto.gtitle}</a></td>
								<td style="text-align: center">${dto.gwriteday}</td>
								<td style="text-align: center">${dto.greadcnt}</td>
								<td style="text-align: center">${dto.qnaNum}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		<br>
		</div>
		<jsp:include page="itemPage.jsp" />
			<br> <br>	<br>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>

