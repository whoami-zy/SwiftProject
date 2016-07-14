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
  <link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
 </head>
<body>
	<div class="top"></div>
<div id="header">
	<div class="logo">基于swift的云存储系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！管理员 </li>
			<li><a href="" target="main_view"><%=session.getAttribute("sessionName") %></a></li>
			<li><a href="" target="main_view">修改密码</a></li>
			<li><a href="" target="main_view">设置</a></li>
			<li><a href="user_loginOut" target="">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
				<ul id="nav_dot">
      <li>
          <h4 class="M1"><span></span>容器管理</h4>
          <div class="list-item none">
            <a href='action_getAllContainer' target="main_view">查看所有容器</a>
            <a href="addContainer.jsp" target="main_view">添加容器</a>
          </div>
        </li>
        <li>
          <h4 class="M2"><span></span>对象管理</h4>
          <div class="list-item none">
            <a href='adminJsp/addAdmin.jsp' target="main_view">查看全部文件</a>
            <a href='adminJsp/viewAdminByIdDo.jsp' target="main_view">图片</a>     
            <a href='adminJsp/viewAdminByIdDo.jsp' target="main_view">文档</a>   
            <a href='adminJsp/viewAdminByIdDo.jsp' target="main_view">电影</a>  
           </div>
        </li>
         <li>
          <h4 class="M3"><span></span>Account管理</h4>
          <div class="list-item none">
            <a href='adminJsp/addAdmin.jsp' target="main_view">查看元数据</a>
           </div>
        </li>
  </ul>
		</div>
		<div class="m-right">
			<div class="main">
				    <iframe id="iframe_view" name="main_view" src=""></iframe>
			</div>
			</div>
		</div>
<div class="bottom"></div>
<div id="footer"><p>Copyright©  2015 版权所有b</p></div>
<script>navList(12);</script>
</body>
</html>