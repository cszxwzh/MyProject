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
$(function(){
	$("#stuBirth").datepicker(
		{
				//添加日期选择功能  
	            numberOfMonths:1,//显示几个月  
	            showButtonPanel:true,//是否显示按钮面板  
	            dateFormat: 'yy-mm-dd',//日期格式  
	            clearText:"清除",//清除日期的按钮名称  
	            closeText:"关闭",//关闭选择框的按钮名称  
	            yearSuffix: '年', //年的后缀  
	            showMonthAfterYear:true,//是否把月放在年的后面  
	            monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],  
	            dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],  
	            dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],  
	            dayNamesMin: ['日','一','二','三','四','五','六'],  
	            });
	});
	
	$(document).ready(function(){
		$("#updatebtn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/jsp/stu/doedit",
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
	学生编号：<input type="text" readonly="readonly" id="stuId" name="stuId" value="${requestScope.stu.stuId }"><br><br>
	学生姓名：<input type="text" id="stuName" name="stuName" value="${requestScope.stu.stuName }"><br><br>
	学生生日：<input type="text" id="stuBirth" name = "stuBirth" value="<fmt:formatDate value='${requestScope.stu.stuBirth}' pattern="yyyy-MM-dd"/>"><br><br>
	学生班级：
	<select id="clsId" name="clsId">
	<option value="0">请选择</option>
	<c:forEach items="${requestScope.clist }" var= "cls">
		<option value="${cls.clsId }" <c:if test="${cls.clsId==requestScope.stu.clsId }">selected="selected"</c:if>>${cls.clsName}</option>
	</c:forEach>
	</select>
	<br><br>
	<input type="button" id="updatebtn" value="修改">
	<input type="reset" value="重置">
</form>
</body>
</html>