<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/3/8
  Time: 14:57
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
    <script type="text/javascript">
        function changeColor(obj) {
            obj.className="bgcolor";
        }
        function changeColor1(obj) {
            obj.className="";
        }
    </script>
</head>
<body>

<table border="1">
    <tr>
        <th width="200px">名片ID</th>
        <th width="200px">名称</th>
        <th width="250px">单位</th>
        <th width="200px">详情</th>
    </tr>

    <s:iterator value="#request.cards" id="ca">
        <tr>

            <td><s:property value="#ca.id"/></td>
            <td><s:property value="#ca.name"/></td>
            <td><s:property value="#ca.company"/></td>
            <td><a href="./updateAll.action?id=<s:property value="id"/>" target="_blank">修改</a> </td>
        </tr>
    </s:iterator>
    <tr>
        <td colspan="4" align="right">
            &nbsp; &nbsp; &nbsp;
            &nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;
            第${pageCur}页&nbsp;&nbsp;
            <s:url id="url_pre" value="updateCard1.action">
                <s:param name="pageCur" value="pageCur-1"></s:param>
            </s:url>
            <s:url id="url_next" value="updateCard1.action">
                <s:param name="pageCur" value="pageCur+1"></s:param>
            </s:url>
            <s:a href="%{url_pre}">上一页</s:a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <s:a href="%{url_next}">下一页</s:a>
        </td>
    </tr>

</table>

</body>
</html>
