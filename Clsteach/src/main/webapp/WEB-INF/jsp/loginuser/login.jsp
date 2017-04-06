<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href ="${pageContext.request.contextPath}/resource/js/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href ="${pageContext.request.contextPath}/resource/js/bootstrap.min.css">
<link rel ="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/js/jquery-ui.css">
<!-- 引入jquery的插件 -->
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/jquery-3.1.1.js"></script>
<!-- 引入分页的插件 -->
<script type="text/javascript" src ="${pageContext.request.contextPath}/resource/js/jquery.dataTables.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/bootbox.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/jquery-ui.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#checklogin").click(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/jsp/loginuser/dologin",
			type:"post",
			data:$("#loginform").serialize(),
			dataType:"json",
			success:function(msg){
				if(msg.tag){
					bootbox.alert(msg.message);
					setTimeout(function(){window.location.href="${pageContext.request.contextPath}/jsp/cls/clsshow";},800);
				}else{
					bootbox.alert(msg.message);					
				}
			}			
		});
	}),
	$("#tosignin").click(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/jsp/loginuser/tosignin",
			type:"post",
			success:function(msg){
				bootbox.dialog({
					title:"账号注册",
					message:msg
				});
			}
		});
	});	
});
</script>
</head>
<body>
	<form action="#" method="post" id="loginform" name="loginform">
	用户名：<input type="text" id="logName" name="logName"><br><br>
	密码：<input type="text" id="logPsw" name="logPsw"><br><br>
	<input type="button" id="checklogin" value="登录">
	<input type="button" id="tosignin" value="注册">
	</form>
	<span>当前使用的人数为：${applicationScope.count}</span>
	<span>当前登录的人数为：${applicationScope.logincount}</span>
</body>
</html>