package model;

/**
 * This class represents an item that has been ordered.
 * 
 * @author Austin
 */
public class OrderedItem {
    private int orderID;
    private int itemID;
    private int quantity;
    
    protected OrderedItem (int orderID, int itemID, int quantity) {
        this.orderID = orderID;
        this.itemID = itemID;
        this.quantity = quantity;
    }
    
    protected int getOrderID() {
        int id = this.orderID;
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
