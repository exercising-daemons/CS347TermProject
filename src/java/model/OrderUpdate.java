/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import model.Order;
/**
 *
 * @author Audrey
 */
public class OrderUpdate {
    
    public boolean addOrder(String status, String id, String time){
        //insert order. time is in correct format so just put quotes around it
        return true;
    }
            
    public boolean changeOrderStatus(String orderID, String status){
        //update satus where orderID is the one given
        return true;
    }
}
