<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>带班老师管理</title><link rel="stylesheet" type="text/css" href ="${pageContext.request.contextPath}/resource/js/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href ="${pageContext.request.contextPath}/resource/js/bootstrap.min.css">
<link rel ="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/js/jquery-ui.css">
<style>
.content{
text-align:center;
}
</style>
<!-- 引入jquery的插件 -->
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/jquery-3.1.1.js"></script>
<!-- 引入分页的插件 -->
<script type="text/javascript" src ="${pageContext.request.contextPath}/resource/js/jquery.dataTables.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/bootbox.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/clist.js"></script>

<script type="text/javascript">
$(function(){
	$("#startDate,#endDate").datepicker(
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
		$("#subbtn").click(function(){
			var sdate = new Date($("#startDate").val());
			var edate = new Date($("#endDate").val());
			if(edate-sdate>=0){
			$.ajax({
				url:"${pageContext.request.contextPath}/jsp/cls/docon",
				type:"post",
				data:$("#conform").serialize(),
				dataType:"json",
				success:function(msg){
					if(msg.tag){
						$(".bootbox-close-button").click();
						bootbox.alert(msg.message);
						//createclsTable();
						history.go(-1);
						}else{
						bootbox.alert(msg.message);	
						}
				}
			});
			}else{
				bootbox.alert("阶段的开始日期不能小于结束日期，请检查输入的日期！");
			}
		}),
		
		$("#staId").change(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/jsp/cls/selteach",
				type:"post",
				data:{"clsId":$("#clsId").val(),"staId":$("#staId").val()},
				dataType:"json",
				success:function(msg){
					$("#teachName").val(msg.data.teach.teachName);
					$("#teachId").val(msg.data.teach.teachId);
				}
			});
		}),
	$("#teachName").click(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/jsp/cls/teachselect",
			type:"post",
			success:function(msg){
				bootbox.dialog({
					title:"选择老师",
					className:"selectTeach",
					message:msg
				});
			}
		}); 
	});
});
	function back(){
		window.location.href="${pageContext.request.contextPath}/jsp/cls/clsshow";
	}
</script>
</head>
<body>
<form action="#" method="post" name="conform" id="conform">
班级编号：<input type="text" name="clsId" id="clsId" readonly="readonly" value="${requestScope.cls.clsId }"><br><br>
班级名称：<input type="text" readonly="readonly" value="${requestScope.cls.clsName}"><br><br>
学习阶段：<select id="staId" name = "staId">
			<option value="0">请选择</option>
			<c:forEach items="${requestScope.stlist }" var="sta">
				<option value="${sta.staId }">${sta.staName }</option>
			</c:forEach>
</select><br><br>
<input type="text" name="teachId" id="teachId" style="display:none">
对应老师：<input type="text" name="teachName" id="teachName">
		<%-- <select id="teachId" name="teachId">
		<option value="0">请选择</option>
		<c:forEach items="${requestScope.tealist }" var="tea">
			<option value="${tea.teachId }">${tea.teachName}</option>
		</c:forEach>
		</select> --%>
		<br><br>
开始时间：<input type="text" id="startDate" name="startDate" class="datetype"><br><br>
结束时间：<input type="text" id="endDate" name="endDate" class="datetype"><br><br>
<input type="button" name="subbtn" id="subbtn" value="提交">
<input type="reset" value="重置">
&emsp;<input type="button" onclick="back()" value="返回主页">
</form>
</body>
</html>