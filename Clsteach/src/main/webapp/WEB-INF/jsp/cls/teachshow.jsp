<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师信息</title>
</head>
<body>
<form action="#" method="post" name="updateform" id="updateform">
	教师编号：<input type="text" readonly="readonly" id="teachId" name="teachId" value="${requestScope.teacher.teachId }" ><br><br>
	教师姓名：<input type="text" readonly="readonly" id="teachName" name="teachName" value="${requestScope.teacher.teachName }"><br><br>
	教师性别：<input type="text" readonly="readonly" id="teachSex" name="teachSex" value="${requestScope.teacher.teachSex }"><br><br>
	入职日期：<input type="text" readonly="readonly" id="entryDate" name = "entryDate" value="<fmt:formatDate value='${requestScope.teacher.entryDate}' pattern="yyyy-MM-dd"/>"><br><br>
	负责班级：<c:forEach items="${requestScope.teacher.clslist}" var="cls">
				<font>${cls.clsName}&nbsp;&nbsp;&nbsp;&nbsp;</font>
			</c:forEach>
			<br><br>
	教师简介：<textarea rows="3" cols="25" name = "teachIntro" id="teachIntro">${requestScope.teacher.teachIntro }</textarea>
</form>
</body>
</html>