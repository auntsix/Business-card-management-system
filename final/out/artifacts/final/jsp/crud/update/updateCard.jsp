<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/8
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <style>


    </style>
</head>
<body>
    <s:form action="update1" method="POST" enctype="multipart/form-data">
    <table border="1" style="border-collapse: collapse">
        <caption>
            <font size="4">修改名片</font>
        </caption>
        <tr>
            <td><s:textfield name="id" label="ID" value="%{acard.id}"/> </td>
        </tr>
        <tr>
            <td><s:textfield name="name" label="名称" value="%{acard.name}"/> </td>
        </tr>
        <tr>
            <td><s:textfield name="telephone" label="电话" value="%{acard.telephone}"/> </td>
        </tr>
        <tr>
            <td><s:textfield name="email" label="E-Mail" value="%{acard.email}"/> </td>
        </tr>
        <tr>
            <td><s:textfield name="company" label="单位" value="%{acard.company}"/> </td>
        </tr>
            <td><s:file name="logo" label="logo"/>
                <s:if test="acard.logo!=null">
                    <img alt="" width="50" height="50">
                </s:if>
            </td>
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
