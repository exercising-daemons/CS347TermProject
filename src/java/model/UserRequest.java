package model;

import java.util.*;
import java.sql.*;
import model.User;

/*
 * Handle requests for user information
 * @author - Eric Walters
 * @acknowledgements - Ralph Grove for code to base class off of
 */
public class UserRequest {
  
  /*
   * Returns a ArrayList, the first element of which is an Integer containing the
   * count of columns in the table. The remaining ArrayList elements are item
   * objects.
   */
  public ArrayList<Object> getUserTable() {
    String query = "select * from User";
    ArrayList<Object> result = new ArrayList<Object>();

    // open a connection to the database and a Statement object
    try {
      DBQueryHandler dbQueHand = new DBQueryHandler();
      ResultSet rs = dbQueHand.doQuery(query);
      ResultSetMetaData rsmd = rs.getMetaData();

      int numberOfColumns = rsmd.getColumnCount();
      result.add(new Integer(numberOfColumns));

      while (rs.next()) {
        int i = 1; // 1st column
		int id = rs.getInt(i++);
        String fName = rs.getString(i++);
        String mName = rs.getString(i++);
        String lName = rs.getString(i++);
        String address = rs.getString(i++);
        String email = rs.getString(i++);
        String password = rs.getString(i++);
		int phoneNum = rs.getInt(i++);
		int admin = rs.getInt(i++);
		int payment_info_id = rs.getInt(i++);

        User user = new User(id, fName, lName, mName, address, email, password,
							 phoneNum, admin, payment_info_id);
        result.add(user);
      }
      
      dbQueHand.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    // return the result
    return result;
  }
  
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
  public String getUserID(String email){
      //make select query for id where email is the one given
      return "1";
  }
  public String getPassword(String email){
      //make select query for password where email is the one given
      return "password";
  }
  
  public String getName(String userID){
      //return first name for the given user id
      return "name";
  }
}
