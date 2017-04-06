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
<link rel="stylesheet" type="text/css" href ="${pageContext.request.contextPath}/resource/js/bootstrap.css">
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
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/bootstrap.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/bootbox.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/resource/js/jquery-ui.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	datatable=$("#stutable").DataTable({
		language:{url:"${pageContext.request.contextPath}/resource/js/china.json"},
		paging:true,
		searching:false,
		ordering:false,
		serverSide:true,
			ajax:{
			url:"${pageContext.request.contextPath}/jsp/stu/stulist",
			type:"post",
			data:{"key2":$("#key2").val()},
			datasrc:'data'
			},
			columns:[
			{data:"stuId"},
			{data:"stuName"},
			{data:"stuBirth"},
			{data:"cls.clsName"},
			]
	});
});


</script>
<body>

<input type="text" id="key2" value="${requestScope.clsName }" style="display:none">

<table id="stutable" class="display" width="540px">
	<thead>
		<tr>
			<th class="content">学生编号</th>
			<th class="content">学生姓名</th>
			<th class="content">学生生日</th>
			<th class="content">班级名称</th>
		</tr>
	</thead>
</table>
</body>
</html>