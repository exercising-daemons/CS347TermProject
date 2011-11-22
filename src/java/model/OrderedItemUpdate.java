package model;

import java.sql.SQLException;

/**
 * This class handles updates to OrderedItems
 * 
 * @author Austin
 */
public class OrderedItemUpdate {
    
    /*
     * Update the quantity of an OrderedItem
     */
    public boolean updateQuantity(int orderID, int itemID, int quantity) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "UPDATE team27DB.OrderedItem"
                + "SET Quantity = " + quantity + " "
                + "WHERE OrderID = " + orderID 
                + " AND ItemID = " + itemID + ";";
        
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
