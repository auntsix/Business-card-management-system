<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/5
  Time: 23:21
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
    <title>$Title$</title>
  <style>
    .login{
      /*margin-top: 80px;*/
    }
    .login,.register{
      text-align: center;
      height: 40px;
      width: 200px;
      margin-left: 200px;
      padding-top:10px;
      margin-bottom:10px;
      background-color: lightblue;
    }

    a{
      padding-top: 30px;
    }
  </style>
  </head>
  <body>
      <%--<form action="" method="post">--%>
        <%--<input type="hidden" name="flag">--%>
       <%--   <table border="1" bgcolor="#add8e6" align="center">
            <tr>
              <td>姓名：</td>
              <td>
                <input class="textSize" type="text" name="uname" value="${requestScope.uname} onblur="nameIsNull"/>
              </td>
            </tr>


          </table>
       --%> <div class="login">
          <a href="./jsp/login/login.jsp">登录</a><br>
        </div>
        <div class="register">
          <a href="./jsp/login/register.jsp">注册</a>
        </div>
      <%--</form>--%>
  </body>
</html>
