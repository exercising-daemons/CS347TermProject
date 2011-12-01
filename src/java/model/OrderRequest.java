package model;

import java.util.*;
import java.sql.*;
//import common.Order;

/*
 * Handle requests for order information
 * @author - Eric Walters
 * @acknowledgements - Ralph Grove for code to base class off of
 */
public class OrderRequest {
  
  /*
   * Returns a ArrayList, the first element of which is an Integer containing the
   * count of columns in the table. The remaining ArrayList elements are item
   * objects.
   */
  public ArrayList<Object> getOrderTable() {
    String query = "select * from Order";
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
		int order_ID = rs.getInt(i++);
        String status = rs.getString(i++);
		int user_ID = rs.getInt(i++);
		//Date date = rs.getObject(i++);
                String date  = rs.getString(i++);
        Order order = new Order(order_ID, status, user_ID, date);
        result.add(order);
      }
      
      dbQueHand.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    // return the result
    return result;
  }
}
