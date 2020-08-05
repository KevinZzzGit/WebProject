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

<title>My JSP 'pay.jsp' starting page</title>

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
<style>
	body{
		background-color: grey;
	}
</style>
</head>

<body>

	<div class="box" style="margin:0px auto;width:600px;background-color: white;margin-top:10%;padding:25px">
		<div class="table-responsive">
			<table class="table" >
				<caption>我的订单</caption>
				<thead>
					<tr>
						<th><h1>食物名</h1></th>
						<th><h1>单价</h1></th>
						<th><h1>数量</h1></th>
					</tr>
				</thead>
				<tbody>

					<s:iterator var="cartItem" value="#session.oldcart.cartItems">
						<tr>



							<td><s:property value="#cartItem.food.foodName" /></td>

							<td><s:property value="#cartItem.food.foodPrice" />元/份</td>

							<td><s:property value="#cartItem.count"/></td>



						</tr>
					</s:iterator>

				</tbody>
			</table>


		</div>

		<h1 >
			总价
			<s:property value="#session.oldcart.totalPrice" />
			元
		</h1>
		<a href="<%=basePath%>returnindex" style="font-size: 20px">返回</a> 
		<a href="<%=basePath%>payOrderAction.action" style="float:right;font-size: 20px">支付</a>
	</div>







</body>
</html>
