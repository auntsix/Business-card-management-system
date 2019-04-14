<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/8
  Time: 19:02
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
        .textSize{
            width:100px;
            height: 15px;
        }
    </style>

    <script type="text/javascript">
        function nameIsNull() {
            var name = document.registForm.userName.value;
            if(name==""){
                alert("请输入姓名！");
                document.registForm.userName.focus();
                return false;
            }
            document.registForm.flag.value="0";
            document.registForm.submit();
            return true;
        }
        function allIsNull() {
            var name = document.registForm.userName.value;
            var pwd = document.registForm.password.value;
            var repwd = document.registForm.repassword.value;
            if(name==""){
                alert("请输入姓名！");
                document.registForm.userName.focus();
                return false;
            }
            if(pwd == ""){
                alert("请输入密码！");
                document.registForm.password.focus();
                return false;
            }
            if(repwd == ""){
                alert("输入确认密码！");
                document.registForm.repassword.focus();
                return false;
            }
            if(pwd!=repwd){
                alert("两次密码不一致，请重新输入！")
                document.registForm.password.value="";
                document.registForm.repassword.value="";
                document.registForm.password.focus();
                return false;
            }
            document.registForm.flag.value="1";
            document.registForm.submit();
            return true;
        }
    </script>
</head>
<body>
    <form action="isRegist.action" method="post" name="registForm">
        <input type="hidden" name="flag">
        <table border="1" align="center">
            <tr>
                <td>姓名：</td>
                <td>
                    <input class="textSize" type="text" name="userName" value="${requestScope.userName}" onblur="nameIsNull()"/>
                    <s:if test="#request.isExit=='false'">
                        <font color="red" size="5">×</font>
                    </s:if>
                    <s:if test="#request.isExit=='true'">
                        <font color="green" size="5">√</font>
                    </s:if>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input class="textSize" type="password" name="password" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td>
                    <input class="textSize" type="password" name="repassword" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="注册" onclick="allIsNull()"/>
                </td>
            </tr>


        </table>
    </form>
</body>
</html>
