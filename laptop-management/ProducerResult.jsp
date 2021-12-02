<%@page language="java" import="java.text.*, java.util.*, java.awt.*, entity.*, dao.*"%>
<%
ArrayList<entity.Producer>list = (ArrayList)session.getAttribute("list");
if(list==null){
    response.sendRedirect("Home.jsp?ok=3");
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>Laptop management</TITLE>
<META http-equiv=Content-Type content="text/html; charset=iso-8859-1">
</HEAD>
<BODY leftMargin=0>
    <h1>LIST PRODUCER</h1>
        <%
        for(Producer i : list){%>
            <label><%out.print(i.getIdProducer());%></label>&emsp;
            <label><%out.print(i.getName());%></label>&emsp;
            <label><%out.print(i.getRate());%></label><br>
        <%}%>
</BODY>
</HTML>