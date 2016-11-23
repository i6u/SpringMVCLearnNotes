<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/20
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="user/login" method="post">
   <fieldset>
       <legend>user login</legend>
       <input type="text" name="username">
       <input type="password" name="password">
       <input type="submit" value="login">
   </fieldset>
</form>
</body>
</html>
