<%@ page language="java" import="java.util.*,com.zhbit.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	<style>
	
		body{
		background-image: url("images/snow.jpg");
		}
/*轮播图  */	
			.dot {
			  
			  cursor:pointer;
			  height: 13px;
			  width: 13px;
			  margin: 0 2px;
			  background-color: #bbb;
			  border-radius: 50%;
			  display: inline-block;
			  transition: background-color 0.6s ease;
			}
			.toright{
				right:0;
			}
			.toleft, .toright {
			  cursor: pointer;
			  position: absolute;
			  top: 40%; 
			  padding: 5px;
			  color: skyblue;
			  font-weight: bold;
			  font-size: 40px;
			  transition: 0.8s ease;
			  border-radius: 0 5px 5px 0;
			}
			.toleft:hover, .toright:hover {
			  background-color: rgba(0,0,0,0.8);
			  text-decoration: none;
			}
			.mylunbo{
				display:none;
			}
			.lunbo{
				width:65%;
				position: absolute;
				z-index: 0;
			}
			.active, .dot:hover {
			  background-color:  #595959;
			}
			
			
			.fade {
			  animation-name: fade;
			  animation-duration: 3.5s;
			}	
			@keyframes fade {
			  from {opacity: .4} 
			  to {opacity: 1}
			}
			










a:link,a:visited,a:active{
	text-decoration:none;
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
    padding: 15px;
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
    background-color:#FF9966;
    color: #ffffff;
    padding: 15px;
}
.left{
	margin-top:20px;
	border:2px black solid;
	height:1000px;
	
}

.functionbutton{
	margin-left:10%;
	
	
	border-radius:30px;
	border:1px solid black;
	height:80px;
	/* display:inline-block; */
	background-color:#33b5e5;
	cursor: pointer;
	/* border:1px black solid; */
	text-align: center;
	margin-top: 8%
}


.functionbutton:hover {
    background-color: #0099cc;
}

.functionbutton a{	
	
	
	color:white;
	font-weight: 900
}
</style>



</head>
<body onload="autoshowimg()">
  
<%
	String flag=(String)session.getAttribute("flag");
	if(flag==null){
		session.setAttribute("flag","true");
		response.sendRedirect("/oderingsystem/adShowAction");
	}	
%>

  

    
    <div class="header">
		<h1>欢迎来到XXXX火锅城</h1>
	</div>

<div class="row">

	<div class="left col-4">
	<div class="advertisementshowbox" style="text-align: center;padding-top: 10%">
	<img src="images/girl1.jpg" style="height:160px;border-radius:200px">
		
		<h1>顾客会员:<s:property value="#session.Customer.cname"/></h1>
	</div>

	

	
	
	<br><br>
	<div class="functionbutton col-4"><h3><a href="<%=basePath%>/customerlogin/customerlogin.jsp">用户登陆</a></h3></div>
	<div class="functionbutton col-4"><h3><a href="<%=basePath%>index.jsp">返回主页</a></h3></div>
	<br><br>
	<div class="functionbutton col-4"><h3><a href="<%=basePath%>pageShowAction?page=menupage">菜单浏览</a></h3></div>
	<div class="functionbutton col-4"><h3><a href="<%=basePath%>tologin?tologin=pay">我的订单</a></h3></div>
	<br><br>
	<div class="functionbutton col-4"><h3><a href="<%=basePath%>pageShowAction?page=leavemsg">留言反馈</a></h3></div>
	
	
<!-- 	<div class="functionbutton col-4"><h3><a href="/oderingsystem/pageShowAction?page=menupage">智慧商城(暂不开放）</a></h3></div>
	<div class="functionbutton col-4"><h3><a href="/oderingsystem/pageShowAction?page=foodoperatepage">呼叫服务员(暂不开放)</a></h3></div>
	<br>
	<div class="functionbutton col-4"><h3><a href="/oderingsystem/pageShowAction?page=menupage">呼叫服务员(暂不开放)</a></h3></div>
	<div class="functionbutton col-4"><h3><a href="/oderingsystem/pageShowAction?page=foodoperatepage">暂无</a></h3></div> -->
	
	</div>



	<div class="col-8" style="margin-top:7px">
	<script type="text/javascript">
			var mylunboindex = 0; //初始显示第一张
			var mylunbobox = document.getElementsByClassName("mylunbo");
			var dots = document.getElementsByClassName("dot");
			showimg(mylunboindex);

			function dotshow(n) {
				showimg(mylunboindex = n);
			}

			function torightimg() {
				mylunboindex++;
				showimg(mylunboindex);
			}

			function toleftimg() {
				mylunboindex--;
				showimg(mylunboindex);
			}
			//参数不要设为全局变量一样
			function showimg(n) {

				//首先重置所有display
				for (var i = 0; i < mylunbobox.length; i++) {
					mylunbobox[i].style.display = "none";
					dots[i].className = dots[i].className.replace(" active", "");
				}

				//右边越界
				if (n > mylunbobox.length - 1) {
					mylunboindex = 0
				}
				//左边越界
				if (n < 0) {
					mylunboindex = 2
				}
				dots[mylunboindex].className += " active";
				mylunbobox[mylunboindex].style.display = "block";

			}

			function autoshowimg() {
			
				showimg(mylunboindex);
				mylunboindex++;
				setTimeout(autoshowimg, 3000);
			}

		</script>

		<div style="">
			<div class="lunbo">
				<s:iterator var="advertisement" value="#session.nowadvertisementList">
				<div class="mylunbo fade"><img src="<s:property value='#advertisement.adImg'/>" style="height: 700px;width:100%"></div>				
				</s:iterator>
				<a class="toleft" onclick="toleftimg()">❮</a>
				<a class="toright" onclick="torightimg(1)">❯</a>
			</div>
			<div style="position: absolute;text-align:center;z-index: 1;top:800px;left:65%">
				<span class="dot" onclick="dotshow(0)"></span>
				<span class="dot" onclick="dotshow(1)"></span>
				<span class="dot" onclick="dotshow(2)"></span>
			</div>
		</div>

		<div class="guanggaomessage" style="margin-top: 700px;">
		
			<s:iterator var="advertisement" value="#session.nowadvertisementList">
				<div class="col-4" style="display:inline-block;border:1px solid black;height:300px">
					<p style="font-size: 18px;font-weight: 600"><s:property value='#advertisement.admessage'/></p>
					<p>相关信息:<a href="#"><s:property value='#advertisement.adSourse'/></a></p>
				</div>
								
		</s:iterator>
	  	</div>
	  	
	</div>
</div>
    
    
    
  </body>
</html>
