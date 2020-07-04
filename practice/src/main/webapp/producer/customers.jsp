<%@ page import="cn.edu.usts.cs2018.dao.UseJson" %>
<%@ page import="cn.edu.usts.cs2018.dao.MySQLDBHelper" %>
<%@ page import="cn.edu.usts.cs2018.dao.WorkerDAOImpl" %>
<%@ page import="static cn.edu.usts.cs2018.dao.UseJson.formatJson" %><%--
  Created by IntelliJ IDEA.
  User: cjt
  Date: 2020/5/10
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head >
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>生产线管理页面</title>

    <link rel="stylesheet" type="text/css" href="../js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../js/easyui/demo/demo.css">

    <script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>

    <%--<script type="text/javascript" src="../js/easyui/locale/easyui-lang-zh_CN.js"></script>--%>
    <%
        UseJson u = new UseJson();
        u.s();

        MySQLDBHelper BaseDao = new MySQLDBHelper();
        WorkerDAOImpl dao = new WorkerDAOImpl();
        String s = dao.findAllProducer();
        String jsonString = formatJson(s.toString());
    %>
</head>
<body>

<div style="width:800px;height:50%;padding:10px;overflow:hidden; center:'true'">
    <table id="grid"></table>
</div>

<div id="dialog" class="easyui-dialog" data-options="closed:true" title="生产线管理页面"
     style="width:300px;height:320px;text-align:center;align-self: center;" >
    <br>
    <form id="form" method="post">
        <div style="margin-bottom:10px">
            <label>车间</label>
            <input class="easyui-textbox" name="workkshopNo" data-options="required:true" />
        </div>
        <div style="margin-bottom:10px">
            <label>生产线编号</label>
            <input class="easyui-textbox" name="producerNo" data-options="required:true" />
        </div>
        <div style="margin-bottom:10px">
            <label>生产线状态</label>
            <input class="easyui-textbox" name="status" data-options="required:true" />
        </div>

    </form>
</div>

<script type="text/javascript">
    /* jquery入口*/
    $(function() {
        loadgrid(); //加载datagrid
    });

    /* 加载datagrid列表*/
    function loadgrid(){
        $('#grid').datagrid({
            title : '生产线信息一览表',
            url:'test.json',
            method: 'get',
            loadMsg : '正在加载…',  //当从远程站点载入数据时，显示的一条快捷信息。
            rownumbers: true,
            nowrap: false, //设置为true，当数据长度超出列宽时将会自动截取
            fitColumns : true, // 自动适应列宽
            singleSelect : true, // 每次只选中一行
            sortName : 'customerNo', //默认排序字段
            sortOrder : 'asc', // 升序asc/降序desc
            striped : true,  // 隔行变色
            pagination : true,  // 在底部显示分页工具栏
            pageNumber : 1, //初始化页码
            pageSize : 20,  // 指定每页的大小，服务器要加上page属性和total属性
            pageList : [ 20, 30, 50 ], // 可以设置每页记录条数的列表，服务器要加上rows属性
            //rownumbers : true, // 在最前面显示行号
            idField : 'id', // 主键属性
            // 冻结列,当很多咧出现滚动条时该列不会动
            frozenColumns : [ [
                // {title : '选择', width : '20', field : 'ck', checkbox : true},
                {title : '序号', width : '100', field : 'id', sortable : true},
                {title : '车间', width : '100',	field : 'workshopNo',sortable : true},
                {title : '生产线编号', width : '100', field : 'producerNo', sortable : true}

            ] ],
            columns : [ [
                {title : '生产线状态', width : '20', field : 'status', sortable: false }
            ] ],

            // 工具栏按钮
            toolbar: [
                "-", {id: 'add', text: '添加',	iconCls: 'icon-add', handler: function () { add()} },
                "-", {id: 'edit', text: '修改',	iconCls: 'icon-edit',	 handler: function () { edit()} },
                "-", {id: 'remove', text: '删除',iconCls: 'icon-remove', handler: function () {remove()} },
                "-", {id: 'remove',  text: '刷新',iconCls: 'icon-reload', handler: function () {reload()} }
            ]
        });
    }

    /* 显示Dialog*/
    function openDialog(title){
        $("#dialog").dialog({
            resizable: false,
            modal: true,
            buttons: [{ //设置下方按钮数组
                text: '保存',
                iconCls: 'icon-save',
                handler: function () {
                    save();
                }
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    closeDialog();
                }
            }]
        });
        $("#dialog").dialog('setTitle', title);
        $("#dialog").dialog('open');
    }

    /* 关闭Dialog*/
    function closeDialog() {
        $("#form").form('clear'); // 清空form的数据
        $("#dialog").dialog('close');// 关闭dialog
    }

    /* 添加数据*/
    function add() {
        openDialog('添加客户'); // 显示添加数据dialog窗口
        $("#form").form('clear'); // 清空form的数据
        url = 'customer!add.action'; //后台添加数据action
    }

    /* 修改数据*/
    function edit() {
        var row = $('#grid').datagrid('getSelected'); //// 得到选中的一行数据
        //如果没有选中记录
        if(row == null){
            $.messager.alert("提示", "请选择一条记录",'info');
            return;
        }
        openDialog('修改客户信息'); // 显示更新数据dialog窗口
        $("#form").form('load', row); // 加载选择行数据
        url = 'customer!edit.action?id='+row.id; //后台更新数据action
    }

    /* 保存数据*/
    function save(){
        $('#form').form('submit',{
            url: url,						//提交地址
            onSubmit: function(){
                return $(this).form('validate'); //前台字段格式校验
            },
            success: function(result){
                var result = eval('('+result+')');
                if (result.success){
                    closeDialog();		// 调用closeDialog;
                    reload();			// 重新加载
                    $.messager.show({    //显示正确信息
                        title: '提示',
                        msg: result.msg
                    });
                } else {
                    $.messager.show({	//显示错误信息
                        title: '错误',
                        msg: result.msg
                    });
                }
            }
        });
    }

    /* 删除数据*/
    function remove(){
        var row = $('#grid').datagrid('getSelected');
        //如果没有选中记录
        if(row == null){
            $.messager.alert("提示", "请选择一条记录",'info');
            return;
        }
        $.messager.confirm('确认', '确定要删除吗？', function (r) {
            if (r) {
                //提交到后台的action
                $.post('customer!remove.action', { id: row.id }, function (result) {
                    if (result.success) {
                        reload();
                        $.messager.show({	//显示正确信息
                            title: '提示',
                            msg: result.msg
                        });
                    } else {
                        $.messager.show({	//显示错误信息
                            title: '错误',
                            msg: result.msg
                        });
                    }
                }, 'json');
            }
        });

    }

    /* 刷新grid*/
    function reload(){
        $('#grid').datagrid('reload');
    }

    /*提交数据*/
    $('#ff').form('submit', {
        success: function(data){
            var data = eval('(' + data + ')'); // change the JSON string to javascript object
            if (data.success){
                alert(data.message)
            }
        }
    });


</script>
</body>
</html>

