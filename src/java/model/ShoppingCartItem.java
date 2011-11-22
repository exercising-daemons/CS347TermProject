package model;

/**
 * This class represents an item in the users shopping cart
 * 
 * @author Austin
 */
public class ShoppingCartItem{
    
    private int userID;
    private int itemID;
    private int quantity;
    
    protected ShoppingCartItem (int userID, int itemID, int quantity) {
        this.userID = userID;
        this.itemID = itemID;
        this.quantity = quantity;
    }
    
    protected int getOrderID() {
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
