<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>账户管理列表</title>
<jsp:include page="../../util/easyui_util.jsp"></jsp:include>
<script type="text/javascript">

	function delaccount(id) {
		$.messager.confirm('确认对话框', '您确定要删除吗？', function(r){
			if(r){
				$.post('user/userdelete.do' , {id:id} , function(result){
					$.messager.alert("信息",result.message,'info');
					//1 刷新数据表格 
					$('#accountDataGrid').datagrid('reload');
					//2 清空idField   
					$('#accountDataGrid').datagrid('unselectAll');
				});
			} else {
				return ;
			}
		});
	}
	
	var toolbar = [{
		text : '添加数据',
		iconCls:'icon-add', 
		handler : function(){
			window.location.href="jsp/user/account_add.jsp";
		}
	}];

	$(function(){
		$("#accountDataGrid").datagrid({
			idField:'id',
			url:'user/list.do',
			rownumbers : true,
			fitColumns : true, 
			autoRowHeight : true, 
			pagination: true , 
			singleSelect : true,
			border : false,
			loadMsg: '数据正在加载,请耐心的等待...' ,
			pageSize: 5 ,
			pageList:[5,10,15,20,50] ,
			toolbar:toolbar,
			columns:[[
				{field:'uName',title:'用户名',align:'center',sortable:true},
				{field:'uNickname',title:'昵称',align:'center',sortable:true},
				{field:'uPhone',title:'手机',align:'center',sortable:true},
				{field:'uAddr',title:'地址',align:'center',sortable:true},
				{field:'uRole',title:'职务',align:'center',sortable:true,
					formatter:function(value,row,index){  
						if(row.uRole==1){
							return "经理";
						}else{
							return "员工";
						}
					}
				},
				 {field:'opt',title:'操作',align:'center',
					 formatter:function(value,row,index){  
						 if('${user.uRole}'==1){
		                	 return "<a href='javascript:delaccount(\""+row.uId+"\")' style='color:red'>删除</a>";
						}
				    }	
				}
			]]
		});
	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'账户管理列表'">
		<table id="accountDataGrid"></table>
	</div>
</body>
</html>