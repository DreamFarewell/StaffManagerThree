<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.a_index {
	text-decoration: none;
}
</style>
<title>管理用户</title>
</head>
<body>
<c:if test="${userType=='super' }">
	<div>
		<img src="${pageContext.request.contextPath}/images/logo.png">
		<div class="page_log">
			<c:if test="${username==null }">
				登录后才能进行操作，请<a
					href="${pageContext.request.contextPath }/employee/employeeUpdate.action">登录</a>
			</c:if>
			<c:if test="${username!=null }">
				<table>
					<tr>
						<td><font color="#103f69">超级管理员用户:</font></td>
						<td><font color="#0080c0"> ${username }</font><font
							color="#103f69">已登录</font></td>
					</tr>
				</table>
				<table>
					<tr>
						<td style="border-left: 2px; border-color: black;"><a
							class="log_o"
							href="${pageContext.request.contextPath }/logout.action"><font
								size="1">退出登录</font></a></td>
					</tr>
				</table>
			</c:if>
		</div>
	</div>
	<form
		action="${pageContext.request.contextPath }/super/manageUser.action"
		method="post">
		<c:if test="${not empty userList }">
			<table>
				<tr>
					<td><input name="all" type="checkbox" /></td>
					<td>用户</td>
					<td>类型</td>
					<td colspan="2">操作</td>
				</tr>
				<c:forEach items="${userList }" var="list">
					<tr>
						<td><input name="idx" type="checkbox"></td>
						<td>${list.user }</td>
						<td>${list.userType }</td>
						<td align="center" class="td_style"><a
									class="a_button_update"
									href="${pageContext.request.contextPath }/super/updateUserPage.action?id=${list.id}">修改</a></td>
								<td align="center" class="td_style_delete"><a
									class="a_button_delete" onclick="return deleteEmployeeOne()"
									href="${pageContext.request.contextPath }/super/deleteUser.action?username=${list.user}&type=${list.userType}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
</c:if>
<c:if test="${userType=='ordinary' }">
	权限不足
	<a class="a_index"
				href="${pageContext.request.contextPath }/jsp/index.action">返回首页</a>
</c:if>
</body>
</html>