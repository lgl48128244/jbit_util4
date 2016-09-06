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
			function setit() {
				 if(!checkAge()){
					$("#uage").focus();
					return false;
				}else if(!checkPhone()){
					$("#utelephone").focus();
					return false;
				}else if(!checkAddress()){
					$("#uaddress").focus();
					return false;
				} else {
					$.messager.confirm('确认对话框','您确定要保存吗？',function(r){
						if(r){
							$("#myForm").submit();
						}
					});
				}
			}
			
			function back() {
				$.messager.confirm('确认对话框', '您是否确定要返回?',function(r){
					if(r){
						window.location.href="jsp/user/user.jsp";
					}
				});
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
		</script>
	</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'修改信息'">
		<form id="myForm" name="myForm" action="user/edit.do?uid=${user.uId}" method="post"> 
			<table align="center" cellpadding="0" cellspacing="12" style="margin-top: 40px">
				<tr>
					<td align="right" width="30%">
						昵称：
					</td>
					<td align="left">
						<input type="text" name="uNickname" value="${user.uNickname}" id="nickname" />
						<input type="hidden" name="uId" value="${user.uId}"/>
					</td>
				</tr>
				<tr>
					<td align="right" width="30%">
						年龄：
					</td>
					<td align="left">
						<input type="text" name="uAge" value="${user.uAge}" id="uage" />
						<span style="color: red;" id="ageSpan">*</span>
					</td>
				</tr>
				<tr>
					<td align="right" width="30%">
						性别：
					</td>
					<td align="left">
						<select id="usex" name="uSex">
							<c:if test="${user.uSex == 1}">
								<option value='1'>
									男
								</option>
								<option value='0'>
									女
								</option>
							</c:if>
							<c:if test="${user.uSex == 0}">
								<option value='0'>
									女
								</option>
								<option value='1'>
									男
								</option>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right" width="30%">
						手机：
					</td>
					<td align="left">
						<input type="text" name="uPhone" value="${user.uPhone}" id="utelephone" />
						<span id="phoneSpan" style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<td align="right" width="30%">
						地址：
					</td>
					<td align="left">
						<input type="text" name="uAddr" value="${user.uAddr}" id="uaddress" />
						<span id="addressSpan" style="color: red;">*</span>
					</td>
				</tr>
			</table>
			<div style="margin-left: 470px;">
				<a href="javascript:;" class="easyui-linkbutton" onclick="setit();">保存数据</a> 
					&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:;" class="easyui-linkbutton" onclick="back();">返回</a> 
			</div>
		</form>
	</div>
</body>
</html>