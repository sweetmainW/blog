<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
var input_name = "";
$(document).ready(function() {
	// ajax校验用户名是否存在
	$("#input_name").blur(function() {
		var inputName = $("#input_name").val();
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/ajaxValidate.action',
			contentType:'application/json;charset=utf-8',
			//数据格式是json串，
			data:'{"uname": "'+inputName+'"}',
			success:function(data){//返回json结果
				if (data.uname == inputName){
					alert("用户名已存在，请重新想名字");
					input_name = data.uname;
				}
			}
		});
		
    });
	
	$("#reg").click(function(check) {
		// 获得用户名
	    var uname = $("#input_name").val();
	    var password = $("#password").val();
	    
        // 校验用户名 是否为空
        if (uname == "") {
            alert("用户名不能为空");
            $(":text[id=input_name]").focus();
            check.preventDefault();//此处阻止提交表单
        }
     // 说明用户填写的名字已经存在
		if (input_name ==  uname) {
        	$(":text[id=input_name]").focus();
            check.preventDefault();//此处阻止提交表单
		}
        //长度是否超过十个字符
		if (uname.length > 10  ) {
        	alert("用户名长度不能超过十个字符");
        	$(":text[id=input_name]").focus();
            check.preventDefault();//此处阻止提交表单
    	}
        // 校验密码是否为空
        if (password == "" ) {
			alert("密码不能为空");
            $(":text[id=password]").focus();
            check.preventDefault();//此处阻止提交表单
		}
        //密码长度不能超过16个字符
        if (password.length > 16) {
            alert("密码长度不能超过十六个字符");
            $(":text[id=password]").focus();
            check.preventDefault();//此处阻止提交表单
        }
        
    });
});
</script>
</head>

<body>
	<h1>用户注册</h1>
<form action="${pageContext.request.contextPath}/register.action" method="post">
<table>
  <tr>
    <th>用户名：</th>
    <td><input type="text" name="uname" id="input_name" id="input_name"/></td>
  </tr>
  <tr>
  	<th>密码：</th>
    <td><input type="password" name="password" id="password"/></td>
  </tr>
  <tr>
  	<td><input type="submit" value="注册" id="reg"/></td>
  </tr>
</table>
</form>
</body>

</html>