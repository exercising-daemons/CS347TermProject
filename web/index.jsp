<%-- 
    Document   : index
    Created on : Nov 16, 2011, 4:50:16 PM
    Author     : lynerc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
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
              <h1>Hello World!</h1>
            </div>
          <div id="clearfooter"></div>
          <!-- to clear footer -->
        </div>
        <!-- end outer div -->
        <div id="footer"></div>

        <div id="header">E-Commerce Application</div>
       
    </body>
</html>
