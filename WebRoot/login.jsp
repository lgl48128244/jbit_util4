<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>登录</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	#code,#img{vertical-align: middle;}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	/**
	 * 登录验证
	 * @return {TypeName} 
	 */
	function checkName() {
		var username = $("#UId").val();
		var span1 = $("#name");
		if (username == null || username == "") {
			span1.html("用户名不能为空");
			$("#UId").focus();
			return false;
		} else {
			span1.html("");
			return true;
		}
	} 
	 
	function checkPassword() {
		var password = $("#upassword").val();
		var span1 = $("#pass");
		if (password == null || password == "") {
			span1.html("密码不能为空");
			$("#upassword").focus();
			return false;
		} else {
			span1.html("");
			return true;
		}
	}

	function validLogin(){
		if(!checkName()){
			$("#UId").focus();
			return false;
		}else if(!checkPassword()){
			$("#upassword").focus();
			return false;
		}else{
			return true;
		}
	}
	/* function checkCode() {
		var ck = document.getElementById("code").value;
		var span1 = document.getElementById("vcode");
		var reg = /^[a-zA-z0-9]{5}$/;
		if (ck == null || ck == "") {
			span1.innerHTML = "验证码不能为空";
			return false;
		} else if (reg.test(ck) == false) {
			span1.innerHTML = "输入字符无效";
			return false;
		} else {
			span1.innerHTML = "";
			return true;
		}
	} */

	/***
	  *   获取当前的时间作为参数，无具体意义   
	  *   每次请求需要一个不同的参数，否则可能会返回同样的验证码    
	  *   这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。  
	  */
	/* function changeValidateCode(obj) {
		
		var timenow = new Date().getTime();
		obj.src = "dsna.images?d=" + timenow;
	} */

	function checklogin() {
		var isValid = validLogin();
		if (!isValid){
			return isValid;	// 返回false终止表单提交
		}else{
			$("form").submit();
		}
	}
	
	window.onload = function(){
		$("#UId").focus();
	}
	
	document.onkeydown = function(e){  
		var ev = document.all ? window.event : e;
		if(ev.keyCode==13) {// 如（ev.ctrlKey && ev.keyCode==13）为ctrl+Center 触发
			checklogin();
		}
	}
</script>
</head>
<body>
	<div class="login-top"></div>
	<div class="login-area">
		<form action="user/login.do" method="post" id="loginForm">
			<table>
				<tr>
					<th align="right">用户名:</th>
					<td>
						<input type="text" name="uName" id="UId"/>
						<span id="name" style="color: red; font-size: 12px;">*</span> 
					</td>
				</tr>
				<tr>
					<th align="right">密码:</th>
					<td>
						<input type="password" name="uPwd" id="upassword" />
						<span id="pass" style="color: red; font-size: 12px;" >*</span> 
					</td>
				</tr>
			</table>
			<!-- 
			<label>验证码：</label> 
			<input id="code" type="text" name="code" onblur="return checkCode();" /> 
			<img id="img" src="dsna.images" onclick="changeValidateCode(this)"/> 
			<span id="vcode" style="color: red"></span>  -->
			<input type="button" class="login-sub" value="" onclick="checklogin();"/><br/> 
			<span style="color: green; font-size: 16px;">${message }</span>
		</form>
	</div>
	<div class="login-copyright"></div>
</body>
</html>
