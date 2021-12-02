<%@page language="java" import="java.text.*, java.util.*, java.awt.*, entity.*, dao.*"%>
<%
ArrayList<entity.Laptop>list = (ArrayList)session.getAttribute("list");
if(list==null){
    response.sendRedirect("Home.jsp?ok=3");
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>JSP demo test</TITLE>
<META http-equiv=Content-Type content="text/html; charset=iso-8859-1">
</HEAD>
<BODY leftMargin=0>
    <h1>LIST LAPTOP</h1>
        <%
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);

        for(Laptop i : list){%>
            <label><%out.print(i.getIdLaptop());%></label>&emsp;
            <label><%out.print(i.getProducer());%></label>&emsp;
            <label><%out.print(i.getName());%></label>&emsp;
            <label><%out.print(i.getType());%></label>&emsp;
            <label><%out.print(myFormat.format(i.getPrice())+"VND");%></label>&emsp;
            <label><%out.print(i.getSize()+"''");%></label>&emsp;
            <label><%out.print(i.getCpu());%></label>&emsp;
            <label><%out.print(i.getRam()+"GB");%></label><br>
        <%}%>
</BODY>
</HTML>
