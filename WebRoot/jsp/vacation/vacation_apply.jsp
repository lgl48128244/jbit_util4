<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>申请休假</title>
<jsp:include page="../../util/easyui_util.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$("#save").click(function(){
			 $('#myform').form('submit', {
				url: 'vacation/add.do',
				onBeforeLoad: function(){
					alert(checker);
					var isValid = $(this).form('validate');
					if (!isValid){
						return isValid;	// 返回false终止表单提交
					}
				},
				success: function(result){
					var data = JSON.parse(result);
					$.messager.alert("信息",data.message,'info');
					$('#myform').form('reset');
				}
			}); 
		})
		$("#cancle").click(function(){
			window.location.href = "jsp/vacation/vacation.jsp";
		})
	});
	
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'申请休假'">
		<form name="myform" id="myform" action="" method="post">
			<input type="hidden" name="vState" value="0" />
			<table align="center" cellpadding="0" cellspacing="10">
				<tr>
					<td align="right" width="30%">姓名：</td>
					<td align="left"><input type="text" name="vName" value="${user.uName}" readonly="readonly" /></td>
				</tr>
				<tr>
					<td align="right" width="30%">开始时间：</td>
					<td align="left"><input class="easyui-datebox" data-options="required:true" name="vStarttime"></td>
				</tr>
				<tr>
					<td align="right" width="30%">结束时间：</td>
					<td align="left"><input class="easyui-datebox" data-options="required:true" name="vEndtime"></td>
				</tr>
				<tr>
					<td align="right" width="30%">请假天数：</td>
					<td align="left"><input name="vDays" class="easyui-numberbox" data-options="required:true,min:0,max:30,missingMessage:'最多请假30天'"/> </td>
				</tr>
				<tr>
					<td align="right" width="30%">请假原因：</td>
					<td align="left"><textarea cols="30" rows="4" name="vReason" class="easyui-validatebox" required="true" validType="length[5,200]" missingMessage="5-200个字符！" ></textarea></td>
				</tr>
				<tr>
					<td align="right" width="30%">审批人：</td>
					<td align="left">
						<input name="vChecker" id="vChecker" class="easyui-combobox" data-options=" 
																		editable:false,
																		required:true,   
																        valueField: 'uName',
																        textField: 'uName',
																        panelHeight:'auto',
																        url: 'vacation/app_vacation.do?uName=${user.uName }'"/>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2"><br /> 
						<a class="easyui-linkbutton" href="javascript:;" id="save">提交</a>&nbsp;&nbsp;&nbsp;
						<a class="easyui-linkbutton" href="javascript:;" id="cancle">返回</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>