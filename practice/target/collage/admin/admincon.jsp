<%--
  Created by IntelliJ IDEA.
  User: cjt
  Date: 2020/5/9
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../js/easyui/demo/demo.css">
    <script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>

    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/bootstrap-table.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="../css/icon.css">

    <base href="<%=basePath%>">
    <title>员工管理页面</title>
</head>
<body>

<div style="padding:20px;">
    <h1 style="text-align: center;font-size: xx-large;font-family: 楷体;">员工管理页面</h1>
    <div class="btn-group btn-group-justified" role="group" style="font-size: large;padding-bottom: 10px;">
        <div style="padding-right: 20px;">
            <form action="admin/update_user.jsp" method="post" >
                <input type="submit" class="btn btn-outline-danger"  name="login" id="login" value="更新" style="opacity: 0.7;">
            </form>
        </div>
        <div style="padding-left: 10px;width: 5px;">
            <form action="../mainpage.jsp" method="post" >
                <input type="submit" class="btn btn-outline-dark"  name="login2" id="login2" value="返回主页" style="opacity: 0.7;">
            </form>
        </div>
    </div>

    <h1>${xiaoxi}</h1>
    <table class="table table-striped" >
        <tr  style="text-align: center;font-family: 楷体;font-size: large;">
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>密码</th>
            <th>联系方式</th>
            <th>完成单数</th>
        </tr>

        <c:forEach var="U" items="${userAll}" >
            <form action="UpdateServlet" method="post">
                <tr  style="text-align: center;font-family: 楷体;font-size: medium;">
                    <td><input type="text" style="border:0px;background:rgba(0,0,0,0);text-align: center;" value="${U.number}" name="userid"></td>
                    <td><input type="text" style="border:0px;background:rgba(0,0,0,0);text-align: center;" value="${U.name}" name="username"></td>
                    <td><input type="text" style="border:0px;background:rgba(0,0,0,0);text-align: center;" value="${U.password}" name="password"></td>
                    <td><input type="text" style="border:0px;background:rgba(0,0,0,0);text-align: center;" value="${U.telephone}" name="telephone"></td>
                    <td><input type="text" style="border:0px;background:rgba(0,0,0,0);text-align: center;" value="${U.work_count}" name="address"></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</div>
</body>
</html>
