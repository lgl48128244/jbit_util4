<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>邮件信息列表</title>
<jsp:include page="../../util/easyui_util.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function() {
		$("#emailDataGrid").datagrid({
			idField:'id',
			url:'email/reveive.do?eReceive=${user.uName}',
			rownumbers : true,
			fitColumns : true, 
			autoRowHeight : true, 
			pagination: true , 
			singleSelect : true,
			border : false,
			loadMsg: '数据正在加载,请耐心的等待...' ,
			pageSize: 5 ,
			pageList:[5,10,15,20,50] ,
			columns:[[
				{field:'eTitle',title:'邮件标题',align:'center'},
				{field:'eSender',title:'发送者',align:'center'},
				{field:'eReceive',title:'接收者',align:'center'},
				{field:'eContent',title:'邮件内容',align:'center'},
				{field:'eIsread',title:'是否已读',align:'center',
					formatter:function(value,row,data){
						if(row.eIsread == 0){
							return "未读";
						}else{
							return "已读";
						}
					}
				},
				{field:'eReceivetime',title:'接收时间',align:'center',formatter : formatMethod},
				{field:'opt',title:'操作',align:'center',
					 formatter:function(value,row,index){  
						 var detail ="<a href='email/detail.do?eId="+row.eId+"'> 详情</a>&nbsp;&nbsp;";
	                     var del = "&nbsp;&nbsp;<a href='javascript:delrow(\""+row.eId+"\",\""+row.eTitle+"\");'>删除</a>";  
	                     return detail+del;  
				    }	
				}
			]]
		});
	});

 	function delrow(id,title){  
 		$.messager.confirm('确认对话框', '您确定要删除['+title+']吗？', function(r){
			if(r){
				$.post('email/deleteVirtual.do' , {eId:id} , function(result){
					$.messager.alert("信息",result.message,'info');
					//1 刷新数据表格 
					$('#emailDataGrid').datagrid('reload');
				});
			} else {
				return ;
			}
		});
    } 
	
	/**
	 * 格式化时间
	 */
	function formatMethod(val, row) {
		var date = new Date(val);
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		var h = date.getHours();
		var mm = date.getMinutes();
		var s = date.getSeconds();
		var dateTime = y + "-" + (m < 10 ? ("0" + m) : m) + "-"
				+ (d < 10 ? ("0" + d) : d) + " " + (h < 10 ? ("0" + h) : h)
				+ ":" + (mm < 10 ? ("0" + mm) : mm) + ":"
				+ (s < 10 ? ("0" + s) : s);
		return dateTime;
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'收件箱'" >
    	<table id="emailDataGrid"></table>
    </div>
</body>
</html>