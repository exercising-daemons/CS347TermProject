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
    
    public OrderedItem (int orderID, int itemID, int quantity) {
        this.orderID = orderID;
        this.itemID = itemID;
        this.quantity = quantity;
    }
    
    public int getOrderID() {
        int id = this.orderID;
        return id;
    }
    
    public int getItemID() {
        int id = this.itemID;
        return id;
    }
    
    public int getQuantity() {
        int quant = this.quantity;
        return quant;
    }
}
