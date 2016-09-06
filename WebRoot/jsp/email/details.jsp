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
<title>邮件详情</title>
<jsp:include page="../../util/easyui_util.jsp"></jsp:include>
<script type="text/javascript">
	function back() {
		window.location = "email/update.do?eId=${email.eId}";
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'邮件详情'">
		<form id="myForm" name="myForm" method="post" action="email/download.do?fileName=${email.eUpfile}">
			<input type="hidden" name="EId" value="${email.eId}" />
			<table align="center" cellpadding="0" cellspacing="10">
				<tr>
					<td align="right" width="30%">邮件标题：</td>
					<td align="left"><input type="text" name="title" value="${email.eTitle}" disabled="disabled" id="title" /></td>
				</tr>
				<tr>
					<td align="right" width="30%">邮件内容：</td>
					<td align="left"><textarea cols="40" rows="10" disabled="disabled" name="content" id="content">${email.eContent}</textarea></td>
				</tr>
				<tr>
					<td align="right" width="30%">发件时间：</td>
					<td align="left">
						<fmt:formatDate value="${email.eReceivetime}" pattern="yyyy-MM-dd hh:mm:ss" />
					</td>
				</tr>
				<tr>
					<td align="right" width="30%">来自：</td>
					<td align="left"><input type="text" name="sender" value="${email.eSender}" disabled="disabled" id="sender" /></td>
				</tr>
				<tr>
					<td align="right" width="30%">文件：</td>
					<td align="left">
						<c:if test="${email.eUpfile!=null}">
							${email.eUpfile}<a href="email/download.do?fileName=${email.eUpfile}" style="color: red;">下载</a>
						</c:if></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><br /> <input type="button" id="re_to" value="返回" onclick="back();" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>