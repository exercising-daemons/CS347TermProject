package model;

import java.sql.*;

/*
 * Handle order update and deletion requests.
 * @author - Eric Walters
 * @acknowledgements - Ralph Grove for source code to base off of
 */
public class OrderUpdate {

  /*
   * Update an order record.
   */
  public boolean addOrder(int order_ID, String status, String user_ID,
      String OrderTime) {
    DBCommandHandler dbComHand = new DBCommandHandler();
    String command = "INSERT INTO Orders VALUES(";
	command += "0";
    command += ",'" + status + "'";
    command += ", " + user_ID;
    command += ", '" + OrderTime + "'";
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
   * Delete an order record.
   */
  public boolean deleteOrder(int order_ID) {
    DBCommandHandler dbComHand = new DBCommandHandler();
    try {
      String command = "delete from Order where order_ID = '" + order_ID + "'";
      int result = dbComHand.doCommand(command);
      dbComHand.close();
      return (result > 0);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      return false;
    }
  }
  
  public boolean changeOrderStatus(String orderID, String status){
        //update satus where orderID is the one given
        return true;
    }
  
} // end class
