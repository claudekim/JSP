
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/candy-box.css" />
<script type="text/javascript" src="css/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="css/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/css.css">
<title>회원가입</title>
</head>
<body>
<div class="input">
   <h1 style="text-align: center;">회원가입</h1>
   <hr>
   <form action="join.four" method="post">
   <table class="JoinTable">
   <tr>
    <td>  ID   </td><td><input name="id" value="${id}"> <c:if test="${errors.IDexist}"><font color=#FF0000>아이디가 중복입니다.</font></c:if><c:if test="${errors.idNull}"><font color=#FF0000>아이디를 입력해주세요.</font></c:if> <br> 
     </td> </tr><tr>
   <td>   비밀번호 </td><td> <input type="password" name="pw"> <c:if test="${errors.pwNull}"><font color=#FF0000>비밀번호를 입력해주세요</font></c:if> <br>
    </td> </tr><tr>
   <td>   암호확인</td><td> <input type="password" name="repw"> <c:if test="${errors.PWdisagree}"><font color=#FF00000>암호와 확인이 불일치합니다</font></c:if> <br>
       </td> </tr><tr>
   <td>   이름 </td><td> <input name="name" value="${name}"><c:if test="${errors.nameNull}"><font color=#FF00000>이름을 입력해주세요</font></c:if><br>
     </td>  </tr><tr>
   <td>   주소 </td><td><textarea rows="5" name="address" style="height: 30px;width: 168px" >${address}</textarea><c:if test="${errors.addressNull}"><font color=#FF00000>주소를 입력해주세요</font></c:if><br>
      </td> </tr><tr>
   <td>   성별 </td><td> <input type="radio" name="sex" value="M">남 <input type="radio" name="sex" value="F">여 <c:if test="${errors.sexNull}"><font color=#FF00000>성별을 입력해주세요</font></c:if><br>
       </td> </tr><tr>
   <td>   생년월일</td><td><input name="birthday" type="date"> <c:if test="${errors.birthdayNull}"><font color=#FF00000>생일을입력해주세요</font></c:if> <br>
      </td> </tr>
</table>
      
      <br>
     <button type="reset" class="btn btn-primary">되돌리기</button>
          <button type="submit" class="btn btn-primary">가입하기</button>
   </form><br>
   	<a href="index.jsp"><button>◀ 로그인 화면으로 돌아가기</button></a>
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