<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/5
  Time: 23:37
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
    <title>Title</title>
    <style>
        table{
            background:lightblue  ;
        }

    </style>

<%--    <script type="text/javascript">
        function gogo(){      //确定按钮
            document.form[0].submit();
        }
        //取消按钮
        function cancel(){
            document.form[0].action="";
        }
    </script>--%>
</head>
<body>
<s:form action="add" method="post" name="login">
    <table>
        <tr>
            <td><s:textfield name="userName" label="姓名"/></td>
        </tr>
        <tr>
            <td><s:password name="password" label="密码"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
            <td>
                <input type="reset" value="清除">
                <a href="./jsp/login/register.jsp"/>注册</a>
            </td>
        </tr>
    </table>

</s:form>
<s:fielderror/>
</body>
</html>
