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
	$("#checksignin").click(function(){
		alert($("#signinform").serialize());
		$.ajax({
			url:"${pageContext.request.contextPath}/jsp/loginuser/dosignin",
			data:$("#signinform").serialize(),
			type:"post",
			dataType:"json",
			success:function(msg){
				if(msg.tag){
					bootbox.alert(msg.message);
				}else{
					bootbox.alert(msg.message);
				}
			}
		});
	});
});
</script>
</head>
<body>
	<form action="#" method="post" id="signinform" name="signinform">
	用户名：<input type="text" id="logName" name="logName"><br><br>
	密码：<input type="text" id="logPsw" name="logPsw"><br><br>
	<input type="button" id="checksignin" value="注册">
	<input type="reset" value="重置">
	</form>
</body>
</html>