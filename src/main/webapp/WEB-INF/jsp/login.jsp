<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" >
$(document).ready(function() {
	 // 失去焦点事件 执行   校验用户名
	$("#input_name").blur(function() {
		var inputName = $("#input_name").val();
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/ajaxValidate.action',
			contentType:'application/json;charset=utf-8',
			//数据格式是json串，
			data:'{"uname": "'+inputName+'"}',
			success:function(data){//返回json结果
				if (data.uname != inputName){
					alert("用户名不存在，请点击注册用户");
				}
			}
		});
    });
	
	// 注册按钮
	//$("#reg").click(function (){
     //   window.location.href = '${pageContext.request.contextPath}/register.jsp';
    //});
});
</script>
</head>
<body>
<h1>用户登录</h1>
<form action="${pageContext.request.contextPath }/login.action" method="post">
<table>
  <tr>
    <th>用户名：</th>
    <td><input type="text" name="uname" id="input_name"/></td>
  </tr>
  <tr>
  	<th>密码：</th>
    <td><input type="password" name="password" id="input_password"/></td>
  </tr>
  <tr>
  	<td><input type="submit" value="登录"/></td>
  	<td><a href="${pageContext.request.contextPath}/register.jsp">注册</a></td>
  </tr>
</table>
</form>
</body>
</html>