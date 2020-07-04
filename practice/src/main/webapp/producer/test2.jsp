<%--
  Created by IntelliJ IDEA.
  User: cjt
  Date: 2020/7/3
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <title>弹出层</title>
    <style>
        .white_content {
            display: none;
            position: absolute;
            left: 25%;
            width: 50%;
            padding: 6px 16px;
            border-top: 30px solid #6cabc5;
            background-color: white;
            z-index:1002;
            overflow: auto;
            border-radius: 10px;
        }
        .black_overlay {
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color:#f5f5f5;
            z-index:1001;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=80);
        }
        .close {
            margin-top: -28px;
            margin-right: 20px;
        }
        .close a {
            color:#fff;
            text-decoration:none;
            font-size:14px;
            position: fixed;
        }


    </style>
    <script>

        function show(tag){
            var light=document.getElementById(tag);
            light.style.display='block';
            $("#fade").css('display','block');
        }
        function hide(tag){
            var light=document.getElementById(tag);
            light.style.display='none';
            $("#fade").css('display','none');
        }

    </script>
</head>
<body>
<a href="javascript:void(0)" οnclick="show('light')">点击</a>

<div id="light" class="white_content">
    <div class="close"><a href="javascript:void(0)" οnclick="hide('light')"> 关闭</a></div>

    <div style="overflow:scroll;height:450px;" >            <!-- 滚动条框 -->
        <table class="table table-responsive-sm table-bordered table-striped" >
            <thead>
            <tr>
                <th>#</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Age</th>
                <th>City</th>
                <th>Country</th>
                <th>Sex</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
                <th>Example</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            <tr>
                <td>1</td>
                <td>Anna</td>
                <td>Pitt</td>
                <td>35</td>
                <td>New York</td>
                <td>USA</td>
                <td>Female</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
                <td>Yes</td>
            </tr>
            </tbody>
        </table>
    </div>                        <!-- 滚动条结束 -->

</div>


<div id="fade" class="black_overlay"></div>
</body>
</html>