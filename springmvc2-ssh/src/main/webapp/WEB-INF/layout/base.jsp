<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/22
  Time: 下午8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%
    String cont = request.getContextPath();
%>
<html>
<head>
    <title><decorator:title/></title>
    <style type="text/css">
        .base {
            margin: 0;
        }

        div.baseDiv {
            padding: 1px 30px;
            background: #ec4b4f;
            color: bisque;
            align: center;
        }

        a {
            /*background: #1269ff;*/
            /*border:1px #ff8872 solid;*/
            text-decoration: none;
        }

        input{
            margin: 5px;
        }
    </style>
    <link rel="stylesheet" href="<%=cont%>/static/css/tipso.min.css">
    <script type="text/javascript" src="<%=cont%>/static/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=cont%>/static/js/plugins/tipso.min.js"></script>
    <decorator:head/>
</head>

<body class="base">

<div class="baseDiv"><h3><a href="<%=cont%>/">学生管理系统</a></h3>

    <nav>
        <a href="<%=cont%>/user/add">学生添加</a>
        <a href="<%=cont%>/user/list">学生列表</a>
    </nav>
</div>
<decorator:body/>
<div class="baseDiv"><h5>copyRight@2016-2018</h5></div>
</body>
</html>
