package model;

import java.util.*;
import java.sql.*;
import model.User;

/*
 * Handle requests for item information
 * @author - Eric Walters
 * @acknowledgements - Ralph Grove for code to base class off of
 */
public class UserRequest {
  
  /*
   * Returns a ArrayList, the first element of which is an Integer containing the
   * count of columns in the table. The remaining ArrayList elements are item
   * objects.
   */
  public boolean login(String email, String password) {
    String query = "select * from User where Email='"+email+"' and Password='"
            +password+"';";
    boolean success =true;

    // open a connection to the database and a Statement object
    try {
      DBQueryHandler dbQueHand = new DBQueryHandler();
      ResultSet rs = dbQueHand.doQuery(query);
      ResultSetMetaData rsmd = rs.getMetaData();
      
      if(rsmd.getColumnCount()<=0)
          success=false;


      
      dbQueHand.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    // return the result
    return success;
  }
  
  public String getPassword(String email){
      //make select query for password where email is the one given
      return "password";
  }
  
  public String getUserID(String email){
      //make select query for id where email is the one given
      return "id";
  }
}
