<%@ page language="java" contentType="text/html;charset=gbk"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="pages" scope="page" class="cn.edu.usts.cs2018.utils.splitPage"/>
<%!
    //ÿҳ��ʾ�ļ�¼��
    int pageSize = 15;
    String sqlStr = "";
    //��ǰҳ
    int showPage = 1;
    String userName = "root";
    String userPassword="123456";
    //���ݿ��url
    String url="jdbc:mysql://localhost:3306/treat?useUnicode=true&characterEncoding = gb2312";
    //�������Ӷ���
    Connection dbcon;
%>
<%
    try{
        //������������
        Class.forName("com.mysql.jdbc.Driver");
        //������ݿ����Ӷ���
        dbcon = DriverManager.getConnection(url,userName,userPassword);
    }
    catch(SQLException ex){

        System.out.println(ex.toString());
    }
    catch(ClassNotFoundException ex){

        System.out.println(ex.toString());
    }
    //��page�в���con��ֵ
    pages.setCon(dbcon);
    sqlStr = "select * from producer order by id";
    //��ѯ���ݱ�
    String strPage = null;
    //��ȡĿ�Ľ���
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
    //��ȡҪ��ʾ�����
    Vector vData = pages.getPage();

%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>�����߹������</title>

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

</head>

<body>
<div style="padding:20px;" align = center>

    <h1 style="text-align: center;font-size: xx-large;font-family: ����;">�����߹���ҳ��</h1>
    <%--<div class="panel panel-default">--%>
        <%--<!-- Default panel contents -->--%>
        <%--<div class="panel-heading">Panel heading</div>--%>

        <div class="btn-group btn-group-justified" role="group" style="font-size:20px;">
        <div style="padding-left:70%;padding-right: 20px;">
            <form action="producer_update.jsp" method="post" >
                <input type="submit" class="btn btn-outline-danger btn-lg"  name="login" id="login" value="����" style="opacity: 0.7;">
            </form>
        </div>
        <div style="padding-left: 10px;width: 5px;">
            <form action="../mainpage.jsp" method="post" >
                <input type="submit" class="btn btn-outline-dark btn-lg"  name="login2" id="login2" value="������ҳ" style="opacity: 0.7;">
            </form>
        </div>
    </div>

    <h1>${xiaoxi}</h1>
    <table class="table table-striped" style="width:50%;">
        <tr  style="text-align: center;font-family: ����;font-size:20px;">
            <th>���</th>
            <th>��������</th>
            <th>�����߱��</th>
            <th>������״̬</th>
        </tr>

        <%
            for(int i = 0;i <vData.size();i++){
                //��ʾ����
                String[] sData=(String[])vData.get(i);
        %>
        <tr>
            <td style="border:0px;background:rgba(0,0,0,0);text-align: center;font-family: ����;"><%=sData[0]%></td>
            <td style="border:0px;background:rgba(0,0,0,0);text-align: center;font-family: ����;"><%=sData[1] %></td>
            <td style="border:0px;background:rgba(0,0,0,0);text-align: center;font-family: ����;"><%=sData[2]%></td>
            <td style="border:0px;background:rgba(0,0,0,0);text-align: center;font-family: ����;"><%=sData[3]%></td>
        </tr>
        <%
            } %>
    </table>

    <form action="show_producer.jsp" method="get" target="_self" style="font-size:medium;font-family: ����;padding-left: 50%;">
        ��<font color = red ><%=pages.getRowCount()%></font>��&nbsp;
        <%=pageSize%>��/ҳ&nbsp;
        ��<font color = red><%=showPage%></font>ҳ/��
        <font color = red><%=pages.getPageCount()%></font>ҳ&nbsp;</br>
        <nav aria-label="Page navigation example">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="show_producer.jsp?showPage=1" target="_self" >��ҳ</a></li>
                    <%
                        //�жϡ���һҳ�������Ƿ�Ҫ��ʾ
                        if(showPage>1){
                    %>
                    <li class="page-item"><a class="page-link"
                            href="show_producer.jsp?showPage
	    				=<%=showPage-1%>"target="_self">��һҳ
                    </a></li>

                    <%
                    }else{
                    %>
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">��һҳ</a>
                    </li>

                    <%
                        }
                        //�ж���һҳ�����Ƿ�Ҫ��ʾ
                        if(showPage<pages.getPageCount())
                        {
                    %>

                    <li class="page-item"><a class="page-link"
                            href="show_producer.jsp?showPage=<%=showPage+1 %>"
                                             target="_self">��һҳ</a></li>
                    <%
                    }else{
                    %>
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">��һҳ</a>
                    </li>
                    <%
                        }
                    %>
                    <li class="page-item"><a class="page-link" href="show_producer.jsp?showPage=<%=pages.getPageCount()%>"
                                             target="_self">βҳ</a></li>&nbsp;&nbsp;


                    ת��
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
                    ҳ&nbsp;
                    <input type="submit" name="go" value="�ύ"/>
            </ul>


        </nav>
        </nav>


    </form>
    <%
        //�ر����ݿ�����
        dbcon.close();
    %>
    <%--</div>--%>
</div>
</body>
</html>