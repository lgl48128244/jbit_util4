<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>休假信息列表</title>
<jsp:include page="../../util/easyui_util.jsp"></jsp:include>
<script type="text/javascript">
	var toolbar = [{
				text : '申请休假',
				iconCls:'icon-add', 
				handler : function(){
					window.location.href="jsp/vacation/vacation_apply.jsp";
				}
			}];
	
	$(function(){
		$("#vacationDataGrid").datagrid({
			idField:'id',
			url:'vacation/list.do',
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
				{field:'vName',title:'申请人',align:'center'},
				{field:'vStarttime',title:'开始时间',align:'center'},
				{field:'vEndtime',title:'结束时间',align:'center'},
				{field:'vDays',title:'请假天数',align:'center',
					formatter:function(value,row,data){
						return value + "天";
					}
				},
				{field:'vState',title:'审批状态',align:'center',
					formatter:function(value,row,data){
						if(row.vState == 0){
							return "<span style='color: blue;'>未审核</span>";
						}else if(row.vState == 1){
							return "<span style='color: green;'>已审核</span>";
						}else if(row.vState == 3){
							return "<span style='color: yellow;'>审核未通过</span>";
						}else if(row.vState == 4){
							return "<span style='color: red;'>已取消审核</span>";
						}
					}
				},
				{field:'vReason',title:'请假原因',align:'center'},
				{field:'vChecker',title:'审核人',align:'center'},
				{field:'opt',title:'操作',align:'center',
					 formatter:function(value,row,index){  
						 var uname = '${user.uName}';
						 var url;
						 if(row.vState == 0 && uname == row.vChecker){
							 url ="<a href='javascript:check(\""+row.vName+"\",\""+uname+"\",\""+row.vId+"\")' style='color: red'>审核</a>";
						 }else if(row.vState == 0 && uname == row.vName ){
							 url = "<a href='javascript:cancel(\""+row.vId+"\",\""+4+"\")' style='color:red'>取消申请</a>";
						 }else if(row.vState == 3 && uname == row.vName){
							 url = "<a href='vacation/apply.do?vId="+row.vId+"' style='color:red'>重新申请</a>";
						 }else if(row.vState == 4 && uname == row.vName){
							 url = "<a href='javascript:del(\""+row.vId+"\")' style='color:red'>删除</a>";
						 }
	                     return url;  
				    }	
				}
			]]
		});
	});
	
	function check(vname, name,vId) {
		if (name == vname) {
			$.messager.alert("警告","不能为自己审核！","warning");
		} else {
			window.location.href = "vacation/detail.do?vId=" + vId;
		}
	}
	
	function cancel(vId,vState) {
		$.messager.confirm('信息', '您确定要取消休假吗？', function(r){
			if(r){
				$.post('vacation/cancel.do' , {vId:vId,vState:vState} , function(result){
					$.messager.alert("信息",result.message,'info');
					//1 刷新数据表格 
					$('#vacationDataGrid').datagrid('reload');
				});
			} else {
				return ;
			}
		});
	}
	
	function del(id) {
		$.messager.confirm('信息', '您确定要删除吗？', function(r){
			if(r){
				$.post('vacation/delete.do' , {vId:id} , function(result){
					$.messager.alert("信息",result.message,'info');
					//1 刷新数据表格 
					$('#vacationDataGrid').datagrid('reload');
				});
			} else {
				return ;
			}
		});
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'休假信息列表'" >
    	<table id="vacationDataGrid"></table>
    </div>
</body>
</html>