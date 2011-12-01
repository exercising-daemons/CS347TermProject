<%--
    Document   : login.jsp
    Created on : Nov 30, 2011, 5:37:34 PM
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form action="Login" method="POST" >
            E-Mail Address: <input type="text" name="email" />
            <br />
            Password: <input type="password" name="password" />
            <br />
            <input type="submit" name="login" value="Login" />
           
        </form>
    </body>
</html>

