<%-- 
    Document   : forgotPassword
    Created on : Nov 16, 2011, 4:54:05 PM
    Author     : lynerc
--%>

<%@page import="java.util.*, model.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
        <link href="css/index.css" rel="stylesheet" type="text/css" />
        <link href="css/thumbnails.css" rel="stylesheet" type="text/css" />
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
                <li><a href="shoppingcart.jsp">Shopping Cart</a></li>
                <li><a href="wishlist.jsp">Wish List</a></li>
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
            <h1>Shopping Cart</h1>
            
            <div class="container">
            <div class="spacer">
              &nbsp;
            </div>
             
                <%
                    
                    // get userID from session
                    int userID = Integer.parseInt(session.getAttribute("userID").toString());
                    // get a list of all shopping cart items
                    ArrayList<Object> cart = (new WishListItemRequest()).getWishListItems(userID);
                    int count = 0;
                    
                    // print all items in cart
                    for (Object wish_item: cart) {
                        // first item is number of items in shopping cart
                        if (count != 0) {
                            out.print("<div class=\"float\">");
                            out.print("<img src=\"http://www.alistapart.com/d/practicalcss/image1.gif\" width=\"100\" height=\"100\" />");
                            out.print("<br />");
                            out.print("<p> ID: " + ((WishListItem)wish_item).getItemID() + "</p>");
                            // get item id integrated into the remove request
                            //out.print("<p>" + "remove from cart?" + "<input type=\"checkbox\" name=\"remove\" />" + "</p>");
                            out.print("</div>");
                        }
                        count++;
                    }
                    
                %>
                
                <form method="post" action="WishList">
                    <p>Item ID:<input type="text" name="itemID"/></p>
                    <p>Remove Item from shopping cart<input type="submit" name="deleteItem" value="remove"/></p>
                    
                </form>
                <form method="get" action="checkout.jsp">
                    <p><input type="submit" name="checkout" value="Check Out"/></p>
                </form>
 
            <div class="spacer">
              &nbsp;
            </div>

                
                
            </div>
        
     
          </div>
          <div id="clearfooter"></div>
          <!-- to clear footer -->
        </div>
        <!-- end outer div -->
        <div id="footer"></div>

        <div id="header">E-Commerce Application</div>
       
    </body>