package model;

import java.io.*;
import java.sql.*;

/*
 * This class handles the DB query interface.
 */
public class DBQueryHandler extends DBHandler implements Serializable {

  /*
   * Execute a query and return a ResultSet.
   */
  public ResultSet doQuery(String query) throws SQLException {
    if (! isOpen ) {
      open();
    }
    ResultSet rs = stmt.executeQuery(query);
    return rs;
  }
}
