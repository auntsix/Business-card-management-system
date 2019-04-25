<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/6
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <style>
        table{
            width: 400px;
            height:300px;
        }
    </style>
</head>
<body>
    <s:form action="addCard" method="POST" enctype="multipart/form-data">
        <table border=1 style="border-collapse: collapse">
            <caption>
                <font size="4">添加名片</font>
            </caption>
            <tr>
                <td><s:textfield name="name" label="姓名"/> </td>
            </tr>
            <tr>
                <td><s:textfield name="telephone" label="电话"/> </td>
            </tr>
            <tr>
                <td><s:textfield name="email" label="E-Mail"/> </td>
            </tr>
            <tr>
                <td><s:textfield name="company" label="单位"/> </td>
            </tr>
            <tr>
                <td><s:textfield name="post" label="职务"/> </td>
            </tr>
            <tr>
                <td><s:textfield name="address" label="地址"/> </td>
            </tr>
            <tr>
                <td><s:file name="headImage" label="logo"/> </td>
            </tr>
            <tr>
                <td align="center"><s:submit value="提交"/> </td>
                <td align="left"><s:reset value="重置"/> </td>
            </tr>

        </table>

    </s:form>
    <s:fielderror/>
</body>
</html>
