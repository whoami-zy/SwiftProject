<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>Insert title here</title>
</head>
<body>
<div>
<div><h2>容器列表：</h2></div>
	<div class="left" style="float:left; width: 50px;">
		<table border="0"  bordercolor="black"  >

			<s:iterator value="#request.AllContainer" id="person">

				<tr >
					<th ><a href="action_getContainerMeta?containerName=<s:property value="#person.name" />" target="data_view"><s:property value="#person.name" /></a></th>
				</tr>

			</s:iterator>

		</table>
	</div>
	<div class="right" style="margin-left:150px;">
			<div class="main" style="height:360px;width:840px">
				    <iframe  style="height:360px;width:840px" id="iframe_view" name="data_view" src="containerMeta.jsp"></iframe>
			</div>
	</div>
</div>
</body>
</html>