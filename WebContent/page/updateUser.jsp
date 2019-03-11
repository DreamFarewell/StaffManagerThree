<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息修改</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/super/updateUser.action" method="post">
		<input type="hidden" name="id" value="${userCustom.id }"/>
		<table>
			<tr><td>用户名:</td><td><input type="text" name="user" value="${userCustom.user }"/></td></tr>
			<tr><td>密   码: </td><td><input type="text" name="password" value="${userCustom.password }"/></td></tr>
			<tr><td>用户类型:</td><td><select name="type"><option value="ordinary">管理员</option></select></td></tr>
			<tr><td><input type="submit" value="提交"/></td></tr>
		</table>
	</form>
</body>
</html>