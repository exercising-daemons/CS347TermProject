
package model;

/**
 * This class represents an item in a users wishlist
 * 
 * @author Austin
 */
public class WishListItem {
    
    private int userID;
    private int itemID;
    private int quantity;
    
    protected WishListItem (int userID, int itemID, int quantity) {
        this.userID = userID;
        this.itemID = itemID;
        this.quantity = quantity;
    }
    
    protected int getUserID() {
        int id = this.userID;
        return id;
    }
    
    protected int getItemID() {
        int id = this.itemID;
        return id;
    }
    
    protected int getQuantity() {
        int quant = this.quantity;
        return quant;
    }
}
