<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/6
  Time: 0:01
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
    <title>欢迎进入名片管理系统</title>
    <style>
        #navigator{
            width:1000px;
            height: 300px;
            margin-top: -10px;
            /* background-color: aquamarine; */
        }
        #navigator ul{
            background-color:lightblue;
        }
        li{
            list-style-type: none;
        }
        #navigator ul li ul{
            visibility: hidden;
            position: absolute;
        }
        #navigator ul li:hover ul,
        #navigator ul a:hover ul{
            visibility:visible;
        }
        .liebiao{
            width: 300px;
            list-style-type: none;
            /* display: block; */
            float: left;
            /* padding-top: 20px; */
            /* padding-left: 30px; */
            background-color:lightblue;
        }
        h1{
            margin-left: 300px;
        }
        iframe{
            width:950px;
            height: 400px;
            margin-left: 0px;
            margin-top: -250px;
            margin-left: 25px;
        }
        #footer{
            margin-bottom:0px;
            margin-left: 350px;
        }
    </style>
</head>
<body>
    <div id="header">
        <h1>欢迎<s:property value="#session.userName"/>进入名片管理系统！</h1>
    </div>
    <div id="navigator">
        <ul>
            <li class="liebiao"><a>名片管理</a>
            <ul>
                <li><a href="./jsp/crud/add/addCard.jsp" target="center">添加名片</a></li>
                <li><a href="./deleteCard1.action?pageCur=1" target="center">删除名片</a></li>
                <li><a href="./updateCard1.action?pageCur=1" target="center">修改名片</a></li>
                <li><a href="./queryCard.action?pageCur=1" target="center">查询名片</a></li>
            </ul>
            </li>
            <li class="liebiao"><a>个人中心</a>
            <ul>
                <li><a href="./jsp/user/updatePWD.jsp" target="_top">修改密码</a></li>
                <li><a href="./jsp/user/userInfo.jsp " target="center">基本信息</a></li>
            </ul>
            </li>
            <li class="liebiao"><a href="" target="">安全退出</a> </li>
        </ul>
    </div>

    <div id="content">
        <iframe src="" name="center" frameborder="0"></iframe>
    </div>
    <div id="footer">Copyright XX出版社</div>
</body>
</html>
