<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>标题</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
 </head>
<body>
		<div>
			<div class="container" style="float: left;width: 200px;height:350px;border-right:1px solid black; " >
					<h4>容器详细：</h4>
					<div class="container-meta" style="width: 200px;height:230px ">
					
						<table border="0"  bordercolor="black"  >
							
							<s:iterator value="#request.containerMeta" id="meta">
							<tr >
								<th >name:</th>
								<th ><s:property value="#meta.name" /></th>
							</tr>
							<tr >
								<th >count:</th>
								<th ><s:property value="#meta.count" /></th>
							</tr>
							<tr >
								<th >size:</th>
								<th ><s:property value="#meta.bytse" /> B</th>
							</tr>	
							</s:iterator>
								 <s:iterator value="#request.containerDataMap" id="column">      
							   			<tr >
												<th > <s:property value="key"/></th>
												<th ><s:property value="value"/></th>
										</tr>    
							  </s:iterator>    
						</table>
					</div>
					<hr>
					<div class="container-upload" style="float: left;width: 200px;height:100px;border-right: 1px">
							<s:iterator value="#request.containerMeta" id="meta1">					
								<form action="upload?containerNameObj=<s:property value="#meta1.name" />" method="post" enctype="multipart/form-data">
									<input type="file" name="file">
									<input type="submit" value="上传">
	   							</form>
   							</s:iterator>
					</div>
			</div>
			<div class="object">
			<h4 style="padding-top: 20px">对象列表：</h4>
			<div>
				<table border="0"  bordercolor="black" style="padding-left: 50px"  >
							<s:iterator value="#request.objList" id="obj">
							<tr >
								<th >
									<a href="action_getObjMeta?containerNameObj=<s:property value="#obj.container" />&objName=<s:property value="#obj.name" />" target="data_view"><s:property value="#obj.name" /></a>
								</th>
								<th >
									<a href="action_getObjDownload?downContainerNameObj=<s:property value="#obj.container" />&downObjName=<s:property value="#obj.name" />" style="padding-left: 250px" target="data_view">下载</a>
								</th>
							</tr>
							</s:iterator>
						</table>
						</div>
			</div>
		</div>
</body>
</html>