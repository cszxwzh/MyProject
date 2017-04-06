<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#updatebtn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/jsp/loginuser/doedit",
				type:"post",
				data:$("#updateform").serialize(),
				dataType:"json",
				success:function(msg){
					if(msg.tag){
						$(".bootbox-close-button").click();
						bootbox.alert(msg.message);
						datatable.draw(true);
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
<form action="#" method="post" name="updateform" id="updateform">
	用户编号:<input type="text" id="logId" name="logId" value="${requestScope.loginuser.logId }" readonly="readonly"><br><br>
	用户账号:<input type="text" id="logName" name="logName" value="${requestScope.loginuser.logName }" readonly="readonly"><br><br>
	用户密码:<input type="text" id="logPsw" name="logPsw" value="${requestScope.loginuser.logPsw }"><br><br>
	用户类型:<input type="text" id="logType" name="logType" value="${requestScope.loginuser.logType }"><br><br>
	<br><font>1表示为具有可以给班级分配老师的权限</font>
	<input type="button" id="updatebtn" value="修改">
	<input type="reset" value="重置">
</form>
</body>
</html>