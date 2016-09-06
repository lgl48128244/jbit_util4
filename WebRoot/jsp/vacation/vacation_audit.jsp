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
<title>休假审核</title>
<jsp:include page="../../util/easyui_util.jsp"></jsp:include>
<script type="text/javascript">
	function yes() {
		document.getElementById("vState").value = "1";
		 $('#myForm').form('submit', {
			url: 'vacation/audit.do',
			success: function(result){
				var data = JSON.parse(result);
				$.messager.alert("信息",data.message,'info');
				setTimeout(function(){
					window.location.href="jsp/vacation/vacation.jsp";
				}, 2000);
			}
		}); 
	}
	function no() {
		document.getElementById("vState").value = "3";
		 $('#myForm').form('submit', {
			url: 'vacation/audit.do',
			success: function(result){
				var data = JSON.parse(result);
				$.messager.alert("信息",data.message,'info');
				setTimeout(function(){
					window.location.href="jsp/vacation/vacation.jsp";
				}, 2000);
			}
		}); 
	}
</script>
</head>

<body class="easyui-layout">
	<div data-options="region:'center',title:'休假审核'">
		<form id="myForm" name="myForm" action="" method="post">
			<input type="hidden" id="vState" name="vState" value="" /> 
			<input type="hidden" name="vId" value="${vacation.vId}" />
			<input type="hidden" name="vChecker" value="${vacation.vChecker}" />
			<table align="center" cellpadding="0" cellspacing="12" style="margin-top: 40px;">
				<tr>
					<td align="right" width="30%">申请人：</td>
					<td align="left"><input type="text" name="vName" value="${vacation.vName}" readonly="readonly" id="applicant" /></td>
				</tr>
				<tr>
					<td align="right" width="30%">开始时间：</td>
					<td align="left">
						<input type="text" name="vStarttime" value="${vacation.vStarttime}" readonly="readonly" id="starttime" />
					</td>
				</tr>
				<tr>
					<td align="right" width="30%">结束时间：</td>
					<td align="left">
						<input type="text" name="vEndtime" value="${vacation.vEndtime}" readonly="readonly" id="endtime" />
					</td>
				</tr>
				<tr>
					<td align="right" width="30%">请假天数：</td>
					<td align="left"><input type="text" name="vDays" value="${vacation.vDays}" readonly="readonly" id="totalday" /></td>
				</tr>
				<tr>
					<td align="right" width="30%">请假原因：</td>
					<td align="left"><input type="text" name="vReason" value="${vacation.vReason}" readonly="readonly" id="reason" /></td>
				</tr>
			</table>
		</form>
		<div style="margin-left: 470px;">
			<a href="javascript:;" class="easyui-linkbutton" onclick="yes()">审核通过</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:;" class="easyui-linkbutton" onclick="no()">审核不通过</a>
		</div>
	</div>
</body>
</html>