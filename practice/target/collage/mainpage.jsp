<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/9
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>拼团项目</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="assets/bootstrap-table.css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
	<h1>拼团旅游</h1>
	<p>
		Group tourism
	</p>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="#">拼团系统</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="#">主页</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="demo.jsp">登录</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="./common/register.jsp">注册</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="admin/savepage.jsp">会员管理</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">所有活动</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="addActivity.jsp">创建活动</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="Activity_append.jsp">加入活动</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="activity/savepage.jsp">活动支出管理</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="bill/search_bill.jsp">费用结算</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">退出登录</a>
			</li>
		</ul>
	</div>
</nav>
<div id="demo" class="carousel slide" data-ride="carousel">

	<!-- 指示符 -->
	<ul class="carousel-indicators">
		<li data-target="#demo" data-slide-to="0" class="active"></li>
		<li data-target="#demo" data-slide-to="1"></li>
		<li data-target="#demo" data-slide-to="2"></li>
	</ul>

	<!-- 轮播图片 -->
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="https://static.runoob.com/images/mix/img_fjords_wide.jpg" width="1550px" height="400px">
			<div class="carousel-caption">
			</div>
		</div>
		<div class="carousel-item">
			<img src="https://static.runoob.com/images/mix/img_nature_wide.jpg" width="1550px" height="400px">
			<div class="carousel-caption">
			</div>
		</div>
		<div class="carousel-item">
			<img src="https://static.runoob.com/images/mix/img_mountains_wide.jpg" width="1550px" height="400px">
			<div class="carousel-caption">
			</div>
		</div>
	</div>
	<!-- 左右切换按钮 -->
	<a class="carousel-control-prev" href="#demo" data-slide="prev">
		<span class="carousel-control-prev-icon"></span>
	</a>
	<a class="carousel-control-next" href="#demo" data-slide="next">
		<span class="carousel-control-next-icon"></span>
	</a>

</div>
<div class="col-sm-12" style="height:70px;background-color:rgb(201, 201, 201);text-align: center">
	<p>CS2018, USTS. 版权所有.</p>
	<p>Copyright &copy; 2010-2020 YSL.All Rights Reserved.</p>
</div>
</body>
</html>

