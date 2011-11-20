/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import model.User;
/**
 *
 * @author smith8ar
 */
public class UserUpdate {
    public boolean addUser(String Fname, String Mname, String Lname, String address,
            String email, int phone, int admin, String password){
        //return true;
    DBCommandHandler dbComHand = new DBCommandHandler();
    String command = "INSERT INTO User VALUES(";
    //this is how to insert id, just blank quotes
    command += "0";
    command += ",'" + Fname + "'";
    command += ",'" + Mname + "'";
    command += ",'" + Lname + "'";
    command += ", '" + address+ "'";
    command += ", '" + email + "'";
    command += ", '" + password + "'";
    command += ", '" + phone + "'";
    command += "," + admin + "";
    command += ",'" + 1 + "'";
    command += ");";
    
    System.out.println(command);

    try {
      int resultCount = dbComHand.doCommand(command);
      dbComHand.close();
      return (resultCount > 0);
    } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
    }
    }
}
