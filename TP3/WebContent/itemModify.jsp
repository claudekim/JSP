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

<title>상품등록</title>
</head>
<body>
	<div class="container"
		style="background-color: #ffffff; margin-top: 50px; border-radius: 5px;">
		<!--네비게이션 시작 -->
		<jsp:include page="nav.jsp" />
		<!--네비게이션 바 종료 -->
		<!-- 상품상세정보나열 -->
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="page-header">
					<h2>상품 등록 수정</h2>
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
						제품명: <input type="text" name="gtitle" value="${Ito.dto.gtitle}"><br>
						제품 설명: <br>
						<div
							style="width: 300px; height: 100px; display: inline-block; border: 1px solid #555">
							<textarea rows="10" name="gcontent"
								style="border: 1px solid red; width: 300px; height: 200px; ovdeflow: hidden;">${Ito.dto.gcontent}</textarea>
						</div>
						첨부파일: <input type="file" name="filename1"
							style="border: 1px solid #666"> <input type="submit"
							value="저장">
					</div>s
				</div>
				<br> <br>
			</form>
		
		</div>
		
		<br> <a href="itemList.four">목록보기</a><br>
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