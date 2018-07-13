<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup_form.jsp</title>
</head>
<body>

 <% 
 String id=(String)session.getAttribute("id");
 if(id!=null){ %>
	<script>
	alert("로그아웃 해주세요");
	location.href="index.jsp";
    </script>
		<%}else{ %>
		
	<%} %>	
	
<div class="container">	
<h3>회원 가입 페이지 입니다.</h3>
<form action="index.jsp?nav=users/joinus.jsp" method="post" id="joinForm">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"/>
	<span id="checkResult"></span>
	<br/>
	<label for="pwd">비밀번호</label>
	<input type="pwd" name="pwd" id="pwd"/><br/>
	<label for="name">이름</label>
	<input type="text" name="name" id="name"/><br/>
	<label for="phone">휴대폰번호</label>
	<input type="text" name="phone" id="phone"/><br/>
	<button type="submit">가입</button>
</form>
</div>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>	

<script>
	//폼의 유효성 여부
	var formValid=false;
	
	$("#joinForm").submit(function(){
		//만일 폼의 유효성 여부가 false 이면 
		if(formValid==false){
			return false;//폼 전송 막기
		}
	});
	

	//아이디 입력란에 입력했을때 실행할 함수 등록 
	$("#id").on("input",function(){
	//입력한 아이디를 읽어와서
	var inputId=$(this).val();

	$.ajax({
		url:"users/checkid.jsp",
		method:"post",
		data:{"inputId":inputId},
		success:function(responseData){
			console.log(responseData);

			if(responseData.canUse){
				formValid=true;
				$("#checkResult").text("사용가능")
				.css("color","#00ff00");
			}else{
				formValid=false;
				$("#checkResult").text("사용불가")
				.css("color","#ff0000");
			}
		}
		
	});
	});
</script>
</body>
</html>

