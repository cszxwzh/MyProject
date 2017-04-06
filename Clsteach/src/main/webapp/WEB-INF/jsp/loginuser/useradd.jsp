<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
$(document).ready(function(){
	$("#addbtn").click(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/jsp/loginuser/doadd",
			type:"post",
			data:$("#addform").serialize(),
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
<form action="#" method="post" name="addform" id="addform">
	用户名称：<input type="text" id="logName" name=logName><br><br>
	用户密码：<input type="text" id="logPsw" name="logPsw"><br><br>
	用户类型：<input type="text" id="logType" name="logType"><br><br>
	<input type="button" id="addbtn" value="添加">
	<input type="reset" value="重置">
</form>
</body>
</html>