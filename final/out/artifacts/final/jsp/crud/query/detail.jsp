<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/8
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>

<%--<!DOCTYPE html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>名片详细信息</title>
</head>
<body>
    <center>
        <table border="1" style="border-collapse: collapse">
            <caption>
                <font size="4">名片详细信息</font>
            </caption>
            <tr>
                <td>ID</td>
                <td><s:property value="acard.id"/> </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><s:property value="acard.name"/> </td>
            </tr>
            <tr>
                <td>电话</td>
                <td><s:property value="acard.telephone"/> </td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td><s:property value="acard.email"/> </td>
            </tr>
            <tr>
                <td>单位</td>
                <td><s:property value="acard.company"/> </td>
            </tr>
            <tr>
                <td>地址</td>
                <td><s:property value="acard.address"/> </td>
            </tr>
            <tr>
                <td>logo</td>
                <td>
                    <s:if test="acard.logo!=null">
                        <img alt="" width="250" height="250"
                             src="<%=basePath%>image/<s:property value='acard.userName'/>/<s:property value='acard.logo'/>"/>
                    </s:if>
                    <s:else>
                        没有图片
                    </s:else>
                </td>
            </tr>
        </table>
    </center>

</body>
</html>
