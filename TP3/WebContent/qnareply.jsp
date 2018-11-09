<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Insert title here</title>
</head>
<body>
	<div class="container"
		style="background-color: #ffffff; margin-top: 50px; border-radius: 5px;">
		<!--네비게이션 시작 -->
		<jsp:include page="nav.jsp" />
		<!--네비게이션 바 종료 -->
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<div class="page-header">
					<h2>문의 답변하기</h2>
				</div>
			</div>
		</div>
			<!-- 문의 폼 시작 -->
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="well">
					<form class="form-horizontal"  action="qnareply.four" method="post">			
						<input type="hidden" name="qnum" value="${dto.qnum}"> 
						<input type="hidden" name="qid" value="${login.id}"> 
						<input type="hidden" name="repRoot" value="${dto.repRoot}"> 
						<input type="hidden" name="repStep" value="${dto.repStep}"> 
						<input type="hidden" name="repIndent" value="${dto.repIndent}">
						<fieldset>
							<div class="form-group">
								<label class="col-lg-2 control-label">원글번호<br> [ ${dto.qnum} ]</label>
								<label class="col-lg-2 control-label">제목</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" name="qtitle" value="${dto.qtitle}" placeholder="${dto.qtitle}">
								</div>
							</div>
							<div class="form-group">
								<label for="textArea" class="col-lg-2 control-label">내용</label>
								<div class="col-lg-10">
									<textarea class="form-control" name="qcontent" rows="10"
										id="textArea">${dto.qcontent}</textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-10 col-lg-offset-2">
									<button class="btn btn-default">취소</button>
									<button type="submit" class="btn btn-primary">수정</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
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
	<br>
</body>
</html>