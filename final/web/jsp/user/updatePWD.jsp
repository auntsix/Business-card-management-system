<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/29
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>修改密码</title>
    <script type="text/javascript">
        function allIsNull() {
            var pwd = document.updateForm.password.value;
            var repwd = document.updateForm.repassword.value;
            if(pwd == ""){
                alert("请输入新密码！");
                document.updateForm.password.focus();
                return false;
            }
            if(repwd == ""){
                alert("请输入新密码！");
                document.updateForm.repassword.focus();
                return false;
            }
            if(pwd!=repwd){
                alert("两次密码不一致，请重新输入！")
                document.updateForm.password.value="";
                document.updateForm.repassword.value="";
                document.updateForm.password.focus();
                return false;
            }
            document.updateForm.submit();
            return true;
        }
    </script>
</head>
<body>
<form action="user/updatePwd" method="post" name="updateForm">
    <table>
        <tr>
            <td>姓名：</td>
            <td>
                <s:property value="#session.userName"/>
            </td>
        </tr>
        <tr>
            <td>新密码：</td>
            <td><input class="textSize" type="password" maxlength="20" name="password"></td>
        </tr>
        <tr>
            <td>确认新密码：</td>
            <td><input class="textSize" type="password" maxlength="20" name="repassword"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="button" value="修改密码" onclick="allIsNull()"></td>
        </tr>

    </table>
</form>

</body>
</html>
