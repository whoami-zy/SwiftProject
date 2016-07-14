<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<div class="object">

			<h4 style="padding-top: 20px">对象元数据：</h4>
			<div>
				<table border="0"  bordercolor="black" style="padding-left: 50px"  >
							<s:iterator value="#request.objMeta" id="obj">
							<tr >
								<th >name:</th>
								<th ><s:property value="#obj.name" /></th>
							</tr>
							<tr >
								<th >所在容器:</th>
								<th ><s:property value="#obj.container" /></th>
							</tr>
							<tr >
								<th >大小:</th>
								<th ><s:property value="#obj.bytes" /></th>
							</tr>
							<tr >
								<th >文件类型:</th>
								<th ><s:property value="#obj.contentType" /></th>
							</tr>
							<tr >
								<th >最后修改时间:</th>
								<th ><s:property value="#obj.lastModified" /></th>
							</tr>
							<tr >
								<th >地址:</th>
								<th ><s:property value="#obj.uri" /></th>
							</tr>
							</s:iterator>
						</table>
						</div>
			</div>
		</center>
</body>
</html>