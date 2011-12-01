package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import model.WishListItem;

/**
 *
 * @author Austin
 */
public class WishListItemRequest {
    
    /*
   * Returns an ArrayList, the first element of which is an Integer containing
   * the count of unique WishListItems (not including quantity) in the list.
   * The remaining ArrayList elements are WishListItem objects.
   */
    public ArrayList<Object> getWishListItems(int userID) {
        String query = "SELECT * FROM Wish_List_Item WHERE user_ID = " 
                + userID;
        ArrayList<Object> items = new ArrayList<Object>();
        
        try {
            DBQueryHandler dbqh = new DBQueryHandler();
            ResultSet rs = dbqh.doQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numCols = rsmd.getColumnCount();
            items.add(new Integer(numCols));
            
            while (rs.next()) {               
                WishListItem wli = new WishListItem(rs.getInt(1), 
                        rs.getInt(2), rs.getInt(3));
                items.add(wli);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return items;
    }
}
