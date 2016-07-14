<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>成功</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <link href='images/top2.jpg' rel='icon' type='image/x-icon' />
  <meta http-equiv="description" content="This is my page">
 </head>
 <body>
			<script type="text/javascript">
 		alert('创建成功,点击返回主页');
 		window.location.href='action_getAllContainer';
 	</script>
 </body>
</html>