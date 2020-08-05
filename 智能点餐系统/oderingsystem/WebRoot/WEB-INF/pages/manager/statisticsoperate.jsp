<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'statisticsoperate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   
   
   
   
   
   
   
   
   
   	<div class="table-responsive">
		<table class="table table-hover">
			
			<thead>
				<tr>
				
					
					<th><h2>数据PK</h2></th>
					<th><h2>数据id</h2></th>
					<th><h2>数据统计对象</h2></th>
					<th><h2>统计数目</h2></th>
					<th><h2>统计时间</h2></th>

				</tr>
			</thead>
			<tbody>
				<s:iterator var="statistics" value="#session.statisticsList">
					<tr>
						<td><h2><s:property value="#statistics.pkStatistics" /></h2></td>
						<td><h2><s:property value="#statistics.statisticsId" /></h2></td>
						<td><h2><s:property value="#statistics.statisticalObjects" /></h2></td>
						<td><h2><s:property value="#statistics.statisticalNumber" /></h2></td>						
						<td><h2><s:property value="#statistics.statisticalTime" /></h2></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
   
   
   
   
   
   
   
   
  </body>
</html>
