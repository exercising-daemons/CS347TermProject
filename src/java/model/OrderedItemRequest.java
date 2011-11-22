package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import model.OrderedItem;

/**
 * Handles requests for OrderedItem information
 * 
 * @author Austin
 */
public class OrderedItemRequest {
     
   /*
   * Returns an ArrayList, the first element of which is an Integer containing the
   * count of unique OrderedItems (not including quantity) in the list. The remaining 
   * ArrayList elements are OrderedItem objects.
   */
    public ArrayList<Object> getOrderedItems(int orderID) {
        String query = "SELECT * FROM Ordered_Item WHERE order_ID = " + orderID;
        ArrayList<Object> items = new ArrayList<Object>();
        
        try {
            DBQueryHandler dbqh = new DBQueryHandler();
            ResultSet rs = dbqh.doQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numCols = rsmd.getColumnCount();
            items.add(new Integer(numCols));
            
            while (rs.next()) {               
                OrderedItem oi = new OrderedItem(rs.getInt(1), 
                        rs.getInt(2), rs.getInt(3));
                items.add(oi);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return items;
    }    
}
