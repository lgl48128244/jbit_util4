<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>错误页面</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function back() {
		window.location.href="login.jsp";
	}
</script>
</head>
<body>
	<div class="action">
		<div class="t">出错了</div>
		<div class="pages" style=" padding-top:30px; font-size:18px">
			操作出现错误,点击<a href="javascript:back()" style="font-size:24px; color:#F00">这里</a>返回?
		</div>
	</div>
</body>
</html>