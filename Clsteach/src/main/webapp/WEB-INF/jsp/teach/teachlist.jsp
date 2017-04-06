<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师信息</title>
</head>
<link rel="stylesheet" type="text/css" href ="${pageContext.request.contextPath}/resource/js/jquery.dataTables.css">
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
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
var datatable = null;
$(document).ready(function(){
	 createTable();
	 $("#selbtn").click(function(){
	 createTable();		 
	 });
});

function createTable(){
	if(datatable!=null){
		datatable.destroy();
	}
	datatable=$("#teachtable").DataTable({
		language:{url:"${pageContext.request.contextPath}/resource/js/china.json"},
		paging:true,
		searching:false,
		ordering:false,
		serverSide:true,
			ajax:{
			url:"${pageContext.request.contextPath}/jsp/teach/teachlist",
			type:"post",
			data:{"key1":$("#key1").val(),"key2":$("#key2").val()},
			datasrc:'data'
			},
			columns:[
			{data:"TEACH_ID"},
			{data:"TEACH_NAME"},
			{data:"TEACH_SEX"},
			{data:"ENTRY_DATE"},
			{data:"TEACH_INTRO"},
			{data:"CLSNAMES"},
			{data:"TEACH_ID",render: function(data,type,row){
			return"<a href='javascript:doedit("+data+")'>修改</a>|<a href='javascript:dodel("+data+")'>删除</a>"
			}}
			]
	});
}

function doedit(teachId){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/teach/toedit",
		type:"post",
		data:{"teachId":teachId},
		success:function(msg){
			bootbox.dialog({
				title:"教师信息修改",
				message:msg
			});
		}
	});
}

function doadd(){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/teach/toadd",
		type:"post",
		success:function(msg){
			bootbox.dialog({
				title:"教师信息添加",
				message:msg
			});
		}
	});
}
function dodel(teachId){
	bootbox.confirm("你确定要删除吗？",function(result){
		if(result){
		$.ajax({
			url:"${pageContext.request.contextPath}/jsp/teach/dodel",
			type:"post",
			data:{"teachId":teachId},
			dataType:"json",
			success:function(msg){
				if(msg.tag){
					bootbox.alert(msg.message);
					datatable.draw(false);
				}else{
					datatable.draw(false);
				}
			}
		});	
		}
	});
}
function back(){
	window.location.href="${pageContext.request.contextPath}/jsp/cls/clsshow";
}
</script>
<body>
<a href="javascript:doadd()">教师添加</a>&emsp;<input type="button" onclick="back()" value="返回主页">
<form action="#" method="post">
教师姓名：<input type="text" id="key1"> 简介信息：<input type="text" id="key2">
<input type="button" id="selbtn" value="搜索"><input type="reset" value="重置">
</form>
<table id="teachtable" class="display">
	<thead>
		<tr>
			<th class="content">行号</th>
			<th class="content">教师姓名</th>
			<th class="content">教师性别</th>
			<th class="content">入职日期</th>
			<th class="content">教师简介</th>
			<th class="content">负责班级</th>
			<th class="content">功能操作</th>
		</tr>
	</thead>
</table>
</body>
</html>