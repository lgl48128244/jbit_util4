<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>个人信息</title>
<jsp:include page="../../util/easyui_util.jsp"></jsp:include>
<script type="text/javascript">
	function editor() {
		window.location.href = "user/info.do?uId=${user.uId }";
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'个人信息'">
	<form id="myForm" name="myForm">
		<table align="center" cellpadding="0" cellspacing="12" style="margin-top: 40px">
			<tr>
				<td align="right" width="30%">昵称：</td>
				<td align="left"><input type="text"  value="${user.uNickname}" disabled="disabled"  /></td>
			</tr>
			<tr>
				<td align="right" width="30%">年龄：</td>
				<td align="left"><input type="text" value="${user.uAge}" disabled="disabled" /></td>
			</tr>
			<tr>
				<td align="right" width="30%">性别：</td>
				<td align="left">
					<c:if test="${user.uSex == 1}">
						<input type="text"  value="男" disabled="disabled" />
					</c:if>
					<c:if test="${user.uSex == 0 }">
						<input type="text"  value="女" disabled="disabled"/>
					</c:if>
				</td>
			</tr>
			<tr>
				<td align="right" width="30%">手机：</td>
				<td align="left"><input type="text" value="${user.uPhone}" disabled="disabled"  /></td>
			</tr>
			<tr>
				<td align="right" width="30%">地址：</td>
				<td align="left"><input type="text" value="${user.uAddr}" disabled="disabled"  /></td>
			</tr>
		</table>
		<div style="margin-left: 470px;">
			<a href="javascript:;" class="easyui-linkbutton" onclick="editor();">编辑数据</a>
		</div>
	</form>
</div>
</body>
</html>