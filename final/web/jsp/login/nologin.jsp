<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/5
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
    您若没有登录成功。请<a href="crud/login/login.jsp" target="_top">登录</a>
</body>
</html>
