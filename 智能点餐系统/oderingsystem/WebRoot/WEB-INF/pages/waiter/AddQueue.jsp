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
    
    <title>My JSP 'AddQueue.jsp' starting page</title>
    
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
			     padding-top: 50px;
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
     <h2>添加排号</h2>
     	<div style="">
      
    	 <form action="/oderingsystem/AddQueue" method="post">
           
         
		 

		  <label>排号时间:</label><input type="text" name="queue.queueTime" value="<s:date name="#session.queueTime" format="yyyy-MM-dd HH:mm:ss"/>" style="font-size:12px;width: 120px;margin-top:10px;"
		     id="txt"/>
		    <br>
		   <label>排号状态:</label><input type="text" name="queue.queueState" value="等待" style="font-size:12px;width: 120px;margin-top:10px;"
		     id="txt"/>
		    <br>
		   <label>排号人数:</label><input type="text" name="queue.queueNum" value="" style="font-size:12px;width: 120px;margin-top:10px;"
		     id="txt"/>
		    <br>
		    <br><br><br>
		    <!--javascript:history.back(-1);  -->
		   <input type="button" value="取消" onclick="document.location='<%=basePath%>toQueue'">&nbsp;&nbsp;&nbsp;
		   <input type="submit" value="提交">
		  
   
    	 </form>
      
     	</div>
     
  	 </div>
   </div>
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  
  
  
  
  

  </body>
</html>
