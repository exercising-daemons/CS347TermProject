/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;
/**
 *
 * @author Audrey
 */
public class WishListServlet extends HttpServlet {
     
  /*
   * Handle GET requests
   */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {
      
      forwardRequest(request, response, "/index.jsp");
  }
  /*
   * Handle "POST" requests
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {
    if (request.getParameter("addItem") != null) {
      handleAddItem(request, response);
      forwardRequest(request, response, "/wishlist.jsp");
    }    
    else if (request.getParameter("deleteItem") != null) {
      handleDeleteItem(request, response);
      forwardRequest(request, response, "/wishlist.jsp");
    }  
  }
  /**
   * Handles adding an item(s) from the current users wish list
   * @param request
   * @param response
   * @throws IOException
   * @throws ServletException 
   */
  private void handleAddItem(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
    
    HttpSession session = request.getSession(true);
    boolean itemAdded = true;
    
    int itemID = -1; 
    int quantity = -1;
    int userID = -1;
    try{
        itemID = Integer.parseInt(request.getParameter("itemID"));
        quantity = Integer.parseInt(request.getParameter("quantity"));
        userID = Integer.parseInt((String)session.getAttribute("userID"));
    }
    catch(NumberFormatException nfe){
        session.setAttribute("addMessage", "Must enter integer into both fields");
        return;
    }
    
    WishListItemUpdate wlUpdate = new WishListItemUpdate();
    itemAdded = wlUpdate.addWishListItem(userID, itemID, quantity);

    if(itemAdded)
           session.setAttribute("addMessage", "Item has been added successfully");
    else
           session.setAttribute("addMessage", "Item has not been added");

   
  }  
  /**
   * handles deleting an item from the current user's wishlist
   * @param request
   * @param response
   * @throws IOException
   * @throws ServletException 
   */
    private void handleDeleteItem(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
        
    HttpSession session = request.getSession(true);
    boolean itemDeleted = true;
    
    int itemID = -1; 
    int userID = -1;
    try{
        itemID = Integer.parseInt(request.getParameter("itemID"));
        userID = Integer.parseInt((String)session.getAttribute("userID"));
    }
    catch(NumberFormatException nfe){
        session.setAttribute("deleteMessage", "item ID must be an integer number");
        return;
    }
    
    WishListItemUpdate wlUpdate = new WishListItemUpdate();
    itemDeleted = wlUpdate.removeWishListItem(userID, itemID);

    if(itemDeleted)
           session.setAttribute("deleteMessage", "Item has been deleted successfully");
    else
           session.setAttribute("deleteMessage", "Item has not been deleted");
    }
        /*
   * Forward this request to another component.
   */
  private void forwardRequest(HttpServletRequest request,
          HttpServletResponse response, String forwardUrl)
          throws IOException, ServletException {
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
            forwardUrl);
    dispatcher.forward(request, response);
  }
}