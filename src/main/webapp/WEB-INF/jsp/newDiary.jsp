<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建日记</title>
</head>
<body>
<h1>创建日记</h1>
<form action="${pageContext.request.contextPath}/insert.action"  method="post">
	<input name="uid" type="hidden" value="${user.uid}"/>
	<table width="100%" border="1">
	<tr>
	    <th>标题:</th>
	    <td><input name="title" type="text"/></td>
	</tr>
	<tr>		  
	    <th>内容:</th>
	    <td><textarea name="text" rows="10" cols="30" ></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
		<input type="submit" value="创建日记"/>
		</th>
	</tr>
	</table> 
</form>
</body>
</html>