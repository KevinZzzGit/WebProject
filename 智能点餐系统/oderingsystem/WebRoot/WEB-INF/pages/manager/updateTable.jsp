<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateTable.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="css/index.css">
    -->
	<style type="text/css">

	        #txt{
				  padding: 6px;
				  font-size:15px;
				  border-radius:4px;
				  border: 1px solid #ccc;
			}
			#txt:focus {
			     border: 1px solid #fafafa;
			    -webkit-box-shadow: 0px 0px 6px #007eff;
			     -moz-box-shadow: 0px 0px 5px #007eff;
			     box-shadow: 0px 0px 5px #007eff;
			     }
			#div0{
			     width: 350px;
			     height: 400px;
			     border: 1px solid black;
			     margin: 0 auto;
			     text-align: center;
			     padding-top:80px;
			     padding-bottom:80px; /* 50px; */
			     border-radius: 10px;
			     background-image: url("images/divv.jfif");
			     margin-top: 60px;
			}
			#div1{
			width: 100%;
			height: 100%;
			border: 1px solid black;
			margin: 0 auto;
			background-image: url("images/div11.jpg");
			background-repeat: no-repeat;
			background-size: 100% 100%;
			
	</style>

  </head>
  
  <body>

		
		<div id="div1">
   <div id="div0">
     <h2>修改餐桌信息</h2>
     	<div style="">
      
    	 <form action="/oderingsystem/updateTable" method="post">
           
           <s:iterator value="#request.tablesId" status="tables">
		  <label>餐 桌 P K:</label><input type="text" name="tables.pkTables" readonly="readonly" style="font-size:12px;width: 120px;"
		    id="txt" value="<s:property value="pkTables"/>"/>
		   <br>
		   <label>餐 桌 I D:</label><input type="text" name="tables.tablesId" style="font-size:12px;width: 120px;margin-top:10px;"
		    value="<s:property value="tablesId" />" id="txt"/>
		   <br>
		  <label>座   位  数 :</label><input type="text" name="tables.seatNumber" style="font-size:12px;width: 120px;margin-top:10px;"
		    value="<s:property value="seatNumber" />" id="txt"/>
		    <br>
		   <label>餐桌状态:</label><input type="text" name="tables.tableState" style="font-size:12px;width: 120px;margin-top:10px;"
		    value="<s:property value="tableState" />" id="txt"/>
		    <br>
		   <label>订单状态:</label><input type="text" name="tables.orderState" style="font-size:12px;width: 120px;margin-top:10px;"
		    value="<s:property value="orderState" />" id="txt"/>
		    <br>
		    <br><br><br>
		   <input type="button" value="取消" onclick="document.location='<%=basePath%>toTables'">&nbsp;&nbsp;&nbsp;
		   <input type="submit" value="提交">
		  
    		</s:iterator>
    	 </form>
      
     	</div>
     
  	 </div>
   </div>
		
		
		
		
		
		
		
		


  </body>
</html>
