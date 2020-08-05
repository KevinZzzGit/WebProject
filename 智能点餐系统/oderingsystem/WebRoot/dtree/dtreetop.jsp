<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dtreetop.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
			body{
		background-image: url("snow.jpg");
		}
		.header {
    background-color:#FFCC66;
    color: #ffffff;
    padding:2%;
}
	</style>
  </head>
  
  <body>
  
    	<div class="header">
			<h1>XXXX火锅城后台管理</h1>
			
			<a style="float:right;font-size: 20px" href="#" onclick="javascript:top.location.href='<%=basePath%>index.jsp'">退出</a>
		</div>
  

  </body>
</html>
