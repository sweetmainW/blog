<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日记列表</title>
<script type="text/javascript">
//当前第几页数据
var currentPageNum = ${diaryQueryVo.currentPageNum};

// 总页数
var totalPage = ${diaryQueryVo.pageSum};

function submitForm(actionUrl){
	var formElement = document.getElementById("stuForm");
	formElement.action = actionUrl;
	formElement.submit();
}

// 首页
function firstPage(){
	if(currentPageNum == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		window.location.href = '${pageContext.request.contextPath}/diaryList.action?currentPageNum=1';
		return true;
	}
}

// 下一页
function nextPage(){
	if(currentPageNum == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		window.location.href = '${pageContext.request.contextPath}/diaryList.action?currentPageNum='+ (currentPageNum+1);
		return true;
	}
}

// 上一页
function previousPage(){
	if(currentPageNum == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		window.location.href = '${pageContext.request.contextPath}/diaryList.action?currentPageNum='+ (currentPageNum-1);
		return true;
	}
}

// 尾页 这有问题
function lastPage(){
	if(currentPageNum == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		window.location.href = '${pageContext.request.contextPath}/diaryList.action?currentPageNum='+totalPage;
		return true;
	}
}
</script>
</head>
<body>
<h1>日记列表</h1>
欢迎您 ${user.uname }，
<a href="${pageContext.request.contextPath}/logout.action">退出</a>
<br/>
<a href="${pageContext.request.contextPath}/newDiary.action">新建日记</a> <!-- 该功能已实现 -->
<form action="${pageContext.request.contextPath}/diaryList.action" method="post">
<input id="search_input" type="text" name="titleSearch"/>
<input type="submit" value="根据标题搜索"/><hr/><!-- 该功能已实现 -->
</form>

<table width="100%" border="1">
  <tr>
    <th>标题</th>
	<th>内容</th>
	<th>创建时间</th>
	<th>操作</th>
  </tr>
<%--遍历输出 --%>
<c:forEach var="diary" items="${diaryQueryVo.diaryList}">
  <tr>
    <td><c:out value="${diary.title}"></c:out></td>
	<td><c:out value="${diary.text}"></c:out><a href="${pageContext.request.contextPath}/showDiary.action?lid=${diary.lid}">修改</a></td>
	<td><fmt:formatDate value="${diary.lcreateTime}" pattern="yyyy-MM-dd"/></td>
	<td><a href="${pageContext.request.contextPath}/delete.action?lid=${diary.lid}">删除</a></td>
  </tr>
</c:forEach>
</table>
<div>
	<font color="red">${errorMsg }</font>
</div>
<form action="#" id="stuForm"> 
	<br> 共${diaryQueryVo.totalRecord }条记录共${diaryQueryVo.pageSum }页&nbsp;&nbsp;当前第${diaryQueryVo.currentPageNum }页&nbsp;&nbsp;
	<a href="#" onclick="firstPage();">首页</a>&nbsp;&nbsp; 
	<a href="#" onclick="nextPage();" >下一页</a>&nbsp;&nbsp; 
	<a href="#" onclick="previousPage();">上一页</a>&nbsp;&nbsp;
	<a href="#" onclick="lastPage();">尾页</a>	
</form>
	
</body>
</html>