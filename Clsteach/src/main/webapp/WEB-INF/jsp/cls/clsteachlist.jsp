<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
</head>
<body>
<table align="center" width="480px" >
<tr height="30px" align="right">
<th colspan="3">${requestScope.clsex.clsName}教学安排</th>
</tr>
<tr height="30px" >
<td width="110px" >学习阶段</td>
<td width="110px">指导老师</td>
<td>时间安排</td>
</tr>
<c:if test="${requestScope.clsex!=null }">
<c:forEach items="${requestScope.clsex.stagelist }" var="stl">
<tr  height="30px">
<td>${stl.staName}</td>
<td>${stl.teach.teachName}</td>
<td><fmt:formatDate value="${stl.ctrelation.startDate}" pattern="yyyy-MM-dd"/>===> <fmt:formatDate value="${stl.ctrelation.endDate}" pattern="yyyy-MM-dd"/></td>
</tr>
</c:forEach>
</c:if>
<c:if test="${requestScope.clsex==null }">
<tr>
<td colspan="3" id="noresult" align="center">该班级没有安排，具体的教学计划！</td>
</tr>
</c:if>
</table>
</body>
</html>