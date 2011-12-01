package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ShoppingCartItem;

/**
 * This class handles requests for ShoppingCartItemInformation
 * 
 * @author Austin
 */
public class ShoppingCartItemRequest {
    
  /*
   * Returns an ArrayList, the first element of which is an Integer containing
   * the count of unique ShoppingCartItems (not including quantity) in the list.
   * The remaining ArrayList elements are ShoppingCartItem objects.
   */
    public ArrayList<Object> getShoppingCartItems(int userID) {
        String query = "SELECT * FROM Shopping_Cart_Item WHERE user_ID = " 
                + userID;
        ArrayList<Object> items = new ArrayList<Object>();
        
        try {
            DBQueryHandler dbqh = new DBQueryHandler();
            ResultSet rs = dbqh.doQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numCols = rsmd.getColumnCount();
            items.add(new Integer(numCols));
            
            while (rs.next()) {               
                ShoppingCartItem sci = new ShoppingCartItem(rs.getInt(1), 
                        rs.getInt(2), rs.getInt(3));
                items.add(sci);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return items;
    }
}
