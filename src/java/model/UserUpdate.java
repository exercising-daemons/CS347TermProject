package model;

import java.sql.*;
import model.Item;


/*
 * Handle user update and deletion requests.
 * @author - Eric Walters
 * @acknowledgements - Ralph Grove for source code to base off of
 */
public class UserUpdate {

  /*
   * Update a user record.
   */
  public boolean addUser(String Fname, String Mname, String Lname, String address,
            String email, int phone, int admin, String password){
        //return true;
    DBCommandHandler dbComHand = new DBCommandHandler();
    String command = "INSERT INTO User VALUES(";
    //this is how to insert id, just blank quotes
    command += "0";
    command += ",'" + Fname + "'";
    command += ",'" + Mname + "'";
    command += ",'" + Lname + "'";
    command += ", '" + address+ "'";
    command += ", '" + email + "'";
    command += ", '" + password + "'";
    command += ", '" + phone + "'";
    command += "," + admin + "";
    command += ",'" + 1 + "'";
    command += ");";
    
    System.out.println(command);

    try {
      int resultCount = dbComHand.doCommand(command);
      dbComHand.close();
      return (resultCount > 0);
    } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
    }
    }

  /*
   * Delete a user record.
   */
  public boolean deleteUser(int id) {
    DBCommandHandler dbComHand = new DBCommandHandler();
    try {
      String command = "delete from User where user_ID = '" + id + "'";
      int result = dbComHand.doCommand(command);
      dbComHand.close();
      return (result > 0);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      return false;
    }
  }
  
} // end class
