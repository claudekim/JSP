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

<title>��ǰ ���</title>
</head>
<body>
	<div class="container"
		style="background-color: #ffffff; margin-top: 50px; border-radius: 5px;">
		<!--�׺���̼� ���� -->
		<jsp:include page="nav.jsp" />
		<!--�׺���̼� �� ���� -->
		<!-- ��ǰ���������� -->
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="page-header">
					<h2>��ǰ ���</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<form action="itemWrite.four" method="post"
					enctype="multipart/form-data">
					<table class="table table-striped ">
						<tbody>
							<tr>
								<td>��ǰ��</td>
								<td><input type="text" name="gtitle"></td>
							</tr>
							<tr>
								<td>��ǰ ����</td>
								<td>
									<div>
										<textarea rows="10" name="gcontent"></textarea>
									</div>
								</td>
							<tr>
								<td>÷������</td>
								<td><input type="file" name="filename1" size=40
									style="border: 1px solid #666"></td>
							</tr>
						</tbody>
					</table>
	
					  	<a href="itemList.four">
					<button type="button" class="btn btn-primary">�� ���ư���</button>				<button type="submit" class="btn btn-primary">����</button>
				</a>
				</form>
				<br> <br>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>