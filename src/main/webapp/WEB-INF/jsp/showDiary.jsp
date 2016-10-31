<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改日记</title>
</head>
<body>
<h1>日记修改</h1>
<!-- 提交后 转到日记列表 -->
<form action="${pageContext.request.contextPath}/update.action" method="post">
	<input id="lid_input" name="lid" type="hidden" value="${diary.lid}"/>
	<table width="100%" border="1">
	<tr>
	    <th>标题:</th>
	    <td><input name="title" type="text" value="${diary.title}"/></td>
	</tr>
	<tr>		  
	    <th>内容:</th>
	    <td><textarea name="text" rows="10" cols="30" name="detail">${diary.text}</textarea></td>
	</tr>
	<tr>
		<th colspan="2">
		<input type="submit" value="提交修改"/>
		</th>
	</tr>
	</table> 
</form>
</body>
</html>