<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/19
  Time: 下午8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user list</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css" type="text/css"/>
</head>
<body>
<h1>Hello:${loginUser.username}</h1>
<table>
    <tr>
        <td>name</td>
        <td>pass</td>
        <td>email</td>
        <td>option</td>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td><a href="${u.value.id}">${u.value.username}</a></td>
            <td>${u.value.password}</td>
            <td>${u.value.email}</td>
            <td><a href="${u.value.id}/update">修改</a><a href="delete/${u.value.id}">删除</a></td>
        </tr>
    </c:forEach>
    <tr align="right">
        <td colspan="5">
            <button onclick="location='add'">add user</button>
        </td>
    </tr>
</table>
<a href="/hello/user/list">/hello/user/list</a><br/>
<a href="list">list</a>
</body>
</html>
