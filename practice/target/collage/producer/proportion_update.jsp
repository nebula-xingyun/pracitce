<%--
  Created by IntelliJ IDEA.
  User: cjt
  Date: 2020/6/10
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>物料配比修改界面</title>

    <link href="../css/style.css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" type="text/css" href="../js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../js/easyui/demo/demo.css">
    <script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>

    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/bootstrap-table.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" type="text/css" href="../css/icon.css">
</head>


<body background="../images/login_bgx.gif" style=" background-repeat:no-repeat ;background-size:100% 100%; background-color: 	#F0FFFF;
background-attachment: fixed;">
<div class="modal-dialog" style="margin-top: 10%;width: 400px;">
    <div class="modal-content">
        <div class="modal-header">

            <h2 class="modal-title text-center" id="myModalLabel" style="font-family: 楷体;">物料配比修改</h2>
        </div>
        <form action="${pageContext.request.contextPath}/update_user" method="post" onsubmit="return check()">
            <div style="text-align: center;color: red;" id="showMsg"></div>

            <table align="center"  style="text-align: center;font-family: 楷体;font-size:large;">
                <tr>
                    <td width="40%">
                        <div style="margin-bottom:10px;padding-left:10px;padding-right: 10px;padding-top: 30px;">
                            物料1
                        </div>
                    </td>
                    <td width="60%">
                        <div style="margin-bottom:10px;padding-top: 10px;">
                            <input class="easyui-textbox" type="text" name="userid" id="userid"  placeholder="Id" style="height:30px;padding:12px"
                                   data-options="prompt:'物料1',iconWidth:38" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="40%">
                        <div style="margin-bottom:10px;padding-left:10px;padding-right: 10px;padding-top: 10px;">
                            物料2
                        </div>
                    </td>
                    <td width="60%">
                        <div style="margin-bottom:10px;padding-top: 10px;">
                            <input class="easyui-textbox" type="text" name="userid" id="userid"  placeholder="Id" style="height:30px;padding:12px"
                                   data-options="prompt:'物料1',iconWidth:38" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="40%">
                        <div style="margin-bottom:10px;padding-left:10px;padding-right: 10px;padding-top: 10px;">
                            物料3
                        </div>
                    </td>
                    <td width="60%">
                        <div style="margin-bottom:10px;padding-top: 10px;">
                            <input class="easyui-textbox" type="text" name="userid" id="userid"  placeholder="Id" style="height:30px;padding:12px"
                                   data-options="prompt:'物料1',iconWidth:38" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="40%">
                        <div style="margin-bottom:10px;padding-left:10px;padding-right: 10px;padding-top: 10px;">
                            物料4
                        </div>
                    </td>
                    <td width="60%">
                        <div style="margin-bottom:10px;padding-top: 10px;">
                            <input class="easyui-textbox" type="text" name="userid" id="userid"  placeholder="Id" style="height:30px;padding:12px"
                                   data-options="prompt:'物料1',iconWidth:38" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="40%">
                        <div style="margin-bottom:10px;padding-left:10px;padding-right: 10px;padding-top: 10px;">
                            物料5
                        </div>
                    </td>
                    <td width="60%">
                        <div style="margin-bottom:10px;padding-top: 10px;">
                            <input class="easyui-textbox" type="text" name="userid" id="userid"  placeholder="Id" style="height:30px;padding:12px"
                                   data-options="prompt:'物料1',iconWidth:38" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="40%">
                        <div style="margin-bottom:10px;padding-left:10px;padding-right: 10px;padding-top: 10px;">
                            物料6
                        </div>
                    </td>
                    <td width="60%">
                        <div style="margin-bottom:10px;padding-top: 10px;">
                            <input class="easyui-textbox" type="text" name="userid" id="userid"  placeholder="Id" style="height:30px;padding:12px"
                                   data-options="prompt:'物料1',iconWidth:38" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="40%">
                        <div style="margin-bottom:10px;padding-left:10px;padding-right: 10px;padding-top: 10px;">
                            物料7
                        </div>
                    </td>
                    <td width="60%">
                        <div style="margin-bottom:10px;padding-top: 10px;">
                            <input class="easyui-textbox" type="text" name="userid" id="userid"  placeholder="Id" style="height:30px;padding:12px"
                                   data-options="prompt:'物料1',iconWidth:38" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="40%">
                        <div style="margin-bottom:10px;padding-left:10px;padding-right: 10px;padding-top: 10px;">
                            物料8
                        </div>
                    </td>
                    <td width="60%">
                        <div style="margin-bottom:10px;padding-top: 10px;">
                            <input class="easyui-textbox" type="text" name="userid" id="userid"  placeholder="Id" style="height:30px;padding:12px"
                                   data-options="prompt:'物料1',iconWidth:38" />
                        </div>
                    </td>
                </tr>
            </table>
            <div class="modal-footer">
                <input type="submit" class="btn btn-primary"  name="login" id="login" value="确认修改" style="opacity: 0.7;">
                <input type="button"  onclick="history.back(-1);" class="btn btn-primary"  name="reload" id="reload" value="取消修改" style="opacity: 0.7;">
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    function check() {
        var username = $("#username").val();
        var password = $("#password").val();
        if(username==""||password==""){
            $("#message").text("账号或密码不能为空!");
            return false;
        }
        return true;
    }
    var isCheckCodeSuccess = false;     // 设置验证成功标志
    $(function() {
        $("#logyzm").bind("blur",function(){
            //此处写你需要执行的代码
            isCheckCodeSuccess = false;
            checkCode();
        });

        $("#logyzm").bind("focus",function(){
            //此处写你需要执行的代码
            checkCodeClear();
        });

    });
    function doLogin(){
        if($("input[name='username']").val()=="" || $("input[name='password']").val()==""){
            $("#message").html("用户名或密码为空，请重新输入。");
            $("input[name='username']").focus();
        }
        if(! isCheckCodeSuccess) {
            $("#message").html("验证码错误，请重新输入。");
        }
        else
        {
            $("#login").dialog("close");
            $("#loginForm").get(0).submit();
        }
    }

    function changeCheckCode() {
        var timestamp = new Date().getTime();
        // var path = "./getValidateCode?date=";
        // $("#imgCheckCode").attr("src", path + timestamp);
        var img=document.getElementById("imgCheckCode");
        img.src="./getValidateCode?date="+timestamp;//此处很重要，不加后面的就不会变
    }

    function checkCode() 	 {
        $.ajax({
            url: './checkCode',
            type: "POST",
            data:  {
                logyzm:$("#logyzm").val()
            },  //将表单序列化$("#logyzm").serialize(),
            //contentType: "application/json; charset=utf-8",   // 请求数据格式
            dataType: "json",               //  响应数据格式
            beforeSend: function() {
                isCheckCodeSuccess = false;     // 设置验证成功标志
            },
            success: function (data) {
                //data = jQuery.parseJSON(data);  // 如果dataType注释了，故需要转换为JSON对象
                //data2 = eval('(' + data1 + ')');      //将一个json字符串解析成js对象
                //ajax方式直接将后台的json字符串转换为json对象，即这里的data已经是json对象，不需要转换
                if (data.Success) {
                    isCheckCodeSuccess = true;     // 设置验证成功标志--成功:true.
                }
            },
            error:function(){
                alert('验证码校验请求失败!');
            }
        })
    }

    function checkCodeClear() 	 {
        $("#checkIconOK").attr("src", "");
        //$("#logyzm").textbox("setValue","");
    }


</script>

</body>
</html>