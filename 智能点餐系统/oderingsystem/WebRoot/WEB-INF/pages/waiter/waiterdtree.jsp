<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>

<head>
	<title>Destroydrop &raquo; Javascripts &raquo; Tree</title>
	<link rel="StyleSheet" href="./dtree/dtree.css" type="text/css" />
	<script type="text/javascript" src="./dtree/dtree.js"></script>

</head>

<body>



<div class="dtree">

	<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>

	<script type="text/javascript">
		

		d = new dTree('d');
		//根节点
		d.add(0,-1,' 服务员管理系统');
			//顾客管理
			d.add(01,0,'餐桌管理');
				d.add(010,01,'查看餐桌','<%=basePath%>waiterToTables.action','','mainFrame');
			//服务员管理
			d.add(02,0,'排号管理');	
				d.add(020,02,'查看排号','<%=basePath%>toQueue.action','','mainFrame');							
			//菜品管理
			d.add(03,0,'订单管理');
				d.add(030,03,'查看订单','<%=basePath%>findAllOrderAction.action','','mainFrame');
				
		//页面渲染
		document.write(d);
	
	</script>

</div>



</body>

</html>