package model;

import java.util.*;
import java.sql.*;
import model.Item;

/*
 * Handle requests for item information
 * @author - Eric Walters
 * @acknowledgements - Ralph Grove for code to base class off of
 */
public class ItemRequest {
  
  /*
   * Returns a ArrayList, the first element of which is an Integer containing the
   * count of columns in the table. The remaining ArrayList elements are item
   * objects.
   */
  public ArrayList<Object> getItemTable() {
    String query = "select * from Item";
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
        String name = rs.getString(i++);
        String description = rs.getString(i++);
        double price = rs.getDouble(i++);
        String category = rs.getString(i++);
        int stock = rs.getInt(i++);
        Item item = new Item(id, name, description, price, 
		category, stock);
        result.add(item);
      }
      
      dbQueHand.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    // return the result
    return result;
  }
}
