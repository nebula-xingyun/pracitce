<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="./css/login.css">
    <script type="text/javascript" src="./js/script.js"></script>
    <script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
</head>
<body>

<div class="head clearfix">
    <div class="headLogo">
        <h2>畅所拼团！</h2>
    </div>
    <ul class="headnav clearfix" id="headnav">
        <li id="menu_0" class="current-menu">
            <a href="#">菜单管理</a>
            <!--</li>-->
            <!--<li id="menu_1" >-->
            <!--<a href="#">模块管理</a>-->
            <!--</li>-->
            <!--<li id="menu_2">-->
            <!--<a href="#">系统设置</a>-->
            <!--</li>-->
            <!--<li id="menu_3">-->
            <!--<a href="#">扩展管理</a>-->
            <!--</li>-->
    </ul>
    <ul id="headnavRight" class="clearfix" >
        <li>
            <a href="#">欢迎您！</a>
        </li>
        <li>
            <a href="#">隐藏菜单</a>
        </li>
        <!--<li>-->
        <!--<a href="#">首页</a>-->
        <!--</li>-->
        <!--<li>-->
        <!--<a href="#">帮助</a>-->
        <!--</li>-->
        <li>
            <a href="#">退出</a>
        </li>
    </ul>
</div>

<div class="leftMenu">
    <div class="leftMenu_1 leftMenu-item" id="leftMenu_1" >
        <dl>
            <dt>会员管理</dt>
            <dd>
                <ul class="clearfix">
                    <li>
                        <a href="#" _link="./admin/login.jsp">会员注册与登录</a>
                    </li>
                    <li>
                        <a href="#" _link="./admin/personalinformation.jsp">个人资料修改</a>
                    </li>
                    <li>
                        <a href="#" _link="./admin/viewUser.jsp">会员资料修改</a>
                    </li>
                </ul>
            </dd>
        </dl>
        <dl>
            <dt>组团活动</dt>
            <dd>
                <ul class="clearfix">
                    <li>
                        <a href="#" _link="./admin/createTuan.jsp">创建团队</a>
                    </li>
                    <li>
                        <a href="#" _link="./admin/joinTuan.jsp">加入团队</a>
                    </li>
                    <li>
                        <a href="#" _link="./admin/viewcost.jsp">查看缴费信息</a>
                    </li>
                    <li>
                        <a href="#" _link="./admin/viewTuan.jsp">查看团队信息</a>
                    </li>
                </ul>
            </dd>
        </dl>
        <!--<dl>-->
        <!--<dt>快捷面板</dt>-->
        <!--<dd>-->
        <!--<ul class="clearfix">-->
        <!--<li><a href="#">广告管理</a></li>-->
        <!--<li><a href="#">公告管理</a></li>-->
        <!--<li><a href="#">友情链接</a></li>-->
        <!--<li><a href="#">留言本管理</a></li>-->
        <!--<li><a href="#">清除系统缓存</a></li>-->
        <!--</ul>-->
        <!--</dd>-->
        <!--</dl>-->
    </div>
    <!--<div class="leftMenu_1 leftMenu-item" id="leftMenu_2" style="display: none">-->
    <!--<dl>-->
    <!--<dt>内置模块</dt>-->
    <!--<dd>-->
    <!--<ul class="clearfix">-->
    <!--<li><a href="#">自由模块管理</a></li>-->
    <!--<li><a href="#">广告管理</a></li>-->
    <!--<li><a href="#">专题管理</a></li>-->
    <!--<li><a href="#">公告管理</a></li>-->
    <!--<li><a href="#">留言版管理</a></li>-->
    <!--<li><a href="#">评论管理</a></li>-->
    <!--</ul>-->
    <!--</dd>-->
    <!--</dl>-->
    <!--<dl>-->
    <!--<dt>其他模块</dt>-->
    <!--</dl>-->
    <!--</div>-->
    <!--<div class="leftMenu_1 leftMenu-item" id="leftMenu_3" style="display: none">-->
    <!--<dl>-->
    <!--<dt>系统设置</dt>-->
    <!--<dd>-->
    <!--<ul class="clearfix">-->
    <!--<li><a href="#" _link="webSet.html">网站设置</a></li>-->
    <!--<li><a href="#">伪静态缓存设置</a></li>-->
    <!--<li><a href="#">在线客服设置</a></li>-->
    <!--<li><a href="#">清除系统缓存</a></li>-->
    <!--<li><a href="#">留言版管理</a></li>-->
    <!--<li><a href="#">评论管理</a></li>-->
    <!--</ul>-->
    <!--</dd>-->
    <!--</dl>-->
    <!--<dl>-->
    <!--<dt>静态缓存</dt>-->
    <!--<dd>-->
    <!--<ul class="clearfix">-->
    <!--<li><a href="#">一键更新全站</a></li>-->
    <!--<li><a href="#">更新首页</a></li>-->
    <!--<li><a href="#">更新栏目</a></li>-->
    <!--<li><a href="#">更新文档</a></li>-->
    <!--<li><a href="#">更新专题</a></li>-->

    <!--</ul>-->
    <!--</dd>-->

    <!--</dl>-->
    <!--</div >-->
    <!--<div class="leftMenu_1 leftMenu-item" id="leftMenu_4" style="display: none">-->
    <!--<dl>-->
    <!--<dt>会员管理</dt>-->
    <!--<dd>-->
    <!--<ul class="clearfix">-->
    <!--<li><a href="#">会员管理</a></li>-->
    <!--<li><a href="#">会员墙管理</a></li>-->

    <!--</ul>-->
    <!--</dd>-->
    <!--</dl>-->
    <!--<dl>-->
    <!--<dt>管理员管理</dt>-->
    <!--<dd>-->
    <!--<ul class="clearfix">-->
    <!--<li><a href="#">系统用户管理</a></li>-->
    <!--<li><a href="#">用户墙设置</a></li>-->
    <!--<li><a href="#">节点列表</a></li>-->
    <!--</ul>-->
    <!--</dd>-->

    <!--</dl>-->
    <!--</div>-->
</div>

<div class="rightMain" >
    <div class="rightContent" style="background-image: url('./img/welcome.jpg');background-repeat: no-repeat ;background-size: cover" >
        <iframe id="main" class="main" frameborder="0" scrolling="auto"  >
        </iframe>
    </div>
</div>


<script type="text/javascript">
    $(document).ready(function () {
        $("#headnav li").click(function () {

            $(this).addClass("current-menu");
            $(this).siblings().removeClass("current-menu");

            //主导航与左侧导航关联
            var _id = $(this).index();
            //alert(_id);
            $(".leftMenu").find(".leftMenu-item").eq(_id).css("display","block").siblings(
                ".leftMenu-item").css("display","none");
        });
        $(".leftMenu_1 dl dt").click(function () {
            $(this).siblings('dd').slideToggle('fast');
        });

        //控制左侧菜单栏的显示与隐藏
        var isFold = false;
        $("#headnavRight li").click(function () {
            if ($(this).index() == 1)
            {
                if (isFold == false)
                {
                    $(".leftMenu").css("display","none");
                    isFold = true;
                    $(this).children("a").text("显示菜单");
                    $("body").addClass("hideLeftMenu").removeClass("showLeftMenu");
                }
                else{
                    $(".leftMenu").css("display","block");
                    $(this).children("a").text("隐藏菜单");
                    $("body").addClass("showLeftMenu").removeClass("hideLeftMenu");
                    isFold = false;
                }
            }
        });


        //左侧导航切换
        $(".leftMenu_1 dl dd ul li a").click(function () {
            var _link = $(this).attr("_link");
            //alert(_link);
            $("iframe").attr("src",_link);
            $(this).addClass("currentLeftMenu");
            $(this).parent().siblings().children().removeClass("currentLeftMenu");
            $(this).parents('dl').siblings().find('a').removeClass("currentLeftMenu");
        });
    });
</script>
</body>
</html>
</body>
</html>