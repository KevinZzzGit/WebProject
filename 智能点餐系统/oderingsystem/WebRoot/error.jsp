<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="refresh" content="5;url=<%=basePath%>index.jsp">
    <title>My JSP 'error.jsp' starting page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="./style/bootstrap.min.css">

<link rel="stylesheet" href="./style/style.css">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/dandelion.css"  media="screen" />
  </head>
  
  <body>
		<!-- Main Wrapper. Set this to 'fixed' for fixed layout and 'fluid' for fluid layout' -->
	<div id="da-wrapper" class="fluid">
    
        <!-- Content -->
        <div id="da-content">
            
            <!-- Container -->
            <div class="da-container clearfix">
            
            	<div id="da-error-wrapper">
                	
                   	<div id="da-error-pin"></div>
                    <div id="da-error-code">
                    	error <span>404</span>                    </div>
                
                	<h1 class="da-error-heading"><%=session.getAttribute("errormsg")%>！</h1>
                    <p>页面将在5秒后跳转至首页，若无跳转，请<a href="#"  onclick="window.history.back(-1);" >点击返回首页</a></p>
                </div>
            </div>
        </div>
        
        <!-- Footer -->
        <div id="da-footer">
        	<div class="da-container clearfix">
           	<p> 2013 17sucai . All Rights Reserved. <a href="http://www.mycodes.net/" target="_blank">智能火锅</a></div>
        </div>
    </div>
    
    
    
    
    
  </body>
</html>
