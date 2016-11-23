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
    <style type="text/css">
        .hover {
         background: #1269ff;
        }

        #parent{
            width:100%;
            height:50%;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $("tr").hover(
                function (e) {
                    $(this).addClass("hover");
                    var a = $(this).find("input").val();
                    var i = $(this).attr('title');
                    $(this).tipso({
                        speed           : 300,
                        background:"#637DEC",
                        color           : '#ffffff',
                        position        : 'right',
                        width           : 150,
                        height          : 150,
                        delay           : 10,
//                        content         : "<img src='"+i+"'/>",

                    })
                },
                function () {
                    $(this).removeClass("hover");
                }
            );

            $("#pd").tipso({
                useTitle: false,
                background: 'tomato'
            });
            $('#tip4').tipso();
        });



    </script>
</head>
<body>
<div id="parent">
<table style="margin: 5px 20px;">
    <tr>
        <td>name</td>
        <td>pass</td>
        <td>email</td>
        <td>option</td>
    </tr>
    <c:forEach items="${users.datas}" var="u">
        <tr title="${u.email}">
            <td><a href="${u.uid}">${u.username}/${u.pic}</a></td>
            <td>${u.password}</td>
            <td>${u.email}</td>
            <td><a href="${u.uid}/update">修改</a><a href="delete/${u.uid}">删除</a></td>
        </tr>
    </c:forEach>
    <tr align="right">
        <td colspan="5">
            <button onclick="location='add'">add user</button>
        </td>
    </tr>
</table>
<jsp:include page="/static/paging/pager.jsp">
    <jsp:param value="list" name="url"/>
    <jsp:param value="${users.pagerSize}" name="pagerSize"/>
    <jsp:param value="${users.totalRecord}" name="items"/>
</jsp:include>
</div>
</body>
</html>
