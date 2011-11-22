package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Handles requests for OrderedItem information
 * 
 * @author Austin
 */
public class OrderedItemRequest {
     
   /*
   * Returns an ArrayList, the first element of which is an Integer containing the
   * count of columns in the list. The remaining ArrayList elements are item
   * objects.
   */
    public ArrayList<Object> getOrderedItems() {
        String query = "Select * from OrderedItem";
        ArrayList<Object> items = new ArrayList<Object>();
        int orderID;
        int itemID;
        int quantity;
        
        try {
            DBQueryHandler dbqh = new DBQueryHandler();
            ResultSet rs = dbqh.doQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numCols = rsmd.getColumnCount();
            items.add(new Integer(numCols));
            
            while (rs.next()) {
                // create an OrderedItem from a tuple
                // add OrderedItem to ArrayList
                // repeat
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return items;
    }
}
