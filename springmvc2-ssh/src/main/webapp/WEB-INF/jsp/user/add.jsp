<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/19
  Time: 下午8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>user add</title>
</head>
<body>
<form:form method="post" modelAttribute="user" enctype="multipart/form-data">
    <fieldset>
        <legend>add user</legend>
    <form:input path="username"/><form:errors path="username"/> <br/>
    <form:password path="password"/><form:errors path="password"/><br/>
    <form:input path="email"/><form:errors path="email"/><br/>
        <input type="file" name="attach"><br/>
    <input type="submit" value="add user" style="width: 100px;margin-top: 15px"/><br/>
</fieldset>
</form:form>
</body>
</html>
