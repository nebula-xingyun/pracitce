<%--
  Created by IntelliJ IDEA.
  User: cjt
  Date: 2020/5/9
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 使用BootStrap,上述3个meta标签必须放在最前面，任何其他内容都必须跟随其后！ -->
    <title>展示会员表</title>

    <!-- 新 Bootstrap 的核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/bootstrap-table.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body background="../images/image2.jpg"
      style=" background-repeat:no-repeat ;background-size:100% 100%; background-color: #F0FFFF;
background-attachment: fixed;">
<div class="jumbotron" style="background-color: rgba(0,0,0,0);">
    <div class="container">
        <h1>点击展示会员信息</h1>
        <form action="../servlet/UserbeanServlet" method="get">
            <input class="btn btn-primary btn-lg" type="submit" value="确定">
        </form>
    </br>
    </br>
        <form action="../mainpage.jsp" method="post" >
            <input type="submit" class="btn btn-primary"  name="login2" id="login2" value="返回主页" style="opacity: 0.7;padding-top: 10px;padding-bottom: 10px;">
        </form>
    </div>
</div>
</body>
</html>
