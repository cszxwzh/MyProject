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
<script type="text/javascript">
$(document).ready(function(){
	datatable=$("#teachtable").DataTable({
		language:{url:"${pageContext.request.contextPath}/resource/js/china.json"},
		paging:true,
		searching:false,
		ordering:false,
		serverSide:true,
			ajax:{
			url:"${pageContext.request.contextPath}/jsp/teach/teachlist",
			type:"post",
			datasrc:'data'
			},
			columns:[
			{data:"TEACH_ID",render:function(data,type,row){
				return "<a href='javascript:choose(\""+data+"\")'>选择</a>"
			}},
			{data:"TEACH_NAME"},
			{data:"TEACH_SEX"},
			{data:"ENTRY_DATE"},
			{data:"TEACH_INTRO"}
			]
	});
	
});

function choose(teachId){

	$.ajax({
		url:"${pageContext.request.contextPath}/jsp/teach/tosel",
		type:"post",
		data:{"teachId":teachId},
		dataType:"json",
		success:function(msg){
			$("#teachName").val(msg.data.teachName);
			$("#teachId").val(msg.data.teachId);
			$(".selectTeach .bootbox-close-button").click();
		}
	});

}
</script>
<body>
<table id="teachtable" class="display" width="560px">
	<thead>
		<tr>
			<th class="content"></th>
			<th class="content">教师姓名</th>
			<th class="content">教师性别</th>
			<th class="content">入职日期</th>
			<th class="content">教师简介</th>
		</tr>
	</thead>
</table>
</body>
</html>