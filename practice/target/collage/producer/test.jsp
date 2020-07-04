<%@ page language="java" contentType="text/html;charset=gbk"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="pages" scope="page" class="cn.edu.usts.cs2018.utils.splitPage"/>
<%!
    //ÿҳ��ʾ�ļ�¼��
    int pageSize = 20;
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
    <meta http-equiv="Content-Type" content="text/html;charset=gbk">

    <title>��ҳ��ʾ</title>

</head>

<body>
<h1 align = center>���Ա�</h1>
<div align = center>
    <table border="1" cellspacing="0" cellpadding="0" width="80%">
        <tr>
            <th width="20%">���</th>
            <th width="20%">���Ա���</th>
            <th width="30%">����ʱ��</th>
            <th width="30%">����</th>
        </tr>

        <%
            for(int i = 0;i <vData.size();i++){
                //��ʾ����
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
        ��<font color = red><%=pages.getRowCount()%></font>��&nbsp;
        <%=pageSize%>��/ҳ&nbsp;
        ��<font color = red><%=showPage%></font>ҳ/��
        <font color = red><%=pages.getPageCount()%></font>ҳ&nbsp;
        <a href="test.jsp?showPage=1"target="_self">[��ҳ]</a>&nbsp;
        <%
            //�жϡ���һҳ�������Ƿ�Ҫ��ʾ
            if(showPage>1){

        %>
        <a
                href="test.jsp?showPage
	    				=<%=showPage-1%>"target="_self">[��һҳ]
        </a>&nbsp;

        <%
        }else{
        %>
        [��һҳ]

        <%
            }
            //�ж���һҳ�����Ƿ�Ҫ��ʾ
            if(showPage<pages.getPageCount())
            {
        %>

        <a
                href="test.jsp?showPage=<%=showPage+1 %>"
                target="_self">[��һҳ]</a>
        &nbsp;

        <%
        }else{
        %>
        [��һҳ]&nbsp;
        <%
            }
        %>
        <a href="test.jsp?showPage=<%=pages.getPageCount()%>"
           target="_self">[βҳ]</a>&nbsp;

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

    </form>
    <%
        //�ر����ݿ�����
        dbcon.close();
    %>

</div>
</body>
</html>
