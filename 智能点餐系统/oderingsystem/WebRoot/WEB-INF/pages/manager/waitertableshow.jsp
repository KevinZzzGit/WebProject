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
    			          <th><h2>餐桌ID</h2></th>
    			          <th><h2>餐桌座位数</h2></th>
    			          <th><h2>餐桌状态</h2></th>
    			          <th><h2>订单状态</h2></th>
    			          
				</tr>
			</thead>
			<tbody>

			
				<s:iterator value="#request.tables" status="tables">
				
					<tr>
						
						<td><h2><s:property value="tablesId" /></h2></td>
						<td><h2><s:property value="seatNumber" /></h2></td>
						<td><h2><s:property value="tableState"/></h2></td>
						<td><h2><s:property value="orderState"/></h2></td>
						
						<td>
							<form action="/oderingsystem/setTablesAction.action" method="post">
							<input type="hidden" name="pkTables" value="<s:property value='pkTables'/>">
							<input type="hidden" name="tablesId" value="<s:property value='tablesId' />">
							<input type="hidden" name="seatNumber" value="<s:property value='seatNumber'/>">
							<input type="hidden" name="tableState" value="<s:property value='tableState'/>">
							<input type="hidden" name="orderState" value="<s:property value='orderState'/>">
							<br>
							<button type="submit" class="btn btn-info" >设置当前id</button>
							</form>
						</td>
						
					</tr>
				</s:iterator>
				
			</tbody>
		</table>
	</div>













	<!-- 		
		<s:iterator var="food" value="#session.showFoodList">
		<tr>
		        <th><s:property value=" #food.pkFood" /></th>
				<th><s:property value="#food.foodName"/></th>
				<th><s:property value="#food.foodPicture" /></th>
				<th><s:property value="#food.foodPrice" />元</th>
				<th><s:property value="#food.foodRemark" /></th>
				<th><s:property value="#food.classify" /></th>
				<th></th>
		</tr>
		</s:iterator>   -->










	<!--     <form action="/oderingsystem/addFoodAction" method="post">
    	<input name="foodId" type="text"/><br>
    	<input name="foodName" type="text"/><br>
    	<input name="foodPicture" type="text"/><br>
    	<input name="foodPrice" type="text"/><br>
    	<input name="foodRemark" type="text"/><br>
    	<input name="classify" type="text"/><br>
    	<input type="submit" value="submit"/>
    </form> -->




</body>
</html>
