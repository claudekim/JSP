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

<title>��ǰ���</title>
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
					<h2>��ǰ ��� ����</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<form action="itemModify.four" method="post"
				enctype="multipart/form-data">
					<div class="col-sm-2"></div>	
				<div class="col-sm-4">	
				<img	src="img/${Ito.fileName}" width=350 /></div>
				<div class="col-sm-4">
					<input type="hidden" name="id" value=" ${login.id}"> <input
						type="hidden" name="gnum" value="${Ito.dto.gnum}"> 
					<div style="width: 300px;  margin-bottom: 30px;">
						��ǰ��: <input type="text" name="gtitle" value="${Ito.dto.gtitle}"><br>
						��ǰ ����: <br>
						<div
							style="width: 300px; height: 100px; display: inline-block; border: 1px solid #555">
							<textarea rows="10" name="gcontent"
								style="border: 1px solid red; width: 300px; height: 200px; ovdeflow: hidden;">${Ito.dto.gcontent}</textarea>
						</div>
						÷������: <input type="file" name="filename1"
							style="border: 1px solid #666"> <input type="submit"
							value="����">
					</div>s
				</div>
				<br> <br>
			</form>
		
		</div>
		
		<br> <a href="itemList.four">��Ϻ���</a><br>
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