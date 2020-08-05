<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reindex.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
		<style>
			body{
				margin: 0px;
				background-image: url(./images/login.jpg);
				background-size:100% 100%;
				background-attachment: fixed;
				background-repeat: no-repeat;
				
			}
			.loginbox{
				margin:0 auto;
				/* border:1px solid #000; */
				width:300px;
				width:1000px;
				margin-top: 10%;				
				text-align: center;
			}
			.login{
				
				display:inline-block;
				height:200px;
				width:20%;
				background-color:rgba(0,0,255,0.5);
				margin:5%;
				border-radius:50%;
				border-bottom: 4px solid white;
				line-height:800%;
				font-size: 25px;
				font-weight: 600;
				
				
			
			}
			h1{
			font-size:50px;
			letter-spacing:50px;
			text-shadow: 2px 2px white;
			font-family: Impact, Charcoal, sans-serif;
			padding-bottom: 5%;
			}
			a{
			color: greenyellow;
			text-shadow: 3px 3px black;
			text-decoration: none;
			}
		</style>
  </head>
  
  <body>


		<div class="loginbox">
			<h1>智能点餐系统</h1>
			<div class="login"><a href="<%=basePath%>adShowAction.action">顾客登陆</a></div>
			<div class="login"><a href="<%=basePath%>tologin?tologin=waiter">服务员登陆</a></div>
			<div class="login"><a href="<%=basePath%>tologin?tologin=manager">管理员登陆</a></div>
		</div>	
  
    
  </body>
</html>
