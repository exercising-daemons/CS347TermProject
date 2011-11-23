package model;

import java.sql.SQLException;

/**
 * This class handles updates and additions of WishListItems
 * 
 * @author Austin
 */
public class WishListItemUpdate {
    
    /*
     * Adds a WishListItem to the Wish_List_Item table
     */
    public boolean addWishListItem(int userID, int itemID, int quantity) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "INSERT INTO team27_db.Wish_List_Item"
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
     * Removes a WishListItem from the Wish_List_Item table
     */
    public boolean removeWishListItem(int userID, int itemID) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "DELETE FROM team27_db.Wish_List_Item"
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
     * Update the quantity of a WishListItem
     */
    public boolean updateQuantity(int userID, int itemID, int quantity) {
        boolean result = false;
        DBCommandHandler dbch = new DBCommandHandler();
        String command = "UPDATE team27_db.Wish_List_Item"
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
