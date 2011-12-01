<%-- 
    Document   : stderr.jsp
    Created on : Nov 30, 2011, 3:20:28 PM
    Author     : chris
--%>

<%@page isErrorPage="true" import="java.io.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <%-- Std Exception Handler --%>
        <font color="red">
        <%= exception.toString() %>
        <br /><br />
        </font>
        
        
       <% exception.printStackTrace(); %>
       
    </body>
</html>
