<%-- 
    Document   : registration
    Created on : Nov 16, 2011, 4:53:47 PM
    Author     : lynerc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
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
            <h1>Register for an Account!</h1>
        
            <form action="Login" method="POST">
                <table>

                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="pw1" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="pw2" /></td>
                    </tr>
                </table>
                <br />
                <table>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="firstName" /></td>
                    </tr>
                    <tr>
                        <td>Middle Name:</td>
                        <td><input type="text" name="middleName" /></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="lastName" /></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" name="address" /></td>
                    </tr>
                    <tr>
                        <td>E-Mail Address:</td>
                        <td><input type="text" name="email" /></td>
                    </tr>
                    <tr>
                        <td>Phone Number:</td>
                        <td><input type="text" name="phone" /></td>
                    </tr>

                </table>

                <br />
                <input type="submit" value="Submit" name="createAccount"/>

            </form>
            <%
                if(session.getAttribute("addMessage")!=null)
                    out.println((String)session.getAttribute("addMessage"));
                session.setAttribute("addMessage", null);
            %>
          </div>
          <div id="clearfooter"></div>
          <!-- to clear footer -->
        </div>
        <!-- end outer div -->
        <div id="footer"></div>

        <div id="header">E-Commerce Application</div>
       
    </body>
</html>
