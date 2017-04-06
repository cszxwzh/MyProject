<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<script type="text/javascript">
$(document).ready(function(){
	if($("#logType").val()==1&&$("#logName").val()=="admin"){
		$("#updateType").show();
	}
});
function logout(){
	window.location.href="${pageContext.request.contextPath}/jsp/loginuser/logout";
}
function usercon(){
	window.location.href="${pageContext.request.contextPath}/jsp/loginuser/userdis";
}
function userup(){
	window.location.href="${pageContext.request.contextPath}/jsp/loginuser/userup/${requestScope.loginuser.logId}";
}
</script>
</head>
<body>
<form action="#" method="post" name="userform">
用户编号:<input type="text" id="logId" name="logid" value="${requestScope.loginuser.logId }" readonly="readonly"><br><br>
用户账号:<input type="text" id="logName" name="logName" value="${requestScope.loginuser.logName }" readonly="readonly"><br><br>
用户密码:<input type="text" id="logPsw" name="logPsw" value="${requestScope.loginuser.logPsw }"><br><br>
<input type="text" id="logType" name="logType" style="display:none" value="${requestScope.loginuser.logType }"><br>
<input type="button" onclick="userup()" value="修改密码">&emsp;<input type="button" onclick="logout()" value="退出登录">
<input type="button" value="管理用户信息" id="updateType" onclick = "usercon()" style="display:none">
</form>
</body>
</html>