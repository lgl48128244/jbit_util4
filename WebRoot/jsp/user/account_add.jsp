<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>添加账号</title>
<jsp:include page="../../util/easyui_util.jsp"></jsp:include>
<script type="text/javascript">
	function setit() {
		if(!checkName()){
			$("#uname").focus();
			return false;
		}else if(!checkPassword()){
			$("#upassword").focus();
			return false;
		}else if(!checkRepassword()){
			$("#repassword").focus();
			return false;
		}else if(!checkNickName()){
			$("#nickname").focus();
			return false;
		}else if(!checkAge()){
			$("#uage").focus();
			return false;
		}else if(!checkSex()){
			$("#usex").focus();
			return false;
		}else if(!checkRole()){
			$("#role").focus();
			return false;
		}else if(!checkPhone()){
			$("#utelephone").focus();
			return false;
		}else if(!checkAddress()){
			$("#uaddress").focus();
			return false;
		}else {
			return true;
			//$("#myForm").submit();
			//$("form:first").submit();
			//document.forms[0].submit();
		}
	} 
	
	function checkName() {
		var uname = $("#uname").val();
		if(uname==null || uname.length<=0){
			$("#unameSpan").html("用户名不能为空");
			return false;
		}else{
			$("#unameSpan").html("");
			var formParam = $("#myForm").serialize();//序列化表格内容为字符串    
			$.ajax({
				type : 'post',
				url : 'user/checkName.do?uname=' + uname,
				cache : false,
				success : function(result) {
					if (result == "false") {
						$("#unameSpan").html("用户已存在");
						$("#uname").focus();
					} else {
						$("#unameSpan").html("");
					}
				}
			});
			
			return true;
		}
	}
	
	function checkPassword(){
		var upassword = $("#upassword").val();
		if(upassword == null || upassword.length<=0){
			$("#upasswordSpan").html("密码不能为空");
			return false;
		}
		$("#upasswordSpan").html("");
		return true;
	}
	
	function checkRepassword(){
		var upassword = $("#upassword").val();
		var repassword = $("#repassword").val();
		if(repassword==null || repassword.length<=0){
			$("#repasswordSpan").html("密码不能为空");
			return false;
		}else if (upassword != repassword) {
			$("#repasswordSpan").html("");
			$("#repasswordSpan").html("两次密码不一样！");
			return false;
		}
		$("#repasswordSpan").html("");
		return true;
	}
	
	function checkNickName(){
		var nickname = $("#nickname").val();
		if(nickname==null || nickname.length<=0){
			$("#nicknameSpan").html("昵称不能为空");
			return false;
		}else{
			$("#nicknameSpan").html("");
			return true;
		}
	}
	
	function checkAge(){
		var age = $("#uage").val();
		var ageReg = /^(1[89]|[2-5][0-9]|60)$/;
		if(age ==null || age.length<=0){
			$("#ageSpan").html("年龄不能为空");
			return false;
		}else if (!ageReg.test(age)){
			$("#ageSpan").html("");
			$("#ageSpan").html("年龄范围(18-60)");
			return false;
		}else{
			$("#ageSpan").html("");
			return true;
		}
	}
	
	function checkSex(){
		var usex = $("#usex").val();
		if(usex == null || usex.length<=0){
			$("#sexSpan").html("请选择");
			return false;
		}else{
			$("#sexSpan").html("");
			return true;
		}
	}
	
	function checkRole(){
		var role = $("#role").val();
		if(role == null || role.length<=0){
			$("#roleSpan").html("请选择");
			return false;
		}else{
			$("#roleSpan").html("");
			return true;
		}
	}
	
	function checkPhone(){
		var utelephone = $("#utelephone").val();
		var telReg = /^1[3|4|5|8][0-9]\d{4,8}$/;
		if(utelephone == null || utelephone.length<=0){
			$("#phoneSpan").html("手机号不能为空");
			return false;
		}else if(!telReg.test(utelephone)) {
			$("#phoneSpan").html("");
			$("#phoneSpan").html("手机号不合法");
			return false;
		}else{
			$("#phoneSpan").html("");
			return true;
		}
	}
	
	function checkAddress(){
		var uaddress = $("#uaddress").val();
		if(uaddress == null || uaddress.length<=0){
			$("#addressSpan").html("地址不能为空");
			return false;
		}else{
			$("#addressSpan").html("");
			return true;
		}
	}
	
	$(function(){
		$("#save").click(function(){
			 $('#myForm').form('submit', {
				url: 'user/add.do',
				onSubmit: function(){
					var isValid = setit();
					if (!isValid){
						return isValid;	// 返回false终止表单提交
					}
				},
				success: function(result){
					var data = JSON.parse(result);
					$.messager.alert("信息",data.message,'info');
					$('#myForm').form('reset');
				}
			}); 
		})
		$("#cancel").click(function(){
			window.location.href = "jsp/user/account_list.jsp";
		})
	});
	
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'添加账户'">
	<form id="myForm" name="myForm" action="" method="post">
		<input type="hidden" name="uIsread" value="0">
		<table align="center" cellpadding="0" cellspacing="10">
			<tr>
				<td align="right" width="30%">用户账户：</td>
				<td align="left">
				<input type="text" name="uName" id="uname" onblur="return checkName()" />
					<span id="unameSpan" style="color: red;">*</span>
				</td>
			</tr>
			<tr>
				<td align="right">用户密码：</td>
				<td align="left"><input type="password" name="uPwd" id="upassword" class="text" onblur="return checkPassword();" />
					<span id="upasswordSpan" style="color: red;">*</span>
			<tr>
				<td align="right">确认密码：</td>
				<td align="left"><input type="password" id="repassword" class="text"
					onblur="return checkRepassword();" />
					<span id="repasswordSpan" style="color: red;">*</span>
				</td>
			</tr>
			<tr>
				<td align="right" width="30%">用户昵称：</td>
				<td align="left"><input type="text" name="uNickname" id="nickname" onblur="return checkNickName();"/>
					<span id="nicknameSpan" style="color: red;">*</span>
				</td>
			</tr>
			<tr>
				<td align="right" width="30%">用户年龄：</td>
				<td align="left"><input type="text" name="uAge" id="uage" onblur="return checkAge();" />
				<span id="ageSpan"
					style="color: red;">*</span></td>
			</tr>
			<tr>
				<td align="right" width="30%">用户性别：</td>
				<td align="left">
				<select id="usex" name="uSex" onblur="return checkSex();">
						<option value="">请选择</option>
						<option value="1">男</option>
						<option value="0">女</option>
				</select>
				<span id="sexSpan" style="color: red;">*</span>
				</td>
			</tr>
			<tr>
				<td align="right" width="30%">用户权限：</td>
				<td align="left"><select id="role" name="uRole" onblur="return checkRole();">
						<option value="">请选择</option>
						<option value="1">经理</option>
						<option value="0">用户</option>
				</select>
				<span id="roleSpan" style="color: red;">*</span>
				</td>
			</tr>
			<tr>
				<td align="right" width="30%">用户手机：</td>
				<td align="left"><input type="text" name="uPhone" id="utelephone" onblur="return checkPhone();"/>
					<span id="phoneSpan" style="color: red;">*</span>
				</td>
			</tr>
			<tr>
				<td align="right" width="30%">用户地址：</td>
				<td align="left"><input type="text" name="uAddr" id="uaddress" onblur="return checkAddress();" />
					<span id="addressSpan" style="color: red;">*</span>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><br /> 
					<a class="easyui-linkbutton" href="javascript:;" id="save">保存数据</a>&nbsp;&nbsp;&nbsp;
					<a class="easyui-linkbutton" href="javascript:;" id="cancel">返回</a>
				 </td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>