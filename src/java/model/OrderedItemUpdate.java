package model;

import java.sql.SQLException;

/**
 * This class handles updates and additions of OrderedItems
 * 
 * @author Austin
 */
public class OrderedItemUpdate {
    
    /*
     * Adds an OrderedItem to the Ordered_Item table
     */
    public boolean addOrderedItem(int orderID, int itemID, int quantity) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "INSERT INTO team27_db.Ordered_Item"
                + " (order_ID, item_ID, Quantity) "
                + "VALUES (" + orderID + ", " + itemID + ", " + quantity + ")";
        
        try {
            int resultCount = dbch.doCommand(command);
            dbch.close();
            result = resultCount > 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return result;
    }
    
    /*
     * Remove an OrderedItem from the database
     */
    public boolean removeOrderedItem(int orderID, int itemID) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "DELETE FROM team27_db.Ordered_Item"
                + "WHERE order_ID = " + orderID + " AND item_ID = " + itemID;
        
        try {
            int resultCount = dbch.doCommand(command);
            dbch.close();
            result = resultCount > 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return result;
    }
    
    /*
     * Remove an entire order from the Ordered_Item table
     */
    public boolean removeEntireOrder(int orderID) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "DELETE FROM team27_db.Ordered_Item"
                + "WHERE order_ID = " + orderID;
        
        try {
            int resultCount = dbch.doCommand(command);
            dbch.close();
            result = resultCount > 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return result;
    }
    
    /*
     * Update the quantity of an OrderedItem
     */
    public boolean updateQuantity(int orderID, int itemID, int quantity) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "UPDATE team27_db.Ordered_Item"
                + "SET quantity = " + quantity + " "
                + "WHERE order_ID = " + orderID 
                + " AND item_ID = " + itemID + ";";
        
        try {
            int resultCount = dbch.doCommand(command);
            dbch.close();
            result = resultCount > 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return result;
    }
}
