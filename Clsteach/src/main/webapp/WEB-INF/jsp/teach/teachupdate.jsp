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
	$("#entryDate1").datepicker(
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
				url:"${pageContext.request.contextPath}/jsp/teach/doedit",
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
	教师编号：<input type="text" readonly="readonly" id="teachId" name="teachId" value="${requestScope.teacher.teachId }"><br><br>
	教师姓名：<input type="text" id="teachName" name="teachName" value="${requestScope.teacher.teachName }"><br><br>
	教师性别：<input type="text" id="teachSex" name="teachSex" value="${requestScope.teacher.teachSex }"><br><br>
	入职日期：<input type="text" id="entryDate" name = "entryDate" onClick="WdatePicker()" value="<fmt:formatDate value='${requestScope.teacher.entryDate}' pattern="yyyy-MM-dd"/>"><br><br>
	教师简介：<textarea rows="3" cols="25" name = "teachIntro" id="teachIntro">${requestScope.teacher.teachIntro }</textarea><br><br>
	<input type="button" id="updatebtn" value="修改">
	<input type="reset" value="重置">
</form>
</body>
</html>