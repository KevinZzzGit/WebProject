<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'foodadd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
img {
	width: 100px;
	height: 100px;
}
</style>

<body>




	<div class="table-responsive">
		<table class="table table-hover">
			
			<thead>
				<tr>				
					<th><h2>广告id</h2></th>
					<th><h2>广告信息</h2></th>
					<th><h2>广告来源</h2></th>

					<th><h2>操作</h2></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator var="advertisement" value="#session.advertisementList">
					<tr>

						<td><h2><s:property value=" #advertisement.adId" /></h2></td>
						<td><h2><s:property value=" #advertisement.admessage" /></h2></td>
						<td><h2><s:property value=" #advertisement.adSourse" /></h2></td>


						<td>
							<form action="/oderingsystem/findAdvertisementBySourceAction" method="post">
								<input type="hidden" name="adSourse" value="<s:property value="#advertisement.adSourse" />"/>
								
								<button class="btn btn-info" type="submit">设置该来源</button>
							</form>
							

							
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>












</body>
</html>
