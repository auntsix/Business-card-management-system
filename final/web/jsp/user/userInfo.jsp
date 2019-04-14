<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/299
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
<table>
    <tr>
        <td colspan="2">用户基本信息</td>
    </tr>
    <tr>
        <td>姓名：</td>
        <td><s:property value="#session.userName"/></td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><input type="password" readonly value="<s:property value="#session.password"/>"></td>
    </tr>
</table>
</body>
</html>
