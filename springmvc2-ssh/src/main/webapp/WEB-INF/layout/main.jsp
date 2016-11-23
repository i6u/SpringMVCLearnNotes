<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/23
  Time: 上午10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<style type="text/css">
    p {
        padding: 15px 15px;
        margin: 10px 0;
        font-family: sans-serif;

    }

    .p2 {
        font: 22px/36px arial, simsun, sans-serif;
        text-indent: 0em;
    }

    .p2:first-letter {
        font: 60px arial, simsun, sans-serif;
        font-weight: bolder;
        float: left;
    }
    p.p1 {
        background: #1258d2;
        color: #ffffff;
        font-size: 50px;
        border-radius: 15px 15px 0px 0px;
    }


    section {
        background: #1191ff;
        color: #ffffff;
        font-size: 20px;
        border: 2px;
        border-radius: 15px;
    }


</style>
<section>
    <p class="p1"><decorator:title/></p>
    <p class="p2"><decorator:body/></p>
</section>

