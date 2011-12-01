package model;

import java.sql.*;
import model.Item;


/*
 * Handle item update and deletion requests.
 * @author - Eric Walters
 * @acknowledgements - Ralph Grove for source code to base off of
 */
public class ItemUpdate {

  /*
   * Update an item record.
   */
  public boolean addItem(String name, String description, double price, String category,
      int stock) {
    DBCommandHandler dbComHand = new DBCommandHandler();
    String command = "INSERT INTO Item VALUES(";
    command += "0,";
    command += "'" + name + "'";
    command += ", '" + description + "'";
    command += ", '" + price + "'";
    command += ", '" + category + "'";
	 command += ", '" + stock + "'";
    command += ")";

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
   * Delete an item record.
   */
  public boolean deleteItem(int id) {
    DBCommandHandler dbComHand = new DBCommandHandler();
    try {
      String command = "delete from Item where item_ID = '" + id + "'";
      int result = dbComHand.doCommand(command);
      dbComHand.close();
      return (result > 0);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      return false;
    }
  }
  
} // end class
