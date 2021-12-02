<%@page language="java" import="java.util.*, java.awt.*, entity.*, dao.*" %>
<% String msg = request.getParameter("ok"); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>Laptop management</TITLE>
<META http-equiv = Content-Type content = "text/html; character=iso-8859-1">
</HEAD>
<BODY leftMargin=0 topMargrin=0>
    <h1>LAPTOP MANAGEMENT</h1>

    <form method="POST" name="SendRequest" action="doRequest.jsp">
        <label>Laptop ID: </label><br>
        <input type="text" name="idLaptop" size="5"><br>
        <label>Producer ID: </label><br>
        <input type="text" name="idProducer" size="5"><br>
        <label>-------------------------------------------------------------------------------------</label><br>
        <label>Laptop name: </label><br>
        <input type="text" name="nameLaptop" size="25"><br>
        <label>Type: </label><br>
        <input type="text" name="type" size="25"><br>
        <label>Price: </label><br>
        <input type="text" name="price" size="25"><br>
        <label>Screen size: </label><br>
        <input type="text" name="size" size="25"><br>
        <label>CPU: </label><br>
        <input type="text" name="cpu" size="25"><br>
        <label>RAM: </label><br>
        <input type="text" name="ram" size="25"><br><br>
        <label>-------------------------------------------------------------------------------------</label><br>
        <label>Producer name: </label><br>
        <input type="text" name="nameProducer" size="10"><br>
        <label>Producer rate: </label><br>
        <input type="text" name="rate" size="10"><br><br>
        <label>-------------------------------------------------------------------------------------</label><br>
        <input type="submit" value="Add Laptop" name="btn"><input type="submit" value="Change Laptop Information" name="btn">
        <input type="submit" value="Delete Laptop" name="btn"><br><input type="submit" value="Search Laptop" name="btn"><br>
        <input type="submit" value="Sort price ascending" name="btn">
        <input type="submit" value="Sort price descending" name="btn"><br>
        <label>-------------------------------------------------------------------------------------</label><br>
        <input type="submit" value="Add Producer" name="btn"><input type="submit" value="Change Producer Information" name="btn">
        <input type="submit" value="Delete Producer" name="btn"><br>
        <input type="submit" value="Search Producer by ID" name="btn"><input type="submit" value="List Producer" name="btn">
        <input type="submit" value="List Laptop by Producer" name="btn"><br>
        <label>-------------------------------------------------------------------------------------</label><br>
        <input type="reset" value="Reset" name="Reset">
    </form>
     
    <% if((msg!=null)&&(msg.equals("0"))){ %>
        <SCRIPT language=JavaScript>
        alert ("Add laptop successfully!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("1"))){ %>
        <SCRIPT language=JavaScript>
        alert ("Change laptop information successfully!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("2"))){ %>
        <SCRIPT language=JavaScript>
        alert ("Delete laptop successfully!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("3"))){ %>
        <SCRIPT language=JavaScript>
        alert ("No laptop found!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("4"))){ %>
        <SCRIPT language=JavaScript>
        alert ("Add producer successfully!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("5"))){ %>
        <SCRIPT language=JavaScript>
        alert ("Change producer successfully!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("6"))){ %>
        <SCRIPT language=JavaScript>
        alert ("Delete producer successfully!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("7"))){ %>
        <SCRIPT language=JavaScript>
        alert ("No producer found!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("99"))){ %>
        <SCRIPT language=JavaScript>
        alert ("Fail!!!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("100"))){ %>
        <SCRIPT language=JavaScript>
        alert ("Insert information!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
    <% if((msg!=null)&&(msg.equals("404"))){ %>
        <SCRIPT language=JavaScript>
        alert ("This feature is not ready!");
        </SCRIPT>
        <p align="center"></p>
    <%} %>
</BODY>  
</HTML>