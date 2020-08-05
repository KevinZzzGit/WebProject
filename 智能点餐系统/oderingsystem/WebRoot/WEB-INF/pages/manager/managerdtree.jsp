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
	<link rel="StyleSheet" href="<%=request.getContextPath()%>/dtree/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/dtree/dtree.js"></script>

</head>

<body>



<div class="dtree">

	<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>

	<script type="text/javascript">
		

		d = new dTree('d');
		//根节点
		d.add(0,-1,'管理员管理系统');
			//顾客管理
			d.add(01,0,'顾客管理');
				d.add(010,01,'查看顾客','<%=basePath%>findAllCustomerAction.action','','mainFrame');
			//服务员管理
			d.add(02,0,'服务员管理');	
				d.add(020,02,'服务员添加','<%=basePath%>tologin?tologin=waiteraddmsg','','mainFrame');
				d.add(021,02,'服务员删除','<%=basePath%>searchWaiter.action','','mainFrame');			
			//菜品管理
			d.add(03,0,'菜品管理');
				d.add(030,03,'菜品添加','<%=basePath%>tologin?tologin=foodaddmsg','','mainFrame');
				d.add(031,03,'菜品修改/删除','<%=basePath%>findAllFoodAction.action','','mainFrame');	
			//餐桌管理
			d.add(04,0,'餐桌管理');
				d.add(041,04,'餐桌添加','<%=basePath%>tologin?tologin=AddTables','','mainFrame');
				d.add(042,04,'餐桌修改/删除','<%=basePath%>toTables.action','','mainFrame');
			//留言管理
			d.add(05,0,'留言管理');
				d.add(051,05,'留言浏览','<%=basePath%>findAllMessageAction.action','','mainFrame');	
			//数据统计
			d.add(06,0,'数据统计');
				d.add(061,06,'数据浏览','<%=basePath%>findAllStatisticsAction.action','','mainFrame');	
			//广告设计
			d.add(07,0,'广告管理');
				d.add(071,07,'广告设置','<%=basePath%>findAllAdvertisementAction','','mainFrame');
		//页面渲染
		document.write(d);
	
	</script>

</div>



</body>

</html>