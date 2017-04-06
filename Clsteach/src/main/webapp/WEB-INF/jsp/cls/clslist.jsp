<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级信息</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/clist.js"></script>
<script type="text/javascript">
var datatable = null;
$(document).ready(function(){
	 createclsTable();
	 $("#selbtn").click(function(){
	 createclsTable();		 
	 });
	 checklogin();
});
function createclsTable(){
	if(datatable!=null){
		datatable.destroy();
	}
	datatable=$("#clstable").DataTable({
		language:{url:"${pageContext.request.contextPath}/resource/js/china.json"},
		paging:true,
		searching:false,
		ordering:false,
		serverSide:true,
			ajax:{
			url:"${pageContext.request.contextPath}/jsp/cls/clslist",
			type:"post",
			data:{"key1":$("#key1").val()},
			datasrc:'data'
			},
			columns:[
			{data:"clsId"},
			{data:"clsName",render: function(data,type,row){
				return "<a href='javascript:displaystu(\""+data+"\")'>"+data+"</a";
			}},
			{data:"teachlist",render:function(data,type,row){
				var str = '';
				for(var i =0;i<data.length;i++){
					str =str+ "&nbsp;&nbsp;"+"<a href='javascript:displayteach("+data[i].teachId+")'>"+data[i].teachName+"老师   </a>&nbsp;&nbsp;";
					
				}
				return str;
			}},
			{data:"clsId",render: function(data,type,row){
			return"<a href='javascript:doshowdetail("+data+")'>教学安排详情</a>"
			}},
			//|<a href='javascript:docon("+data+")'>分配老师</a>
			{data:"clsId",render: function(data,type,row){
			return"<a href='javascript:doedit("+data+")'>修改</a>|<a href='javascript:dodel("+data+")'>删除</a>|<a href='${pageContext.request.contextPath}/jsp/cls/tocon?clsId="+data+"'onclick='return checkpower()'>分配老师</a>"
			}}
			]
	});
}
function checkpower(){
	if(${sessionScope.logType eq 1}){
		return true;
	}else{
		bootbox.alert("当前用户不能进行分配老师的操作，如需操作，请联系系统管理员");
		return false;
	}
		
}

function doedit(clsId){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/cls/toedit",
		type:"post",
		data:{"clsId":clsId},
		success:function(msg){
			bootbox.dialog({
				title:"班级信息修改",
				message:msg
			});
		}
	});
}

function doadd(){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/cls/toadd",
		type:"post",
		success:function(msg){
			bootbox.dialog({
				title:"班级信息添加",
				message:msg
			});
		}
	});
}
function dodel(clsId){
	bootbox.confirm("你确定要删除吗？",function(result){
		if(result){
		$.ajax({
			url:"${pageContext.request.contextPath}/jsp/cls/dodel",
			type:"post",
			data:{"clsId":clsId},
			dataType:"json",
			success:function(msg){
				if(msg.tag){
					bootbox.alert(msg.message);
					datatable.draw(false);
				}else{
					bootbox.alert(msg.message);
					datatable.draw(false);
				}
			}
		});	
		}
	});
}

function docon(clsId){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/cls/tocon",
		type:"post",
		data:{"clsId":clsId},
		success:function(msg){
			bootbox.dialog({
				title:"带班老师管理",
				message:msg
			});
		}
	});
}
function displayteach(teachId){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/cls/toteach",
		type:"post",
		data:{"teachId":teachId},
		success:function(msg){
			bootbox.dialog({
				title:"教师信息",
				message:msg
			});
		}
	});
}
function displaystu(clsName){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/cls/tostu",
		type:"post",
		data:{"clsName":clsName},
		success:function(msg){
			bootbox.dialog({
				title:"学生信息",
				message:msg
			});
		}
	});
}
function checklogin(){
	var logname = $("#logininfo").text();
	if(logname!="null"){
		$("#unlogin").hide();
		$("#belogin").show();
		$("#logout").show();
	}
	if(logname=="null"){
		$("#logininfo").text("游客 ");
		$("#unlogin").show();
		$("#belogin").hide();
		$("#logout").hide();
	}
}
function doshowdetail(clsId){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/cls/todetail",
		data:{"clsId":clsId},
		type:"post",
		success:function(msg){
			bootbox.dialog({
				title:"教学安排信息",
				message:msg
			});
		}
		
	});
}
function userinfo(logName){
	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/loginuser/userinfo",
		type:"post",
		data:{"logName":logName},
		success:function(msg){
			bootbox.dialog({
				title:"登录用户信息",
				message:msg
			});
		}
	});
}

</script>
<body>
<a href="javascript:doadd()">班级添加</a>&emsp;<!--&emsp; 制表位 多个空格的效果  -->
<a href="${pageContext.request.contextPath}/jsp/teach/teachshow">教师详细信息管理</a>&emsp;
<a href="${pageContext.request.contextPath}/jsp/stu/stushow">学生详细信息管理</a>&emsp;&emsp;&emsp;&emsp;&emsp;

<a id="logininfo" onclick="userinfo('${sessionScope.log.logName}')">${sessionScope.log.logName}</a>&emsp;<a id="unlogin" href="${pageContext.request.contextPath}/jsp/loginuser/login">请登陆</a>
<font id="belogin">欢迎登陆！</font>
<a id="logout" href="${pageContext.request.contextPath}/jsp/loginuser/logout">退出登录</a>
&emsp;<span>当前使用的人数为：${applicationScope.count}</span>
&emsp;<span>当前登录的人数为：${applicationScope.logincount}</span>
<form action="#" method="post">
班级名称：<input type="text" id="key1">
<input type="button" id="selbtn" value="搜索"><input type="reset" value="重置">
</form>

<table id="clstable" class="display">
	<thead>
		<tr>
			<th class="content">班级编号</th>
			<th class="content">班级名称</th>
			<th class="content">班级老师</th>
			<th class="content">教学安排</th>
			<th class="content">功能操作</th>
		</tr>
	</thead>
</table>
</body>
</html>