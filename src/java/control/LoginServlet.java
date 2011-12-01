package control;

//import bean.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

/*
 * This servlet handles all incoming requests.
 * @author R.Grove
 */
public class LoginServlet extends HttpServlet {

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
    if (request.getParameter("createAccount") != null) {
       
      handleCreateAccount(request, response);
      forwardRequest(request, response, "/registration.jsp");
    } else if (request.getParameter("login") != null) {
      handleLogin(request, response);
      forwardRequest(request, response, "/index.jsp");
    }
    else if(request.getParameter("retrievePassword") != null) {
      handleRetrievePassword(request, response);
      forwardRequest(request, response, "/forgotPassword.jsp");
    }
    else if(request.getParameter("logout") != null) {
      handleLogout(request, response);
      forwardRequest(request, response, "/index.jsp");
    }
     
  }
  
  /**
   * handles the creation of a new user account
   * @param request
   * @param response
   * @throws IOException
   * @throws ServletException 
   */
    private void handleCreateAccount(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
    
    
    String addMessage = null;
    HttpSession session = request.getSession(true);

    // get create account request parameters
    String Fname = request.getParameter("firstName");
    String Lname = request.getParameter("lastName");
    String Mname = request.getParameter("middleName");
    String address = request.getParameter("address");
    String email = request.getParameter("email");
    String password1 = request.getParameter("pw1");
    String password2 = request.getParameter("pw2");

    int phone = 0;
    try{
        phone = Integer.parseInt(request.getParameter("phone"));
    }
    catch(NumberFormatException e){
        session.setAttribute("addMessage", "phone number must be a number");
        return;
    }

    //since admin is hardcoded into DB, can assume this person is not admin
    int admin = 0;

    UserUpdate uu = new UserUpdate();
    boolean addResult = uu.addUser(Fname, Mname, Lname, address,
            email, phone, admin, password1);
    addMessage= addResult ? "Account Created" : "Account Creation Failed";
    
    //automatically log user in?....
    
    session.setAttribute("addMessage", addMessage);
  }
    
    /**
     * handle login request
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    private void handleLogin(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
    
    HttpSession session = request.getSession(true);
    
    String email= request.getParameter("email");
    String password = request.getParameter("password");
    
    UserRequest ur = new UserRequest();
    boolean result = ur.login(email, password);
    
    if(result){
        session.setAttribute("loggedin", true);
        session.setAttribute("userEmail", email);
        session.setAttribute("userID", ur.getUserID(email));
    }    
    else{
        session.setAttribute("loggedin", false);
        //some sort of message?
    }
        
    }
    
    /**
     * handle log out request
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    private void handleLogout(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException {
    
    HttpSession session = request.getSession(true);

        session.setAttribute("loggedin", null);
        session.setAttribute("userEmail", null);
        session.setAttribute("userID", null);

        
    }
    
    /**
     * handle retrieving a user's password
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
   private void handleRetrievePassword(HttpServletRequest request,
          HttpServletResponse response) throws IOException, ServletException{
       
       HttpSession session = request.getSession(true);

       String email = request.getParameter("email");
       
       UserRequest ur = new UserRequest();
       String password = ur.getPassword(email);
       
       session.setAttribute("password", password);
       
       
       //how do we want to handle this??
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