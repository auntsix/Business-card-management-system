<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/5
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>error</title>
</head>
<body>
    密码输入错误！
    <a href="./login.jsp">重新登录</a>

</body>
</html>
