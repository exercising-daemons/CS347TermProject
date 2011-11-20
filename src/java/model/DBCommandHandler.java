package model;

import java.io.*;
import java.sql.*;

/*
 * This class handles the DB command interface.
 */
public class DBCommandHandler extends DBHandler implements Serializable {
  /*
   * Execute a command and return a result count.
   */
  public int doCommand(String command) throws SQLException {
    if (! isOpen ) {
      open();
    }
    int resultCount = stmt.executeUpdate(command);
    return resultCount;
  }
}