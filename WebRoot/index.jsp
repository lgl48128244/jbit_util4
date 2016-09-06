<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ssm.project.model.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
	
	User user = (User)session.getAttribute("user");
	
	if(user == null ){
		request.setAttribute("message", "登录超时，请重新登录！");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>
<html>
<head>
<title>北大青鸟办公管理系统</title>
<base href="<%=basePath%>">
<style type="text/css">
.global-width{ width:960px; margin:0 auto;}
.top{ width:100%; height:88px; background:url(Images/Top_bg.gif) repeat-x;}
.top .logo{ margin:17px 0 0 0;}
.copyright{ text-align:center; font:12px Arial; margin:5px 0; color:#000;}
</style>
<link rel="stylesheet" type="text/css" href="css/index.css">
<jsp:include page="util/easyui_util.jsp"></jsp:include>

<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
	var themes = "${themesName}";
	if(themes==""){
		if(localStorage.themesName!=undefined){
			themes = localStorage.themesName;
		}else{
			themes = "default";
		}
		window.location.href = "tree/reloadthemes.do?themes="+themes;
	}
	
	$(function(){
		//更换主题
		$(".themes_reload:contains('"+themes+"')").css("border","2px solid red");
		$(".themes_reload").click(function(){
			var th = $(this).html();
			$.messager.confirm('确认对话框', '更换主题会刷新所有页面，确定继续么？', function(r){
				if (r){
					localStorage.themesName = th;
					location.href = "tree/reloadthemes.do?themes="+th;
				}
			});
		});
		//加载菜单树
		$("#tt").tree({
			url:'tree/getTreeList.do',
			onLoadSuccess:function(node,data){
				if(data==-1){
					$.messager.alert('警告','登陆已过期，请重新登陆','warning');
					setTimeout(function(){
						window.location.href='login.jsp';
					}, 2000);
				}
			},
			onSelect:function(node){
				if(node.attributes.url!=""&&node.attributes.url!=undefined){
					addTab(node.text,node.attributes.url);
				}
			}
		});
		//修改用户密码
		$("#adminDiv").window({
			title:'管理员设置',
		    width:350,
		    height:300,
		    modal:true
		});
		$("#adminDiv").window('close');
	});
	
	function editPwd(){
		var pwd = $("#pwd").val();
		var oldPwd = $("#oldpwd").val();
		var enterPwd = $("#enterPwd").val();
		if(oldPwd != '${user.uPwd }'){
			$.messager.alert('警告','与原来的密码不一致','warning');
			return false;
		}else if(pwd!=enterPwd){
			$.messager.alert('警告','两次输入的密码不一致','warning');
			return false;
		}else if(enterPwd==""){
			$.messager.alert('警告','输入的密码不能为空','warning');
			return false;
		}else{
			$.ajax({
				url:'user/updatePwd.do',
				type:'post',
				data:{uPwd:enterPwd,uId:'${user.uId}'},
				success:function(result){
					$.messager.alert('我的消息',result.message,'info');
					setTimeout(function(){
						window.location.href = "user/logout.do?type=1";
					}, 2000);
				}
			});
		}
	}
</script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north'" style="height:90px;">
    	<div class="top">
			<div class="global-width">
				<img src="Images/logo.gif" class="logo" />
			</div>
		</div>
    </div>   
    <div data-options="region:'east',iconCls:'icon-reload'" style="width:200px;">
    	<div style="padding: 5px;" align="center">
    		<div class="easyui-calendar" style="width:180px;height:180px;"></div>
    		<a href="javascript:void(0)" id="mb" class="easyui-menubutton"     
			        data-options="menu:'#mm1'">菜单</a>
			<div id="mm1" style="width:150px;">
			    <div data-options="iconCls:'icon-undo'" onclick="window.location.href='user/logout.do?type=0';">注销</div>
			    <div data-options="iconCls:'icon-edit'" onclick="$('#adminDiv').window('open');">管理员设置</div>
			</div>
			<div id="msg_panel" class="easyui-panel" title="消息"     
			        style="width:180px;height:220px;padding:10px;background:#fafafa;"   
			        data-options="iconCls:'',closable:false,    
			                collapsible:false,minimizable:false,maximizable:false">
		          <table align="center" cellpadding="0" cellspacing="10" style="margin-top: 40px;">
		         	 <tr>
			          	<th align="right">当前用户:</th>
			          	<td><font color="blue;">${user.uName }</font></td>
		          	 </tr>
		         	 <tr>
			          	<th align="right">职位:</th>
			          	<td><font color="blue;">${user.uRole ==0?"员工":"经理"}</font></td>
		          	 </tr>
		          </table>
			</div>
    	</div>
    </div>   
    <div data-options="region:'west',title:'菜单'" style="width:150px;">
    	<ul id="tt"></ul>  	    	
    </div>   
    <div id="mm" class="easyui-menu cs-tab-menu">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseother">关闭其他</div>
		<div id="mm-tabcloseall">关闭全部</div>
	</div>
	<div id="adminDiv">
		<div fit="true" class="easyui-tabs" style="width:400px;height:270px;">
		    <div title="修改密码" style="overflow:auto;padding:20px;">
	        	<form method="post">
		        	<table align="center" cellpadding="0" cellspacing="10">
		        		<tr>
		        			<td align="right">当前密码：</td>
		        			<td><input id="oldpwd" type="password"></td>
		        		</tr>
		        		<tr>
		        			<td align="right">新密码：</td>
		        			<td><input name="uPwd" id="pwd" type="password"></td>
		        		</tr>
		        		<tr>
		        			<td align="right">再次输入：</td>
		        			<td><input id="enterPwd" type="password"></td>
		        		</tr>
		        	</table>
		        	<div style="margin-left: 130px; margin-top: 10px;">
		        		<a class="easyui-linkbutton" href="javascript:;" onclick="editPwd();">
		        		<span style="font-size: 20px; color: red;">修&nbsp;改</span></a>
		        	</div>
	        	</form>
		    </div>
		</div>
	</div>
    <div data-options="region:'center'" style="background:#eee;">
    	<div id="tabs" class="easyui-tabs" fit="true" border="false" >
               <div title="首页">
				<div class="easyui-panel index_panel" title="更换主题" style="height:350px;padding:15px;"   
       				data-options="iconCls:'icon-reload',collapsible:true,style:{float: 'left'}">
					<div class="themes_reload" style="background-color: #3d3d3d;color: white;">black</div>
					<div class="themes_reload" style="background-color: #F2F2F2">bootstrap</div>
					<div class="themes_reload" style="background-color: #E0ECFF;">default</div>
					<div class="themes_reload" style="background-color: gray;">gray</div>
					<div class="themes_reload" style="background-color: #ffffff">metro</div>
					<div class="themes_reload" style="background-color: gray;">metro-gray</div>
					<div class="themes_reload" style="background-color: green;">metro-green</div>
					<div class="themes_reload" style="background-color: orange;">metro-orange</div>
					<div class="themes_reload" style="background-color: #F6C1BC;">metro-red</div>
					<div class="themes_reload" style="background-color: #AED0EA">ui-cupertino</div>
					<div class="themes_reload" style="background-color: #0972a5">ui-dark-hive</div>
					<div class="themes_reload" style="background-color: #4C3000">ui-sunny</div>
				</div>
			</div>
       	</div>
    </div> 
    <div data-options="region:'south'" style="height:30px;">
    	<div class="copyright">Copyright&nbsp; 2010 &nbsp; &copy; &nbsp; 北大青鸟</div>
    </div>    
</body>
</html>
