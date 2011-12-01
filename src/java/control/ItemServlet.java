

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
public class ItemServlet extends HttpServlet{
    
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
      forwardRequest(request, response, "/addItem.jsp");
    } else if (request.getParameter("deleteItem") != null) {
      handleDeleteItem(request, response);
      forwardRequest(request, response, "/deleteItem.jsp");
    }
     
  }
  
  /**
   * handle the administrator function of adding an item to the inventory
   * @param request
   * @param response
   * @throws IOException
   * @throws ServletException 
   */
   private void handleAddItem(HttpServletRequest request,
        HttpServletResponse response) throws IOException, ServletException {
    
    HttpSession session = request.getSession(true);
    
    //get item details
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    double price = Double.parseDouble(request.getParameter("price"));
    String category = request.getParameter("category");
    int stock = Integer.parseInt(request.getParameter("stock"));
    
    ItemUpdate iu = new ItemUpdate();
    boolean success = iu.addItem(name, description, price, category, stock);
    
    if(success)
        session.setAttribute("addMessage", "item added");
    else
        session.setAttribute("addMessage", "item not added");
   }
   
   /**
    * handle the administrator function of deleting an item from the inventory
    * @param request
    * @param response
    * @throws IOException
    * @throws ServletException 
    */
   private void handleDeleteItem(HttpServletRequest request,
        HttpServletResponse response) throws IOException, ServletException{
    
       HttpSession session = request.getSession(true);
 
       int itemID = Integer.parseInt(request.getParameter("itemID"));
       
       ItemUpdate iu = new ItemUpdate();
       boolean success = iu.deleteItem(itemID);
       
       if(success)
           session.setAttribute("deleteMessage", "item deleted");
       else
           session.setAttribute("deleteMessage", "item not deleted");
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
