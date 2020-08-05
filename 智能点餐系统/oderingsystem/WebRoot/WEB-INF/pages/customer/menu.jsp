<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'menu.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		
		<style>
		body{
		background-image: url("images/snow.jpg");
		}
			* {
    box-sizing: border-box;
}
.row:after {
    content: "";
    clear: both;
    display: block;
}
[class*="col-"] {
    float: left;
    padding: 5px;
}
.col-1 {width: 8.33%;}
.col-2 {width: 16.66%;}
.col-3 {width: 25%;}
.col-4 {width: 33.33%;}
.col-5 {width: 41.66%;}
.col-6 {width: 50%;}
.col-7 {width: 58.33%;}
.col-8 {width: 66.66%;}
.col-9 {width: 75%;}
.col-10 {width: 83.33%;}
.col-11 {width: 91.66%;}
.col-12 {width: 100%;}
html {
    font-family: "Lucida Sans", sans-serif;
}
.header {
    background-color: #FF9966;
    color: #ffffff;
    padding: 15px;
}
.menu ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}
.menu li {
    padding: 8px;
    margin-bottom: 7px;
    background-color :#33b5e5;
    color: #ffffff;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
    text-align: center;
    
   
}
.menu li a{
	font-size: 25px;color: white;font-style: italic;font-weight: bold;
}
.menu li a:hover {
	font-size:30px;
}
.menu li:hover {
	
    background-color: #0099cc;
}

a:link,a:visited,a:active{
	text-decoration:none;
}
img{
			width:300px;
			height:200px;
}

.card{
		height:400px;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);/*0.2 0.19  */
		text-align: center;
		margin: 0px 5px 5px 5px;
		display: inline-table;		 
}
.addcartbutton{
	float:right;
	background-color: #4CAF50; /* Green */
    
    color: white;
    padding: 5px 10px;
    text-align: center;
   	
    /* display: inline-block; */
    font-size: 25px;
    font-weight:600;
    margin: 4px 2px;
    cursor: pointer;

}	
.addcartbutton:hover {
    background-color: #4CAF50;
   	border-color: black;
}

.cartpostbutton{
	background-color:#33b5e5; /* Green */
    
    color: white;
    padding: 5px 10px;
    text-align: center;
   	
    /* display: inline-block; */
    font-size: 18px;
    font-weight:600;
    margin: 4px 2px;
    cursor: pointer;
}
.cartpostbutton:hover {
   
   font-size: 21px; 
}



.foodremark{
	height:95px;
	font-size: 20px;
font-weight: 500;
	
}
.foodprice{
float:left;
font-size: 20px;
font-weight: 700;
}

</style>
	</head>
	<body>

		<div class="header">
			<h1>欢迎来到XXXX火锅城</h1>
			<a href="/oderingsystem/returnindex">返回</a>	
		</div>

		<div class="row">
			<!--菜单-->
			<div class="col-2 menu">
				<ul>
					<li><a href="<%=basePath%>showFoodAction?classify=all">全部</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=taocan">套餐</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=xinpin">新品</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=tesecai">特色菜</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=guodi">锅底</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=roulei">肉类</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=sulei">素菜</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=wanhualei">丸滑类</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=shanzhenjunlei">山珍类</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=zhushi">主食</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=xiaochi">小吃</a></li>
					<li><a href="<%=basePath%>showFoodAction?classify=yinpin">饮品</a></li>
				</ul>
			</div>


			<!--food展示 -->
			<div class="col-8">
				<s:iterator var="food" value="#session.foodList">
					<form action="<%=basePath%>addCartAction" method="post">
						<ul style="list-style-type: none;"><li>
							<div class="col-3 card">
								<img src="<s:property value="#food.foodPicture" />">
								<input type="hidden" name="pkFoodid" value="<s:property value=" #food.pkFood" />"/>
								<h2><s:property value="#food.foodName"/></h2>
								<div class="foodremark"><s:property value="#food.foodRemark" /></div>
								<br>
								<div class="foodprice"><s:property value="#food.foodPrice" />元/份</div>
								<input class="addcartbutton" type="submit" value="+">
							</div>
						</li></ul>
					</form>
				</s:iterator>
			</div>
			
			
			
			
			
			
			
			
			<!--购物车-->
			<div class="col-2">
				<h1>购物车</h1>
				<s:iterator var="cartItem" value="#session.cart.cartItems">
					<form action="<%=basePath%>cutCartAction" method="post">
						<input type="hidden" name="pkFoodid" value="<s:property value=" #cartItem.food.pkFood" />"/>
						<div>
							<h3><s:property value="#cartItem.food.foodName" />
							-<s:property value="#cartItem.food.foodPrice" />元/份</h3>
						</div>
		
						<div style="float:left">
							<input class="cartcutbutton"  style="float:left"type="submit" value="-">
							<s:property value="#cartItem.count" />
						</div>
					</form>
					<form action="<%=basePath%>addCartAction" method="post">
						<input type="hidden" name="pkFoodid" value="<s:property value=" #cartItem.food.pkFood" />"/>
						<input class="cartaddbutton" style="float:left;" type="submit" value="+"><br>
					</form>	
				</s:iterator>
				<h1>总价<s:property value="#session.cart.totalPrice" />元</h1>
				<a style="float:left" class="cartpostbutton" href="/oderingsystem/clearCartAction">清空购物车</a>	
				<a style="float:right" class="cartpostbutton" href="/oderingsystem/postOrderAction">提交</a>
			</div>
	
	
		</div>
		
		



	</body>
</html>
