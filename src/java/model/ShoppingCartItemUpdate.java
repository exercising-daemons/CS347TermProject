package model;

import java.sql.SQLException;

/**
 * This class handles updates and additions of ShoppingCartItems
 * 
 * @author Austin
 */
public class ShoppingCartItemUpdate {
    
    /*
     * Adds a ShoppingCartItem to the Shopping_Cart_Item table
     */
    public boolean addShoppingCartItem(int userID, int itemID, int quantity) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "INSERT INTO team27_db.Shopping_Cart_Item"
                + " (user_ID, item_ID, Quantity) "
                + "VALUES (" + userID + ", " + itemID + ", " + quantity + ")";
        
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
     * Removes a ShoppingCartItem from the Shopping_Cart_Item table
     */
    public boolean removeShoppingCartItem(int userID, int itemID) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "DELETE FROM team27_db.Shopping_Cart_Item"
                + "WHERE user_ID = " + userID + " AND item_ID = " + itemID;
        
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
     * Update the quantity of a ShoppingCartItem
     */
    public boolean updateQuantity(int userID, int itemID, int quantity) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "UPDATE team27_db.Shopping_Cart_Item"
                + "SET quantity = " + quantity + " "
                + "WHERE user_ID = " + userID 
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
