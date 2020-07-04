<%@ page language="java" contentType="text/html;charset=gbk"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="pages" scope="page" class="cn.edu.usts.cs2018.utils.splitPage"/>
<%!
    //每页显示的记录数
    int pageSize = 20;
    String sqlStr = "";
    //当前页
    int showPage = 1;
    String userName = "root";
    String userPassword="123456";
    //数据库的url
    String url="jdbc:mysql://localhost:3306/treat?useUnicode=true&characterEncoding = gb2312";
    //定义连接对象
    Connection dbcon;
%>
<%
    try{
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库连接对象
        dbcon = DriverManager.getConnection(url,userName,userPassword);
    }
    catch(SQLException ex){

        System.out.println(ex.toString());
    }
    catch(ClassNotFoundException ex){

        System.out.println(ex.toString());
    }
    //给page中参数con赋值
    pages.setCon(dbcon);
    sqlStr = "select * from producer order by id";
    //查询数据表
    String strPage = null;
    //获取目的界面
    strPage = request.getParameter("showPage");
    if(strPage == null){
        showPage = 1;
    }
    else{

        try{
            showPage=Integer.parseInt(strPage);
        }
        catch(NumberFormatException e){

            showPage = 1;
        }
        if(showPage<1){

            showPage=1;
        }
    }
    pages.initialize(sqlStr,pageSize,showPage);
    //获取要显示的命令集
    Vector vData = pages.getPage();

%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=gbk">

    <title>分页显示</title>

</head>

<body>
<h1 align = center>留言本</h1>
<div align = center>
    <table border="1" cellspacing="0" cellpadding="0" width="80%">
        <tr>
            <th width="20%">编号</th>
            <th width="20%">留言标题</th>
            <th width="30%">留言时间</th>
            <th width="30%">留言</th>
        </tr>

        <%
            for(int i = 0;i <vData.size();i++){
                //显示数据
                String[] sData=(String[])vData.get(i);
        %>
        <tr>
            <td><%=sData[0]%></td>
            <td align=left><%=sData[1] %></td>
            <td align=left><%=sData[2]%></td>
            <td align=left><%=sData[3]%></td>
        </tr>
        <%
            } %>
    </table>
    <form action="test.jsp" method="get" target="_self">
        共<font color = red><%=pages.getRowCount()%></font>条&nbsp;
        <%=pageSize%>条/页&nbsp;
        第<font color = red><%=showPage%></font>页/共
        <font color = red><%=pages.getPageCount()%></font>页&nbsp;
        <a href="test.jsp?showPage=1"target="_self">[首页]</a>&nbsp;
        <%
            //判断“上一页”链接是否要显示
            if(showPage>1){

        %>
        <a
                href="test.jsp?showPage
	    				=<%=showPage-1%>"target="_self">[上一页]
        </a>&nbsp;

        <%
        }else{
        %>
        [上一页]

        <%
            }
            //判断下一页链接是否要显示
            if(showPage<pages.getPageCount())
            {
        %>

        <a
                href="test.jsp?showPage=<%=showPage+1 %>"
                target="_self">[下一页]</a>
        &nbsp;

        <%
        }else{
        %>
        [下一页]&nbsp;
        <%
            }
        %>
        <a href="test.jsp?showPage=<%=pages.getPageCount()%>"
           target="_self">[尾页]</a>&nbsp;

        转到
        <select name = "showPage">
            <%
                for(int x = 1;x <= pages.getPageCount();x++){

            %>
            <option value="<%=x %>"<%if(showPage==x)
                out.println("selected");%>>
                <%=x %></option>
            <%
                }
            %>
        </select>
        页&nbsp;
        <input type="submit" name="go" value="提交"/>

    </form>
    <%
        //关闭数据库连接
        dbcon.close();
    %>

</div>
</body>
</html>
