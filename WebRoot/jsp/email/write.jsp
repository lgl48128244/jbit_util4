<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>新增商品</title>
<jsp:include page="../../util/easyui_util.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8">
	//异步上传图片  jquery.form.js js语言模拟一个Form从而把图片提交上去
	function uploadPic(){
		var options = {
			url : "email/uploadPic.do",
			type : "post",
			dataType : "json",
			success : function(data){
				//返回二个路径  
				//全路径  显示图片
				//相对路径  保存数据库
				//data.url  data.path
				$("#allUrl").attr("src",data.url);
				$("#allUrl").height(150);
				$("#allUrl").width(300);
				$("#path").val(data.path);
			}
		}
		//异步上传完成
		$("#addForm").ajaxSubmit(options);
	}
	
	$(function(){
		$("#btn").click(function(){
			 $('#addForm').form('submit', {
				url: 'email/save.do',
				onBeforeLoad: function(){
					var isValid = $(this).form('validate');
					if (!isValid){
						return isValid;	// 返回false终止表单提交
					}
				},
				success: function(result){
					var data = JSON.parse(result);
					$.messager.alert("信息",data.message,'info');
					$('#addForm').form('reset');
					$("#allUrl").attr("src","");
					$("#allUrl").height(0);
					$("#allUrl").width(0);
				}
			}); 
		})
	});
</script>
</head>
<body class="easyui-layout">
<div data-options="region:'center',title:'写邮件'">
	<form id="addForm" method="post" action="">	
		<input type="hidden" name="eSender" value="${user.uName}" /> 
		<input type="hidden" name="eIsread" value="0" /> 
		<input type="hidden" name="eIsdel" value="0" />
		<table align="center" cellpadding="0" cellspacing="15">
			<tr>
				<td align="right"><font >收件人:</font></td>
				<td>
					<input name="eReceive" class="easyui-combobox" data-options=" 
																		editable:false,
																		required:true,   
																        valueField: 'uName',
																        textField: 'uName',
																        panelHeight:'auto',
																        url: 'email/write.do?uName=${user.uName }'"/>
				</td>
			</tr>		
			<tr>
			    <td align="right"> <font >邮件标题:</font></td>
			    <td>
			     	<input type="text" name="eTitle" class="easyui-validatebox" required="true" validType="length[1,25]" invalidMessage="不能超过15个字符！" >
			    </td>
			</tr>
			<tr>
			    <td align="right"> <font >邮件内容:</font></td>
			    <td>
			  	  <textarea rows="7" cols="50" name="eContent" class="easyui-validatebox" validType="length[5,200]" invalidMessage="5-200个字符！" ></textarea>
			    </td>
			</tr>
			<tr>
				<td width="20%"></td>
				<td width="80%">
					<img id="allUrl"/>
					<input type="hidden" id="path" name="eUpfile"/>
					<input type="file" onchange="uploadPic();"  name="pic" class="easyui-validatebox" required="true"/>
				</td>
			</tr>
		</table>
		<div style="margin-left:430px;">
			<a id="btn" href="javascript:;" class="easyui-linkbutton" size="small">保&nbsp;&nbsp;&nbsp;&nbsp;存</a> 
		</div>
	</form>	
</div>
</body>
</html>