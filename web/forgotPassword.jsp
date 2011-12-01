<%-- 
    Document   : forgotPassword
    Created on : Nov 16, 2011, 4:54:05 PM
    Author     : lynerc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        <link href="css/index.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
   
        <div id="minHeight"></div>
        <div id="outer">
          <div id="clearheader"></div>
          <!-- to clear header - you could use padding-top instead on the three main elements-->
          <div id="left">

            <h1>Navigation</h1>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">My Account</a></li>
                <li><a href="#">Shopping Cart</a></li>
                <li><a href="#">Wish List</a></li>
            </ul>

          </div>
          <div id="right">
            <p>
            <ul>
                <li><a href="registration.jsp">Register!</a></li>
                <li><a href="forgotPassword.jsp">Forgot Password?</a></li>
            </ul>
            </p>
          </div>
          <div id="centrecontent">              
            <h1>Forgotten Password?</h1>
        
            <form action="Login" method="POST">
                E-Mail Address:
                <input type="text" name="email" />
                <input type="submit" value="Submit" name="retrievePassword"/>

            </form>
            <%
                if(session.getAttribute("password")!=null)
                    out.println("Your password is: "+(String)session.getAttribute("password"));
                session.setAttribute("password", null);
            %>
          </div>
          <div id="clearfooter"></div>
          <!-- to clear footer -->
        </div>
        <!-- end outer div -->
        <div id="footer"></div>

        <div id="header">E-Commerce Application</div>
       
    </body>