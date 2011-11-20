package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.*;

/*
 * An abstract parent class for database handlers. This class loads
 * database access parameters from web.xml and loads the database
 * driver class.
 */
public abstract class DBHandler {
  protected String driverName = null, url = null, userId = null, password = null;
  protected Connection con;
  protected Statement stmt;
  protected boolean isOpen = false;

  /*
   * Get parameters required to open DBMS connection.
   */
  public DBHandler() {
    try {
      Context envCtx = (Context) (new InitialContext())
          .lookup("java:comp/env");
      driverName = (String) envCtx.lookup("DriverClassName");
      Class.forName(driverName);
      url = (String) envCtx.lookup("Url");
      userId = (String) envCtx.lookup("UserId");
      password = (String) envCtx.lookup("Password");
    } catch (NamingException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  /*
   * Open the DB connection
   */
  public void open() throws SQLException {
    con = DriverManager.getConnection(url, userId, password);
    stmt = con.createStatement();
    isOpen = true;
  }
  
  /*
   * Close the DB connection
   */
  public void close() throws SQLException {
    stmt.close();
    con.close();
    isOpen = false;
  }

}