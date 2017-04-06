<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级信息更新</title>
<script type="text/javascript">	
	$(document).ready(function(){
		$("#updatebtn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/jsp/cls/doedit",
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
	班级编号：<input type="text" readonly="readonly" id="clsId" name="clsId" value="${requestScope.cls.clsId }"><br><br>
	班级名称：<input type="text" id="clsName" name="clsName" value="${requestScope.cls.clsName }"><br><br>
	<input type="button" id="updatebtn" value="修改">
	<input type="reset" value="重置">
</form>
</body>
</html>