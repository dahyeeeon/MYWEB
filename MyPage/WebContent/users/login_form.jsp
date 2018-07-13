<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/loginform.jsp</title>

</head>
<body>

<%
	//로그인후 이동할 url 정보를 읽어온다.
	String url=request.getParameter("url");
	if(url==null){
		//전달되지 못했을때 인덱스 페이지로 이동되도록
		url=request.getContextPath()+"/";
		
	}


%>

 <div class="row">
 <div class="col-sm-4 col-sm-offset-4 text-center">
	<div class="login-panel">
	    <div class="panel-heading">
	        <h3 class="panel-title">Sign In</h3>
	    </div>
	    <div class="panel-body">
	        <form action="index.jsp?nav=users/login.jsp" method="post">
	            <fieldset>
	                <div class="form-group">
	                    <input class="form-control" type="text" placeholder="id" name="id">
	                </div>
	                <div class="form-group">
	                    <input class="form-control" type="password" placeholder="Password" name="pwd">
	                </div>
	                <div class="checkbox">
	                    <label>
	                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
	                    </label>
	                </div>
	
	                <button type="submit" class="btn btn-sm btn-success">Login</a>
	            </fieldset>
	        </form>
	    </div>
	</div>
	</div>
</div>

</body>

</html>