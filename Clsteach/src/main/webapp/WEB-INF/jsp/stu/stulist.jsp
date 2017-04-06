<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
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
	datatable=$("#stutable").DataTable({
		language:{url:"${pageContext.request.contextPath}/resource/js/china.json"},
		paging:true,
		searching:false,
		ordering:false,
		serverSide:true,
			ajax:{
			url:"${pageContext.request.contextPath}/jsp/stu/stulist",
			type:"post",
			data:{"key1":$("#key1").val(),"key2":$("#key2").val()},
			datasrc:'data'
			},
			columns:[
			{data:"stuId"},
			{data:"stuName"},
			{data:"stuBirth"},
			{data:"cls.clsId"},
			{data:"cls.clsName"},
			{data:"stuId",render: function(data,type,row){
			return"<a href='javascript:doedit("+data+")'>修改</a>|<a href='javascript:dodel("+data+")'>删除</a>"
			}}
			]
	});
}

function doedit(stuId){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/stu/toedit",
		type:"post",
		data:{"stuId":stuId},
		success:function(msg){
			bootbox.dialog({
				title:"学生信息修改",
				message:msg
			});
		}
	});
}

function doadd(){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/stu/toadd",
		type:"post",
		success:function(msg){
			bootbox.dialog({
				title:"学生信息添加",
				message:msg
			});
		}
	});
}
function dodel(stuId){
	bootbox.confirm("你确定要删除吗？",function(result){
		if(result){
		$.ajax({
			url:"${pageContext.request.contextPath}/jsp/stu/dodel",
			type:"post",
			data:{"stuId":stuId},
			dataType:"json",
			success:function(msg){
				if(msg.tag){
					bootbox.alert(msg.message);
					createTable();
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
<a href="javascript:doadd()">学生添加</a>&emsp;<input type="button" onclick="back()" value="返回主页">
<form action="#" method="post">
学生姓名：<input type="text" id="key1"> 班级名称：<input type="text" id="key2">
<input type="button" id="selbtn" value="搜索"><input type="reset" value="重置">
</form>
<table id="stutable" class="display">
	<thead>
		<tr>
			<th class="content">学生编号</th>
			<th class="content">学生姓名</th>
			<th class="content">学生生日</th>
			<th class="content">班级编号</th>
			<th class="content">班级名称</th>
			<th class="content">功能操作</th>
		</tr>
	</thead>
</table>
</body>
</html>