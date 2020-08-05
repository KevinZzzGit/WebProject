<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CustomerQueueSucc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="height:200px; width: 300px;text-align:center;margin: 0 auto;border: 1px solid black">
    <h3>排号成功，您的信息如下：</h3>
    <p style="display: inline;font-size: 20px">您的号码：</p><p style="display: inline;font-size: 20px"><s:property value="#session.queueHM"/></p><p style="display: inline;font-size: 20px">号</p><br>
    <br><p style="display: inline">人数：</p><p style="display: inline;font-size: 18px"><s:property value="queue.queueNum"/> </p>&nbsp;
    <p style="display: inline">您前面还有</p>&nbsp;
    <p style="display: inline;font-size: 18px"><s:property value="#session.queues"/></p>&nbsp;
    <p style="display: inline">桌在等候<br>
    <s:property value="queue.queueTime"/>
    <p>听到叫号请到迎宾台，过号请重新取号</p>
    
    
    </div>
  </body>
</html>
