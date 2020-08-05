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

<title>My JSP 'customeroperate.jsp' starting page</title>

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
					<h2>餐桌号码：
									<s:property value="#session.tablesId" />
								</h2>	
	<div id="smalltable" style="border:1px  grey solid;margin-top:1%;height:30%;overflow-y: scroll;">

		<h1 style="display: inline;font-weight: 600">1~2人桌(小桌)</h1>
		<h2 style="display: inline;margin-left: 30px">空桌数：<s:property value="#request.tables1" /></h2>
		
		<div style="width:99%;height:15px;text-align:right;">
			<p style="display: inline;font-size: 13px">
				<a href='<%=basePath%>getTime'>添加</a>
			</p>
		</div>

		<div class="table-responsive">
			<table class="table table-hover">
				
				<thead>
					<tr>
						<th><h2>排号时间</h2></th>
						<th><h2>排号状态</h2></th>
						<th><h2>排号人数</h2></th>
						<th><h2>排号号码</h2></th>
						<th><h2>操作</h2></th>
						
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.queues1" status="queue">
						<tr>
							<td><h2>
									<s:property value="queueTime" />
								</h2></td>
							<td><h2>
									<s:property value="queueState" />
								</h2></td>
							<td><h2>
									<s:property value="queueNum" />
								</h2></td>
							<td><h2>
									<s:property value="queueHao" />
								</h2></td>
								
							<td>
								<button class="btn btn-info"
									onclick="document.location='<%=basePath%>updateStateG?queue.queueId=<s:property value="queueId"/>'">过号</button>
								<br>
								<button class="btn btn-danger"
									onclick="document.location='<%=basePath%>updateStateR?queue.queueId=<s:property value="queueId"/>&queue.queueNum=<s:property value="queueNum"/>'">入座</button>
								<br>
								<button class="btn btn-info"
								    onclick="document.location='<%=basePath%>customerAddQueue?queue.queueHao=<s:property value="queueHao"/>&queue.queueNum=<s:property value="queueNum"/>&queue.queueTime=<s:property value="queueTime"/>'">出票</button>
							</td>

						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>

	</div>
	<div id="middletable" style="border:1px  grey solid;margin-top:1%;height:30%;overflow-y: scroll;">

		<h1 style="display: inline;font-weight: 600">2~4人桌(中桌)</h1>
		<h2 style="display: inline;margin-left: 30px">空桌数：
		<s:property value="#request.tables2" /></h2>
		<div style="width:99%;height:15px;text-align:right;">
			<p style="display: inline;font-size: 13px">
				<a href='<%=basePath%>getTime'>添加</a>
			</p>
		</div>

		<div class="table-responsive">
			<table class="table table-hover">
				
				<thead>
					<tr>
						<th><h2>排号时间</h2></th>
						<th><h2>排号状态</h2></th>
						<th><h2>排号人数</h2></th>
						<th><h2>排号号码</h2></th>
						<th><h2>操作</h2></th>
						
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.queues2" status="queue">
						<tr>
							<td><h2>
									<s:property value="queueTime" />
								</h2></td>
							<td><h2>
									<s:property value="queueState" />
								</h2></td>
							<td><h2>
									<s:property value="queueNum" />
								</h2></td>
							<td><h2>
									<s:property value="queueHao" />
								</h2></td>
								
							<td>
								<button class="btn btn-info"
									onclick="document.location='<%=basePath%>updateStateG?queue.queueId=<s:property value="queueId"/>'">过号</button>
								<br>
								<button class="btn btn-danger"
									onclick="document.location='<%=basePath%>updateStateR?queue.queueId=<s:property value="queueId"/>&queue.queueNum=<s:property value="queueNum"/>'">入座</button>
								<br>
								<button class="btn btn-info"
								    onclick="document.location='<%=basePath%>customerAddQueue?queue.queueHao=<s:property value="queueHao"/>&queue.queueNum=<s:property value="queueNum"/>&queue.queueTime=<s:property value="queueTime"/>'">出票</button>
							</td>
							
							

							
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>





	</div>
	<div id="bigtable" style="border:1px  grey solid;margin-top: 1%;height:30%;overflow-y: scroll;">

		<h1 style="display: inline;font-weight: 600">5~6人桌(大桌)</h1>
		<h2 style="display: inline;margin-left: 30px;">空桌数：
		<s:property value="#request.tables3" /></h2>
		<div style="width:99%;height:15px;text-align:right;">
			<p style="display: inline;font-size: 13px">
				<a href='<%=basePath%>getTime'>添加</a>
			</p>
		</div>

		<div class="table-responsive">
			<table class="table table-hover">
				
				<thead>
					<tr>
						<th><h2>排号时间</h2></th>
						<th><h2>排号状态</h2></th>
						<th><h2>排号人数</h2></th>
						<th><h2>排号号码</h2></th>
						<th><h2>操作</h2></th>
						
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.queues3" status="queue">
						<tr>
							<td><h2>
									<s:property value="queueTime" />
								</h2></td>
							<td><h2>
									<s:property value="queueState" />
								</h2></td>
							<td><h2>
									<s:property value="queueNum" />
								</h2></td>
							<td><h2>
									<s:property value="queueHao" />
								</h2></td>
								
							<td>
								<button class="btn btn-info"
									onclick="document.location='<%=basePath%>updateStateG?queue.queueId=<s:property value="queueId"/>'">过号</button>
								<br>
								<button class="btn btn-danger"
									onclick="document.location='<%=basePath%>updateStateR?queue.queueId=<s:property value="queueId"/>&queue.queueNum=<s:property value="queueNum"/>'">入座</button>
								<br>
								<button class="btn btn-info"
								    onclick="document.location='<%=basePath%>customerAddQueue?queue.queueHao=<s:property value="queueHao"/>&queue.queueNum=<s:property value="queueNum"/>&queue.queueTime=<s:property value="queueTime"/>'">出票</button>
							</td>
							

							
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>


	</div>








</body>
</html>
